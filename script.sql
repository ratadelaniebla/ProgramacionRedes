create table alumnos(nombres varchar2(100),
                     apellidos varchar2(100),
                     cedula varchar2(100),
                     nacimiento varchar2(100),
                     domicilio varchar2(100),
                     genero varchar2(100),
                     estado_civil varchar2(100),
                     matricula varchar2(100));
/*select 
case 
  when estado_civil = 'Soltero' THEN 's' 
    else 'DESCONOCIDO'  
      end as estado_civil
from alumnos*/