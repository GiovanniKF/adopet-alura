package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Tutor;

public record DadosListagemTutor(Long id, String nome, String email, String telefone, String cidade) {
    public DadosListagemTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone(), tutor.getCidade());
    }
}