package it.unibas.progettorest.service;

import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.modello.Utente;
import it.unibas.progettorest.modello.dto.PaginaDTO;
import it.unibas.progettorest.modello.dto.UtenteDTO;
import it.unibas.progettorest.persistenza.DAOFactory;
import it.unibas.progettorest.persistenza.IDAOPagina;
import it.unibas.progettorest.persistenza.IDAOUtente;
import it.unibas.progettorest.util.JWTUtil;
import it.unibas.progettorest.util.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

@ApplicationScoped

public class ServiceUtente {

    public String login(UtenteDTO utenteLogin) {
        IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
        Utente utenteSel = daoUtente.findByEmail(utenteLogin.getEmail());
        if(utenteSel == null){
            throw new IllegalArgumentException("Nessun utente trovato");
        }
        if(!utenteLogin.getPassword().equals(utenteSel.getPassword())){
            throw  new IllegalArgumentException("Password scorretta");
        }
        String token = JWTUtil.generaToken(utenteLogin.getEmail());
        return token;
    }

    public void aggiornaPreferito(PaginaDTO paginaAgg, String email) {
        IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
        Utente utenteSel = daoUtente.findByEmail(email);
        if(utenteSel == null){
            throw new IllegalArgumentException("Utente non trovato");
        }
        IDAOPagina daoPagina = DAOFactory.getInstance().getDaoPagina();
        Pagina paginaSel = daoPagina.findById(paginaAgg.getId());
        if(paginaSel == null){
            throw new IllegalArgumentException("Nessuna pagina trovata con questo id");
        }
        for (Pagina pagina : utenteSel.getListaPreferiti()) {
            if(pagina.getId() == paginaAgg.getId()){
                utenteSel.getListaPreferiti().remove(pagina);
            }
        }
        Pagina pagina = new Pagina(paginaSel.getPercorsoRelativo(), paginaSel.getTitolo(), paginaSel.getDataUltimaModifica(), paginaSel.getIdSito());
        utenteSel.getListaPreferiti().add(pagina);
        daoUtente.makePersistent(utenteSel);
    }

    public void eliminaVecchiPreferiti(String email) {
        IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
        LocalDate dataMenoUnMese = LocalDate.now().minusMonths(1);
        Utente utenteSel = daoUtente.findByEmail(email);
        if(utenteSel == null){
            throw new IllegalArgumentException("Utente non trovato");
        }
        for (Pagina pagina : utenteSel.getListaPreferiti()) {
            if(pagina.getDataUltimaModifica().isBefore(dataMenoUnMese)){
                utenteSel.getListaPreferiti().remove(pagina);
            }
        }
    }
    
}
