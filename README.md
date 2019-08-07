# Jersey Example

[![Build Status](https://travis-ci.org/akadir/jersey-example.svg?branch=master)](https://travis-ci.org/akadir/jersey-example)
[![Maintainability](https://api.codeclimate.com/v1/badges/c5ff00c4b28c3c06086d/maintainability)](https://codeclimate.com/github/akadir/jersey-example/maintainability)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5dde63c2c88b4419aeef5c8bd73d87b1)](https://www.codacy.com/app/akadir/jersey-example?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=akadir/jersey-example&amp;utm_campaign=Badge_Grade)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=io.git.akadir%3Ajersey-example&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.git.akadir%3Ajersey-example)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=io.git.akadir%3Ajersey-example&metric=sqale_index)](https://sonarcloud.io/dashboard?id=io.git.akadir%3Ajersey-example)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)

Example rest project to use jersey with filters and exception handlers.

```bash
mvn --version
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T22:00:29+03:00)
```

jacoco prepare agent:

```bash
mvn clean jacoco:prepare-agent install
```

generate readable code coverage reports:

```bash
mvn jacoco:report
```

## Docs

You can check this site to see implemented endpoint details: [https://akadir.github.io/jersey-example](https://akadir.github.io/jersey-example)

open-api.yaml file is here: [open-api.yaml](docs/open-api.yaml)

To generate html file from open api yaml:

First install redoc-cli
    
```bash
npm install -g redoc-cli
```

then run this command:

```bash
redoc-cli bundle -o index.html openapi.yaml
```

this command will generate new index.html file.

### Example cURL Requests

To make successful request SergenYalcin can be used as username with any password combination as you can see in 
[Authenticator](src/main/java/io/git/kadir/jersey/example/auth/Authenticator.java) class.

*   GET /isUp:
    ```bash
    curl -X GET "http://localhost:8080/jersey-example/api/isUp" -H "accept: application/json" -H "Authorization: Basic U2VyZ2VuWWFsY2luOkJqazE5MDM="
    ```

*   GET /foo:
    ```bash
    curl -X GET "http://localhost:8080/jersey-example/api/foo?bar=bar" -H "accept: application/json" -H "Authorization: Basic U2VyZ2VuWWFsY2luOkJqazE5MDM="
    ```

*   POST /ipsum:
    ```bash
    curl -X POST "http://localhost:8080/jersey-example/api/ipsum" -H "accept: application/json" -H "Authorization: Basic U2VyZ2VuWWFsY2luOkJqazE5MDM=" -H "Content-Type: application/x-www-form-urlencoded" -d "foo=lorem"
    ```

## License
 
The MIT License (MIT)

Copyright (c) kadir
