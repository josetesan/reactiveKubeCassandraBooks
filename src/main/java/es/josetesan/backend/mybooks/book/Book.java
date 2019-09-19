package es.josetesan.backend.mybooks.book;

import lombok.Value;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Value
@Table("books")
public class Book {

    @PrimaryKeyColumn(
        name = "isbn",
        ordinal = 1,
        type = PrimaryKeyType.CLUSTERED,
        ordering = Ordering.DESCENDING)
    private UUID id;
    @Indexed
    @PrimaryKeyColumn(
        name = "title", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String title;
    @Indexed
    @PrimaryKeyColumn(
        name = "author", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String author;
    private Language language;
    private String summary;
}
