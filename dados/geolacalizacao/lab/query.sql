-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE pontos_de_interesse (
id_ponto_de_interesse VARCHAR(10) PRIMARY KEY,
descricao VARCHAR(10),
latitude VARCHAR(10),
longitude VARCHAR(10)
)

CREATE TABLE onibus (
latitude VARCHAR(10),
longitude VARCHAR(10),
id_onibus VARCHAR(10) PRIMARY KEY,
id VARCHAR(10)
)

CREATE TABLE destino (
id VARCHAR(10) PRIMARY KEY,
descricao VARCHAR(10),
-- Erro: nome do campo duplicado nesta tabela!
id VARCHAR(10)
)

CREATE TABLE coordenada_usuario (
id_coordenada_usuario VARCHAR(10) PRIMARY KEY,
horario VARCHAR(10),
latitude VARCHAR(10),
longitude VARCHAR(10),
id_usuario VARCHAR(10),
id_perfil VARCHAR(10)
)

CREATE TABLE usuário+id_perfil (
id_usuario VARCHAR(10),
nome VARCHAR(10),
id_perfil VARCHAR(10),
descricao VARCHAR(10),
PRIMARY KEY(id_usuario,id_perfil)
)

CREATE TABLE usuario_montanha (
longitude VARCHAR(10),
latitude VARCHAR(10),
id VARCHAR(10) PRIMARY KEY,
distancia_percorrida VARCHAR(10),
sentido VARCHAR(10),
-- Erro: nome do campo duplicado nesta tabela!
id VARCHAR(10)
)

CREATE TABLE motanha (
id VARCHAR(10) PRIMARY KEY,
longitude VARCHAR(10),
latitude VARCHAR(10)
)

CREATE TABLE viagem (
id VARCHAR(10) PRIMARY KEY
)

CREATE TABLE etinerario (
horario VARCHAR(10),
id VARCHAR(10) PRIMARY KEY,
-- Erro: nome do campo duplicado nesta tabela!
id VARCHAR(10),
FOREIGN KEY(id) REFERENCES viagem (id)
)

CREATE TABLE usuario_coordenada (
id_coordenada_usuario VARCHAR(10),
id_ponto_de_interesse VARCHAR(10),
FOREIGN KEY(id_coordenada_usuario) REFERENCES coordenada_usuario (id_coordenada_usuario),
FOREIGN KEY(id_ponto_de_interesse) REFERENCES pontos_de_interesse (id_ponto_de_interesse)
)

CREATE TABLE usr_paso (
id VARCHAR(10),
id_usuario VARCHAR(10),
id_perfil VARCHAR(10),
FOREIGN KEY(id) REFERENCES usuario_montanha (id),
FOREIGN KEY(id_perfil,,) REFERENCES usuário+id_perfil (id_usuario,id_perfil)
)

CREATE TABLE viag_usr (
id_usuario VARCHAR(10),
id_perfil VARCHAR(10),
id VARCHAR(10),
FOREIGN KEY(id_perfil,,) REFERENCES usuário+id_perfil (id_usuario,id_perfil),
FOREIGN KEY(id) REFERENCES viagem (id)
)

ALTER TABLE onibus ADD FOREIGN KEY(id) REFERENCES viagem (id)
ALTER TABLE destino ADD FOREIGN KEY(id) REFERENCES viagem (id)
ALTER TABLE coordenada_usuario ADD FOREIGN KEY(id_perfil,,) REFERENCES usuário+id_perfil (id_usuario,id_perfil)
ALTER TABLE usuario_montanha ADD FOREIGN KEY(id) REFERENCES motanha (id)
