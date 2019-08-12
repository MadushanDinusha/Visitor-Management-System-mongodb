package com.visitor.repository.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.visitor.domain.Visitor;
import com.visitor.repository.VisitorRepository;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

public class VisitorRepositoryImpl implements VisitorRepository {

    private JacksonDBCollection<Visitor, String> jacksonCollection;

    public VisitorRepositoryImpl(DB db) {
        DBCollection collection = db.getCollection(Visitor.COLLECTION_NAME);
        jacksonCollection = JacksonDBCollection.wrap(collection, Visitor.class, String.class);
    }

    public Visitor insertVisitor(Visitor visitor) {
        WriteResult<Visitor, String> result = jacksonCollection.insert(visitor);
        return result.getSavedObject();
    }
}
