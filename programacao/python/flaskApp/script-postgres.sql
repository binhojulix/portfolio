CREATE DATABASE valeEY;

CREATE SEQUENCE subfase_id_seq;
CREATE TABLE subfase (
id_sub_fase smallint NOT NULL DEFAULT nextval('subfase_id_seq') primary key,
descricao_sub_fase varchar(200) );


CREATE SEQUENCE fase_id_seq;
CREATE table FASE(
id_fase smallint NOT NULL DEFAULT nextval('fase_id_seq') primary key,
id_sub_fase smallint not null,
 CONSTRAINT fk_fase
      FOREIGN KEY(id_sub_fase) 
	  REFERENCES subfase(id_sub_fase));




CREATE TABLE valeEY.dbo.[sistema] (
id_sistema int IDENTITY(1,1) NOT NULL primary key,
descricao_sistema nvarchar(200) not null );


CREATE TABLE valeEY.dbo.[complexo] (
id_complexo int IDENTITY(1,1) NOT NULL primary key,
descricao_complexo nvarchar(50) not null );


CREATE TABLE valeEY.dbo.[responsavel] (
id_responsavel int IDENTITY(1,1) NOT NULL primary key,
descricao_responsavel nvarchar(200) not null );


CREATE TABLE valeEY.dbo.[unidade_operacional] (
id_unidade_operacional int IDENTITY(1,1) NOT NULL primary key,
fk_sistema int not null foreign key references sistema(id_sistema),
fk_complexo int not null foreign key references complexo(id_complexo),
fk_fase int not null foreign key references fase(id_fase),
descricao_unidade_operacional nvarchar(200) not null,
responsavel_cma int foreign key references responsavel(id_responsavel),
responsavel_bussiness int foreign key references responsavel(id_responsavel),
responsavel_allcenter int foreign key references responsavel(id_responsavel));

CREATE TABLE valeEY.dbo.[ativos] (
id_ativo int IDENTITY(1,1) NOT NULL primary key,
id_unidade_operacional int not null 
foreign key references unidade_operacional(id_unidade_operacional),
descricao_ativo nvarchar(50) );




INSERT INTO valeEY.dbo.subfase
(descricao_sub_fase)
VALUES('fase1');
INSERT INTO valeEY.dbo.subfase
(descricao_sub_fase)
VALUES('fase2');
INSERT INTO valeEY.dbo.subfase
(descricao_sub_fase)
VALUES('fase3');

INSERT INTO valeEY.dbo.fase
(id_sub_fase, descricao_fase)
VALUES(1, 'fase 1');
INSERT INTO valeEY.dbo.fase
(id_sub_fase, descricao_fase)
VALUES(1, 'fase 2');
INSERT INTO valeEY.dbo.fase
(id_sub_fase, descricao_fase)
VALUES(1, 'fase 3');

SELECT id_fase, id_sub_fase, descricao_fase
FROM valeEY.dbo.fase;