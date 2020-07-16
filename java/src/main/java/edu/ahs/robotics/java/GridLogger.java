package edu.ahs.robotics.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GridLogger {


    private boolean firstRow = true;

    private HashSet<String> categorySet;
    private ArrayList<String> categories = new ArrayList<>();
    private HashMap<String, String> rowValues;

    private LogWriter writer;
    private Clock clock;


    public GridLogger(LogWriter writer, Clock clock) {
        this.writer = writer;
        this.clock = clock;
        clock.reset();
        categorySet = new HashSet<>();
        rowValues = new HashMap<>();
        categories.add("Time");

    }

    /**
     * Add a value to the logger under the category.  Categories are lazily added to the logger
     * in the order encountered.
     *
     * @param category
     * @param value
     */
    public void add(String category, String value) {
        if (firstRow&&!categorySet.contains(category)) {
            //We are adding the category to the HashSet and ArrayList.
            categories.add(category);
            categorySet.add(category);

        }
        rowValues.put(category, value);
    }

    /**
     * Write a line of data to the log.  If this is the first call to writeLn, categories are
     * written first, followed by the line of data.  Once the data is written, the logger is reset
     * and calls to add() will add values to the next line of data.
     */
    public void writeLn() {
        if (firstRow) {
            StringBuffer header = new StringBuffer();
            for (int i = 0; i < categories.size(); i++) {
                header.append(categories.get(i));
                if (i < categories.size() - 1) {
                    header.append(",");
                }
            }
            writer.writeLine(header.toString());
            firstRow = false;
        }
        //Update the time

        rowValues.put("Time",Long.toString(clock.getCurrentTimeMillis()));
        StringBuffer valueRow = new StringBuffer();
        for (int i = 0; i < categories.size(); i++) {
            String category = categories.get(i);
            String value = rowValues.get(category);
            if (value!=null){
                valueRow.append(value);
            }
            if (i < categories.size() - 1) {
                valueRow.append(",");
            }
        }
        writer.writeLine(valueRow.toString());
        rowValues.clear();
    }

    public void stop() {
    }
}




