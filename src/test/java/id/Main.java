 package id;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;

 /**
  * Please add application.properties under test/resources.
  * enter spring.datasource.* and spring.jpa.* configs as needed
  */
 @SpringBootApplication
 public class Main {
     public static void main(String[] args) {
         SpringApplication.run(Main.class, args);
     }
 }