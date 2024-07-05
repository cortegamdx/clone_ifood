package com.br.algaworks.algafoodapi.domain.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "TB_GRUPO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column
    private String nome;

}
