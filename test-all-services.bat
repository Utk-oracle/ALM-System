@echo off
setlocal EnableExtensions EnableDelayedExpansion

rem Runs read-only smoke tests against every exposed ALM REST resource.
rem Start the API first with start-all-services.bat background.

set "BASE_URL=http://localhost:6060"
if not "%~1"=="" set "BASE_URL=%~1"
if "%BASE_URL:~-1%"=="/" set "BASE_URL=%BASE_URL:~0,-1%"
set "BASE_URL=%BASE_URL%/"

where curl.exe >nul 2>&1
if errorlevel 1 (
    echo ERROR: curl.exe was not found on PATH. Windows 10 version 1803 or later includes it by default.
    exit /b 1
)

set "FAILED=0"
for %%R in (assets liabilities cash-flows market-rates report-history risk-metrics scenario-results scenarios users) do (
    call :test_endpoint "%%R"
)

if not "%FAILED%"=="0" (
    echo.
    echo %FAILED% smoke test^(s^) failed.
    exit /b 1
)

echo.
echo All REST API smoke tests passed.
exit /b 0

:test_endpoint
set "RESOURCE=%~1"
set "STATUS="
for /f "delims=" %%S in ('curl.exe -s -o NUL -w "%%{http_code}" --connect-timeout 5 --max-time 15 "%BASE_URL%api/%RESOURCE%"') do set "STATUS=%%S"

if "!STATUS:~0,1!"=="2" (
    echo PASS  !STATUS!  %BASE_URL%api/%RESOURCE%
    exit /b 0
)

if not defined STATUS set "STATUS=no response"
echo FAIL  !STATUS!  %BASE_URL%api/%RESOURCE%
set /a FAILED+=1
exit /b 0
