package br.com.alura.adopet.domain.tutor;

public record DadosListagemTutor(Long id, String nome, String email, String telefone, String cidade) {
    public DadosListagemTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone(), tutor.getCidade());
    }
}