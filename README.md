Version: 6fded861e429e45045074c927c6a6712fc9f3dd5

Pre-requisites:
1. java 1.8
2. maven

Run unit tests:
- mvn clean test -PunitTests


To check code coverage open 'target/site/jacoco/index.html' in browser


Run integration tests:
- mvn clean test -PintegrationTests


Build executable jar:
- mvn clean package