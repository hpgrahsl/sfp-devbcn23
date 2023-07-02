package com.github.hpgrahsl.quarkus;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import java.net.URI;

import org.jboss.resteasy.reactive.MultipartForm;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("owners")
public class OwnerResource {

  @Inject
  OwnerRepository repository;

  @Inject
  Template ownersList;

  @Inject
  Template owner;

  @GET
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance getOwners(@QueryParam("lastName") @DefaultValue("") String lastName) {
    return lastName.isEmpty()
        ? ownersList.data("owners", repository.listAll())
        :  ownersList.data("owners", repository.list("owner.last_name LIKE ?1",lastName));
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance getOwnerById(@PathParam("id") Integer id) {
    return owner.data("o", repository.findByIdOptional(id).orElseThrow(NotFoundException::new));
  }

  @POST
  @Path("{id}")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response updateOwner(@PathParam("id") Integer id, @MultipartForm OwnerFormFields ownerFormFields) {
    OwnerWithPets ownerWithPets = repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    ownerWithPets = ownerFormFields.updateEntity(ownerWithPets);
    repository.update(ownerWithPets);
    return Response.status(Status.MOVED_PERMANENTLY)
        .location(URI.create("/owners")).build();
  }

}
