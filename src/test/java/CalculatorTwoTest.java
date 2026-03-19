import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTwoTest {

    CalculatorTwo calculator = new CalculatorTwo();
    int a = 1;
    int b = 2;

    @Test
    void add() {
        int result = calculator.calculate("add", a, b);
        assertEquals(3, result);
    }

    @Test
    void subtract() {
        int result = calculator.calculate("subtract", a, b);
        assertEquals(-1, result);
    }

    @Test
    void multiply() {
        int result = calculator.calculate("multiply", a, b);
        assertEquals(2, result);
    }
    @Test
    void divide() {
        int result = calculator.calculate("divide", a, b);
        assertEquals(2, result);
    }
}