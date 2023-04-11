package br.com.alura.adopet.model;

import br.com.alura.adopet.dto.pet.DadosAtualizaPet;
import br.com.alura.adopet.dto.pet.DadosCadastroPet;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "pet")
@Entity(name = "Pet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String foto;

    @Enumerated(EnumType.STRING)
    private Porte porte;

    private String descricao;
    private Boolean adotado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="abrigo_id")
    private Abrigo abrigo;

    public Pet(DadosCadastroPet dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.foto = dados.foto();
        this.porte = dados.porte();
        this.descricao = dados.descricao();
        this.adotado = false;
        this.createdAt = LocalDateTime.now();
    }

    public void atualizaPet(DadosAtualizaPet dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.foto = dados.foto();
        this.porte = dados.porte();
        this.descricao = dados.descricao();
        this.adotado = dados.adotado();
        this.updatedAt = LocalDateTime.now();
    }

    public void petAdotado() {
        this.adotado = true;
    }
}
