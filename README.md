# Reto para la empresa Napptilus

## Requisitos

Se pide construir un servicio empaquetado en WAR o EAR que provea un endpoint rest de consulta tal que:

- Acepte como parámetros de entrada: fecha de aplicación, identificador de
  producto, identificador de cadena.

- Devuelva como datos de salida: identificador de producto, identificador de
  cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del
ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

-  Desarrollar unos test al endpoint rest que validen las siguientes peticiones al servicio
   con los datos del ejemplo:

   - Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
   - Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
   - Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
   - Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
   - Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1

En la base de datos de comercio electrónico de la compañía disponemos de la tabla
PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena
entre unas fechas determinadas. A continuación, se muestra un ejemplo de la tabla con los
campos relevantes:

| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR |
|----------|----------------------|----------------------|------------|------------|----------|--------|------|
| 1        | 2020-06-14-00.00.00  | 2020-12-31-23.59.59  | 1          | 35455      | 0        | 35.50  | EUR  |
| 1        | 2020-06-14-15.00.00  | 2020-06-14-18.30.00  | 2          | 35455      | 1        | 25.45  | EUR  |
| 1        | 2020-06-15-00.00.00  | 2020-06-15-11.00.00  | 3          | 35455      | 1        | 30.50  | EUR  |
| 1        | 2020-06-15-16.00.00  | 2020-12-31-23.59.59  | 4          | 35455      | 1        | 38.95  | EUR  |

---


## Solución y decisiones adoptadas

Para el servicio se ha generado la documentación por swagger en la [URL](http://localhost:8080/swagger-ui/index.html) para posibles pruebas manuales del servicio

### BBDD
He decidido tomar como clave productId, brandId y priceList ya que para los datos de ejemplo y pensando el resto de datos, sería lo más lógico.

Para la query en un principio no había tenido en cuenta la columna prioridad, mostrando el rango de fecha de inicio y fin más acorde a la fecha enviada. Dejo la query para su revisión:

```
SELECT pr.product_id, pr.brand_id, pr.price_list, pr.price, pr.start_date, pr.end_date 
FROM PRICE pr 
WHERE 
pr.product_id=35455 and
      pr.brand_id = 1 and
      pr.start_date <= {ts '2020-06-14 16:00:00'} AND
      pr.end_date >= {ts '2020-06-14 16:00:00'} AND
      DATEDIFF(second,pr.start_date, pr.end_date) = (SELECT MIN(DATEDIFF(second,p.start_date, p.end_date)) minDate FROM PRICE p WHERE p.product_id=35455 and
      p.brand_id = 1 and
      p.start_date <= {ts '2020-06-14 16:00:00'} AND
      p.end_date >= {ts '2020-06-14 16:00:00'} );
```

No he tenido en cuenta si el precio pudiera estar dado de alta en diferences monedas (currency) como el dollar.
