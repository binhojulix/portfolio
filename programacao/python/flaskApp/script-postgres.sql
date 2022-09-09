CREATE SEQUENCE subfase_id_seq;
CREATE SEQUENCE fase_id_seq;

cREATE TABLE subfase (
id_sub_fase int NOT NULL DEFAULT nextval('subfase_id_seq') primary key,
descricao_sub_fase varchar(200) );



CREATE table FASE(
id_fase int NOT NULL DEFAULT nextval('fase_id_seq') primary key,
id_sub_fase smallint not null,
 CONSTRAINT fk_fase
      FOREIGN KEY(id_sub_fase) 
	  REFERENCES subfase(id_sub_fase),
	 descricao_fase varchar(200) );
	
INSERT INTO Subfase(descricao_sub_fase)VALUES('fase1');
INSERT INTO Subfase(descricao_sub_fase)VALUES('fase2');
INSERT INTO Subfase(descricao_sub_fase)VALUES('fase3');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 1');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 2');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 3');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 4');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 5');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 6');
INSERT INTO fase(id_sub_fase, descricao_fase)VALUES(1, 'fase 7');


select *from subfase ;
select *from FASE;
