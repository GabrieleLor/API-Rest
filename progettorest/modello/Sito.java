package it.unibas.progettorest.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Sito {
    
    private Long id;
    private String nome;
    private String indirizzo;
    private List<Pagina> listaPagine = new ArrayList<>();

    public Sito(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }
    
    
    
}
