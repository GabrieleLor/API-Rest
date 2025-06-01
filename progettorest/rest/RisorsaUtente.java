package it.unibas.progettorest.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.unibas.progettorest.modello.dto.PaginaDTO;
import it.unibas.progettorest.modello.dto.UtenteDTO;
import it.unibas.progettorest.service.ServiceUtente;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@RequestScoped
@Path("/utenti")

public class RisorsaUtente {
    
    @Inject
    private ServiceUtente serviceUtente;
    
    @Context
    private SecurityContext securityContext;
    
    @POST
    @Path("/logni")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public String login(UtenteDTO utenteLogin){
        return serviceUtente.login(utenteLogin);
    }
    
    @PUT
    @Path("/me/aggiorna")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @SecurityRequirement(name="bearerAuth")
    public void aggiornaPreferiti(@Valid @NotNull PaginaDTO paginaAgg){
        String email = securityContext.getUserPrincipal().getName();
        serviceUtente.aggiornaPreferito(paginaAgg, email);
    }
    
    @DELETE
    @Path("/me/elimina")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @SecurityRequirement(name="bearerAuth")
    public void eliminaVecchiPreferiti(){
        String email = securityContext.getUserPrincipal().getName();
        serviceUtente.eliminaVecchiPreferiti(email);
    }
    
}
