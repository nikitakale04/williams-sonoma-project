
# Williams-Sonoma-project

## Installation Instructions
### 1. Clone the repo in your local by running the following command:
git clone https://github.com/nikitakale04/williams-sonoma.git

### 2. Build and Run Unit Tests
`./mvnw clean verify`

### 3. Run application
go to the path /zipcodes-merge-service in your terminal and run the following command:
`./mvnw spring-boot:run`

### 4. Use the APIs
#### Swagger UI: 
Open the Swagger UI : http://localhost:8080/swagger-ui.html
####
http://localhost:8080/zipRangeMerge
##### Sample Input for POST body
[
{
  "start": 94133,
  "end": 94133
},
{
  "start": 94200,
  "end": 94299
}
]

####
http://localhost:8080/zipRangeStringInputMerge
##### Sample Input for POST body - when input and output and in String format
"[94133,94133] [94200,94299]"

## Choice of language, framework and libraries
### JAVA 8, Spring Boot
I have extensively used these technologies.
Spring Boot have lot of built in libraries which makes coding faster and easier. Spring Boot reduces lots of development time and increases productivity. It avoids writing lots of boilerplate Code, Annotations and XML Configuration.

Time complexixity ---> O(n * log n)
Space complexity ----> O(1)
