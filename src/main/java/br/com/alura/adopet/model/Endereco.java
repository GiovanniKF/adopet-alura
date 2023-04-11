package br.com.alura.adopet.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
    private String cep;
}
