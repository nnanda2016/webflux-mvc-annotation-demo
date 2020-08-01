# webflux-mvc-annotation-demo
A Demo app showing the usage of Spring WebFlux reactive with MVC Annotations

## Use The App
Use following command to run the app

```bash
./gradlew clean build bootRun
```

This will start the server on port `9090`. The URL to test the app is

```bash
curl -v http://localhost:9090/api/hello/someName
```

The logs are generated under `build/logs` folder.

