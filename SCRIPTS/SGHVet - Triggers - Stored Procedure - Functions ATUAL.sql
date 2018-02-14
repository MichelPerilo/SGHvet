# Trigger

delimiter |
create trigger CadastroAgendamento
after insert on consulta
for each row
begin   
  
   insert agendamento set  id_consulta = new.id, data_Agenda = now();
   
end  |


delimiter |
create trigger CadastroEstoque
after insert on intem_estoque
for each row
begin   
  
   insert estoque set  id_intemEstoque = new.id_intem_estoque;
   
end  |


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
   set id = new.cpf;
   
  
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
   set id = new.cpf;
   
   update logDataHoraAux set nome = nameAux, data_cadastro = this_dateHoraLog, id_aux = id;
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
   set id = new.cpf;
   update logDataHoraAdm set nome = nameAdm, data_cadastro = this_dateHoraLog, id_adm = id;
   update cargoAdm set  cpf = new.cpf, tipo = new.cargo;  
end  |







# Functions



delimiter |
create function atualizarProduto (codProduto int, quantidade int) returns int
begin
	declare qtd_aux int;
	select qtd_atual into qtd_aux from sghvet.intem_estoque where codigo_remedio_ie = codProduto;
    set qtd_aux = quantidade;
    update sghvet.intem_estoque set qtd_atual = qtd_aux where codigo_remedio_ie = codProduto;
    return quantidade;
end |

delimiter |
create function checarRaca (racaid int, especieid int) returns boolean

begin
    declare checar_especie int;
    select cod_esp into checar_especie from raça where codRac = racaid;
 	IF checar_especie = especieid THEN return true;
 	ELSE return false;
 	END IF;
end |


delimiter |
create function ehOfertado(IdServico int, dataNec date) returns boolean
begin
   return exists (select * from servico 
              where id_servico = IdServico and data_final <= dataNec);
end |


drop function disponivelEm;
delimiter |
create function disponivelEm(medicoID char(11), clinicaID int, horario time) 
	returns date

begin

    declare dt date;
    declare hora_i time;
    declare hora_f time;
    
    if exists (select cpf from alocado where cpf = medicoID and id_cli = clinicaID) then

		
		set hora_i = (select hora_ini from alocado where cpf = medicoID and id_cli = clinicaID);
        set hora_f = (select hora_fim from alocado where cpf = medicoID and id_cli = clinicaID);
        
        if horario >= hora_i and horario <= hora_f then   -- se horario desejado está dentro do horario de trabalho do médico
        
			set dt = (select data_ini from alocado where cpf = medicoID and id_cli = clinicaID);
            
            if (select dia from consulta where cpf_vet = medicoID) = dt then
            

                set dt = DATE_ADD(dt, interval 7 day);
                return dt;
			
            else 
            
				return dt;
            
			end if;

        else
        
			return null;         -- não há datas disponíveis
            
		end if;
        
	end if; 

    return null;
    
end |


