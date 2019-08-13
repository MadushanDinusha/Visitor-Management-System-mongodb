package com.visitor.remote.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.visitor.domain.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RestClientImpl implements RestClient {

    private static final Logger LOGGER = LogManager.getLogger(RestClientImpl.class);

    private WebResource webResource;

    public RestClientImpl(String uri) {
        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(MultiPartWriter.class);
        clientConfig.getClasses().add(ByteArrayHttpMessageConverter.class);
        Client client = Client.create(clientConfig);
        webResource = client.resource(uri);
    }


    public void createVisitor(Map<String, Object> bodyMap, HttpHeaders headers, String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
        restTemplate.postForObject(uri, requestEntity, String.class);
    }

    public Optional<List<Visitor>> getAllVisitors(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        List<Visitor> visitorList = (List<Visitor>) restTemplate.getForObject(uri, List.class);
        return Optional.ofNullable(visitorList);
    }

    public static class ApiUrl {
        private static final String HOST_PORT_SEPARATOR = ":";
        private boolean sslEnabled;
        private String restApiHost;
        private int restApiPort;
        private String restApiUri;

        public ApiUrl(String restApiHost, int restApiPort, String restApiUri, boolean sslEnabled) {
            this.sslEnabled = sslEnabled;
            this.restApiHost = restApiHost;
            this.restApiPort = restApiPort;
            this.restApiUri = restApiUri;
        }
        public String getRestApiUrl() {
            String protocol = this.sslEnabled ? "https://" : "http://";
            return protocol + restApiHost + HOST_PORT_SEPARATOR + restApiPort + restApiUri;
        }
    }
}
