-- FUNCTIONS

delimiter |
create function atualizarProduto (codProduto int, quantidade int) returns int
begin
	declare qtd_aux int;
	select qtd_atual into qtd_aux from sghvet.intem_estoque where codigo_remedio_ie = codProduto;
    set qtd_aux = quantidade;
    update sghvet.intem_estoque set qtd_atual = qtd_aux where codigo_remedio_ie = codProduto;
    return quantidade;
end |




create function checarRaca (racaid varchar(45), especieid varchar(45)) returns boolean

begin
    declare checar_especie int;    
    declare chacar_especie2 int ;
    select cod_esp into checar_especie from raça where nome = racaid;
 	select codEsp into chacar_especie2 from especie where nome = especieid;
    
    
    IF checar_especie = chacar_especie2 THEN return true;
 	ELSE return false;
 	END IF;
end |




delimiter |
create function ehOfertado(IdServico int, dataNec date) returns boolean
begin
   return exists (select * from servico 
              where id_servico = IdServico and (dataNec between data_inicial and data_final));
end |




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


-- --------------------------------------------------------------------------------------------------------


-- PROCEDURES

delimiter |
create procedure consultasNaoAtendidas()
begin
	declare hoje date;
	set hoje = CURDATE();
	select * from consulta where dia = hoje and concluido = false;
end |

delimiter |
create procedure verificarVencimento (diasRestantes int)
begin
	declare data_buscada date;
    set data_buscada = DATE_ADD(CURDATE(), interval 'diasRestante' day);
	select codigo_remedio_ie from sghvet.intem_estoque where data_validade <= data_buscada;
end |

delimiter |
create procedure gerarProntuario (animalID int)
begin
	
    select * from registro 
		join consulta on registro.id_exame = consulta.id
        join animal on consulta.prontuario = animal.prontuario and animal.prontuario = animalID;	
    
end|



-- --------------------------------------------------------------------------------------------------------

-- TRIGGERS

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


delimiter |
create trigger atualizarIdadeAnimal
before insert on animal	
for each row
begin

	declare this_year int;
	declare animal_year int;
    declare aux date;
    
    set aux = SYSDATE();
	set this_year = YEAR(aux);
    set animal_year =YEAR(new.dataNascimento);
    
	set new.idade = (this_year - animal_year);  
end|



--  -----------------------------------------------------------------------------------------------------------


# trigger comentada para testar o Procedure com cursor

/*

delimiter |
create trigger atualiza_qtd_remedio_on_ins_rec
after insert on receituario
for each row
begin
   declare aux int;
   set aux = new.qtd_remedio;
   update intem_estoque set qtd_atual = (qtd_atual - aux) where codigo_remedio_ie = new.cod_remedio;
end |

delimiter |
create trigger atualiza_qtd_remedio_on_ins_cir
after insert on cirurgia
for each row
begin
   declare aux int;
   set aux = new.qtd_remedio;
   update intem_estoque set qtd_atual = (qtd_atual - aux) where codigo_remedio_ie = new.cod_remedio;
end |

*/


delimiter |
create trigger AfterRequisitarFarmacoClinico
after insert on requisicaoFarmaco
for each row
begin 
   declare id int;
   declare nameAdm VARCHAR(45);
   
   set id = new.id;
   set nameAdm = 'CLINICO';

   insert into requisicaoFarmacoSolicitadas set idrequisicao = id, tipo = nameAdm, dataSolicitada = now();
  
end  |

delimiter |
create trigger AfterRequisitarFarmacoCIRURGICO
after insert on requisicaoFarmacoCirurgia
for each row
begin 
   declare id int;
   declare nameAdm VARCHAR(45);
   
   set id = new.id;
   set nameAdm = 'CIRURGICO';

   insert into requisicaoFarmacoSolicitadas set idrequisicao = id, tipo = nameAdm, dataSolicitada = now();
  
end  |


delimiter |
create trigger atualizarEqpCirurgicaOnRm
before delete on membro_cirurgia
for each row
begin
	declare aux int;
    set aux = old.id_cirur;
	update cirurgia set tamanho_equipe = (tamanho_equipe - 1) where cod_cirur = aux;
end |


delimiter |
create trigger atualizarEqpCirurgicaOnAd
after insert on membro_cirurgia
for each row
begin
	declare aux int;
    set aux = new.id_cirur;
	update cirurgia set tamanho_equipe = (tamanho_equipe + 1) where cod_cirur = aux;
end |

delimiter |
create trigger atualiza_qtd_remedio_on_ins_cir
after insert on cirurgia
for each row
begin
   declare aux int;
   set aux = new.qtd_remedio;
   update intem_estoque set qtd_atual = (qtd_atual - aux) where codigo_remedio_ie = new.cod_remedio;
end |


delimiter |
create trigger atualiza_qtd_remedio_on_del_rec
before delete on receituario
for each row
begin
   declare aux int;
   set aux = old.qtd_remedio;
   update intem_estoque set qtd_atual = (qtd_atual + aux) where codigo_remedio_ie = old.cod_remedio;
end |


delimiter |
create trigger atualiza_qtd_remedio_on_del_cir
before delete on cirurgia
for each row
begin
   declare aux int;
   set aux = old.qtd_remedio;
   update intem_estoque set qtd_atual = (qtd_atual + aux) where codigo_remedio_ie = old.cod_remedio;
end |


--  -----------------------------------------------------------------------------------------------------------

# CURSOR


delimiter |
create procedure checarEstoque (idRec int)
begin

declare done int default false;
declare cod_aux int;
declare qtd_aux int;
declare est_aux int;
declare possivel boolean default false;

declare pegaValor cursor for select qtd_remedio,cod_remedio from receituario where id_rec = idRec;
declare continue handler for not found set done = true;
open pegaValor;


read_loop: loop
	
    fetch pegaValor into qtd_aux,cod_aux;
	set est_aux = (select qtd_atual from intem_estoque where codigo_remedio_ie = cod_aux); 
    if done then 
		leave read_loop;
    end if;  
    
    if est_aux >= qtd_aux then    
		set possivel =  true;     
	else if est_aux < qtd_aux then 
        set possivel =  false; 
		leave read_loop;
        end if;
    end if;
        
end loop;
close pegaValor;	  
    select possivel;
end |

