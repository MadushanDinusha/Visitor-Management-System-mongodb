package com.visitor.visitormanagementsystem.service;

import com.visitor.domain.Visitor;
import com.visitor.remote.client.RestClientImpl;
import com.visitor.remote.client.RestClientImpl.ApiUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class VisitorServiceImpl implements VisitorService {

    private RestClientImpl restClient;
    private  ApiUrl apiUrl;

    @Value("${destination.ip}")
    private String HOST;
    @Value("${destination.port}")
    private int PORT;
    @Value("${destination.uri}")
    private String URI;
    @Value("${destination.ssl.enabled:false}")
    private boolean sslEnabled;

    @PostConstruct
    public void init() {
        apiUrl = new ApiUrl(HOST, PORT, URI, sslEnabled);
        restClient = new RestClientImpl(apiUrl.getRestApiUrl());
    }


    @Override
    public void processVisitorSave(Visitor visitor) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", visitor.getName());
        bodyMap.put("id", visitor.getVisitorId());
        restClient.createVisitor(bodyMap, headers, apiUrl.getRestApiUrl() + "/createVisitor");
    }
}
