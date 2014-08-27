package com.tripping.question.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.tripping.question.core.repository.Marker;

@Configuration
@EnableMongoRepositories(basePackageClasses = Marker.class)
public class MongoConfig extends AbstractMongoConfiguration{
    @Override
    protected String getDatabaseName() {
        return "trippingQuestions";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}
