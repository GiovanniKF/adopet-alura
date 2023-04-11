package br.com.alura.adopet.service;

import br.com.alura.adopet.dto.abrigo.DadosAtualizaAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosCadastroAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosDetalhesAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosListagemAbrigo;
import br.com.alura.adopet.model.Abrigo;
import br.com.alura.adopet.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public DadosCadastroAbrigo cadastrar(DadosCadastroAbrigo dados) {
        Abrigo abrigo = new Abrigo(dados);
        repository.save(abrigo);
        return new DadosCadastroAbrigo(abrigo);
    }

    public DadosDetalhesAbrigo atualizar(DadosAtualizaAbrigo dados) {
        Abrigo abrigo = repository.getReferenceById(dados.id());
        abrigo.atualizaAbrigo(dados);
        return new DadosDetalhesAbrigo(abrigo);
    }

    public DadosDetalhesAbrigo detalhar(Long id) {
        if (!repository.existsById(id)) {
            return null;
        }

        Abrigo abrigo = repository.getReferenceById(id);
        return new DadosDetalhesAbrigo(abrigo);
    }

    public Page<DadosListagemAbrigo> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemAbrigo::new);
    }

    public Boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
