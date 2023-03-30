package br.com.alura.adopet.controller;

import br.com.alura.adopet.dto.DadosAtualizaTutor;
import br.com.alura.adopet.dto.DadosCadastroTutor;
import br.com.alura.adopet.dto.DadosDetalhesTutor;
import br.com.alura.adopet.dto.DadosListagemTutor;
import br.com.alura.adopet.service.TutorService;
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
@RequestMapping({"tutores"})
public class TutorController {

    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados, UriComponentsBuilder uriBuilder) {
        DadosCadastroTutor tutor = service.cadastrar(dados);
        var uri = uriBuilder.path("/tutores/{id}").buildAndExpand(tutor.id()).toUri();

        return ResponseEntity.created(uri).body(tutor);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaTutor dados) {
        DadosDetalhesTutor tutor = service.atualizar(dados);
        return ResponseEntity.ok(tutor);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity detalhar(@PathVariable Long id) {
        DadosDetalhesTutor tutor = service.detalhar(id);

        if (tutor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }

        return ResponseEntity.ok(tutor);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTutor>> listarTodos(@PageableDefault Pageable paginacao) {
        Page<DadosListagemTutor> tutores = service.listarTodos(paginacao);
        return ResponseEntity.ok(tutores);
    }

    @DeleteMapping({"/{id}"})
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!service.deletar(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }

        return ResponseEntity.ok("Tutor deletado com sucesso.");
    }
}
