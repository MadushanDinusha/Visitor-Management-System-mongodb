package com.visitor.repository.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.visitor.domain.Visitor;
import com.visitor.repository.VisitorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mongojack.JacksonDBCollection;

import java.util.List;

public class VisitorRepositoryImpl implements VisitorRepository {
    private static final Logger LOGGER = LogManager.getLogger(VisitorRepositoryImpl.class);

    private JacksonDBCollection<Visitor, String> jacksonCollection;

    public VisitorRepositoryImpl(DB db) {
        DBCollection collection = db.getCollection(Visitor.COLLECTION_NAME);
        jacksonCollection = JacksonDBCollection.wrap(collection, Visitor.class, String.class);
    }

    public void insertVisitor(Visitor visitor) {
        LOGGER.info("Inserting visitor to database [{}]",visitor);
        jacksonCollection.insert(visitor);
    }

    public List<Visitor> getAllVisitors(){
        LOGGER.info("Retrieving all visitors");
        return jacksonCollection.find().toArray();
    }
}
