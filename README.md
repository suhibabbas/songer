# Songr App

you can use this app to add a new album to the bata base or render the saved data.

## application.properties

server.port=8080
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/songr
spring.datasource.username=suh
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.datasource.initialization-mode=always

## Path

1. to view the greeting page use: ```/hello?name={name}```
2. to view capitalize page use:```/capitalize/{something}```
3. to view the manual added album use:```/Album```
4. to add and view the album from data base use ```/allAlbum```
5. to add and view the new song use ```/song```
6. to add song to the album by id ```/album/id```
7. to find album by title ```/album/{title}```