package com.visitor.remote.server;

import com.visitor.RemotingServerProcessor;
import com.visitor.domain.Visitor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitor")
public class RemotingServer {

    @Qualifier("remotingServerProcessor")
    private RemotingServerProcessor remotingServerProcessor;

    @RequestMapping(value = "/createVisitor", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createCampaign(@RequestBody Visitor visitor) {
        try {
            remotingServerProcessor.save(visitor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
