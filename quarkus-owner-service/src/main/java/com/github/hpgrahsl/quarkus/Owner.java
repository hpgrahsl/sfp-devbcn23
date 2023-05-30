package com.github.hpgrahsl.quarkus;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="mysql1.petclinic.owners")
public class Owner {

  @BsonId
  public Document _id;
  
  public String first_name;
  public String last_name;
  public String city;
  public String address;
  public String telephone;

}
