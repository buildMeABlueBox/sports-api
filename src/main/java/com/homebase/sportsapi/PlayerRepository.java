package com.homebase.sportsapi;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerRepository - class to interact with a repository (File/DB/etc)
 */
public class PlayerRepository {
    private MongoClient mongo;
    private MongoDatabase database;
	private MongoCollection<Document> collection;
    private List<Player> players;

    public PlayerRepository(String sport){
        mongo = new MongoClient();
        database = mongo.getDatabase("sports");
        collection = database.getCollection(sport);
    }

    /**
	 * @return the collection
	 */
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(String sport) {
		this.collection = database.getCollection(sport);
	}

	public List<Player> getPlayerData(){
        ArrayList<Player> players = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try{
            while(cursor.hasNext()){
                String jsonString = cursor.next().toJson();
                Gson g = new Gson();
                Player p = g.fromJson(jsonString, Player.class);
                players.add(p);
            }
        }finally{
            cursor.close();
        }
        return players;
    }
}