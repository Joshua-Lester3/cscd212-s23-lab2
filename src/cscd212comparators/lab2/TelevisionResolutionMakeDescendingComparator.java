package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {
    @Override
    public int compare(final Television t1, final Television t2) {
        int resolutionCompare = (-1) * Integer.compare(t1.getResolution(), t2.getResolution());
        if (resolutionCompare == 0) {
            return (-1) * t1.getMake().compareTo(t2.getMake());
        }
        return resolutionCompare;
    }
}
