package com.visitor.repository.mongo.connector;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.apache.cxf.common.i18n.Exception;

import java.util.List;

public class MongoConnector {

    private List<ServerAddress> replicas;

    private String dbName;

    private DB db;

    private Mongo mongo;

    public MongoConnector(List<ServerAddress> replicas, String dbName) {
        this.replicas = replicas;
        this.dbName = dbName;
    }

    public void connect() throws Exception {
        this.mongo = new MongoClient(replicas);
        this.db = mongo.getDB(dbName);
    }

    public DB db() {
        return db;
    }

    public void disconnect() {
        mongo.close();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MongoConnectorImpl{");
        sb.append("replicas=").append(replicas);
        sb.append(", dbName='").append(dbName).append('\'');
        sb.append(", db=").append(db);
        sb.append(", mongo=").append(mongo);
        sb.append('}');
        return sb.toString();
    }
}
