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
