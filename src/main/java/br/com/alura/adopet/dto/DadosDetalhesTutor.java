package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Tutor;

public record DadosDetalhesTutor(Long id, String foto, String nome, String email, String telefone, String cidade, String sobre) {
    public DadosDetalhesTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getFoto(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone(), tutor.getCidade(), tutor.getSobre());
    }
}