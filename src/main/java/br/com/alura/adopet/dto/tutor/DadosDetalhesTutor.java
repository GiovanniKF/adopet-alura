package br.com.alura.adopet.dto.tutor;

import br.com.alura.adopet.model.Endereco;
import br.com.alura.adopet.model.Tutor;

public record DadosDetalhesTutor(Long id, String foto, String nome, String email, String telefone, Endereco endereco, String sobre) {
    public DadosDetalhesTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getFoto(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone(), tutor.getEndereco(), tutor.getSobre());
    }
}