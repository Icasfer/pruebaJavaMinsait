# Prueba Java Ecommerce

## Enunciado

El enunciado de la práctica esta en /Prueba Java[70].txt

## Estructura

Para no darle demasiada complejidad a la solución se ha optado por darle la siguiente estructura al proyecto:

- Controller: Aquí expongo el endpoint.
- Services: Aquí aplico la lógica para obtener el precio final.
- Repository: Aquí es donde tengo las operaciones con la BD.
- Model: Aquí es donde tenemos los modelos de datos y entidades.
- Exceptions: Aquí es donde tengo las excepciones que he creado para el control de errores.

He creado un endpoint de tipo GET para recuperar los datos indicados, dicho endpoint recibe los 3 parámetros de entrada en la URL: 
prices/{fecha de aplicación con el fomato yyyy-mm-dd hh:mm:ss}/{productId}/{brandId} y nos devuelve la salida indicada en el enunciado.

## Base de Datos

Para la BD he creado una h2 que al ejecutar el proyecto se inicializan los datos, para esto he creado los archivos src/main/resources/db/schema.sql (esquema de BD) y src/main/resources/db/data.sql (datos de la BD).
Si se quiere acceder por consola introducir la siguiente url con las siguientes credenciales: http://localhost:8080/h2-console ; username: prueba password: 1234

He optado por añadir un campo más como clave primaria que es un id autoincremental lo demás lo he dejado prácticamente igual. De tipos de datos he elegido los siguientes:

ID INTEGER,
BRAND_ID BIGINT,
START_DATE TIMESTAMP,
END_DATE TIMESTAMP,
PRICE_LIST BIGINT,
PRODUCT_ID BIGINT,
PRIORITY INTEGER,
PRICE DECIMAL(5,2),
CURR VARCHAR(10)

He decidido las fechas guardarlas como TIMESTAMP para tener el dia y la hora (me parece más correcto que guardarlo como varchar), y he utilizado BIGINT porque para ids de productos, tiendas, etc... muchas veces se utiliza el tipo Long en Java aunque en este ejemplo realmente no hace falta con los datos que manejamos.

## Funcionamiento general del proyecto

En el modelo tengo definidos los datos de entrada y salida; y una entidad que corresponde con la tabla de la base de datos H2. El endpoint que tenemos definido en el controlador llama a la capa de servicio, aunque lo hace comunicandose con una interfaz, es la implementación de ese servicio la que consultar a BD con el productId, el brandId y la fecha que nos indican, esto lo hacemos mediante JPA Criteria. Básicamente consultamos que el productId y el brandId coincidan y que esté comprendido entre las fechas de inicio y fin (start_date y end_date). Digamos que un ejemplo de la consulta que haríamos a BD sería la siguiente:

SELECT *
FROM   PRICES P
WHERE  P.brand_id = 1
       AND p.product_id = 35455
       AND '2020-06-14 16:00:00' BETWEEN p.start_date AND p.end_date;

Una vez obtenidos esos resultados desde el servicio nos quedaríamos con el que más prioridad tenga (en caso de que tenga la misma prioridad se quedaría con el primero que recuperara). La comunicación entre la capa servicio y repositorio también es a través de una interfaz 

## Testing

Los test los he implementado con JUnit, Mockito y MockMVC.

He creado los 5 test propuestos para la capa de servicio, corresponden a los que hay en src/test/java/PriceServiceTest.java

- Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) --> Aquí recuperaríamos la lista de precio 1, por tanto el precio final sería de 35.50.

- Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA) --> Aquí recuperaríamos la lista de precio 1 y 2, por tanto el precio final por prioridad sería de 25.45.

- Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA) --> Aquí recuperaríamos la lista de precio 1, por tanto el precio final sería de 35.50.

- Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA) --> Aquí recuperaríamos la lista de precio 1 y 3, por tanto el precio final por prioridad sería de 30.50.

- Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) --> Aquí recuperaríamos la lista de precio 1 y 4, por tanto el precio final por prioridad sería de 38.95.

A parte se ha creado un test para el endpoint del controller.

## Levantar servidor

Con ejecutar el proyecto como SprinBoot App ya levanta el servidor en el puerto 8080.

## Contacto

Iván Castaño Fernández

ivan.castano.fdez@gmail.com