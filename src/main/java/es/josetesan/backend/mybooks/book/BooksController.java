package es.josetesan.backend.mybooks.book;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
public class BooksController {


    private BookRepository bookRepository;
    private Counter counter;
    private Timer timer;

    public BooksController(BookRepository bookRepository, MeterRegistry meterRegistry) {
        this.bookRepository = bookRepository;
        this.counter = meterRegistry.counter("books.controller.count");
        this.timer = meterRegistry.timer("books.controller.timer");
    }

    @GetMapping("/books")
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @PostMapping("/book")
    public Mono<Book> createBook(@Valid @RequestBody Book book) throws Exception {

        this.counter.increment();
        return this.timer.recordCallable(() -> {
            log.info("Created book {}", book);
            return bookRepository.save(book);
        });
    }

    @GetMapping("/book/{id}")
    public Mono<Book> getBook(@PathVariable("id") UUID id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/book")
    public Flux<Book> getBookByTitleAprox(@RequestParam("title") String title) throws Exception {
        return this.timer.recordCallable(() ->  bookRepository.findBookByTitleContains(title));
    }
}

