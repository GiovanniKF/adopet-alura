package br.com.alura.adopet.controller;

import br.com.alura.adopet.dto.adocao.DadosNovaAdocao;
import br.com.alura.adopet.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity adotar(@RequestBody @Valid DadosNovaAdocao dados, UriComponentsBuilder uriBuilder) {
        DadosNovaAdocao adocao = service.adotar(dados);
        var uri = uriBuilder.path("/adocao/{id}").buildAndExpand(adocao.petId()).toUri();

        return ResponseEntity.created(uri).body(adocao);
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity cancelar(@PathVariable UUID id) {
//
//    }
}
