package sarc.cloud.chronomesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Chronomesh application.
 *
 * @author marco.mangan@gmail.com
 */
@SpringBootApplication
public class ChronomeshApplication {

     /**
      * The main method that serves as the entry point for the Spring Boot
      * application.
      * It uses Spring Boot's {@link SpringApplication#run(Class, String...)} method
      * to
      * launch the application.
      *
      * @param args command-line arguments passed to the application
      */
     public static void main(String[] args) {
          SpringApplication.run(ChronomeshApplication.class, args);
     }

}
