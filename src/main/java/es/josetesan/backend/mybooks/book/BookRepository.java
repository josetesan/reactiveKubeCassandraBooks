package es.josetesan.backend.mybooks.book;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends ReactiveCassandraRepository<Book, UUID> {
}
