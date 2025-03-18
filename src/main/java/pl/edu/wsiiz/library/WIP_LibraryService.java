package pl.edu.wsiiz.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class WIP_LibraryService {
    @Test
    public void Testy_Stanu_i_Zachowania()
    {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");
        Book Ksiazka_2 = new Book("WIP_2a", "WIP_2b", "2788656487505");
        Book Ksiazka_3 = new Book("WIP_3c", "WIP_3c", "3788656487505");

        Library Biblioteka_1 = new Library();
        LibraryService Biblioteka_Service_1 = new LibraryService(Biblioteka_1);

        assertDoesNotThrow(() -> {
            Biblioteka_1.addBook(Ksiazka_1);
            Biblioteka_1.addBook(Ksiazka_2);
            Biblioteka_1.addBook(Ksiazka_3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Biblioteka_1.addBook(Ksiazka_1);
        });
    }

    @Test
    void Testy_Powiadomien()
    {
        Book Ksiazka_1 = new Book("WIP_1a", "WIP_1b", "1788656487505");
        Book Ksiazka_2 = new Book("WIP_2a", "WIP_2b", "2788656487505");
        Book Ksiazka_3 = new Book("WIP_3c", "WIP_3c", "3788656487505");

        Library Biblioteka_1 = new Library();
        LibraryService Biblioteka_Service_1 = new LibraryService(Biblioteka_1);

        assertDoesNotThrow(() -> {
            Biblioteka_1.addBook(Ksiazka_1);
            Biblioteka_1.addBook(Ksiazka_2);
            Biblioteka_1.addBook(Ksiazka_3);
        });

        assertDoesNotThrow(() -> {
            System.out.println(Biblioteka_Service_1.borrowBookWithConfirmation("1788656487505"));
            System.out.println(Biblioteka_Service_1.borrowBookWithConfirmation("1788656487505"));
            System.out.println(Biblioteka_Service_1.borrowBookWithConfirmation("4788656487505"));
        });

        assertDoesNotThrow(() -> {
            Biblioteka_Service_1.notifyAboutOverdue("1788656487505");
            Biblioteka_Service_1.notifyAboutOverdue("1788656487505");
            Biblioteka_Service_1.notifyAboutOverdue("5788656487505"); // Książka o takim ISBN nie istnieje więc println nie wykonuje się
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "abc", "01230456789", ""})
    void Testy_Parametrowane(String ISBN)
    {
        Library Biblioteka_1 = new Library();
        LibraryService Biblioteka_Service_1 = new LibraryService(Biblioteka_1);

        assertThrows(IllegalArgumentException.class, () -> {
            Biblioteka_1.addBook(new Book("WIP_Tytuł", "WIP_Autor", ISBN));
        });

    }
}