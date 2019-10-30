import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Tests {
    // Expected exception for catching arithmetic exception in constructor with args
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    // Constructor with args
    @Test
    public void testConstructorWithArgs() {
        Rational r = new Rational(1, 2);
        assertEquals("Constructor with args returns wrong numerator", 1, r.getNumerator());
        assertEquals("Constructor with args returns wrong denominator", 2, r.getDenominator());
    }

    @Test
    public void testConstructorWithArgsException() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        Rational r = new Rational(1, 0);
        thrown = ExpectedException.none();
    }

    @Test
    public void testConstructorWithArgsReduce() {
        Rational r = new Rational(5, 10);
        assertEquals("Constructor with args doesn't reduce numerator", 1, r.getNumerator());
        assertEquals("Constructor with args doesn't reduce denominator", 2, r.getDenominator());
    }

    @Test
    public void testSimplifyMinuses() {
        Rational negativeRational = new Rational(1, -2);
        assertEquals("Constructor with args doesn't simplify minuses in numerator", -1, negativeRational.getNumerator());
        assertEquals("Constructor with args doesn't simplify minuses in denominator", 2, negativeRational.getDenominator());
    }

    // ToString
    @Test
    public void testRationalToString() {
        Rational r = new Rational(1, 2);
        assertEquals("\"ToString\"-method returns wrong string", r.toString(), "1/2");
    }

    // Operations
    @Test
    public void testRationalPlus() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational result = r1.plus(r2);
        assertEquals("\"Plus\"-method returns Rational with wrong numerator", 5, result.getNumerator());
        assertEquals("\"Plus\"-method returns Rational with wrong denominator", 6, result.getDenominator());
    }

    @Test
    public void testRationalMinus() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational result = r1.minus(r2);
        assertEquals("\"Minus\"-method returns Rational with wrong numerator", 1, result.getNumerator());
        assertEquals("\"Minus\"-method returns Rational with wrong denominator", 6, result.getDenominator());
    }

    @Test
    public void testMultiply() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational result = r1.multiply(r2);
        assertEquals("\"Multiply\"-method returns Rational with wrong numerator", 1, result.getNumerator());
        assertEquals("\"Multiply\"-method returns Rational with wrong denominator", 6, result.getDenominator());
    }

    @Test
    public void testDivide() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational result = r1.divide(r2);
        assertEquals("\"Divide\"-method returns Rational with wrong numerator", 3, result.getNumerator());
        assertEquals("\"Divide\"-method returns Rational with wrong denominator", 2, result.getDenominator());
    }

    @Test
    public void testDivideWithZeroInDenominatorResult() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        Rational r1 = new Rational();
        Rational r2 = new Rational(1, 2);
        Rational result = r2.divide(r1);
        thrown = ExpectedException.none();
    }

    // Equal
    @Test
    public void testEqualWithEqualArg() {
        Rational r1 = new Rational();
        Rational r2 = new Rational();
        assertTrue("\"Equals\"-method returns False with equal arg", r1.equals(r2));
    }

    @Test
    public void testEqualWithLessArg() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        assertFalse("\"Equals\"-method returns True with less arg", r1.equals(r2));
    }

    @Test
    public void testEqualWithGreaterArg() {
        Rational r1 = new Rational(1, 3);
        Rational r2 = new Rational(1, 2);
        assertFalse("\"Equals\"-method returns True with greater arg", r1.equals(r2));
    }

    // Less
    @Test
    public void testLessWithEqualArg() {
        Rational r1 = new Rational();
        Rational r2 = new Rational();
        assertFalse("\"Less\"-method returns True with equal arg", r1.less(r2));
    }

    @Test
    public void testLessWithLessArg() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        assertFalse("\"Less\"-method returns True with less arg", r1.less(r2));
    }

    @Test
    public void testLessWithGreaterArg() {
        Rational r1 = new Rational(1, 3);
        Rational r2 = new Rational(1, 2);
        assertTrue("\"Less\"-method returns False with greater arg", r1.less(r2));
    }

    // LessOrEqual
    @Test
    public void testLessOrEqualWithEqualArg() {
        Rational r1 = new Rational();
        Rational r2 = new Rational();
        assertTrue("\"LessOrEqual\"-method returns False with equal arg", r1.lessOrEqual(r2));
    }

    @Test
    public void testLessOrEqualWithLessArg() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        assertFalse("\"LessOrEqual\"-method returns True with less arg", r1.lessOrEqual(r2));
    }

    @Test
    public void testLessOrEqualWithGreaterArg() {
        Rational r1 = new Rational(1, 3);
        Rational r2 = new Rational(1, 2);
        assertTrue("\"LessOrEqual\"-method returns False with greaters arg", r1.lessOrEqual(r2));
    }
}