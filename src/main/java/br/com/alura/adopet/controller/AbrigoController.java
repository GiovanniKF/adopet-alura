package br.com.alura.adopet.controller;

import br.com.alura.adopet.dto.abrigo.DadosAtualizaAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosCadastroAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosDetalhesAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosListagemAbrigo;
import br.com.alura.adopet.service.AbrigoService;
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
@RequestMapping({"abrigos"})
public class AbrigoController {

    @Autowired
    private AbrigoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados, UriComponentsBuilder uriBuilder) {
        DadosCadastroAbrigo abrigo = service.cadastrar(dados);
        var uri = uriBuilder.path("/abrigos/{id}").buildAndExpand(abrigo.id()).toUri();

        return ResponseEntity.created(uri).body(abrigo);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaAbrigo dados) {
        DadosDetalhesAbrigo abrigo = service.atualizar(dados);
        return ResponseEntity.ok(abrigo);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        DadosDetalhesAbrigo abrigo = service.detalhar(id);

        if (abrigo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abrigo não encontrado.");
        }

        return ResponseEntity.ok(abrigo);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAbrigo>> listarTodos(@PageableDefault Pageable paginacao) {
        Page<DadosListagemAbrigo> abrigos = service.listarTodos(paginacao);
        return ResponseEntity.ok(abrigos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!service.deletar(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abrigo não encontrado.");
        }

        return ResponseEntity.ok("Abrigo deletado com sucesso.");
    }
}
