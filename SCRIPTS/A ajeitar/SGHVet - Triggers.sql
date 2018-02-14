delimiter |
create trigger AfterCadastroVet
after insert on veterinario
for each row
begin 
   declare this_dateHoraLog DATETIME;
   declare nameVet VARCHAR(45);
   declare  id INT;
   
   set this_dateHoraLog = now();
   set nameVet = new.nome;
   set id = new.id_vet;
   
  
   insert  logDataHoraVet set nome = nameVet, data_cadastro = this_dateHoraLog, id_vet = id;   
   insert   cargosVeterinario set  cpf = new.cpf, tipo = new.cargo;  
   
end  |

delimiter |
create trigger AfterCadastroAux
after insert on auxiliar
for each row
begin 
   declare this_dateHoraLog DATETIME;
   declare nameAux VARCHAR(45);
   DECLARE  id INT;
   set this_dateHoraLog = now();
   set nameAux = new.nome;
   set id = new.id_aux;
   
   update logDataHoraVet set nome = nameAux, data_cadastro = this_dateHoraLog, id_aux = id;
   update cargoAuxiliar set  cpf = new.cpf, tipo = new.cargo;  
end  |

delimiter |
create trigger AfterCadastroAdm
after insert on administrativo
for each row
begin 
   declare this_dateHoraLog DATETIME;
   declare nameAdm VARCHAR(45);
   DECLARE  id INT;
   set this_dateHoraLog = now();
   set nameAdm = new.nome;
   set id = new.id_adm;
   update logDataHoraVet set nome = nameAdm, data_cadastro = this_dateHoraLog, id_adm = id;
   update cargoAdm set  cpf = new.cpf, tipo = new.cargo;  
end  |

delimiter |
create trigger logHorasDataCadastroVet
after insert on veterinario
for each row
begin 
   declare this_dateHoraLog date;
   declare nameVet VARCHAR(45);
   set this_dateHoraLog = now();
   set nameVet = new.nome;
   update logDataHoraVet set nome = nameVet, data_cadastro = this_dateHoraLog;
end  |

delimiter |
create trigger atualizarIdadeAnimal
after insert on animal	
for each row
begin
	declare this_year date;
	declare animal_year date;
	set this_year = YEAR(CURDATE());
	set animal_year =YEAR(animal.data_nasc);
	update animal set idade_em_anos = this_year - animal_year;  
end|

delimiter |
create trigger atualizarEqpCirurgicaOnRm
after delete on equipe_cirurgica
for each row
begin
	update equipe_cirurgica set quantidade = quantidade - 1;
end |


delimiter |
create trigger atualizarEqpCirurgicaOnAdd
after insert on equipe_cirurgica
for each row
begin
	update equipe_cirurgica set quantidade = quantidade + 1;
end |

delimiter |
create trigger atualiza_qtd_rec
after insert on receituario
for each row
begin
   declare aux int;
   set aux = new.qtdMedicamento;
   update item_estoque set qtd_estoque = (qtd_estoque - aux) where id = new.idMedicamento;
end |

delimiter |
create trigger atualiza_qtd_cir
after insert on cirurgia
for each row
begin
   declare aux int;
   set aux = new.qtdMedicamento;
   update item_estoque set qtd_estoque = (qtd_estoque - aux) where id = new.idMedicamento;
end |