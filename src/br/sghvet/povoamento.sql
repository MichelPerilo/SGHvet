-- ADM
-- senha de admsupremo eh 'abcd'
-- CREATE USER IF NOT EXISTS '10103566406'@'localhost' IDENTIFIED BY '301716283811389038011477436469853762335';
-- INSERT INTO sghvet.usuario (`cpf`, `tipo`) VALUES ('10103566406', 'ADMINISTRATIVO');
-- INSERT INTO sghvet.administrativo (nome, cpf, dataNasc, cargo, contato, email) VALUES ('admS', '10103566406', '1990-12-30', 'ADMINISTRADOR', '99998888', 'adm@adm.com');

-- VETERINARIO
-- senha é vetteste
CREATE USER IF NOT EXISTS '15887739223'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('15887739223','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste1','15887739223','1990-01-10','MEDICO','81906070502','vetteste1@email.com','12345678');

-- senha é vetteste
CREATE USER IF NOT EXISTS '35104314308'@'localhost' IDENTIFIED BY '72776562159603421323494213068919658392';
insert into sghvet.usuario(cpf, tipo) VALUES ('35104314308','VETERINARIO'); 
insert into veterinario (nome, cpf, dataNasc, cargo, contato, email, crmv) values ('vetteste2','35104314308','1990-01-12','MEDICO','81906070502','vetteste2@email.com','12345678108');

-- ADMNISTRATIVO
-- senha é admteste
CREATE USER IF NOT EXISTS '74366811251'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('74366811251','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','74366811251','1989-10-01','ATENDENTE','81910320867','admteste1@email.com');

-- senha é admteste
CREATE USER IF NOT EXISTS '78486222230'@'localhost' IDENTIFIED BY '225924457817391587456758655622674699859';
insert into sghvet.usuario(cpf, tipo) VALUES ('78486222230','ADMINISTRATIVO'); 
insert into administrativo (nome, cpf, dataNasc, cargo, contato, email)values('admteste1','78486222230','1989-07-12','ATENDENTE','81910320567','admteste2@email.com');

-- AUXILIAR
-- senha é auxiliarteste
CREATE USER IF NOT EXISTS '92111807320'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('92111807320','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste1','92111807320','1987-01-08','LABORATORIO','81907646578','auxiliar1@email.com');

-- senha é auxiliarteste
CREATE USER IF NOT EXISTS '34136723989'@'localhost' IDENTIFIED BY '32132284830152013577255565556480929325';
insert into sghvet.usuario(cpf, tipo) VALUES ('34136723989','AUXILIAR'); 
insert into auxiliar (nome, cpf, dataNasc, cargo, contato, email)values('auxiliarteste2','34136723989','1987-01-08','LABORATORIO','81907646789','auxiliar2@email.com');

-- TUTOR
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste1','18575833707','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste2','26842425859','F','81908766483');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua um','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'18575833707');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua dois','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'26842425859');

-- ANIMAL
insert into sghvet.animal (nome, especie, raca, pelagem, peso, sexo, idade, cpfTutor)values('ringo','CACHORRO','yorkshire','pelo fofo',5.5,'M',4,'18575833707');
insert into sghvet.animal (nome, especie, raca, pelagem, peso, sexo, idade, cpfTutor)values('rex','CACHORRO','bulldog','pouco pelo',10.2,'M',5,'26842425859');

-- CONSULTA
INSERT INTO sghvet.consulta (dia, horario, cpf_tutor, prontuario, cpf_vet) values ('2018-02-20','15:00','18575833707',1,'15887739223');
INSERT INTO sghvet.consulta (dia, horario, cpf_tutor, prontuario, cpf_vet) values ('2018-03-10','16:00','26842425859',2,'35104314308');

-- REQ_EXAME
insert into sghvet.req_exame (cpf_vet,cpf_tutor,prontuario,data_exame,realizado) values ('15887739223','18575833707',1,'2018-02-22',0);
insert into sghvet.req_exame (cpf_vet,cpf_tutor,prontuario,data_exame,realizado) values ('35104314308','26842425859',2,'2018-03-11',0);