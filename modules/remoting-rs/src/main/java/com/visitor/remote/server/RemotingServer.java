package com.visitor.remote.server;

import com.visitor.RemotingServerProcessor;
import com.visitor.domain.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/visitor")
public class RemotingServer {
    private static final Logger LOGGER = LogManager.getLogger(RemotingServer.class);

    @Autowired
    @Qualifier("remotingServerProcessor")
    private RemotingServerProcessor remotingServerProcessor;

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@RequestBody Map<String, String> request) {
        try {
            Visitor visitor = new Visitor();
            visitor.setVisitorId(request.get("visitorId"));
            visitor.setName(request.get("name"));
            LOGGER.info("Sending to visitor to save [{}]",visitor);
            remotingServerProcessor.save(visitor);
        } catch (Throwable t) {
            LOGGER.info("Error occurred while sending visitor to save",t);
            throw new RuntimeException(t);
        }
    }

    @RequestMapping(value = "/getAllVisitors",method = RequestMethod.GET)
    public List<Visitor> getAllVisitors(){
        LOGGER.info("Getting all visitors");
        return remotingServerProcessor.getAllVisitors();
    }
}
