# CRUD Rest Services with Spring

CRUD Rest Services with Spring based on 
https://spring.io/guides/tutorials/rest/

Adding PDF with same instructions than link above
steps/Building REST services with Spring.pdf

Step so far:
Step 1 - Creating a new Spring Project at Spring Initializr web site:
	https://start.spring.io/
	see 'steps' folder
Step 2 - Add domain object: Product.
	Additionally the library Lombok was added in order to use annotations instead of manual setters and getters. More info at:
	https://projectlombok.org/
Step 3 - Adding JPA annotations and repository
Step 4 - DataBase loading
Step 5 - Adding the product controller (services exposure)
Step 6 - Catching exceptions. If the product ID is not found, a 500 error is return, but in the following exception is never handled:
	java.util.NoSuchElementException: No value present
	This an unchecked exception that can be customized by extending RuntimeException: ProductNotFoundException
Step 7 - Customizing response. It returns a custom error messsage with the status code 404
Step 8 - Returning customized JSON response.
Step 9 - Solving the CORS issue for local testing purposes. More details:
	https://enable-cors.org/
	https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin

(Optional)
Step 10 - Running service with docker.
	run the command
		./gradlew bootBuildImage --imageName=springio/crud-restful-docker
	run the container
		docker run -p 8081:8080 -t springio/crud-restful-docker
	Where:
		8081 can be replaced by any port available on the host
		8080 is the port where the service is running 'inside' the container
	More info:
	https://spring.io/guides/gs/spring-boot-docker/	
