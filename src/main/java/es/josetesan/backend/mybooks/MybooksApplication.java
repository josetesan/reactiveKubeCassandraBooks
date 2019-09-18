package es.josetesan.backend.mybooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableReactiveCassandraRepositories
public class MybooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybooksApplication.class, args);
    }

}
