package cscd212comparators.lab2;

import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(final Television t1, final Television t2) {
        int compareModel = t1.getModel().compareTo(t2.getModel());
        if (compareModel == 0) {
            return Integer.compare(t1.getScreenSize(), t2.getScreenSize());
        }
        return compareModel;
    }
}
