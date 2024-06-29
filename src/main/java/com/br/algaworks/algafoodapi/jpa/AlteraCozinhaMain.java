package com.br.algaworks.algafoodapi.jpa;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteraCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha bean = context.getBean(CadastroCozinha.class);

        Cozinha c1 = new Cozinha();
        c1.setId(1L);
        c1.setNome("Brasileira");

        c1 = bean.adicionar(c1);
        System.out.println(c1.getNome());
    }
}
