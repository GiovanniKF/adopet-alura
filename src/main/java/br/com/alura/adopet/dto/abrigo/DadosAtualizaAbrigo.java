package br.com.alura.adopet.dto.abrigo;

import br.com.alura.adopet.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaAbrigo(
        @NotNull Long id,
        @NotBlank String nome,
        @NotNull Endereco endereco
) {
}
