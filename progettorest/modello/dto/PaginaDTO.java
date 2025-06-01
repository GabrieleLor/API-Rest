package it.unibas.progettorest.modello.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaginaDTO {
    
    private Long id;
    @NotBlank
    private String percorsoRelativo;
    @NotBlank
    private String titolo;
    @NotNull
    private LocalDate dataUltimaModifica;
    private Long idSito;
    
}
