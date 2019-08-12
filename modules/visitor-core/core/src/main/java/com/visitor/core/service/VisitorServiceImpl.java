package com.visitor.core.service;

import com.visitor.domain.Visitor;
import com.visitor.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;
    @Override
    public void save(Visitor visitor) {
        Visitor savedVisitor = visitorRepository.insertVisitor(visitor);
    }
}
