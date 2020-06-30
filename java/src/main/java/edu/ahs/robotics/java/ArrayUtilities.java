package edu.ahs.robotics.java;

import java.util.ArrayList;

public class ArrayUtilities {

    public static boolean searchArray(String string, ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (string == list.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static Integer maxValue(ArrayList<Integer> integers) {
        int max = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) > max) {
                max = integers.get(i);


            }
        }


        return max;
    }

    /**
     * @param integers The list of numbers to search
     * @param highNumberAllowed A limit value
     * @return an ArrayList containing all numbers lower than the specified limit value
     */
    public static ArrayList<Integer> lowerNumbers(ArrayList<Integer> integers, int highNumberAllowed) {
        int temp = 0;
        ArrayList<Integer> lowerArrayList= new ArrayList<Integer>();
        for (int i = 0; i < integers.size(); i++) {
            if(integers.get(i)<highNumberAllowed){

                lowerArrayList.add(integers.get(i));
            }
        }

        return lowerArrayList;
    }


}