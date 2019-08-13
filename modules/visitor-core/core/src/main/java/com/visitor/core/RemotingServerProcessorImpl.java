package com.visitor.core;

import com.visitor.RemotingServerProcessor;
import com.visitor.core.service.VisitorService;
import com.visitor.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "remotingServerProcessor")
public class RemotingServerProcessorImpl implements RemotingServerProcessor {

    @Autowired
    private VisitorService visitorService;

    @Override
    public void save(Visitor visitor) {
        visitorService.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors(){
        return visitorService.getAllVisitors();
    }
}
