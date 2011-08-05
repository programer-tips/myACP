package org.codeexample.maxNumber;

import static org.junit.Assert.assertEquals;
import org.codeexample.common.OverflowException;
import org.codeexample.common.Utils;
import org.junit.Test;

public class MaxNumberTester
{
    // ############## Main test cases for MaxNumber
    @Test
    public void testMaxNumber()
    {
        assertEquals(89887, MaxNumber.maxNumber(new int[] { 8, 87, 89 }));
        assertEquals(89887, MaxNumber.maxNumber(new int[] { 89, 87, 8 }));
        assertEquals(89887, MaxNumber.maxNumber(new int[] { 87, 8, 89 }));

        // assertEquals(89887, MaxNumber.maxNumber(Utils.toList(new int[] {87, 8, 89 })));
        // assertEquals(89887, MaxNumber.maxNumber(Utils.toList(new int[] {87, 8, 89 })));

        // ########## boundary cases
        assertEquals(0, MaxNumber.maxNumber(new int[] { 0, 0, 0 }));
        assertEquals(100, MaxNumber.maxNumber(new int[] { 0, 0, 1 }));

        // Generate the max value nteger.MAX_VALUE - 2147483647 by 2, 147483647
        assertEquals(Integer.MAX_VALUE, MaxNumber.maxNumber(new int[] { 147483647, 2 }));

    }

    @Test(expected = OverflowException.class)
    public void maxOverflow1()
    {
        // 7, 214748364, this would throw overflow(7-214748364)
        MaxNumber.maxNumber(new int[] { Integer.MAX_VALUE / 10, Integer.MAX_VALUE % 10 });
    }

    @Test(expected = OverflowException.class)
    public void maxOverflow2()
    {
        MaxNumber.maxNumber(new int[] { 1, Integer.MAX_VALUE });
    }

    // @Test(expected = IllegalArgumentException.class)
    public void hasNegative()
    {
        MaxNumber.maxNumber(new int[] { 1, 2, 3, -1 });
    }

    // ############## The following methods would test MyComparator class
    // @Test
    public void testMyComparator()
    {
        MyComparator comparator = new MyComparator();
        assertEquals(0, comparator.compare(8, 8));
        assertEquals(0, comparator.compare(8, 88));
        assertEquals(0, comparator.compare(8, 888));

        assertEquals(1, comparator.compare(8, 87));
        assertEquals(-1, comparator.compare(8, 89));

        assertEquals(0, comparator.compare(88, 88));
        assertEquals(0, comparator.compare(88, 888));

        assertEquals(1, comparator.compare(88, 887));
        assertEquals(-1, comparator.compare(88, 889));
    }

    // ############## The following methods would test Utils class
    @Test
    public void testGetNumberOfDigits()
    {
        assertEquals(1, Utils.getNumberOfDigits(1));
        assertEquals(2, Utils.getNumberOfDigits(11));
        assertEquals(3, Utils.getNumberOfDigits(111));

        assertEquals(1, Utils.getNumberOfDigits(9));
        assertEquals(2, Utils.getNumberOfDigits(99));
        assertEquals(3, Utils.getNumberOfDigits(999));

        assertEquals(1, Utils.getNumberOfDigits(-1));
        assertEquals(2, Utils.getNumberOfDigits(-11));
        assertEquals(3, Utils.getNumberOfDigits(-111));

        assertEquals(1, Utils.getNumberOfDigits(0));
    }

    @Test
    public void testRightPadNumber()
    {
        assertEquals(1, Utils.rightPadNumber(1, 1));
        assertEquals(11, Utils.rightPadNumber(1, 2));
        assertEquals(111, Utils.rightPadNumber(1, 3));

        assertEquals(9, Utils.rightPadNumber(9, 1));
        assertEquals(99, Utils.rightPadNumber(9, 2));
        assertEquals(999, Utils.rightPadNumber(9, 3));

        assertEquals(0, Utils.rightPadNumber(0, 1));
        assertEquals(0, Utils.rightPadNumber(0, 2));

        assertEquals(123, Utils.rightPadNumber(123, 3));
        assertEquals(1233, Utils.rightPadNumber(123, 4));
        assertEquals(12333, Utils.rightPadNumber(123, 5));

        assertEquals(-1, Utils.rightPadNumber(-1, 1));
        assertEquals(-11, Utils.rightPadNumber(-1, 2));
        assertEquals(-111, Utils.rightPadNumber(-1, 3));
    }
}
