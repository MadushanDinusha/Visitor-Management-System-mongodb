package com.visitor.core;

import com.visitor.RemotingServerProcessor;
import com.visitor.domain.Visitor;
import org.springframework.stereotype.Component;

@Component(value = "remotingServerProcessor")
public class RemotingServerProcessorImpl implements RemotingServerProcessor {

    @Override
    public void save(Visitor visitor) {

    }
}
