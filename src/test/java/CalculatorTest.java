import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;
    private final int a = 1;
    private final int b = 3;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add() {
        int result = calc.add(a, b);
        assertEquals(4, result);
    }

    @Test
    void subtract() {
        int result = calc.subtract(a, b);
        assertEquals(-2, result); // 1 - 3 = -2
    }

    @Test
    void multiply() {
        int result = calc.multiply(a, b);
        assertEquals(3, result); // 1 * 3 = 3
    }

    @Test
    void divide() {
        int result = calc.divide(a, b);
        assertEquals(0, result); // 1 / 3 = 0 (int)
    }
}