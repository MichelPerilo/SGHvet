-- ------------------------------------------------------------------------------------------------

-- TUTOR
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste1','18575833707','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste2','26842425859','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste3','04920772157','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste4','45365557735','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste5','70930613708','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste6','18110315607','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste7','46483313209','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste8','15267770299','F','81908766483');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste9','00882858041','M','81908765423');
insert into sghvet.tutor (nome, cpf, sexo, contato)values('tutorteste10','92561652793','F','81908766483');

-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua um','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'18575833707');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua dois','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'26842425859');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua tres','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'04920772157');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua quatro','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'45365557735');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua cinco','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'70930613708');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua seis','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'18110315607');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua sete','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'46483313209');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua oito','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'15267770299');
-- ENDERECO TUTOR
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua nove','Bairro Novo', 80,'onde o vento faz a curva' ,'53140060','Olinda', 'PE' ,'00882858041');
insert into endereco (rua, bairro, numero, complemento, cep, cidade, estado, cpfTutor) values ('Rua dez','Bairro Velho', 90,'onde o vento faz a curva' ,'53140150','Recife', 'PE' ,'92561652793');


-- ANIMAL
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','ringo','CACHORRO','Afghan Hound','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','rex','CACHORRO','Airedale Terrier','pouco pelo',10.2,'M','26842425859');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','tulipa','CACHORRO','Akita','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','abraao','CACHORRO','Australian Cattle Dog','pouco pelo',10.2,'M','26842425859');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','nox','CACHORRO','yorkshire','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','poto','GATO','Angorá','pouco pelo',10.2,'M','26842425859');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','bruno','GATO','Burmese','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','alex','GATO','Norwegian Forest','pouco pelo',10.2,'M','15267770299');

insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','freddy','GATO','Devon Rex','pelo fofo',5.5,'M','18575833707');
insert into sghvet.animal (dataNascimento, nome, especie, raca, pelagem, peso, sexo, cpfTutor)values('2018-02-5','popo','GATO','Sagrado da Birmânia','pouco pelo',10.2,'M','26842425859');


-- ----------------------------------------------------------------------------------------------
-- RAÇAS E ESPECIES 
insert into sghvet.especie (nome) values ('CACHORRO');
insert into sghvet.especie (nome) values ('GATO');

-- especies cachorro
load data infile 'C:/Users/raylison.santos/git/SGHvet/SCRIPTS/racaCachorro.csv' into table sghvet.raça fields terminated by ';' lines terminated by '\r\n' (nome,cod_esp);

-- especies gato

load data infile 'C:/Users/raylison.santos/git/SGHvet/SCRIPTS/racaGato.csv' into table sghvet.raça fields terminated by ';' lines terminated by '\r\n' (nome,cod_esp);

-- ----------------------------------------------------------------------------------------------

-- CONSULTA
INSERT INTO sghvet.consulta (dia, horario, cpf_tutor, prontuario, cpf_vet) values ('2018-02-20','15:00','18575833707',1,'15887739223');
INSERT INTO sghvet.consulta (dia, horario, cpf_tutor, prontuario, cpf_vet) values ('2018-03-10','16:00','26842425859',2,'35104314308');

-- REQ_EXAME
insert into sghvet.exame (cpf_aux,cpf_tutor,prontuario,data_exame,realizado) values ('92111807320','18575833707',1,'2018-02-22',1);
insert into sghvet.exame (cpf_aux,cpf_tutor,prontuario,data_exame,realizado) values ('92111807320','26842425859',2,'2018-03-11',0);
