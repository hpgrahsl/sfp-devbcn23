package com.github.hpgrahsl.quarkus;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;

public class OwnerFormFields {

  @FormParam("first_name")
  @PartType(MediaType.TEXT_PLAIN)
  public String first_name;

  @FormParam("last_name")
  @PartType(MediaType.TEXT_PLAIN)
  public String last_name;

  @FormParam("city")
  @PartType(MediaType.TEXT_PLAIN)
  public String city;

  @FormParam("address")
  @PartType(MediaType.TEXT_PLAIN)
  public String address;

  @FormParam("telephone")
  @PartType(MediaType.TEXT_PLAIN)
  public String telephone;

  public Owner updateEntity(Owner entity) {
    entity.first_name = first_name;
    entity.last_name = last_name;
    entity.city = city;
    entity.address = address;
    entity.telephone = telephone;
    return entity;
  }

}
