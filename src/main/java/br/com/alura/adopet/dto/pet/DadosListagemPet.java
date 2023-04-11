package br.com.alura.adopet.dto.pet;

import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.Porte;

public record DadosListagemPet(Long id, String nome, String idade, String foto, Porte porte, String descricao, Long abrigoId) {

    public DadosListagemPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getFoto(), pet.getPorte(), pet.getDescricao(), pet.getAbrigo().getId());
    }
}
