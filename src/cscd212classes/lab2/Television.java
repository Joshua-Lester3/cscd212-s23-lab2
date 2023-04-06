package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make == null || model == null || make.isEmpty() || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.fourK = (resolution == 2160);
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
    }

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this(make, model, smart, screenSize,resolution);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        String tvString =  (smart) ? "smart tv" : "tv";
        String resString = (fourK) ? "4K resolution" : resolution + " resolution";
        return make + "-" + model + ", " + screenSize + " inch " + tvString + " with " + resString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Television that))
            return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && this.make.equals(that.make) && this.model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return make.hashCode() + model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(final Television another) {
        if (another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        int makeCompare = make.compareTo(another.make);
        if (makeCompare != 0)
            return makeCompare;
        int modelCompare = model.compareTo(another.model);
        if (modelCompare != 0)
            return modelCompare;
        return this.screenSize - another.screenSize;
    }
}
