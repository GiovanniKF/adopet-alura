package br.com.alura.adopet.model;

import br.com.alura.adopet.dto.abrigo.DadosAtualizaAbrigo;
import br.com.alura.adopet.dto.abrigo.DadosCadastroAbrigo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "abrigo")
@Entity(name = "Abrigo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Abrigo(DadosCadastroAbrigo dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.endereco = dados.endereco();
        this.createdAt = LocalDateTime.now();
    }

    public void atualizaAbrigo(DadosAtualizaAbrigo dados) {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
        this.updatedAt = LocalDateTime.now();
    }
}
