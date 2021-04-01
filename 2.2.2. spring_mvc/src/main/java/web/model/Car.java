package web.model;

public class Car {
    private String model;
    private int series;
    private int release;

    public Car(String model, int series, int release) {
        this.model = model;
        this.series = series;
        this.release = release;
    }

    @Override
    public String toString() {
        return new StringBuilder(model)
                .append(" ")
                .append(series)
                .append(", ")
                .append(release)
                .append(" release")
                .toString();
    }
}
