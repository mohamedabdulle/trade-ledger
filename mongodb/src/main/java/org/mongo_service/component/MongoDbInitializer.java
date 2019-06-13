package org.mongo_service.component;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import org.mongo_service.model.ClientTransactionsDocument;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class MongoDbInitializer implements ApplicationRunner {

    @Value("${spring.data.mongodb.collection}")
    private String collection;

//    @Value("${spring.data.mongodb.stub-file-location-json}")
//    private String stubFileLocationJson;

    @Value("${spring.data.mongodb.stub-file-location}")
    private String stubFileLocation;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        ClassLoader cl = this.getClass().getClassLoader();
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
//        Resource[] resources = resolver.getResources(stubFileLocationJson);

//        Map<String, Class<?>> map = new HashMap<>();
//        map.put("distributiontransactions.json", DistributionTransactions.class);
//        map.put("clienttransactionsdocument.json", ClientTransactionsDocument.class);

//        for (Resource resource : resources) {
//            if (resource.getFile().isFile()) {
//                if (map.containsKey(resource.getFilename())) {
//                    mongoOperations
//                            .insert(new ObjectMapper().readValue(resource.getFile(), map.get(resource.getFilename())));
//                }
//            }
//        }
        mongoOperations
                .insertAll(new ObjectMapper().readValue(new ClassPathResource(stubFileLocation + collection + ".json").getFile(), new TypeReference<List<ClientTransactionsDocument>>(){}));
    }
}
