INSERT INTO TB_COZINHA (id,nom_cozinha) values  (1,'Tailandesa');
INSERT INTO TB_COZINHA (id,nom_cozinha) values  (2,'Indiana');

insert into TB_RESTAURANTE (nome, taxa_frete,cozinha_id) values ('Thai Gourmet', 10, 1);
insert into TB_RESTAURANTE (nome, taxa_frete,cozinha_id) values ('Thai Delivery', 9.50,1);
insert into TB_RESTAURANTE (nome, taxa_frete,cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into TB_ESTADO (id, nome) values (1, 'Minas Gerais');
insert into TB_ESTADO (id, nome) values (2, 'São Paulo');
insert into TB_ESTADO (id, nome) values (3, 'Ceará');

insert into TB_CIDADE (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into TB_CIDADE (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into TB_CIDADE (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into TB_CIDADE (id, nome, estado_id) values (4, 'Campinas', 2);
insert into TB_CIDADE (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into TB_FORMA_PAGAMENTO (id, descricao) values (1, 'Cartão de crédito');
insert into TB_FORMA_PAGAMENTO (id, descricao) values (2, 'Cartão de débito');
insert into TB_FORMA_PAGAMENTO (id, descricao) values (3, 'Dinheiro');

insert into TB_PERMISSAO (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into TB_PERMISSAO (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
