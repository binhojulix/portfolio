
--Script de Corre��o de orienta��o de Pol�gonos no SQL Server
update Place
 set CoordenadasGeo = CoordenadasGeo.ReorientObject()
 where CoordenadasGeo.EnvelopeAngle() > 90;