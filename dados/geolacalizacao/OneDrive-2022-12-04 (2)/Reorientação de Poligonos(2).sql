
--Script de Correção de orientação de Polígonos no SQL Server
update Place
 set CoordenadasGeo = CoordenadasGeo.ReorientObject()
 where CoordenadasGeo.EnvelopeAngle() > 90;