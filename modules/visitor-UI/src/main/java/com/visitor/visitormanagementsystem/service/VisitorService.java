package com.visitor.visitormanagementsystem.service;

import com.visitor.domain.Visitor;

import java.util.List;

public interface VisitorService {
    void processVisitorSave(Visitor visitor);
    List<Visitor> getAllVisitors();
}
