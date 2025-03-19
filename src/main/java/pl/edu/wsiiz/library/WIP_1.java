package pl.edu.wsiiz.library;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WIP_1 {
    @Test
    void Test_1() {
        Book Ksiazka_1 = new Book("WIP_1", "WIP_2", "9788656487505");
        Book Ksiazka_2 = new Book("WIP_3", "WIP_4", "9788656487505");

        System.out.println(Ksiazka_1.equals(Ksiazka_2));
        assertTrue(Ksiazka_1.equals(Ksiazka_2));
    }

    @Disabled
    @Test
    void Test_2() {
        Book Ksiazka_1 = new Book("WIP_1", "WIP_2", "9788656487505");
        Book Ksiazka_2 = new Book("WIP_3", "WIP_4", "9788656487505");

        System.out.println(Ksiazka_1.equals(Ksiazka_2));
        assertFalse(Ksiazka_1.equals(Ksiazka_2));
    }

    @Test
    void Test_3() {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");

        Library Biblioteka_1 = new Library();

        Biblioteka_1.addBook(Ksiazka_1);

        assertDoesNotThrow(() -> {
            Biblioteka_1.borrowBook("1788656487505");
        });

        assertThrows(IllegalStateException.class, () -> {
            Biblioteka_1.borrowBook("1788656487505");
        });
    }
}