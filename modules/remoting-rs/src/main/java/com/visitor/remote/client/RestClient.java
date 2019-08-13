package com.visitor.remote.client;


import org.springframework.http.HttpHeaders;

import java.util.Map;

public interface RestClient {
    void createVisitor(Map<String, Object> bodyMap, HttpHeaders headers, String uri);
}
