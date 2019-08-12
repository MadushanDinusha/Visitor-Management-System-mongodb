package com.visitor.remote.server;

import com.visitor.RemotingServerProcessor;
import com.visitor.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/visitor")
public class RemotingServer {

    @Autowired
    @Qualifier("remotingServerProcessor")
    private RemotingServerProcessor remotingServerProcessor;

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@RequestBody Map<String, String> request) {
        try {
            Visitor visitor = new Visitor();
            visitor.setVisitorId(request.get("visitorId"));
            visitor.setName(request.get("name"));
            remotingServerProcessor.save(visitor);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}
