package com.dst.subaccounting.trade_ledger.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.dst.subaccounting.trade_ledger.model.setup.DistributionTransactions;
import com.dst.subaccounting.trade_ledger.model.setup.ClientTransactionsDocument;
import com.fasterxml.jackson.databind.ObjectMapper;

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
                .insert(new ObjectMapper().readValue(new ClassPathResource(stubFileLocation + collection + ".json").getFile(), ClientTransactionsDocument.class));
    }
}
