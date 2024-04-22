## Development

During development it is recommended to use the profile `local`. Create your own `application-local.yml` file to
override settings for development.

After starting the application it is accessible under `http://localhost:8080/swagger-ui/index.html`.

## Build and run in docker

The application jar can be built using the following command:

```
mvnw clean package
```

Then, to build the docker image, run the following command:

```
docker build -t swapi-proxi-api .  
```

Start your application with the following command:

```
docker run -d -p 8081:8080 swapi-proxi-api 
```

Check the swagger endpoint at `http://localhost:8081/swagger-ui/index.html`
