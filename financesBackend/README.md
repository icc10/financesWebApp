### Backdend

built assuming postgreSQL

run using: mvn spring-boot:run

# database stuff goes in src/resources/application.properties with the following format:

# PostgreSQL configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/financesApp
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=[DB_USERNAME]
spring.datasource.password=[BS_PASSWORD]
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect


# it needs to eventually use the real database.
becuase im using JPA, it should be as easy as inputting that data and everything will work. 
we'll see if that actaully happens

