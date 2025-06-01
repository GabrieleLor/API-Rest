/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unibas.progettorest.persistenza;

import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.persistenza.IDAOGenerico;
import java.time.LocalDate;

/**
 *
 * @author gabri
 */
public interface IDAOSito extends IDAOGenerico<Sito> {

    public boolean findAgg();

    public boolean findAgg(LocalDate data);
}
