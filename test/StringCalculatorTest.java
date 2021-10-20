import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
/*If the string starts with E, only even numbers should be added, if it starts with O, only odd numbers should be added
Input:“E1,2,3” Output: 2
Input: “O1,2,3” Output: 4*/

public class StringCalculatorTest {

    private StringCalculator calculator;	

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturn0() {
        assertEquals(calculator.add(""), 0);
    }

    @Test
    public void numberStringShouldReturnSameNumber() {
        assertEquals(calculator.add("1"), 1);
        assertEquals(calculator.add("5"), 5);
    }

    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        assertEquals(calculator.add("1,2"), 3);
        assertEquals(25, calculator.add("10,15"));
    }

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(calculator.add("1\n2"), 3);
        assertEquals(calculator.add("11\n13"), 24);
    }

    @Test
    public void threeNumbersDelimitedAnywayShouldBeSummed() {
        assertEquals(calculator.add("1,2,3"), 6);
        assertEquals(calculator.add("5\n2\n3"), 10);
    }

    @Test
    public void negativeInputReturnsException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        calculator.add("-1");
        calculator.add("-5,10\n-15");
    }

    
    @Test
    public void numbersGreaterThan1000AreIgnored() {
        assertEquals(calculator.add("5,12,1001"), 17);
        assertEquals(calculator.add("14124,22\n4,1214"), 26);
    }
    @Test
    public void numberStrartsWithEAndOReturnEventNumberNumber() {
        assertEquals(calculator.add("E1,2,3"), 2);
        assertEquals(calculator.add("O1,2,3"), 4);
    }
}
