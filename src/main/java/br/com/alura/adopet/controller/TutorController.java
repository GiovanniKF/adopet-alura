package br.com.alura.adopet.controller;

import br.com.alura.adopet.domain.tutor.DadosListagemTutor;
import br.com.alura.adopet.domain.tutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tutores")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados, UriComponentsBuilder uriBuilder) {
        var tutor = new Tutor(dados);
        tutorRepository.save(tutor);

        var uri = uriBuilder.path("/tutores/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesTutor(tutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaTutor dados) {
        var tutor = tutorRepository.getReferenceById(dados.id());
        tutor.atualizaPerfil(dados);

        return ResponseEntity.ok(new DadosDetalhesTutor(tutor));
    }

    @GetMapping("/{id}")
    public ResponseEntity listar(@PathVariable Long id) {
        if(!tutorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
            //return ResponseEntity.notFound().build();
        }

        var tutor = tutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesTutor(tutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTutor>> listarTodos(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var tutores = tutorRepository.findAll(paginacao).map(DadosListagemTutor::new);
        return ResponseEntity.ok(tutores);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        if(!tutorRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
            //return ResponseEntity.notFound().build();
        }

        tutorRepository.deleteById(id);
        return ResponseEntity.ok("Tutor deletado com sucesso.");
    }
}
