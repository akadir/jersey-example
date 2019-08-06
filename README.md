# Jersey Example

[![Build Status](https://travis-ci.org/akadir/jersey-example.svg?branch=master)](https://travis-ci.org/akadir/jersey-example)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=io.git.akadir%3Ajersey-example&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.git.akadir%3Ajersey-example)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=io.git.akadir%3Ajersey-example&metric=sqale_index)](https://sonarcloud.io/dashboard?id=io.git.akadir%3Ajersey-example)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)


Example rest project to use jersey with filters and exception handlers.

```
mvn --version: Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T18:41:47+03:00)
```

jacoco prepare agent:
```
mvn clean jacoco:prepare-agent install
```

generate readable code coverage reports:
```
mvn jacoco:report
```