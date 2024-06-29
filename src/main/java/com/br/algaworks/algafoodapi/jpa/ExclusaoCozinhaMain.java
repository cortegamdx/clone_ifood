package com.br.algaworks.algafoodapi.jpa;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

          CadastroCozinha bean =  context.getBean(CadastroCozinha.class);

          bean.remover(1L);
    }

}
