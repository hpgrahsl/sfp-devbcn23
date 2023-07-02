package com.github.hpgrahsl.quarkus;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import org.bson.Document;

@ApplicationScoped
public class OwnerRepository implements
        PanacheMongoRepositoryBase<OwnerWithPets,Integer> {
            
        // public Optional<OwnerWithPets> findByDocumentId(Integer id) {
        //     return find(
        //         new Document("_id", new Document("id",id))
        //     ).singleResultOptional();
        // }

}
