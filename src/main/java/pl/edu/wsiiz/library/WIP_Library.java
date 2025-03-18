package pl.edu.wsiiz.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WIP_Library {
    @Test
    void Dodawanie_Duplikatow_ISBN()
    {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");
        Book Ksiazka_2 = new Book("WIP_2a", "WIP_2b", "2788656487505");
        Book Ksiazka_3 = new Book("WIP_3c", "WIP_3c", "2788656487505");

        Library Biblioteka_1 = new Library();

        assertDoesNotThrow(() -> { // "Poprawne dodawanie" książek
            Biblioteka_1.addBook(Ksiazka_1);
            Biblioteka_1.addBook(Ksiazka_2);
        });

        assertThrows(IllegalArgumentException.class, () -> { // "Niepoprawne dodawanie" książek
            Biblioteka_1.addBook(Ksiazka_3);
        });
    }

    @Test
    void Wypozyczanie_Nieistniejacej_Ksiazki()
    {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");

        Library Biblioteka_1 = new Library();

        Biblioteka_1.addBook(Ksiazka_1);

        assertDoesNotThrow(() -> {
            Biblioteka_1.borrowBook("1788656487505");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Biblioteka_1.borrowBook("4788656487505");
        });
    }

    @Test
    void Zwracanie_Nieistniejacej_Ksiazki()
    {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");

        Library Biblioteka_1 = new Library();

        Biblioteka_1.addBook(Ksiazka_1);

        assertDoesNotThrow(() -> {
            Biblioteka_1.borrowBook("1788656487505");
            Biblioteka_1.returnBook("1788656487505");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Biblioteka_1.returnBook("4788656487505");
        });
    }
}