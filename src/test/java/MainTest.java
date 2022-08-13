import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void calc() throws Exception {
        assertEquals("3", Main.calc("1 + 2"));
        assertEquals("2", Main.calc("5 / 2")); // Результатом операции деления является целое число, остаток отбрасывается.
        assertEquals("II", Main.calc("VI / III"));
        assertThrows(Exception.class, () -> Main.calc("I - II"));
        assertThrows(Exception.class, () -> Main.calc("I + 1"));
        assertThrows(Exception.class, () -> Main.calc("1"));
        assertThrows(Exception.class, () -> Main.calc("1 + 2 + 3"));
    }
}