package fr.kissy.gcm.rest.server.repository;

import fr.kissy.gcm.rest.server.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Guillaume Le Biller
 */
@Repository
public class DeviceRepository extends SimpleMongoRepository<Device, String> {
    /**
     * Default constructor
     */
    @Autowired
    public DeviceRepository(MongoRepositoryFactory mongoRepositoryFactory, MongoOperations mongoOperations) {
        super(mongoRepositoryFactory.<Device, String>getEntityInformation(Device.class), mongoOperations);
    }

    public List<String> findAllRegistrationByApplication(String application) {
        Query query = Query.query(Criteria.where("application").is(application));
        query.fields().include("registration");
        return getMongoOperations().find(query, String.class);
    }

    public List<Device> findAllByApplication(String application) {
        Query query = Query.query(Criteria.where("application").is(application));
        return getMongoOperations().find(query, Device.class);
    }

    public Device findByApplication(String application, String id) {
        Query query = Query.query(Criteria.where("application").is(application))
                .addCriteria(Criteria.where("id").is(id));
        return getMongoOperations().findOne(query, Device.class);
    }
}
