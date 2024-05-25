# Music Reviews System

## Introduction

Welcome to the Music Reviews System documentation. 
This project aims to provide a Full Stack web application to post music albums reviews and let users comment it. 
The goal of this project is to create a community where users can discover new music and share their opinions about it 
but also interact with other people.
It is built using Java for the backend and Vue.js for the frontend.

### Key Features
- **Post Album Review** - user with role `ADMIN` can post a review of an album
- **Comment Review** - user with role `USER` or `ADMIN` can comment on a review
- **User Authentication** - user can register and login to the system

### Technologies Used
- **Backend:** Java (Spring Boot (REST API), Hibernate (ORM))
- **Frontend:** Vue.js (Vuex, Vue Router, etc.)
- **Database:** PostgreSQL
- **Deployment:** Docker, Docker Compose
- **Authentication:** JWT (JSON Web Token) for secure authentication




## Getting Started

### Prerequisites
Before you begin, ensure you have met the following requirements:
- Java (version 17 or later)
- Node.js (version 16 or later)
- npm or Yarn
- PostgreSQL
- Docker and Docker Compose (optional)
- Git
- IDE (IntelliJ IDEA, Eclipse, Visual Studio Code, etc.)

### Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/your-repo.git
    ```
2. **Backend Setup:**
    - Navigate to the backend directory:
        ```sh
        cd backend
        ```
    - Install dependencies:
        ```sh
        ./mvnw install
        ```
    - Run the application:
        ```sh
        ./mvnw spring-boot:run
        ```
3. **Frontend Setup:**
    - Navigate to the frontend directory:
        ```sh
        cd frontend
        ```
    - Install dependencies:
        ```sh
        npm install
        # or
        yarn install
        ```
    - Run the application:
        ```sh
        npm run serve
        # or
        yarn serve
        ```
4. **Accessing the Application:**
    - Open your browser and go to `http://localhost:8080` (or the configured port).

### Configuration
1. **application.properties** - backend application properties: <br>
   **Database Configuration**
    - `spring.datasource.url` - database URL
    - `spring.datasource.username` - database username
    - `spring.datasource.password` - database password
    - `spring.jpa.hibernate.ddl-auto` - database initialization mode
    - `spring.jpa.properties.hibernate.dialect` - database dialect
    - `spring.jpa.show-sql` - show SQL queries <br><br>
   **JWT Configuration**
    - `jwt.secret` - JWT secret key 
    - `jwt.expiration` - JWT expiration time <br><br>
   **Mail Configuration**
    - `spring.mail.host` - SMTP server host
    - `spring.mail.port` - SMTP server port
    - `spring.mail.username` - SMTP server username
    - `spring.mail.password` - SMTP server password
         - **other properties for mail configuration**
2. **.env** - environment variables for the docker compose file:
    - `DATABASE_USER` - database username
    - `DATABASE_PASSWORD` - database password
    - `DATABASE_NAME` - database name


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jdbc)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.



## Project Structure

### Backend
- `src/main/java/dev/musicsystem/musicsystem` - Java source files
- `src/main/resources` - Configuration files

### Frontend
- `src` - Vue.js components, views, store, etc.
- `public` - Static assets

### Important Files
- `pom.xml` - Maven configuration file
- `package.json` - npm/Yarn configuration file
- `README.md` - Project overview and instructions


## API Documentation

### Authentication
- **Endpoint:** `POST /api/auth/login`
- **Request:**
    ```json
    {
      "username": "user",
      "password": "password"
    }
    ```
- **Response:**
    ```json
    {
      "token": "jwt-token"
    }
    ```

### User Management
- **Get User:**
    - **Endpoint:** `GET /api/users/{id}`
    - **Response:**
        ```json
        {
          "id": 1,
          "username": "user"
        }
        ```
- **Create User:**
    - **Endpoint:** `POST /api/users`
    - **Request:**
        ```json
        {
          "username": "newuser",
          "password": "password"
        }
        ```
    - **Response:**
        ```json
        {
          "id": 2,
          "username": "newuser"
        }
        ```
