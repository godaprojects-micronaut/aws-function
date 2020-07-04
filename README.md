# Micronaut AWS fuction
Implemented in three ways
1. V1 using FunctionInitializer
2. V2 using MicronautRequestHandler (Standard and the latest) - Needs a memory of 256MB although it uses only 93 MB. Need to check that. 
3. V3 using java.util.function.Function - Seems to be an extension of the MicronautRequestHandler variety but does not work when the @FunctionBean is anything other than "test"

Used the following commands
```
sam build
sam local invoke <Function Name> -e <Event file name>
```

P.S. Tried the constructor injection and that did not seem to work with the MicronautRequestHandler. Have to see later

## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)

