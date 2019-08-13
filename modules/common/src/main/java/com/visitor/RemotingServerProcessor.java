package com.visitor;

import com.visitor.domain.Visitor;

import java.util.List;

public interface RemotingServerProcessor {

    void save(Visitor visitor);
    List<Visitor> getAllVisitors();
}
