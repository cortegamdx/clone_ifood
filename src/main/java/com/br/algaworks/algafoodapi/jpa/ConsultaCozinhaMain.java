package com.br.algaworks.algafoodapi.jpa;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import com.br.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha bean = context.getBean(CadastroCozinha.class);

        List<Cozinha> listar = bean.listar();

        listar.forEach(c -> System.out.println(c.getNome()));
    }
}
