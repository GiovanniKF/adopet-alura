package br.com.alura.adopet.dto.abrigo;

import br.com.alura.adopet.model.Abrigo;

public record DadosListagemAbrigo(Long id, String nome, String cidade, String uf) {
    public DadosListagemAbrigo(Abrigo abrigo){
        this(abrigo.getId(), abrigo.getNome(), abrigo.getEndereco().getCidade(), abrigo.getEndereco().getUf());
    }
}
