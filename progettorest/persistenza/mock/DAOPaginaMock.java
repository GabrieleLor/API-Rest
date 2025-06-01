/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.progettorest.persistenza.mock;

import it.unibas.progettorest.persistenza.IDAOPagina;
import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.persistenza.IDAOGenerico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class DAOPaginaMock extends DAOGenericoMock<Pagina> implements IDAOPagina{

  

    @Override
    public boolean findAgg(Sito sito, LocalDate data) {
        for (Pagina pagina : sito.getListaPagine()) {
            if(pagina.getDataUltimaModifica().isBefore(data)){
                return false;
            }
        }
        return true;
        
        //return !sito.getListaPagine().stream().anyMatch(p -> p.getDataUltimaModifica().isBefore(data));
    }
    
}
