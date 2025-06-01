package it.unibas.progettorest.persistenza.mock;

import it.unibas.progettorest.persistenza.IDAOUtente;
import it.unibas.progettorest.modello.Utente;
import it.unibas.progettorest.persistenza.IDAOGenerico;

public class DAOUtenteMock extends DAOGenericoMock<Utente> implements IDAOUtente{

    @Override
    public Utente findByEmail(String email) {
        for (Utente utente : this.findAll()) {
            if(utente.getEmail().equalsIgnoreCase(email)){
                return utente;
            }
        }
        return null;
    }
    
}
