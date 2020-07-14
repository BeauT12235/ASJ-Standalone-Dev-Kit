package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GridLoggerTest {
    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        GridLogger gridLogger = new GridLogger(writer);
        gridLogger.add("RobotX", "2.4");
        gridLogger.add("RobotY", "3.5");
        gridLogger.writeLn();

        List lines = writer.getLines();
        // check the lines
        assertEquals("RobotX,RobotY", lines.get(0));
        assertEquals("2.4,3.5", lines.get(1));
    }

    private class TestWriter implements LogWriter {

        List lines = new ArrayList();

        @Override
        public void writeLine(String line) {
            lines.add(line);
        }

        public List getLines() {
            return lines;
        }
    }
}
