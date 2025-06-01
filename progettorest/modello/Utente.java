package it.unibas.progettorest.modello;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Utente {
    
    private Long id;
    private String email;
    private String password;
    private List<Pagina> listaPreferiti = new ArrayList<>();

    public Utente(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    
    
}
