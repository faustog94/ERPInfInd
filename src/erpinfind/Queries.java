/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpinfind;

/**
 *
 * @author franco-lxle
 */
public class Queries {

    public static String TIPOARTICULO_GETTIPOARTICULO = "Select * from TipoArticulo";
    public static String TIPOARTICULO_GETTIPOARTICULOBYID = "Select * from TipoArticulo where idTipoArticulo = IDTIPO";

    public static String ARTICULO_ALTAARTICULO = "Insert into Articulo (codArticulo, descripcion, activo, unidadMedida, idTipoArticulo) VALUES ('CODART', 'DESC', ACT, 'UM', IDTIPO)";
    public static String ARTICULO_MODIFICARARTICULO = "Update Articulo Set codArticulo = 'CODART', descripcion = 'DESC', activo = ACT, unidadMedida = 'UM', idTipoArticulo = IDTIPO where idArticulo = IDART";
    public static String ARTICULO_BAJAARTICULOINDIVIDUAL = "Update Articulo set activo = 0 where idArticulo = IDART";
    public static String ARTICULO_GETARTICULOS = "Select * from Articulo";
    public static String ARTICULO_GETARTICULOSBYID = "Select * from Articulo where idArticulo = IDART";
    public static String ARTICULO_GETARTICULOSBYCOD = "Select * from Articulo where codArticulo = 'CODART'";
    public static String ARTICULO_GETARTICULOSBYTIPO = "Select * from Articulo where idTipoArticulo = IDTIPO";
    public static String ARTICULO_GETARTICULOSACTIVOS = "Select * from Articulo where activo = 1";
    public static String ARTICULO_ARTICULOEXISTEBYCOD = "Select count(*) as cantidad from Articulo where codArticulo = 'CODART'";

    public static String TIPOPRODUCTO_GETTIPOPRODUCTO = "Select * from TipoProducto";
    public static String TIPOPRODUCTO_GETTIPOPRODUCTOBYID = "Select * from TipoProducto where idTipoProducto = IDTIPO";
    public static String PRODUCTO_ALTAPRODUCTO = "Insert into Producto (codProducto, descripcion, activo, unidadMedida, idTipoProducto, idProductoBase) VALUES ('CODPROD', 'DESC', ACT, 'UM', IDTIPO, IDPRODBASE)";
    public static String PRODUCTO_MODIFICARPRODUCTO = "Update Producto Set codProducto = 'CODPROD', descripcion = 'DESC', activo = ACT, unidadMedida = 'UM', idTipoProducto = IDTIPO, idProductoBase = IDPRODBASE where idProducto = IDPROD";
    public static String PRODUCTO_BAJAPRODUCTOINDIVIDUAL = "Update Producto set activo = 0 where idProducto = IDPROD";
    public static String PRODUCTO_GETPRODUCTOS = "Select * from Producto";
    public static String PRODUCTO_GETPRODUCTOSACTIVOS = "Select * from Producto where activo = 1";
    public static String PRODUCTO_GETPRODUCTOSBYTIPO = "Select * from Producto where idTipoProducto = IDTIPO";
    public static String PRODUCTO_GETPRODUCTOBYID = "Select * from Producto where idProducto = IDPROD";
    public static String PRODUCTO_GETPRODUCTOBYCOD = "Select * from Producto where codProducto = 'CODPROD'";
    public static String PRODUCTO_PRODUCTOEXISTEBYCOD = "Select count(*) as cantidad from Producto where codProducto = 'CODPROD'";

    public static String CENTROTRABAJO_ALTACENTRO = "Insert into CentroTrabajo (codCentro, descripcion, activo, costoHoraMaquinaria, costoHoraManoObra) values ('CODCENTRO', 'DESC', ACT, CMAQ, CMO)";
    public static String CENTROTRABAJO_MODIFICARCENTRO = "Update CentroTrabajo set codCentro = 'CODCENTRO', descripcion = 'DESC', activo = ACT, costoHoraMaquinaria = CMAQ, costoHoraManoObra = CMO where idCentro = IDCENTRO";
    public static String CENTROTRABAJO_BAJACENTROINDIVIDUAL = "Update CentroTrabajo set activo = 0 where idCentro = IDCENTRO";
    public static String CENTROTRABAJO_GETCENTROS = "Select * from CentroTrabajo";
    public static String CENTROTRABAJO_GETCENTROSACTIVOS = "Select * from CentroTrabajo where activo = true";
    public static String CENTROTRABAJO_GETCENTROBYID = "Select * from CentroTrabajo where idCentro = IDCENTRO";
    public static String CENTROTRABAJO_GETCENTROBYCOD = "Select * from CentroTrabajo where codCentro = 'CODCENTRO'";

    public static String PROVEEDOR_ALTAPROVEEDOR = "Insert into Proveedor (nombre, activo) VALUES ('NOM', ACT)";
    public static String PROVEEDOR_MODIFICARPROVEEDOR = "Update Proveedor set nombre = 'NOM', activo = ACT where idProveedor = IDPROV";
    public static String PROVEEDOR_BAJAPROVEEDOR = "Update Proveedor set activo = 0 where idProveedor = IDPROV";
    public static String PROVEEDOR_GETPROVEEDORES = "Select * from Proveedores";
    public static String PROVEEDOR_GETPROVEEDORBYID = "Select * from Proveedores where idProveedor = IDPROV";
    public static String PROVEEDOR_GETPROVEEDORESACTIVOS = "Select * from Proveedores where activo = 1";

    public static String ARTPROV_ALTAARTPROV = "Insert into ArtProv (descripcion, idProveedor, idArticulo, precio) Values ('DESC', IDPROV, IDART, PREC)";
    public static String ARTPROV_MODIFICARARTPROV = "Update ArtProv set descripcion = 'DESC', idProveedor = IDPROV, idArticulo = IDART, precio = PREC where idArtProv = IDARTPROV";
    public static String ARTPROV_BAJAARTPROV = "Delete from ArtProv where idArtProv = IDARTPROV";
    public static String ARTPROV_BAJAARTPROVBYPROVEEDOR = "Delete from ArtProv where idProveedor = IDPROV";
    public static String ARTPROV_BAJAARTPROVBYARTICULO = "Delete from ArtProv where idArticulo = IDART";
    public static String ARTPROV_GETARTPROV = "Select * from ArtProv";
    public static String ARTPROV_GETARTPROVBYPROVEEDOR = "Select * from ArtProv where idProveedor = IDPROV";
    public static String ARTPROV_GETARTPROVBYARTICULO = "Select * from ArtProv where idArticulo = IDART";
    public static String ARTPROV_GETARTPROVBYID = "Select * from ArtProv where idArtProv = IDARTPROV";
    
    public static String ESTRUCTURA_ALTAESTRUCTURA = "Insert into Estructura (cantidad, activo, version, idProducto, idArticulo) Values (CANT, ACT, 'VER', IDPROD, IDART)";
    public static String ESTRUCTURA_MODIFICARESTRUCTURA = "Update Estructura set cantidad = CANT, activo = ACT, version = 'VER', idProducto = IDPROD, idArticulo = IDART where idEstructura = IDEST";
    public static String ESTRUCTURA_BAJAESTRUCTURAINDIVIDUAL = "Update Estructura set activo = 0 where idEstructura = IDEST";
    public static String ESTRUCTURA_BAJAESTRUCTURASPRODUCTO = "Update Estructura set activo = 0 where idProducto = IDPROD";
    public static String ESTRUCTURA_GETESTRUCTURAS = "Select * from Estructura;";
    public static String ESTRUCTURA_GETESTRUCTURASBYARTICULO = "Select * from Estructura where idArticulo = IDART";
    public static String ESTRUCTURA_GETESTRUCTURASBYPRODUCTO = "Select * from Estructura where idProducto = IDPROD";
    public static String ESTRUCTURA_GETESTRUCTURAACTIVABYPRODUCTO = "Select * from Estructura where idProducto = IDPROD and activo = 1";
    public static String ESTRUCTURA_GETESTRUCTURASBYPRODUCTOBYVERSION = "Select * from Estructura where idProducto = IDPROD and version = 'VER'";
    public static String ESTRUCTURA_GETESTRUCTURABYID = "Select * from Estructura where idEstructura = IDEST";
    public static String ESTRUCTURA_EXISTEESTRUCTURACONARTICULO = "Select count(*) as cantidad from Estructura idArticulo = IDART and activo = 1";
    
    public static String ESTADOORDENPRODUCCION_GETESTADOORDENPRODUCCION = "Select * from EstadoOrdenProduccion";
    public static String ESTADOORDENPRODUCCION_GETESTADOORDENPRODUCCIONBYID = "Select * from EstadoOrdenProduccion where idEstOP = IDEST";
    
    public static String ORDENPRODUCCION_ALTAORDENPRODUCCION = "Insert into OrdenProduccion (fechaPedido, idEstOP) Values ('FECHA', IDEST)";
    public static String ORDENPRODUCCION_MODIFICARORDENPRODUCCION = "Update OrdenProduccion set fechaPedido = 'FECHA', idEstOP = IDEST where idOrdenProduccion = IDOP";
    public static String ORDENPRODUCCION_BAJAORDENPRODUCCION = "Update OrdenProduccion set idEstOP = IDEST where idOrdenProduccion = IDOP";
    public static String ORDENPRODUCCION_GETORDENPRODUCCION = "Select * from OrdenProduccion";
    public static String ORDENPRODUCCION_GETORDENPRODUCCIONACTIVA = "Select * from OrdenProduccion where idEstOP = IDESTA or idEstOP = IDESTB";
    public static String ORDENPRODUCCION_GETORDENPRODUCCIONBYESTADO = "Select * from OrdenProduccion where idEstOP = IDEST";
    public static String ORDENPRODUCCION_GETORDENPRODUCCIONBYID = "Select * from OrdenProduccion where idOrdenProduccion = IDOP";
    public static String ORDENPRODUCCION_ORDENISACTIVA = "Select count(*) as cantidad from OrdenProduccion where (idEstOP = IDESTA or idEstOP = IDESTB) and idOrdenProduccion = IDOP";

    
    public static String DETALLENORDENPROD_ALTADETALLEORDENPROD = "Insert into DetalleOrdenProd (cantidad, idProducto, idOrdenProduccion) Values (CANT, IDPROD, IDOP)";
    public static String DETALLENORDENPROD_MODIFICARDETALLEORDENPROD = "Update DetalleOrdenProd set cantidad = CANT, idProducto = IDPROD, idOrdenProduccion = IDOP where idDetalleOrden = IDDET";
    public static String DETALLENORDENPROD_BAJADETALLEORDENPROD = "Delete from DetalleOrdenProd where idDetalleOrden = IDDET";
    public static String DETALLENORDENPROD_GETDETALLEORDENPROD = "Select * from DetalleOrdenProd";
    public static String DETALLENORDENPROD_GETDETALLEORDENPRODBYORDENPRODUCCION = "Select * from DetalleOrdenProd where idOrdenProduccion = IDOP";
    public static String DETALLENORDENPROD_GETDETALLEORDENPRODBYPRODUCTO = "Select * from DetalleOrdenProd where idProducto = IDPROD";
    public static String DETALLENORDENPROD_GETDETALLEORDENPRODBYID = "Select * from DetalleOrdenProd where idDetalleOrden = IDDET";
    
    public static String RUTAFABRICACION_ALTARUTAFABRICACION = "Insert into RutaFabricacion (activa, version, vigenteDesde, idProducto) Values (ACT, 'VER', 'VIG', IDPROD)";
    public static String RUTAFABRICACION_MODIFICARRUTAFABRICACION = "Update RutaFabricacion set activa = ACT, version = 'VER', vigenteDesde = 'VIG', idProducto = IDPROD where idRuta = IDRUT";
    public static String RUTAFABRICACION_BAJARUTAFABRICACIONINDIVIDUAL = "Update RutaFabricacion set activa = 0 where idRuta = IDRUT";
    public static String RUTAFABRICACION_BAJARUTASPRODUCTO = "Update RutaFabricacion set activa = 0 where idProducto = IDPROD";
    public static String RUTAFABRICACION_GETRUTAFABRICACION = "Select * from RutaFabricacion";
    public static String RUTAFABRICACION_GETRUTAFABRICACIONBYPRODUCTO = "Select * from RutaFabricacion where idProducto = IDPROD";
    public static String RUTAFABRICACION_GETRUTAFABRICACIONBYPRODUCTOACTIVA = "Select * from RutaFabricacion where idProducto = IDPROD and activa = true";
    public static String RUTAFABRICACION_GETRUTAFABRICACIONBYID = "Select * from RutaFabricacion where idRuta = IDRUT";
    public static String RUTAFABRICACION_RUTAISACTIVA = "Select count(*) as cantidad from RutaFabricacion where idRuta = IDRUT and activa = 0";

    
    public static String DETALLERUTA_ALTADETALLERUTA = "Insert into DetalleRuta (orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro, idEstructura) Values (ORD, TMO, TMAQ, TREP, IDRUT, IDCEN, IDESTR)";
    public static String DETALLERUTA_MODIFICARDETALLERUTA = "Update DetalleRuta set orden = ORD, tiempoManoObra = TMO, tiempoMaquina = TMAQ, tiempoReposo = TREP, idRuta = IDRUT, idCentro = IDCEN, idEstructura = IDESTR where idDetalleRuta = IDDET";
    //public static String DETALLERUTA_BAJADETALLERUTA = ""; //No debería ser necesaria
    public static String DETALLERUTA_GETDETALLERUTA = "Select * from DetalleRuta";
    public static String DETALLERUTA_GETDETALLERUTABYRUTA = "Select * from DetalleRuta where idRuta = IDRUT";
    public static String DETALLERUTA_GETDETALLERUTABYCENTRO = "Select * from DetalleRuta where idCentro = IDCEN";
    public static String DETALLERUTA_GETDETALLERUTABYESTRUCTURA = "Select * from DetalleRuta where idEstructura = IDESTR";
    public static String DETALLERUTA_GETDETALLERUTABYID = "Select * from DetalleRuta where idDetalleRuta = IDDET";
    
    public static String TIPOMATERIALES_GETTIPOMATERIALES = "Select * from TipoMateriales";
    public static String TIPOMATERIALES_GETTIPOMATERIALESBYID = "Select * from TipoMateriales where idTipoMateriales = IDTM";
    
    public static String MATERIALES_ALTAMATERIALES = "Insert into Materiales (cantidad, idDetalleRuta, idArticulo, idTipoMateriales) Values (CANT, IDDET, IDART, IDTM)";
    public static String MATERIALES_MODIFICARMATERIALES = "Update Materiales set cantidad = CANT, idDetalleRuta = IDDET, idArticulo = IDART, idTipoMateriales = IDTM where idMateriales = IDMAT";
    public static String MATERIALES_BAJAMATERIALES = "Delete from Materiales where idMateriales = IDMAT";
    public static String MATERIALES_GETMATERIALES = "Select * from Materiales";
    public static String MATERIALES_GETMATERIALESBYDETALLE = "Select * from Materiales where idDetalleRuta = IDDET";
    public static String MATERIALES_GETMATERIALESBYARTICULO = "Select * from Materiales where idArticulo = IDART";
    public static String MATERIALES_GETMATERIALESBYTIPO = "Select * from Materiales where idTipoMateriales = IDTM";
    public static String MATERIALES_GETMATERIALESBYTIPOBYDETALLE = "Select * from Materiales where idTipoMateriales = IDTM and idDetalleRuta = IDDET";
    public static String MATERIALES_GETMATERIALESBYID = "Select * from Materiales where idMateriales = IDMAT";

    public static String MAQUINARIA_ALTAMAQUINARIA = "Insert into Maquinaria (codMaquinaria, descripcion, idCentro, activa) Values ('CODMAQ', 'DESC', IDCEN, ACT)";
    public static String MAQUINARIA_MODIFICARMAQUINARIA = "Update Maquinaria set codMaquinaria = 'CODMAQ', descripcion = 'DESC', idCentro = IDCEN, activa = ACT where idMaquinaria = IDMAQ";
    public static String MAQUINARIA_BAJAMAQUINARIA = "Update Maquinaria set activa = 0 where idMaquinaria = IDMAQ";
    public static String MAQUINARIA_GETMAQUINARIA = "Select * from Maquinaria";
    public static String MAQUINARIA_GETMAQUINARIAACTIVA = "Select * from Maquinaria where activa = true";
    public static String MAQUINARIA_GETMAQUINARIAACTIVABYCENTRO = "Select * from Maquinaria where activa = true and idCentro = IDCEN";
    public static String MAQUINARIA_GETMAQUINARIABYCENTRO = "Select * from Maquinaria where idCentro = IDCEN";
    public static String MAQUINARIA_GETMAQUINARIABYCOD = "Select * from Maquinaria where codMaquinaria = 'CODMAQ'";
    public static String MAQUINARIA_GETMAQUINARIABYID = "Select * from Maquinaria where idMaquinara = IDMAQ";
}
