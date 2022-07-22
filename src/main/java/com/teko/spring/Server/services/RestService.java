package com.teko.spring.Server.services;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.teko.spring.Server.entity.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<Object> postReq(String json, String hmac){
        String url = "https://gate-test-02.teko.io/api/initiators/default/initPayment";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Signature", hmac);
        // build the request
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        // send POST request
        ResponseEntity<Object> response = this.restTemplate.postForEntity(url, entity, Object.class);
        return response;
    }

}
