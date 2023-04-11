package br.com.alura.adopet.dto.pet;

import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.Porte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String idade,

        @NotBlank
        String foto,

        @NotNull
        Porte porte,

        @NotBlank
        String descricao,

        Boolean adotado,

        @NotNull
        Long abrigoId
) {
    public DadosCadastroPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getFoto(), pet.getPorte(), pet.getDescricao(), pet.getAdotado(), pet.getAbrigo().getId());
    }
}
