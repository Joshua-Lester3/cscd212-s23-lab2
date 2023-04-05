package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {
    public int compare(final Television t1, final Television t2) {
        return Integer.compare(t1.getScreenSize(), t2.getScreenSize());
    }
}
