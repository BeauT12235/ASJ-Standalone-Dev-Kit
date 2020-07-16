package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GridLoggerTest {
    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        TestClock clock = new TestClock();
        GridLogger gridLogger = new GridLogger(writer, clock);
        gridLogger.add("RobotX", "2.4");
        gridLogger.add("RobotY", "3.5");
        clock.setCurrentTimeMillis(12);
        gridLogger.writeLn();

        List lines = writer.getLines();
        // check the lines
        assertEquals("Time,RobotX,RobotY", lines.get(0));
        assertEquals("12,2.4,3.5", lines.get(1));
    }
    private class TestClock implements Clock{
        long currentTimeMillis;

        boolean resetCalled = false;

        @Override
        public long getCurrentTimeMillis() {
            return currentTimeMillis;
        }

        @Override
        public void reset() {
        resetCalled = true;
        }

        public void setCurrentTimeMillis(long time){
            currentTimeMillis = time;
        }
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
