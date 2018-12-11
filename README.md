# Axi Test Spring Application

It should be possible to `git clone` this project and then run it from both your IDE
and the commandline. 

## Requirements

### Must haves

* Java 10 or 11 installed (https://adoptopenjdk.net/)
* IntelliJ
* Lombok Plugin for IntelliJ

### Nice to haves

* Scoop command line installer for Windows (https://scoop.sh/)
* Git + Git Bash (install via Scoop)
* Gradle (install via Scoop)

## Annotation processing

First however make sure you enable 'Annotation Processing' for this project:

    File > 
      Preferences > 
        Build, Execution, Deployment > 
          Compiler > 
            Annotation Processors >
              Enable Annotation Processing
              
## Run from IDE
              
You can run the application from your IDE by starting MyappApplication. 

## Run from the command line

It should also be possible to build and run the application via Gradle:

    gradlew.bat clean build
    gradlew.bat bootRun
    
## Testing

The application should start with a number of log lines that end with something like this:

    2018-12-11 15:21:39.826  INFO 28483 --- [           main] ... : Tomcat started on port(s): 8080 (http) with context path ''
    2018-12-11 15:21:39.833  INFO 28483 --- [           main] ... : Started MyappApplication in 2.131 seconds (JVM running for 2.576)
    2018-12-11 15:21:53.479  INFO 28483 --- [nio-8080-exec-1] ... : Initializing Spring DispatcherServlet 'dispatcherServlet'
    2018-12-11 15:21:53.479  INFO 28483 --- [nio-8080-exec-1] ... : Initializing Servlet 'dispatcherServlet'
    2018-12-11 15:21:53.487  INFO 28483 --- [nio-8080-exec-1] ... : Completed initialization in 8 ms

If it instead complains it can't listen on port 8080 it means something else is already listening on that port. This can happen if you
start the application twice for example. 

You can now go to http://localhost:8080/hello and should see a response like this:

    {"message":"Hello World!"}