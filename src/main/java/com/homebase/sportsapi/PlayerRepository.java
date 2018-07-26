package com.homebase.sportsapi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
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
        setCollection(database.getCollection(sport));
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
	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public List<Player> getPlayerData(){
        players = new ArrayList<Player>();
        Player p1 = new Player("Carl", "Reed", "Quarterback", 23);
        players.add(p1);
        return players;
    }
}