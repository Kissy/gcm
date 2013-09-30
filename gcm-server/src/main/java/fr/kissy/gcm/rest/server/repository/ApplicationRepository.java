package fr.kissy.gcm.rest.server.repository;

import fr.kissy.gcm.rest.server.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Guillaume Le Biller
 */
@Repository
public class ApplicationRepository extends SimpleMongoRepository<Application, String> {
    /**
     * @inheritDoc
     */
    @Autowired
    public ApplicationRepository(MongoRepositoryFactory mongoRepositoryFactory, MongoOperations mongoOperations) {
        super(mongoRepositoryFactory.<Application, String>getEntityInformation(Application.class), mongoOperations);
    }

    public Application findByUser(String user, String id) {
        Query query = Query.query(Criteria.where("user").is(user))
                .addCriteria(Criteria.where("id").is(id));
        return getMongoOperations().findOne(query, Application.class);
    }
}
