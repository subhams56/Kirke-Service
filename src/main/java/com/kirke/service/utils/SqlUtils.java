package com.kirke.service.utils;

public class SqlUtils {
    private SqlUtils() {
    }

    public static final String TABLE_NAME = "kirke_vmb_config_table";

   public static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(requestId, activityTypeName, scheduledStartDateTime, scheduledEndDateTime, " +
            "referenceId, description, nenSeverity, market, submarket, " +
            "deviceId, deviceType, du, sector, scopeOfImpact, " +
            "impactLevelName, serviceImpact, riskLevel) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

}
