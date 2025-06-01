package it.unibas.progettorest.persistenza.mock;

import it.unibas.progettorest.modello.Pagina;
import it.unibas.progettorest.modello.Sito;
import it.unibas.progettorest.modello.Utente;
import java.time.LocalDate;
import java.time.Month;

public class RepositoryMock extends RepositoryGenericoMock {

    private static final RepositoryMock singleton = new RepositoryMock();

    private RepositoryMock() {
        Utente u1 = new Utente("admin@unibas.it", "Admin!");
        saveOrUpdate(u1);
        
        Sito s1 = new Sito("Sky", "www.sky.com");
        saveOrUpdate(s1);
        Sito s2 = new Sito("prime", "www.prime.it");
        saveOrUpdate(s2);
        
        Pagina p1 = new Pagina("/homePage   ", "Pagina", LocalDate.of(2020, Month.MARCH, 10), s1.getId());
        saveOrUpdate(p1);
        Pagina p2 = new Pagina("/lastPage   ", "Ultima pagina", LocalDate.of(2023, Month.MARCH, 10), s1.getId());
        saveOrUpdate(p2);
        
        u1.getListaPreferiti().add(p1);
        
        s1.getListaPagine().add(p1);
        s1.getListaPagine().add(p2);
    }

    public static RepositoryMock getInstance() {
        return singleton;
    }

}
