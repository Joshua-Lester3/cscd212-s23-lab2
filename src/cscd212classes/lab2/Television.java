package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart,
                      final int screenSize, final int resolution) {
        if (make == null || model == null) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        if (make.isEmpty() || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.fourK = (resolution == 2160);
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
    }

    public Television(final String model, final boolean smart,
                      final int screenSize, final int resolution, final String make) {
        this(make, model, smart, screenSize, resolution);
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    @Override
    public String toString() {
        String tvString =  (this.smart) ? "smart tv" : "tv";
        String resString = (this.fourK) ? "4K resolution" : this.resolution + " resolution";
        return this.make + "-" + this.model + ", " + this.screenSize + " inch " + tvString + " with " + resString;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Television that)) {
            return false;
        }
        return this.fourK == that.fourK && this.resolution == that.resolution
                && this.screenSize == that.screenSize && this.smart == that.smart
                && this.make.equals(that.make) && this.model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution
                + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    @Override
    public int compareTo(final Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        int makeCompare = this.make.compareTo(another.make);
        if (makeCompare != 0) {
            return makeCompare;
        }
        int modelCompare = this.model.compareTo(another.model);
        if (modelCompare != 0) {
            return modelCompare;
        }
        return this.screenSize - another.screenSize;
    }
}
