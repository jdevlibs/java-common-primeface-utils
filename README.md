# JSF + Primeface utilities
JSF and Primeface utilities library

# Build & Deploy
## Setup JDK
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.15.1.jdk/Contents/Home

## Deploy
mvn clean deploy

## Release
mvn nexus-staging:release

## Drop
mvn nexus-staging:drop