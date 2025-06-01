package it.unibas.progettorest.modello;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Pagina {
    
    private Long id;
    private String percorsoRelativo;
    private String titolo;
    private LocalDate dataUltimaModifica;
    private Long idSito;

    public Pagina(String percorsoRelativo, String titolo, LocalDate dataUltimaModifica, Long idSito) {
        this.percorsoRelativo = percorsoRelativo;
        this.titolo = titolo;
        this.dataUltimaModifica = dataUltimaModifica;
        this.idSito = idSito;
    }
    
    
    
}
