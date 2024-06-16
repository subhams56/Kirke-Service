package com.kirke.service.controller;


import com.kirke.service.model.KirkeReq;
import com.kirke.service.service.KirkeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/kirke")
@Slf4j
public class KirkeController {

    @Autowired
    private KirkeService kirkeService;

    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "OK";
    }



    @PostMapping("/save")
    public int saveKirkeJsonToDbTest(@RequestBody String kirkeJson){
        try{
            log.info("Inside saveKirkeJsonToDbTest :: {}",kirkeJson);
            KirkeReq kirkeReq = kirkeService.convertJsonToKirkeReq(kirkeJson);
            log.info("KirkeReq :: {}",kirkeReq);
            return kirkeService.saveKirkeReq(kirkeReq);

        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }


    }

    @PostMapping("/kirkeReq")
    public KirkeReq jsonToKirkeReq(@RequestBody String kirkeJson){
        try{
            log.info("Received :: {}",kirkeJson);
            log.info("Converting To Kirke Req ::");
            KirkeReq kirkeReq = kirkeService.convertJsonToKirkeReq(kirkeJson);
            log.info("KirkeReq :: {}",kirkeReq);

            return kirkeReq;

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


}
