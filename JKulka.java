public class JKulka {
    private int x;
    private int y;
    private float Vx;
    private float Vy;
    private float mass;
    private int radius;

    JKulka(int x, int y, int r, float Vx, float Vy) {
        this.x = x;
        this.y = y;
        this.Vx = Vx;
        this.Vy = Vy;
        radius = r;

        this.mass = radius / 3;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVx() {
        return Vx;
    }

    public void setVx(float vx) {
        Vx = vx;
    }

    public float getVy() {
        return Vy;
    }

    public void setVy(float vy) {
        Vy = vy;
    }

    public int getRadius() {
        return radius;
    }

    public float getMass() {
        return mass;
    }
}
