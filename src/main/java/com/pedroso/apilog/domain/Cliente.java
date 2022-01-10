package com.pedroso.apilog.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(name = "fone")
    private String telefone;
}
