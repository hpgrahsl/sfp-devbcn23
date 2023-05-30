package com.github.hpgrahsl.quarkus;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

import org.bson.Document;

@ApplicationScoped
public class OwnerRepository implements
    PanacheMongoRepositoryBase<Owner,Integer> {

        public Optional<Owner> findByDocumentId(Integer id) {
            return find(
                new Document("_id", new Document("id",id))
            ).singleResultOptional();
        }

}
