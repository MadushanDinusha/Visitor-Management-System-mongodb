package com.visitor.visitormanagementsystem.service;

import com.visitor.domain.Visitor;
import com.visitor.remote.client.RestClientImpl;
import com.visitor.remote.client.RestClientImpl.ApiUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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
    public void save(Visitor visitor) {

    }
}
