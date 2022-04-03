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
3. to add and view the album and song use ```/allAlbum```
4. to view the songs use `/allSongs`
