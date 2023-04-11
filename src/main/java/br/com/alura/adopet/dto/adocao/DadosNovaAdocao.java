package br.com.alura.adopet.dto.adocao;

import br.com.alura.adopet.model.Adocao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record DadosNovaAdocao(
        UUID id,

        @NotNull
        Long petId,

        @NotNull
        Long tutorId,

        @NotNull
        LocalDate data
) {
    public DadosNovaAdocao(Adocao adocao) {
        this(adocao.getId(), adocao.getPet().getId(), adocao.getTutor().getId(), adocao.getData());
    }
}
