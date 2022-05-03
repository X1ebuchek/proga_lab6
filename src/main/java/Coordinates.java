import java.io.Serializable;

public class Coordinates implements Serializable {
    private float x; //Значение поля должно быть больше -536
    private long y;

    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public float getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
