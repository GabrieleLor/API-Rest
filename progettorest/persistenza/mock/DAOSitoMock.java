/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.progettorest.persistenza.mock;

import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.persistenza.IDAOSito;
import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.persistenza.IDAOGenerico;
import java.time.LocalDate;

/**
 *
 * @author gabri
 */
public class DAOSitoMock extends DAOGenericoMock<Sito> implements IDAOSito{

    @Override
    public boolean findAgg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean findAgg(LocalDate data) {
        for (Sito sito : this.findAll()) {
            for (Pagina pagina : sito.getListaPagine()) {
                if(pagina.getDataUltimaModifica().isBefore(data)){
                    return false;
                }
            }
        }
        return true;
    }

   
    
}
