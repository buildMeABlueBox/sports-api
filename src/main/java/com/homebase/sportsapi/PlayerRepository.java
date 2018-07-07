package com.homebase.sportsapi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.List;

/**
 * PlayerRepository - class to interact with a repository (File/DB/etc)
 */
public class PlayerRepository {
    private MongoClient mongo;
    private MongoDatabase database;
	private MongoCollection<Document> table;
    private List<Player> players;

    public PlayerRepository(String sport){
        mongo = new MongoClient();
        database = mongo.getDatabase("sports");
        setTable(database.getCollection(sport));
    }

    /**
	 * @return the table
	 */
	public MongoCollection<Document> getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(MongoCollection<Document> table) {
		this.table = table;
	}

	public List<Player> getPlayers(){
        return players;
    }

    // public Player getPlayer(int id){
    //     for(player a:)
    // }
}