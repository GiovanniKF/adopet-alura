package br.com.alura.adopet.model;

import br.com.alura.adopet.dto.adocao.DadosNovaAdocao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "adocao")
@Entity(name = "Adocao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adocao {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    private LocalDate data;

    public Adocao(DadosNovaAdocao dados) {
        this.data = dados.data();
    }
}
