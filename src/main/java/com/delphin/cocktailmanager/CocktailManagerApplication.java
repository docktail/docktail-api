package com.delphin.cocktailmanager;

import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${database.name}")
    private String databaseName;

    @Value("${database.port}")
    private String databasePort;

    @Value("${database.host}")
    private String databaseHost;

	@Override
	protected String getDatabaseName() {
        return databaseName;
	}

	@Override
	public MongoClient reactiveMongoClient() {
        return MongoClients.create(
		        String.format("mongodb://%s:%s", databaseHost, databasePort)
        );
	}
}



