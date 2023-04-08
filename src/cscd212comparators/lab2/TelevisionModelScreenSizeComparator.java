package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(final Television t1, final Television t2) {
        if(t1.getModel().compareTo(t2.getModel()) == 0) {
            return t1.getScreenSize() - t2.getScreenSize();
        }
        return t1.getModel().compareTo(t2.getModel());
    }
}
