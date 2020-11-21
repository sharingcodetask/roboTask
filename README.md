# RobotTask

## Tech stack
  Spring boot, Java 11, Maven, Lombok, swagger.
 
## Import step for eclipse
  1. clone git repo from url : https://github.com/sharingcodetask/roboTask 
     a. select only master branch
  2. right click working tree(in git repo view)and import project.
     a. select the folder of maven type.
  3. project is imported in project explorer.
## Running instructions using mvn:
    1. build project using mvn install
      Sample:  C:\Users\bansa\git\repository\robot>mvn clean install
    2. run the project using mvn spring-boot:run
      Sample: C:\Users\bansa\git\repository\robot>mvn spring-boot:run
    3. run the test using mvn test
      Sample: C:\Users\bansa\git\repository\robot>mvn clean test
      
      where  "C:\Users\bansa\git\repository\robot" is the project location
      
## App can be accessed with url http://localhost:8080/swagger-ui/index.html on browser
## Or using below request from postman 
  
  POST    http://localhost:8080/api/v1/robots/clean
  Request
          {
          "areaSize" : [5, 5],
          "startingPosition" : [1, 2],
          "oilPatches" : [
            [1, 0],
            [2, 2],
            [2, 3]
        ],
          "navigationInstructions" : "NNESEESWNWW"
        }
        
## Note: test cases are not exhaustive due to time limitation but pretty much gives the design.


