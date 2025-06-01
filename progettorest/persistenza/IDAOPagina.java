/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unibas.progettorest.persistenza;

import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.persistenza.IDAOGenerico;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface IDAOPagina extends IDAOGenerico<Pagina> {


    public boolean findAgg(Sito sito, LocalDate data);
}
