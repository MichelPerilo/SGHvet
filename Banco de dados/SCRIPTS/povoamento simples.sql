-- ------------------------------------------------------------------------------------------------

-- TUTOR
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste1','18575833707','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste2','26842425859','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste3','04920772157','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste4','45365557735','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste5','70930613708','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste6','18110315607','F','81908766483');


-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua um','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'18575833707');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua dois','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'26842425859');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua tres','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'04920772157');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua quatro','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'45365557735');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua cinco','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'70930613708');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua seis','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'18110315607');


-- ANIMAL
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','ringo','CACHORRO','Afghan Hound','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','rex','CACHORRO','Airedale Terrier','pouco pelo',10.2,'M','26842425859');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','tulipa','CACHORRO','Akita','pelo fofo',5.5,'M','04920772157');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','abraao','CACHORRO','Australian Cattle Dog','pouco pelo',10.2,'M','45365557735');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','nox','CACHORRO','yorkshire','pelo fofo',5.5,'M','70930613708');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','poto','GATO','Angorá','pouco pelo',10.2,'M','70930613708');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','bruno','GATO','Burmese','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','alex','GATO','Norwegian Forest','pouco pelo',10.2,'M','18110315607');



-- ----------------------------------------------------------------------------------------------
-- RAÇAS E ESPECIES 
insert into sghvet.especie (nome) values ('CACHORRO');
insert into sghvet.especie (nome) values ('GATO');

-- especies cachorro
load data infile 'C:/Users/Raylison100Notebook/Desktop/Banco de dados/SCRIPTS/racaCachorro.csv' into table sghvet.raça fields terminated by ';' lines terminated by '\r\n' (nome,cod_esp);

-- especies gato

load data infile 'C:/Users/Raylison100Notebook/Desktop/Banco de dados/SCRIPTS/racaGato.csv' into table sghvet.raça fields terminated by ';' lines terminated by '\r\n' (nome,cod_esp);

-- ----------------------------------------------------------------------------------------------


insert into remedio (codigo, nome, tipo, bula, restricao) values (111, 'dip', 'Analgesicos', 'seilah', 'nada');
insert into remedio (codigo, nome, tipo, bula, restricao) values (112, 'aaa', 'Analgesicos', 'seilah', 'nada');
insert into remedio (codigo, nome, tipo, bula, restricao) values (113, 'bbb', 'Antibioticos', 'seilah', 'nada');
insert into remedio (codigo, nome, tipo, bula, restricao) values (114, 'ccc', 'Antiflamatorio', 'seilah', 'nada');


insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) values (888, '2018-02-20', '2019-02-20', 100, 111);
insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) values (889, '2018-02-20', '2019-02-20', 100, 112);
insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) values (890, '2018-02-20', '2019-02-20', 100, 113);
insert into intem_estoque (id_intem_estoque, data_entrada, data_validade, qtd_atual, codigo_remedio_ie) values (891, '2018-02-20', '2019-02-20', 100, 114);


/*

insert into receituario (id_rec, dt_emissão, cod_remedio, qtd_remedio)
            values(12, '2018-02-17', 114, 20);
            
insert into receituario (id_rec, dt_emissão, cod_remedio, qtd_remedio)
            values(13, '2018-02-17', 114, 500);

*/


#------------------------------------------------------Povoamento de CONSULTAS E CIRURGIAS X REQUISIÇOES DE FARMACO  --------------------------------------


insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0001, '2018-02-17', '09:00', '18575833707', true,1,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0002, '2018-02-05', '10:00', '45365557735', true,4,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0003, '2018-02-05', '11:00', '70930613708', true,5,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0005, '2018-02-01', '12:00', '70930613708', true,6,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0006, '2018-02-01', '12:00', '70930613708', true,6,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0007, '2018-02-01', '12:00', '45365557735', true,4,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0008, '2018-02-02', '12:00', '18575833707', true,1,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0009, '2018-02-02', '12:00', '70930613708', true,5,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0010, '2018-02-02', '12:00', '70930613708', true,6,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0011, '2018-02-03', '12:00', '18575833707', true,1,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0012, '2018-02-03', '12:00', '45365557735', true,4,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0013, '2018-02-05', '12:00', '70930613708', true,6,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0014, '2018-02-05', '12:00', '18575833707', true,1,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0015, '2018-02-06', '12:00', '70930613708', true,6,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0016, '2018-02-06', '12:00', '70930613708', true,5,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0017, '2018-02-07', '12:00', '70930613708', true,6,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0018, '2018-02-07', '12:00', '70930613708', true,5,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0019, '2018-02-08', '12:00', '70930613708', true,6,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0020, '2018-02-08', '12:00', '70930613708', true,6,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0021, '2018-02-09', '12:00', '45365557735', true,4,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0022, '2018-02-10', '12:00', '18575833707', true,1,'10103566406');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0023, '2018-02-10', '12:00', '70930613708', true,6,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0024, '2018-02-10', '12:00', '45365557735', true,4,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0025, '2018-02-15', '12:00', '18575833707', true,1,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0026, '2018-02-15', '12:00', '70930613708', true,6,'44022736500');
insert into consulta (id, dia, horario,cpf_tutor,concluido,prontuario,cpf_vet) values (0027, '2018-02-15', '12:00', '45365557735', true,4,'44022736500');




insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1000, 5,'s/n','s/n', '10103566406', 0001,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1001, 5,'s/n','s/n', '10103566406', 0002,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1002, 5,'s/n','s/n', '10103566406', 0003,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1003, 5,'s/n','s/n', '10103566406', 0004,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1004, 5,'s/n','s/n', '10103566406', 0005,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1005, 5,'s/n','s/n', '10103566406', 0006,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1006, 5,'s/n','s/n', '10103566406', 0007,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1007, 5,'s/n','s/n', '10103566406', 0008,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1008, 5,'s/n','s/n', '44022736500', 0009,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1009, 5,'s/n','s/n', '44022736500', 0010,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1010, 5,'s/n','s/n', '10103566406', 0011,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1011, 5,'s/n','s/n', '10103566406', 0012,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1012, 5,'s/n','s/n', '10103566406', 0013,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1013, 5,'s/n','s/n', '44022736500', 0014,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1014, 5,'s/n','s/n', '44022736500', 0015,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1015, 5,'s/n','s/n', '44022736500', 0016,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1016, 5,'s/n','s/n', '10103566406', 0017,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1017, 5,'s/n','s/n', '10103566406', 0018,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1018, 5,'s/n','s/n', '10103566406', 0019,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1019, 5,'s/n','s/n', '44022736500', 0020,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1020, 5,'s/n','s/n', '10103566406', 0021,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1021, 5,'s/n','s/n', '10103566406', 0022,'GOD OF WAR',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1022, 5,'s/n','s/n', '44022736500', 0023,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1023, 5,'s/n','s/n', '44022736500', 0024,'Raylison Nunes',0);
insert into requisicaoFarmaco(id,quantidade,descricao,justificativa,idmedico,idConsulta,nomeMedico,atendido) values (1024, 5,'s/n','s/n', '44022736500', 0025,'Raylison Nunes',0);



insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1001, 'GERAL', 'S/N', '2018-02-01', '07:00', '08:00','SALA_A',114,10,6,4);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1002, 'GERAL', 'S/N', '2018-02-01', '08:00', '09:00','SALA_B',111,10,6,1);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1003, 'GERAL', 'S/N', '2018-02-01', '09:00', '10:00','SALA_C',111,10,6,6);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1004, 'GERAL', 'S/N', '2018-02-02', '10:00', '11:00','SALA_A',113,10,6,5);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1005, 'GERAL', 'S/N', '2018-02-02', '07:00', '08:00','SALA_B',113,10,6,1);
 insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1006, 'GERAL', 'S/N', '2018-02-02', '08:00', '09:00','SALA_C',113,10,6,4);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1007, 'GERAL', 'S/N', '2018-02-03', '07:00', '08:00','SALA_A',112,10,6,5);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1008, 'GERAL', 'S/N', '2018-02-03', '08:00', '09:00','SALA_B',112,10,6,6);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1009, 'GERAL', 'S/N', '2018-02-03', '09:00', '10:00','SALA_C',112,10,6,1);
insert into cirurgia (cod_cirur,tipo,especialidade,data_cir,hr_inic, hr_fim, sala, cod_remedio, qtd_remedio,prontuario, tamanho_equipe)
 values (1010, 'GERAL', 'S/N', '2018-02-04', '07:00', '08:00','SALA_A',113,10,6,4);


insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1003, 4,'s/n','s/n', '10103566406', 1001,'GOD OF WAR',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1004, 4,'s/n','s/n', '10103566406', 1002,'GOD OF WAR',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1005, 4,'s/n','s/n', '44022736500', 1003,'Raylison Nunes',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1006, 4,'s/n','s/n', '44022736500', 1004,'Raylison Nunes',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1007, 4,'s/n','s/n', '10103566406', 1005,'GOD OF WAR',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1008, 4,'s/n','s/n', '44022736500', 1006,'Raylison Nunes',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1009, 4,'s/n','s/n', '44022736500', 1007,'Raylison Nunes',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1010, 4,'s/n','s/n', '10103566406', 1008,'GOD OF WAR',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1011, 4,'s/n','s/n', '44022736500', 1009,'Raylison Nunes',0);
insert into requisicaoFarmacoCirurgia(id,quantidade,descricao,justificativa,idmedico,idCirurgia,nomeMedico,atendido) values (1012, 4,'s/n','s/n', '44022736500', 1010,'Raylison Nunes',0);





#-------------------------------------------------------------------Povoamento de usuarios ----------------------------------------------------------------------------------------------



INSERT INTO sghvet.veterinario (nome, cpf, dataNasc, cargo, contato, email , crmv) VALUES ('Raylison Nunes', '44022736500', '1990-12-30', 'CIRURGIAO', '99998888', 'adm@adm.com', '0001');


/*

-- VETERINARIO



CREATE USER IF NOT EXISTS '15887739223'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('15887739223','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste1','15887739223','1990-01-10','CLINICO','81906070502','vetteste1@email.com','12345678');

CREATE USER IF NOT EXISTS '35104314308'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('35104314308','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','35104314308','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '86783251357'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('86783251357','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','86783251357','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '07150968937'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('07150968937','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','07150968937','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '43724635451'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('43724635451','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','43724635451','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '71822605148'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('71822605148','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','71822605148','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '14859734220'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('14859734220','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','14859734220','1990-01-12','CLINICO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '48247875136'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('48247875136','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','48247875136','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '65883643264'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('65883643264','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','65883643264','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '48467383100'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('48467383100','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','48467383100','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '21778247458'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('21778247458','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','21778247458','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '38437823773'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('38437823773','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','38437823773','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '21187412198'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('21187412198','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','21187412198','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '21794181245'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('21794181245','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','21794181245','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');

CREATE USER IF NOT EXISTS '52131054165'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('52131054165','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','52131054165','1990-01-12','CIRURGIAO','81906070502','vetteste2@email.com','12345678108');


-- ADMNISTRATIVO


CREATE USER IF NOT EXISTS '62663082589'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('62663082589','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','62663082589','1989-10-01','ATENDENTE','81910320867','admteste1@email.com');

CREATE USER IF NOT EXISTS '68847816530'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('68847816530','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','68847816530','1989-07-12','ATENDENTE','81910320567','admteste2@email.com');

CREATE USER IF NOT EXISTS '61289953813'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('61289953813','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','61289953813','1989-10-01','ATENDENTE','81910320867','admteste1@email.com');

CREATE USER IF NOT EXISTS '78486222230'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('78486222230','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','78486222230','1989-07-12','ATENDENTE','81910320567','admteste2@email.com');

CREATE USER IF NOT EXISTS '74486721500'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('74486721500','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','74486721500','1989-10-01','ATENDENTE','81910320867','admteste1@email.com');

CREATE USER IF NOT EXISTS '25213335306'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('25213335306','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','25213335306','1989-07-12','ATENDENTE','81910320567','admteste2@email.com');

CREATE USER IF NOT EXISTS '66726685432'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('66726685432','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','66726685432','1989-10-01','ATENDENTE','81910320867','admteste1@email.com');

CREATE USER IF NOT EXISTS '81889634379'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('81889634379','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','81889634379','1989-07-12','ATENDENTE','81910320567','admteste2@email.com');



-- AUXILIAR



CREATE USER IF NOT EXISTS '92111807320'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('92111807320','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo,crf, contato, email)values('auxiliarteste1','92111807320','1987-01-08','LABORATORIO','1222','81907646578','auxiliar1@email.com');


CREATE USER IF NOT EXISTS '34136723989'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('34136723989','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo,crf, contato, email)values('auxiliarteste2','34136723989','1987-01-08','LABORATORIO','2345','81907646789','auxiliar2@email.com');


CREATE USER IF NOT EXISTS '76141912699'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('76141912699','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo,crf, contato, email)values('auxiliarteste1','76141912699','1987-01-08','LABORATORIO','1134','81907646578','auxiliar1@email.com');


CREATE USER IF NOT EXISTS '65254382767'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('65254382767','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo,crf,contato, email)values('auxiliarteste2','65254382767','1987-01-08','LABORATORIO','5555','81907646789','auxiliar2@email.com');


CREATE USER IF NOT EXISTS '50493798226'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('50493798226','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo,crf, contato, email)values('auxiliarteste1','50493798226','1987-01-08','LABORATORIO','0409','81907646578','auxiliar1@email.com');


CREATE USER IF NOT EXISTS '11978685777'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('11978685777','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste2','11978685777','1987-01-08','FARMACEUTICO','81907646789','auxiliar2@email.com');


CREATE USER IF NOT EXISTS '62277516180'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('62277516180','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste1','62277516180','1987-01-08','FARMACEUTICO','81907646578','auxiliar1@email.com');


CREATE USER IF NOT EXISTS '46573024699'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('46573024699','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste2','46573024699','1987-01-08','FARMACEUTICO','81907646789','auxiliar2@email.com');


CREATE USER IF NOT EXISTS '30280973705'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('30280973705','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste1','30280973705','1987-01-08','FARMACEUTICO','81907646578','auxiliar1@email.com');


CREATE USER IF NOT EXISTS '54945999813'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('54945999813','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste2','54945999813','1987-01-08','FARMACEUTICO','81907646789','auxiliar2@email.com');


*/


