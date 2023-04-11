package br.com.alura.adopet.dto.pet;

import br.com.alura.adopet.model.Porte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPet(
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String idade,

        @NotBlank
        String foto,

        @NotNull
        Porte porte,

        @NotBlank
        String descricao,

        @NotNull
        Boolean adotado
) {
}
