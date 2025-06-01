package it.unibas.progettorest.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.unibas.progettorest.modello.dto.SitoDTO;
import it.unibas.progettorest.service.ServiceSito;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@RequestScoped
@Path("/siti")

public class RisorsaSito {
    
    @Inject
    private ServiceSito serviceSito;
    
    @Context
    private SecurityContext securityContext;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    @Path("")
    public List<SitoDTO> cercaSiti(@QueryParam("data") @NotNull LocalDate data){
        return serviceSito.cercaSiti(data);
    }
    
}
