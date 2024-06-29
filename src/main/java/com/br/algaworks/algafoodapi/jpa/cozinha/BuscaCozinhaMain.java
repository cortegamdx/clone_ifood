package com.br.algaworks.algafoodapi.jpa.cozinha;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha bean = context.getBean(CadastroCozinha.class);

        Cozinha buscar = bean.buscar(1L);
        System.out.printf("%d - %s\n",buscar.getId(),buscar.getNome());
    }
}
