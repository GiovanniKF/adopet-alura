package br.com.alura.adopet.dto.tutor;

import br.com.alura.adopet.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTutor(
        @NotNull Long id,
        String foto,
        @NotBlank String nome,
        @NotBlank String telefone,
        Endereco endereco,
        @NotBlank String sobre
) {
}
