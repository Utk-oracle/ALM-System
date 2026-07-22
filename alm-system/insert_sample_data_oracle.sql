-- Run after database.sql while connected to the same Oracle schema.
-- This is the Oracle version of the sample data script.

INSERT ALL
  INTO users (username, password_hash, role) VALUES ('admin', 'admin123', 'ADMIN')
  INTO users (username, password_hash, role) VALUES ('analyst', 'analyst123', 'ANALYST')
  INTO users (username, password_hash, role) VALUES ('manager', 'manager123', 'MANAGER')
SELECT 1 FROM dual;

INSERT ALL
  INTO assets (asset_name, asset_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_liquid, credit_status, asset_status)
    VALUES ('Home Loan Portfolio', 'LOAN', 1000000.00, 8.5000, 'FIXED', DATE '2030-12-31', 'INR', 4.5000, 1, 0, 'STANDARD', 'ACTIVE')
  INTO assets (asset_name, asset_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_liquid, credit_status, asset_status)
    VALUES ('Corporate Bond Investment', 'BOND', 2000000.00, 7.2000, 'FIXED', DATE '2029-06-30', 'INR', 3.8000, 1, 0, 'STANDARD', 'ACTIVE')
  INTO assets (asset_name, asset_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_liquid, credit_status, asset_status)
    VALUES ('Cash Reserve', 'CASH', 500000.00, 3.5000, 'VARIABLE', NULL, 'INR', 0.1000, 0, 1, 'STANDARD', 'ACTIVE')
  INTO assets (asset_name, asset_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_liquid, credit_status, asset_status)
    VALUES ('Overdue Business Loan', 'LOAN', 750000.00, 10.0000, 'VARIABLE', DATE '2028-03-31', 'INR', 2.7000, 1, 0, 'OVERDUE', 'ACTIVE')
SELECT 1 FROM dual;

INSERT ALL
  INTO liabilities (liability_name, liability_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_short_term, liability_status)
    VALUES ('Savings Deposits', 'DEPOSIT', 800000.00, 4.0000, 'VARIABLE', NULL, 'INR', 0.5000, 1, 1, 'ACTIVE')
  INTO liabilities (liability_name, liability_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_short_term, liability_status)
    VALUES ('Fixed Deposits', 'DEPOSIT', 1200000.00, 6.5000, 'FIXED', DATE '2027-06-30', 'INR', 2.0000, 1, 0, 'ACTIVE')
  INTO liabilities (liability_name, liability_type, principal_amount, interest_rate, rate_type, maturity_date, currency, duration, is_rate_sensitive, is_short_term, liability_status)
    VALUES ('Interbank Borrowing', 'BORROWING', 700000.00, 6.8000, 'VARIABLE', DATE '2026-03-31', 'INR', 1.2000, 1, 1, 'ACTIVE')
SELECT 1 FROM dual;

INSERT ALL
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (1, NULL, DATE '2026-01-31', 85000.00, 'INFLOW')
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (2, NULL, DATE '2026-01-31', 144000.00, 'INFLOW')
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (3, NULL, DATE '2026-01-31', 15000.00, 'INFLOW')
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (NULL, 1, DATE '2026-01-31', 32000.00, 'OUTFLOW')
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (NULL, 2, DATE '2026-01-31', 78000.00, 'OUTFLOW')
  INTO cash_flows (asset_id, liability_id, flow_date, amount, flow_type) VALUES (NULL, 3, DATE '2026-01-31', 47600.00, 'OUTFLOW')
SELECT 1 FROM dual;

COMMIT;
