package br.com.alura.adopet.controller;

import br.com.alura.adopet.dto.pet.DadosListagemPet;
import br.com.alura.adopet.dto.pet.DadosAtualizaPet;
import br.com.alura.adopet.dto.pet.DadosCadastroPet;
import br.com.alura.adopet.dto.pet.DadosDetalhesPet;
import br.com.alura.adopet.service.PetService;
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
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPet dados, UriComponentsBuilder uriBuilder) {
        DadosCadastroPet pet = service.cadastrar(dados);
        var uri = uriBuilder.path("/pets/{id}").buildAndExpand(pet.id()).toUri();

        return ResponseEntity.created(uri).body(pet);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPet dados) {
        DadosDetalhesPet pet = service.atualizar(dados);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        DadosDetalhesPet pet = service.detalhar(id);

        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado.");
        }

        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPet>> listarTodos(@PageableDefault Pageable paginacao) {
        Page<DadosListagemPet> pets = service.listarTodos(paginacao);
        return ResponseEntity.ok(pets);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!service.deletar(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado.");
        }

        return ResponseEntity.ok("Pet deletado com sucesso.");
    }

}
