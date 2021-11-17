package ee.bcs.java.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private List <BookDto> books = new ArrayList<>();

    // http://localhost:8080/book/addBook?name=Faust&author=Goethe&year=1963
    @GetMapping("book/addBook")
    public String addBook(@RequestParam("bookName") String bookName,
                          @RequestParam("author") String author,
                          @RequestParam("year") Integer year) {
        BookDto book = new BookDto();
        book.setBookName (bookName);
        book.setAuthor (author);
        book.setYear (year);
        books.add(book);
        return "Raamat on lisatud andmebaasi";
    }

    // http://localhost:8080/book (GET)
    @GetMapping("book")
    public List<BookDto> getAllBook() {
        return books;
        //TODO tagasta kõik raamatud
    }

    //http://localhost:8080/book/1
    @GetMapping("book/{id}")
    public BookDto getBook(@PathVariable("id") int id) {
        return books.get(id);
    }

    // http://localhost:8080/book/1 (DELETE)
    @DeleteMapping("book/{id}")
    public void deleteBook(@PathVariable("id") int id){
        books.remove(id);
    }
}
