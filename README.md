# GendraPT
Gendra Prueba Tecnico 

Josue Rivera

Por los requerimientos del sistema se nos pidio hacer una pequeña api para obtener lista de sugerencias de ciudades,
las sugerencias se despligan por dos criterios, una palabra de busqueda y una posicion geografica determinada por latitud y longitud

La respueta al consultar la api es una lista de ciudades con su posicion geografica un una puntuacion de confianza, esta ultima esta determinada por la proximidad, entre mas cerca este el punto geografico enviado mas confiaza tendra, la puntuacion esta en el rango de 0 y 1, siendo el 1 el mas confiable, para distinguir los puntos con nombres similares, se diferencian por el nombre del estado donde se encuentra la ciudad.

Los datos son obtenidos desde https://www.geonames.org/
Para reducir el tiempo de respuesta de la api los resultados se guardan en una base de datos.


Para probar  el servicio por medio de curl:

curl -X GET https://gendrapt.uc.r.appspot.com/suggestions?q=londo&latitude=43.70011&longitude=-79.4163 -H accept: application/json


Para probar el servicio por navegador web:

https://gendrapt.uc.r.appspot.com/suggestions?q=londo&latitude=43.70011&longitude=-81.23304

Tambien se puede probar con Swagger en la siguiente liga:

https://gendrapt.uc.r.appspot.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config