package br.com.alura.adopet.domain.tutor;

import jakarta.persistence.*;
import lombok.*;

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
    private String cidade;
    private String sobre;

    public Tutor(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizaPerfil(DadosAtualizaTutor dados) {
        this.foto = dados.foto();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cidade = dados.cidade();
        this.sobre = dados.sobre();
    }
}
