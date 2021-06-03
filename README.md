# Backend Challenge

Itaú Backend - Password Validation

## Requirements
* JDK 8 or greater

## Build
```bash
./gradlew build
```

## Run
```bash
./gradlew run
```

## Unit Tests
```bash
./gradlew test
```

## Run test through curl
```bash
curl -X POST \
  http://localhost:7000/validate \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'password: ABTP9!FOK' \
  -H 'postman-token: bea68031-95af-843c-483a-e5381f24f8b9'
```

## Run test through Application
Just run the class:
```bash
com.eduacsp.backend.validacao.app.Application.kt
```
