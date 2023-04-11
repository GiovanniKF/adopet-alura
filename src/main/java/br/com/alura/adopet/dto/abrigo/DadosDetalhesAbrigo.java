package br.com.alura.adopet.dto.abrigo;

import br.com.alura.adopet.model.Abrigo;
import br.com.alura.adopet.model.Endereco;

public record DadosDetalhesAbrigo(Long id, String nome, Endereco endereco) {
    public DadosDetalhesAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getEndereco());
    }
}
