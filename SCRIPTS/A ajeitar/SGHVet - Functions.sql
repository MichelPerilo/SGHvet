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
