package com.visitor.remote.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.visitor.domain.Visitor;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;

import javax.ws.rs.core.MediaType;

public class RestClientImpl implements RestClient {

    private WebResource webResource;

    public RestClientImpl(String uri) {
        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(MultiPartWriter.class);
        clientConfig.getClasses().add(ByteArrayHttpMessageConverter.class);
        Client client = Client.create(clientConfig);
        webResource = client.resource(uri);
    }

    @Override
    public void save(Visitor visitor) {
        ClientResponse response = webResource.path("/createCampaign")
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, visitor);
        if (response.getStatus() != 200) {
        }
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
