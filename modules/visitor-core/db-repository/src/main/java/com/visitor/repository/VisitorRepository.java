package com.visitor.repository;

import com.visitor.domain.Visitor;

import java.util.List;

public interface VisitorRepository {

    void insertVisitor(Visitor visitor);
    List<Visitor> getAllVisitors();
}
