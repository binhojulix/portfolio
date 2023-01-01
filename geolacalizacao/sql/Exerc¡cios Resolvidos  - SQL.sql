-- Exerc�cio: � poss�vel adicionar outro tipos cole��es dentro de um GeometryCollection? 
DECLARE @GeometryCollection geometry;
SET @GeometryCollection = geometry::STGeomCollFromText(
 'GEOMETRYCOLLECTION(
  POLYGON((5 5, 10 5, 10 10, 5 5)),
  POINT(7.8 8.5),
  LINESTRING(4 7, 11 1),
  MULTIPOLYGON(((10 20, 30 40, 44 50, 10 20)),((5 0, 20 40, 30 34, 5 0)))
    )',
  0
)
select @GeometryCollection

--Exerc�cios r�pidos 
--1) Fa�a uma busca que retorne a latitude e longitude do campo Location de uma cada das linhas da tabela recentemente criada PropertiesForSale do banco GEOFiap
select *, Location.Lat, Location.Long  from PropertiesForSale

--3) Fa�a uma consulta utilizando as tabelas Streets 	e Districts que retorne as ruas e as respectivos 	distritos ao qual ela percorre.
select * from Districts d,  Streets s
where d.DistrictGeo.STIntersects(s.StreetGeo) = 1

--4) Execute o Script World Bordes.sql para criar a 	tabela World_Borders. Uma vez carregada fa�a uma 	consulta para retornar os dados do Brasil (ISO2 	= �BR�) e seus vizinhos utilizando a fun��o 	STIntersects.
select fronteira.* from World_Borders origem
inner join World_Borders fronteira
	on origem.GEOG.STIntersects(fronteira.GEOG) = 1
where origem.ISO2 = 'BR' and fronteira.ISO2 <> 'BR'

--5) Com base na consulta do Exerc�cio anterior, fa�a 	uma nova consulta que retorne todos os pa�ses 	da Am�rica (REGION = 19) que n�o fazem 	fronteira com o Brasil.
select fronteira.* from World_Borders origem
inner join World_Borders fronteira
	on origem.GEOG.STIntersects(fronteira.GEOG) = 0
where origem.ISO2 = 'BR' and fronteira.REGION  = 19

