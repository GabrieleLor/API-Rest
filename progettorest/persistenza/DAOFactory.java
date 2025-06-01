package it.unibas.progettorest.persistenza;

import it.unibas.progettorest.modello.Configurazione;

import static it.unibas.progettorest.enums.EStrategiaPersistenza.DB_HIBERNATE;
import it.unibas.progettorest.persistenza.mock.DAOPaginaMock;
import it.unibas.progettorest.persistenza.mock.DAOSitoMock;
import it.unibas.progettorest.persistenza.mock.DAOUtenteMock;
import lombok.Getter;

@Getter

public class DAOFactory {

    private static final DAOFactory singleton = new DAOFactory();

    public static DAOFactory getInstance() {
        return singleton;
    }
    
    private IDAOUtente daoUtente;
    private IDAOSito daoSito;
    private IDAOPagina daoPagina;

    private DAOFactory() {
        if (Configurazione.getInstance().getStrategiaDb().equals(DB_HIBERNATE)) {

        } else {
            daoPagina = new DAOPaginaMock();
            daoSito = new DAOSitoMock();
            daoUtente = new DAOUtenteMock();
        }
    }

}
