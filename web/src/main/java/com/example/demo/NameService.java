package com.example.demo;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
@EnableFeignClients
public class NameService {

    private NameFeignClient nameFeignClient;

//    private static final String URL = "http://name";
//    private RestTemplate rest;

    public NameService(NameFeignClient nameFeignClient) {
        this.nameFeignClient = nameFeignClient;
    }

    public String getName() {
        //return rest.getForObject(URL,String.class);
        return nameFeignClient.getName();
    }

    @FeignClient("name")
    static interface NameFeignClient{
        @RequestMapping("/")
        public String getName();
    }
}
