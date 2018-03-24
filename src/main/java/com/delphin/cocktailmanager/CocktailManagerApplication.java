package com.delphin.cocktailmanager;

import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class CocktailManagerApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(CocktailManagerApplication.class, args);
	}


	@Override
	protected String getDatabaseName() {
	    return "cocktail-db";
	}

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}
}



