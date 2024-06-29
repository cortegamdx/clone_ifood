package com.br.algaworks.algafoodapi.jpa;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class InclusaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha bean = context.getBean(CadastroCozinha.class);

        Cozinha c1 = new Cozinha();
        c1.setNome("Brasileira");
        c1 = bean.adicionar(c1);

        Cozinha c2 = new Cozinha();
        c2.setNome("Japonesa");
        c2 = bean.adicionar(c2);

        System.out.printf("%d - %s\n", c1.getId(),c1.getNome());
        System.out.printf("%d - %s\n", c2.getId(),c2.getNome());

    }
}
