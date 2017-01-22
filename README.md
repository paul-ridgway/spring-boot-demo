## Spring Boot Demo / Sandbox
 
### Introduction

As a long time Ruby-on-Rails developer I have been looking for ways to make Spring feel as 'quick' as Rails is in terms
of development and prototyping. This project is a demo which looks to address some of the aspects I find challenging.

### 'Features'

#### Spring Boot

I have always found the Spring documentation frustrating - so many versions and often hard to find an up-to-date
example.

The Spring Boot project seems to have better examples and reduces the amount of boilerplate required while still
allowing flexibility and extensibility if desired, as a result I started with Spring Boot much like Rails allows
one to scaffold a project with a simple command. 

I started by generating a project using http://start.spring.io/ 

#### WebJars
- JQuery
- Bootstrap
- Data Tables

#### FreeMarker
- FreeMarker

#### 'Layout' Handling
- layout handling (thanks to JR)

####  early view rendering
TODO

####  jar/local resource serving
TODO

####  Resource debugging
TODO

####  Static content serving
TODO

####  IsJar helper
TODO

####  Figure Resource Caching
- Not actually caching, more build proc
- mvn clean
- WebApp Assets vs resources/public (rebuild to deploy)
    - Jar fix