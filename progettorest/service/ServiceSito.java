package it.unibas.progettorest.service;

import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.modello.dto.SitoDTO;
import it.unibas.progettorest.persistenza.DAOFactory;
import it.unibas.progettorest.persistenza.IDAOPagina;
import it.unibas.progettorest.persistenza.IDAOSito;
import it.unibas.progettorest.util.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped

public class ServiceSito {

    public List<SitoDTO> cercaSiti(LocalDate data) {
        IDAOPagina daoPagina = DAOFactory.getInstance().getDaoPagina();
        IDAOSito daoSito = DAOFactory.getInstance().getDaoSito();
        List<Sito> lista = new ArrayList<>();
        for (Sito sito : daoSito.findAll()) {
            if (daoPagina.findAgg(sito, data)) {
                lista.add(sito);
            }
        }

        return Mapper.map(lista, SitoDTO.class);
    }

}
