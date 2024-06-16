CREATE TABLE kirke_vmb_config_table (
    requestId INT NOT NULL,
    activityTypeName VARCHAR(50),
    scheduledStartDateTime TIMESTAMP,
    scheduledEndDateTime TIMESTAMP,
    referenceId VARCHAR(50),
    description VARCHAR(4000),
    nenSeverity VARCHAR(50),
    market VARCHAR(50),
    submarket VARCHAR(50),
    deviceId INT,
    deviceType VARCHAR(50),
    du VARCHAR(50),
    sector VARCHAR(50),
    scopeOfImpact VARCHAR(50),
    impactLevelName VARCHAR(50),
    serviceImpact VARCHAR(50),
    riskLevel VARCHAR(50)
);

