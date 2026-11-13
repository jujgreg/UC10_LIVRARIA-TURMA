package br.senac.sp.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome da categoria é Obrigatoria!")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
