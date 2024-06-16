package com.kirke.service.repository;

import com.kirke.service.model.KirkeReq;
import com.kirke.service.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Repository
@Slf4j
@Transactional
public class KirkeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int saveKirkeReq(KirkeReq kirkeReq) {
        log.info("Inside saveKirkeReq ::");

        try {
            jdbcTemplate.update(SqlUtils.INSERT, kirkeReq.getRequestId(), kirkeReq.getActivityTypeName(),
                    kirkeReq.getScheduledStartDateTime(), kirkeReq.getScheduledEndDateTime(), kirkeReq.getReferenceId(),
                    kirkeReq.getDescription(), kirkeReq.getNenSeverity(), kirkeReq.getMarket(), kirkeReq.getSubmarket(),
                    kirkeReq.getDeviceId(), kirkeReq.getDeviceType(), kirkeReq.getDu(), kirkeReq.getSector(),
                    kirkeReq.getScopeOfImpact(), kirkeReq.getImpactLevelName(), kirkeReq.getServiceImpact(),
                    kirkeReq.getRiskLevel());
            return 1; // Assuming success if no exception occurs
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Exception in saveKirkeReq ::", e.getMessage());
            return 0; // Return 0 to indicate failure
        }
    }

    public Timestamp convertToTimeStamp(String eventTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime localDateTime = LocalDateTime.parse(eventTime, formatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Timestamp.from(zonedDateTime.toInstant());
    }
}
