package it.unibas.progettorest.modello.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SitoDTO {
    
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String indirizzo;
    
}
