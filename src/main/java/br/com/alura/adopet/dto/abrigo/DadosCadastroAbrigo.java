package br.com.alura.adopet.dto.abrigo;

import br.com.alura.adopet.model.Abrigo;
import br.com.alura.adopet.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAbrigo(
        Long id,
        @NotBlank String nome,
        @NotNull Endereco endereco
) {

    public DadosCadastroAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getEndereco());
    }
}
