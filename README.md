# online-bookstore-test-submission
Online Bookstore Management Sample Test

Springboot version 2.7.14
Datebase = H2 (a copy of the included in the containing folder, needs to be copied user home i.e C:\Users\ikram)
Java version 1.8.0_371

Application runs on HTTP port 8681

Application will run from command line with command = mvn spring-boot:run

A Swagger view page is include at http://localhost:8681/swagger-ui/index.html#/

Application was developed and tested on Intellij, Postman and Swagger UI

UNIT TESTING

Core unit test for endpoint is BookStoreServiceEndpointIntegrationTest.

NOTE: H2 Database is external and in-memory. Entity tables are created on application first run.
      Changelog updates tables on every application restart ever for changes are made.

Observation: I had MockMVC deserilization issues for entity classes with entity relationship.

