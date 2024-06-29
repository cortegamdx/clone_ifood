package com.br.algaworks.algafoodapi.jpa.restaurante;

import com.br.algaworks.algafoodapi.AlgafoodApiApplication;
import com.br.algaworks.algafoodapi.domain.model.Restaurante;
import com.br.algaworks.algafoodapi.jpa.cozinha.CadastroCozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class RestauranteMain {
    public static void main(String[] args){

        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroRestaurante bean = context.getBean(CadastroRestaurante.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Cozinhando com o DOM");
        restaurante.setTaxaFrete(BigDecimal.valueOf(5.40));

        restaurante = bean.salvar(restaurante);

        System.out.println(restaurante);
    }
}
