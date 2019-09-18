package es.josetesan.backend.mybooks.book;

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

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @PostMapping("/book")
    public Mono<Book> createBook(@Valid @RequestBody Book book) {
        log.info("Received book {}", book);
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Mono<Book> getBook(@PathVariable("id") UUID id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/book")
    public Flux<Book> getBookByTitleAprox(@RequestParam("title") String title) {
        return bookRepository.findBookByTitleContains(title);
    }
}

