package com.kirke.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirke.service.model.KirkeReq;
import com.kirke.service.repository.KirkeRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KirkeService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private KirkeRepository kirkeRepository;

    public KirkeReq convertJsonToKirkeReq(String kirkeJson) {
        log.info("Inside convertJsonToKirkeReq :: ");
        try {
            // Check if the JSON is a valid object and contains the required condition
            if (kirkeJson.contains("\"activityTypeName\": \"CONFIGURATION CHANGE\"")) {
                // Parse JSON to KirkeReq object
                KirkeReq kirkeReq = objectMapper.readValue(kirkeJson, KirkeReq.class);
                return kirkeReq;

            }
        } catch (Exception e) {
            log.error("Exception in convertJsonToKirkeReq :: Exception ::", e.getMessage());
            e.printStackTrace(); // Handle or log exception as needed
        }
        return null; // Return null if conditions are not met or if there's an error
    }

    public boolean isJsonObject(String json){
        try{

             new JSONObject(json);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public int saveKirkeReq(KirkeReq kirkeReq){

      try{
          log.info("Inside saveKirkeReq ::");
          return kirkeRepository.saveKirkeReq(kirkeReq);
      }
      catch (Exception e){
          log.error("Exception in saveKirkeReq :: Exception ::", e.getMessage());
          e.printStackTrace();
          return 0;
      }
    }
}
