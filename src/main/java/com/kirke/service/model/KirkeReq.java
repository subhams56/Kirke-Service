package com.kirke.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KirkeReq {

    private int requestId;
    private String activityTypeName;
    private Timestamp scheduledStartDateTime;
    private Timestamp scheduledEndDateTime;
    private String referenceId;
    private String description;
    private String nenSeverity;
    private String market;
    private String submarket;
    private int deviceId;
    private String deviceType;
    private String du;
    private String sector;
    private String scopeOfImpact;
    private String impactLevelName;
    private String serviceImpact;
    private String riskLevel;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public Timestamp getScheduledStartDateTime() {
        return scheduledStartDateTime;
    }

    public void setScheduledStartDateTime(Timestamp scheduledStartDateTime) {
        this.scheduledStartDateTime = scheduledStartDateTime;
    }

    public Timestamp getScheduledEndDateTime() {
        return scheduledEndDateTime;
    }

    public void setScheduledEndDateTime(Timestamp scheduledEndDateTime) {
        this.scheduledEndDateTime = scheduledEndDateTime;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNenSeverity() {
        return nenSeverity;
    }

    public void setNenSeverity(String nenSeverity) {
        this.nenSeverity = nenSeverity;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSubmarket() {
        return submarket;
    }

    public void setSubmarket(String submarket) {
        this.submarket = submarket;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getScopeOfImpact() {
        return scopeOfImpact;
    }

    public void setScopeOfImpact(String scopeOfImpact) {
        this.scopeOfImpact = scopeOfImpact;
    }

    public String getImpactLevelName() {
        return impactLevelName;
    }

    public void setImpactLevelName(String impactLevelName) {
        this.impactLevelName = impactLevelName;
    }

    public String getServiceImpact() {
        return serviceImpact;
    }

    public void setServiceImpact(String serviceImpact) {
        this.serviceImpact = serviceImpact;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return "KirkeReq{" +
                "requestId=" + requestId +
                ", activityTypeName='" + activityTypeName + '\'' +
                ", scheduledStartDateTime=" + scheduledStartDateTime +
                ", scheduledEndDateTime=" + scheduledEndDateTime +
                ", referenceId='" + referenceId + '\'' +
                ", description='" + description + '\'' +
                ", nenSeverity='" + nenSeverity + '\'' +
                ", market='" + market + '\'' +
                ", submarket='" + submarket + '\'' +
                ", deviceId=" + deviceId +
                ", deviceType='" + deviceType + '\'' +
                ", du='" + du + '\'' +
                ", sector='" + sector + '\'' +
                ", scopeOfImpact='" + scopeOfImpact + '\'' +
                ", impactLevelName='" + impactLevelName + '\'' +
                ", serviceImpact='" + serviceImpact + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                '}';
    }
}
