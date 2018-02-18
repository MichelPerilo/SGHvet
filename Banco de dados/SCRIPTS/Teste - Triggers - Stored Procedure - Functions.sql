-- |||||||||||||||||||||||||||||||||||||||||||||||  TRIGGERS  ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

-- teste da trigger que atualiza a quantidade de membros de uma equipe cirurgica

insert into cirurgia (cod_cirur, cod_remedio, qtd_remedio) values (3457, 111, 1);

insert into membro_cirurgia(id, id_cirur) values (44, 3457);

select * from cirurgia;

delete from membro_cirurgia where id = 44;

select * from cirurgia;




-- Teste da trigger que atualiza a quantidade atual de produtos no estoque

insert into remedio (codigo, nome, tipo, bula, restricao) values (111, 'dip', 1, 'seilah', 'nada');

select * from remedio;

insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) 
            values (888, '2018-02-20', '2019-02-20', 100, 111);

select * from intem_estoque;

insert into receituario (id_rec, dt_emissão, cod_remedio, qtd_remedio)
            values(12, '2018-02-14', 111, 20);
                      
select * from intem_estoque;

insert into cirurgia (cod_cirur, cod_remedio, qtd_remedio) values (3457, 111, 1);

select * from intem_estoque;

delete from cirurgia where cod_cirur = 3457;

select * from intem_estoque;




-- teste da trigger que gera o valor da idade do animal

insert into animal (prontuario, nome, dataNascimento, cpfTutor) values (1007, 'Tuco', '2012-01-01', 223);
select * from animal;





-- |||||||||||||||||||||||||||||||||||||||||||||||  FUNCTIONS  ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

-- teste da function que atualiza o situação de um produto no estoque
-- NOTA:
-- diferenciando-se da trigger de atualização após inserção/remoção nas tabelas cirurgia e recituario
-- essa função SETA a quantidade do produto no estoque com o valor que é passado como parâmetro
-- e não incrementa/decrementa como sua contraparte


insert into remedio (codigo, nome, tipo, bula, restricao) values (565, 'busc', 1, 'qqcs', 'tudo');

insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) 
            values (777, '2018-07-7', '2019-08-08', 100, 565);
            
select * from intem_estoque;

select atualizarProduto(565, 200);

select * from intem_estoque;


-- teste da function que checa se raça do animal pertence a determinada espécie



select * from especie;
select * from raça;
select * from animal;

select checarRaca('Akita','CACHORRO');
select checarRaca('Akita', 'GATO');


-- teste da function que checa se um serviço AINDA está(rá) sendo ofertado por determinado funcionário terceirizado
-- em uma determinada data

insert into terceirizado (id_terc, nome, cpf) values (345, 'Faz Tudo', 66100);
insert into servico (id_servico, descricao, id_executor,data_inicial, data_final) 
            values (12, 'Um rolo', 345, '2018-10-10', '2018-12-10');
            
select * from terceirizado;
select * from servico;

select ehOfertado(12, '2018-10-25');
select ehOfertado(12, '2018-12-25');


-- teste da function que verifica a data mais proxima que um medico estará disponível em uma determinada clínica
-- em um horário específico

-- Nota: O sistema considera que todas as consultas de uma semana são marcadas no mesmo dia e, por isso, caso haja uma consulta marcada em um dia
-- o médico só estará disponível para nocas consultas na próxima semana.
-- Caso não haja, a data retornada é a mais próxima em que o médico esteja trabalhando.


insert into clinica (id_clinica, nome) values (0091, 'CDMJ');
insert into veterinario (nome, cpf) values ('Rochedinho', 787);
insert into alocado(cpf, id_cli, data_ini, data_fim, hora_ini, hora_fim)
	   values (787, 0091, '2018-12-11', '2019-12-11', "08:00:00", "16:00:00");

select disponivelEm(787, 0091, "13:30");

insert into consulta(id, dia, horario, cpf_vet) values (1111, '2018-12-11', "11:00", 787);

select disponivelEm(787, 0091, "13:30");

select * from consulta where cpf_vet = '10103566406' and concluido = true and dia between date('2018-02-01') and date('2018-02-28');

