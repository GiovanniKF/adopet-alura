package br.com.alura.adopet.service;

import br.com.alura.adopet.dto.DadosAtualizaTutor;
import br.com.alura.adopet.dto.DadosCadastroTutor;
import br.com.alura.adopet.dto.DadosDetalhesTutor;
import br.com.alura.adopet.dto.DadosListagemTutor;
import br.com.alura.adopet.model.Tutor;
import br.com.alura.adopet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public DadosCadastroTutor cadastrar(DadosCadastroTutor dados) {
        Tutor tutor = new Tutor(dados);
        repository.save(tutor);
        return new DadosCadastroTutor(tutor);
    }

    public DadosDetalhesTutor atualizar(DadosAtualizaTutor dados) {
        Tutor tutor = repository.getReferenceById(dados.id());
        tutor.atualizaPerfil(dados);
        return new DadosDetalhesTutor(tutor);
    }

    public DadosDetalhesTutor detalhar(Long id) {
        if (!repository.existsById(id)) {
            return null;
        }

        Tutor tutor = repository.getReferenceById(id);
        return new DadosDetalhesTutor(tutor);
    }

    public Page<DadosListagemTutor> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTutor::new);
    }

    public Boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
