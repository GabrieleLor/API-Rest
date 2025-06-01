/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unibas.progettorest.persistenza;

import it.unibas.progettorest.modello.Utente;
import it.unibas.progettorest.persistenza.IDAOGenerico;

/**
 *
 * @author gabri
 */
public interface IDAOUtente extends IDAOGenerico<Utente> {

    public Utente findByEmail(String email);
}
