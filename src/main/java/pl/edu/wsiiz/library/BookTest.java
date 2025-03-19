package pl.edu.wsiiz.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest
{
    @Test
    void shouldCreateBookWithValidData() {
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884");
        assertAll(
                () -> assertEquals("Clean Code", book.getTitle()),
                () -> assertEquals("Robert C. Martin", book.getAuthor()),
                () -> assertTrue(book.isAvailable())
        );
    }

    @Test
    void shouldThrowExceptionWhenCreatingWithInvalidISBN()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new Book("Test", "Author", "123")
        );
    }

    @Test
    void shouldChangeAvailabilityStatus()
    {
        Book book = new Book("Effective Java", "Joshua Bloch", "9780321356680");
        book.borrowBook();
        assertFalse(book.isAvailable());

        book.returnBook();
        assertTrue(book.isAvailable());
    }

    @Test
    void WIP_2() {
        Book Ksiazka_1 = new Book("WIP_1", "WIP_2", "9788656487505");
        Book Ksiazka_2 = new Book("WIP_3", "WIP_4", "9788656487505");

        System.out.println(Ksiazka_1.equals(Ksiazka_2));
        assertFalse(Ksiazka_1.equals(Ksiazka_2));
    }
}
