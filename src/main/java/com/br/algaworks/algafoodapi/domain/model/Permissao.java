package com.br.algaworks.algafoodapi.domain.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "TB_PERMISSAO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;


}
