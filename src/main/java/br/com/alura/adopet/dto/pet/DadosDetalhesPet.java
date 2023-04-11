package br.com.alura.adopet.dto.pet;

import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.Porte;
public record DadosDetalhesPet(Long id, String nome, String idade, String foto, Porte porte, String descricao, Boolean adotado) {
    public DadosDetalhesPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getFoto(), pet.getPorte(), pet.getDescricao(), pet.getAdotado());
    }
}
