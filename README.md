# mnemo
Prueba aptitudes Java / Spring Víctor Adeva para MNEMO
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

Peticiones:
 - GET ALL: Bajo la ruta "/users", admite los parámetros:
   - type: admite los valores "id", "name", "surname", "code", "groups_id", "groups_name". Coincide con las columnas de las entidades. Opcional
   - order: admite los valores "asc" y "desc". Opcional.
   - value: valor del filtro a aplicar, si aplica. Opcional.
   - page: página actual para paginado. Por defecto es 0.
   
 - GET SINGLE: Bajo la ruta "/user/{id}". Variable de ruta tipo numérico obligatorio.
 - POST: Bajo la ruta "/user". Request body requerido, con los mismos campos de la entidad a excepción del ID, pues es incremental.
 - PATCH: Bajo la ruta "/user/{id}". Variable de ruta tipo numérico obligatorio. Request body requerido, con los mismos campos de la entidad a excepción del ID.
 - DELETE: Bajo la ruta "/user/{id}". Variable de ruta tipo numérico obligatorio.
 
------------------------------------------------------------------------------------------------------------------------------------------------------------------

Aclaraciones: 
Se ha tardado mucho más de lo previsto por mal planteamiento inicial propio y por problemas de conectividad. Empecé un proyecto que acabé borrando por completo cuando había invertido ya tiempo en él, lo cual me ha hecho invertir aún más, y esto me ha creado conflictos por la falta de planificación de este, pues no esperaba invertir ni la mitad.

Aun con ésto, existen 3 branches, uno con un desarrollo inicial (master), y uno que creé para fixes("Fixes"), que acabé mergeando en el primero.
Tras éste, creé otro nuevo branch para nuevos fixes, que también mergeé una vez solucionado.

Lo único que no he tenido en cuenta es el cambio de versiones, que tendría que haber subido por cada bugfix.

Finalmente, se han añadido tests para el controlador de usuarios. 
