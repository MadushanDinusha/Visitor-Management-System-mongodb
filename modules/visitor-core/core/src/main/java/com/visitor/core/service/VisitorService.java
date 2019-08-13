package com.visitor.core.service;

import com.visitor.domain.Visitor;

import java.util.List;

public interface VisitorService {

    void save(Visitor visitor);
    List<Visitor> getAllVisitors();
}
