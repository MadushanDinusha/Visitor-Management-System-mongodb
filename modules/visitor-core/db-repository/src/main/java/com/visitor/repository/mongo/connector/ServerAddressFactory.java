package com.visitor.repository.mongo.connector;

import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.List;

public class ServerAddressFactory {

    public static List<ServerAddress> convertToServerAddresses(String replicaSetString) {
        List<ServerAddress> replicaSets = new ArrayList<>();
        String[] serverDetails = replicaSetString.split(",");
        for (String serverDetail : serverDetails) {
            String[] serverProperties = serverDetail.split(":");
            try {
                replicaSets.add(new ServerAddress(serverProperties[0], Integer.parseInt(serverProperties[1])));
            } catch (Exception e) {
            }
        }
        return replicaSets;
    }
}
