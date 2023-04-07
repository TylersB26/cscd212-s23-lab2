package cscd212classes.lab2;

public class Television implements Comparable<Television>{

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Bad paramater Television constructor");
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
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if(resolution == 2160) {
            fourK = true;
        }
        else fourK = false;
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
        return make + " " + model;
    }


    @Override
    public int compareTo(Television o) {
        return 0;
    }
}
