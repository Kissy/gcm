package fr.kissy.gcm.rest.server.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

/**
 * @author Guillaume Le Biller
 */
@Configuration
public class DatabaseConfig {
    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.name}")
    private String databaseName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = StringUtils.isNotBlank(databaseUrl) ? new MongoClient(new MongoClientURI(databaseUrl)) : new MongoClient();
        return new SimpleMongoDbFactory(mongoClient, databaseName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public MongoRepositoryFactory mongoRepositoryFactory() throws Exception {
        return new MongoRepositoryFactory(mongoTemplate());
    }
}
