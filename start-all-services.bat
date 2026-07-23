@echo off
setlocal EnableExtensions

rem Starts every runnable service in this repository.
rem The current repository contains one Spring Boot API, alm-system-api,
rem which listens on port 6060. Oracle is an external dependency and must
rem already be running.

set "REPOSITORY_ROOT=%~dp0"
set "API_DIRECTORY=%REPOSITORY_ROOT%alm-system"
set "API_PORT=6060"

if not exist "%API_DIRECTORY%\pom.xml" (
    echo ERROR: Could not find the API Maven project at "%API_DIRECTORY%".
    exit /b 1
)

where mvn >nul 2>&1
if errorlevel 1 (
    echo ERROR: Maven was not found on PATH. Install Maven and make sure the mvn command is available.
    exit /b 1
)

netstat -ano | findstr /R /C:":%API_PORT% .*LISTENING" >nul
if not errorlevel 1 (
    echo alm-system-api is already listening on http://localhost:%API_PORT%/.
    exit /b 0
)

if /I "%~1"=="background" goto :start_background
if not "%~1"=="" (
    echo Usage: %~nx0 [background]
    exit /b 1
)

echo Starting alm-system-api in this terminal. Press Ctrl+C to stop it.
pushd "%API_DIRECTORY%"
mvn spring-boot:run
set "EXIT_CODE=%ERRORLEVEL%"
popd
exit /b %EXIT_CODE%

:start_background
echo Starting alm-system-api in the background...
start "alm-system-api" /D "%API_DIRECTORY%" /B cmd /c "mvn spring-boot:run"

set /a ATTEMPT=0
:wait_for_api
set /a ATTEMPT+=1
netstat -ano | findstr /R /C:":%API_PORT% .*LISTENING" >nul
if not errorlevel 1 (
    echo alm-system-api is running at http://localhost:%API_PORT%/.
    exit /b 0
)

if %ATTEMPT% GEQ 90 (
    echo ERROR: alm-system-api did not listen on port %API_PORT% within 90 seconds.
    exit /b 1
)

timeout /t 1 /nobreak >nul
goto :wait_for_api
