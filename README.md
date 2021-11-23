# GendraPT
Gendra Prueba Tecnica

Josue Rivera

Por los requerimientos del sistema se nos pidió hacer una pequeña api para obtener lista de sugerencias de ciudades, las sugerencias se despliegan por dos criterios, una palabra de búsqueda y una posición geográfica determinada por latitud y longitud

La respuesta al consultar el api es una lista de ciudades con su posición geográfica por puntuación de confianza, esta última está determinada por la proximidad, entre más cerca este el punto geográfico enviado más confianza tendrá, la puntuación está en el rango de 0 y 1, siendo el 1 el más confiable, para distinguir los puntos con nombres similares, se diferencian por el nombre del estado donde se encuentra la ciudad.

Los datos son obtenidos desde https://www.geonames.org/
Para reducir el tiempo de respuesta del api los resultados se guardan en una base de datos.


Para probar el servicio por medio de curl:

curl -X GET https://gendrapt.uc.r.appspot.com/suggestions?q=londo&latitude=43.70011&longitude=-79.4163 -H accept: application/json


Para probar el servicio por navegador web:

https://gendrapt.uc.r.appspot.com/suggestions?q=londo&latitude=43.70011&longitude=-79.4163

También se puede probar con Swagger en la siguiente liga:

https://gendrapt.uc.r.appspot.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
