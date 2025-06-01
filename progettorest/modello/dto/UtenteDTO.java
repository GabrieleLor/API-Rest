package it.unibas.progettorest.modello.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UtenteDTO {
    
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    
}
