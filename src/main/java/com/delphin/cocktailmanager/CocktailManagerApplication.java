package com.delphin.cocktailmanager;

import com.mongodb.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class CocktailManagerApplication extends AbstractReactiveMongoConfiguration {



	public static void main(String[] args) {
		SpringApplication.run(CocktailManagerApplication.class, args);
	}


//	@Override
//	public MongoClient mongoClient() {
//		return new MongoClient("localhost:27017");
//	}

	@Override
	protected String getDatabaseName() {
		return "cocktail-db";
	}

	@Override
	public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}
}



