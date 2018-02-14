-- CREATE USER 'medico'@'localhost' IDENTIFIED BY 'senha1';
GRANT SELECT ON sghvet.animal TO 'medico'@'localhost';
GRANT SELECT ON sghvet.agendamento TO 'medico'@'localhost';
GRANT INSERT ON sghvet.agendamento TO 'medico'@'localhost';
GRANT SELECT ON sghvet.cirurgia TO 'medico'@'localhost';
GRANT INSERT ON sghvet.cirurgia TO 'medico'@'localhost';
GRANT SELECT ON sghvet.equipe_cirurgica TO 'medico'@'localhost';
GRANT INSERT ON sghvet.equipe_cirurgica TO 'medico'@'localhost';
GRANT SELECT ON sghvet.consulta TO 'medico'@'localhost';
GRANT INSERT ON sghvet.consulta TO 'medico'@'localhost';
GRANT SELECT ON sghvet.registro TO 'medico'@'localhost';
GRANT INSERT ON sghvet.registro TO 'medico'@'localhost';
GRANT SELECT ON sghvet.exame TO 'medico'@'localhost';
GRANT INSERT ON sghvet.exame TO 'medico'@'localhost';
GRANT SELECT ON sghvet.tratamento TO 'medico'@'localhost';
GRANT INSERT ON sghvet.tratamento TO 'medico'@'localhost';
GRANT SELECT ON sghvet.receituario TO 'medico'@'localhost';
GRANT INSERT ON sghvet.receituario TO 'medico'@'localhost';
GRANT SELECT ON sghvet.remedio TO 'medico'@'localhost';





-- CREATE USER 'enfermeiro'@'localhost' IDENTIFIED BY 'senha2';
GRANT SELECT ON sghvet.exame TO 'enfermeiro'@'localhost';
GRANT INSERT ON sghvet.exame TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.remedio TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.equipe_cirurgica TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.animal TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.agendamento TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.cirurgia TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.registro TO 'enfermeiro'@'localhost';
GRANT SELECT ON sghvet.receituario TO 'enfermeiro'@'localhost';






-- CREATE USER 'secretario'@'localhost' IDENTIFIED BY 'senha3';
GRANT ALL PRIVILEGES ON sghvet.* TO 'secretario'@'localhost';


-- CREATE USER 'farmaceutico'@'localhost' IDENTIFIED BY 'senha4';
GRANT SELECT ON sghvet.animal TO 'farmaceutico'@'localhost';
GRANT SELECT ON sghvet.registro TO 'farmaceutico'@'localhost';
GRANT SELECT ON sghvet.exame TO 'farmaceutico'@'localhost';
GRANT SELECT ON sghvet.receituario TO 'farmaceutico'@'localhost';
GRANT SELECT ON sghvet.remedio TO 'farmaceutico'@'localhost';
GRANT INSERT ON sghvet.remedio TO 'farmaceutico'@'localhost';






-- CREATE USER 'tecnico'@'localhost' IDENTIFIED BY 'senha5';
GRANT SELECT ON sghvet.registro TO 'tecnico'@'localhost';
GRANT SELECT ON sghvet.animal TO 'tecnico'@'localhost';
GRANT SELECT ON sghvet.exame TO 'tecnico'@'localhost';





