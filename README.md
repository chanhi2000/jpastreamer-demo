# `jpastreamer-demo`

---

## What's included?

![shield-java][shield-java]
![shield-kotlin][shield-kotlin]
![shield-gradle][shield-gradle]
![shield-quarkus][shield-quarkus]
![shield-docker][shield-docker]
![shield-mysql][shield-mysql]

---

## 🚀Quickstart

Run the following shell script to initiate MySQL Sakila DB

```sh
docker run --platform linux/amd64 \
  -d -it \
  --name sakila \
  --publish 3306:3306 \
  restsql/mysql-sakila:latest
```

| title | description |
| :--- | :---- |
| JDBC Driver Class | `com.mysql.cj.jdbc.Driver` |
| JDBC Url | `jdbc:mysql://localhost:3306/sakila` |
| 🔑`User`/`Password` | `root`/`sakila` |

---

## ▶️Run

### Dev Mode

You can run your application in dev mode that enables live coding using:

```sh
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:

```sh
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```sh
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

---

## Creating a native executable

You can create a native executable using: 

```sh
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```sh
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/jpastreamer-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

---

## Related Guides

- Hibernate ORM with Panache and Kotlin ([guide](https://quarkus.io/guides/hibernate-orm-panache-kotlin)): Define your persistent model in Hibernate ORM with Panache
- JPAStreamer ([guide](https://quarkiverse.github.io/quarkiverse-docs/quarkus-jpastreamer/dev/)): Express your Hibernate queries as standard Java Streams
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC

---

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)


[Related Hibernate with Panache in Kotlin section...](https://quarkus.io/guides/hibernate-orm-panache-kotlin)

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

[shield-java]: https://img.shields.io/badge/Temurin-11-f3812a?logo=openjdk&logoColor=f3812a&style=flat-square
[shield-kotlin]: https://img.shields.io/badge/Kotlin-1.4.31-0095D5?logo=kotlin&logoColor=0095D5&style=flat-square
[shield-gradle]: https://img.shields.io/badge/Gradle-7.4.2-abd759?logo=gradle&logoColor=abd759&style=flat-square
[shield-quarkus]: https://img.shields.io/badge/Quarkus-3.4-4695EB?logo=quarkus&logoColor=4695EB&style=flat-square
[shield-docker]: https://img.shields.io/badge/Docker-20.10.x-2496ED?logo=docker&logoColor=2496ED&style=flat-square
[shield-mysql]: https://img.shields.io/badge/MySQL-5.x-4479A1?logo=mysql&logoColor=4479A1&style=flat-square
