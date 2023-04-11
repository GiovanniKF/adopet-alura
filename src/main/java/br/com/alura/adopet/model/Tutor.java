package br.com.alura.adopet.model;

import br.com.alura.adopet.dto.tutor.DadosAtualizaTutor;
import br.com.alura.adopet.dto.tutor.DadosCadastroTutor;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "tutor")
@Entity(name = "Tutor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String foto;
    private String email;
    private String senha;
    private String telefone;
    private String sobre;

    @Embedded
    private Endereco endereco;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Tutor(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.createdAt = LocalDateTime.now();
    }

    public void atualizaPerfil(DadosAtualizaTutor dados) {
        this.foto = dados.foto();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
        this.sobre = dados.sobre();
        this.updatedAt = LocalDateTime.now();
    }

}
