package br.com.alura.adopet.domain.tutor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTutor(
        @NotNull Long id,
        String foto,
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotBlank String cidade,
        @NotBlank String sobre
) {
}
