package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class ArrayUtilitiesTest {

    @Test
    public void searchArray() {

        ArrayList<String> list = new ArrayList();
        list.add("hello");
        list.add("welcome");
        list.add("hi");
        String searchingString = "hi";

        assertTrue(ArrayUtilities.searchArray(searchingString, list));

    }

    @Test
    public void maxValue() {
        ArrayList<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(5);
        integers.add(15);
        integers.add(-23);
        assertEquals(15, ArrayUtilities.maxValue(integers),.00001);
    }

    @Test
    public void lowerNumbers() {
        ArrayList<Integer> integers = new ArrayList();
        integers.add(8);
        integers.add(5);
        integers.add(-7);
        integers.add(52);
        integers.add(3);
        ArrayList<Integer> lowerArrayList = ArrayUtilities.lowerNumbers(integers, 6);


        Integer[] results = lowerArrayList.toArray(new Integer[0]);
        Integer[] expected = {5, -7, 3};
        assertArrayEquals(expected, results);
    }
}