package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;

        if(resolution == 2160) {
            fourK = true;
        }
        else fourK = false;
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        this(model, smart, screenSize, resolution, make);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getResolution(){
        return resolution;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        if(fourK == true) {
            if(smart == true) {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with 4K resolution";
            }
            else {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with 4K resolution";
            }
        }
        else {
            if(smart == true) {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";
            }
            else {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || !(o instanceof Television that)) {
            return false;
        }
        return this.fourK == that.fourK && this.smart == that.smart && this.resolution == that.resolution && this.screenSize == that.screenSize
                && Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    //Write
    @Override
    public int compareTo(Television another) {
        if(another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        if(this.make.compareTo(another.make) == 0) {
            if(this.model.compareTo(another.model) == 0) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }
}