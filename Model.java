import java.util.ArrayList;
import java.util.Observable;

import static java.lang.Thread.sleep;

public class Model extends Observable implements Runnable {

    private ArrayList<JKulka> kulkasArray = new ArrayList<>();

    private float deltaT;

    Model(float dt) {
        deltaT = dt;
    }

    public void createKulka(int x, int y, int r, float Vx, float Vy) {
        kulkasArray.add(new JKulka(x, y, r, Vx, Vy));
    }

    private boolean checkCircleColide(JKulka k1, JKulka k2) {

        int dx = (k1.getX() - k2.getX());
        int dy = (k1.getY() - k2.getY());

        double distSquare = (dx * dx) + (dy * dy);
        return (distSquare < (k1.getRadius() * k2.getRadius()));
    }


    private void calculateCollisions() {
        for (JKulka k1 : kulkasArray) {

            for (JKulka k2 : kulkasArray) {

                if (!k1.equals(k2)) {
                    if (checkCircleColide(k1, k2)) {

//                    int collisionPointX = ((k1.getX() * k2.getRadius()) + (k2.getX() * k1.getRadius())) / (k1.getRadius() + k2.getRadius());
//                    int collisionPointY = ((k1.getY() * k2.getRadius()) + (k2.getY() * k1.getRadius())) / (k1.getRadius() + k2.getRadius());

                        float newVelX1 = k2.getVx();
                        float newVelY1 = k2.getVx();
                        float newVelX2 = k1.getVx();
                        float newVelY2 = k1.getVx();

//                        float newVelX1 = (k1.getVx() * (k1.getMass() - k2.getMass())+(2 * k2.getMass() * k2.getVx())) / (k1.getMass() + k2.getMass());
//                        float newVelY1 = (k1.getVx() * (k1.getMass() - k2.getMass())+(2 * k2.getMass() * k2.getVx())) / (k1.getMass() + k2.getMass());
//                        float newVelX2 = (k2.getVx() * (k2.getMass() - k1.getMass())+(2 * k1.getMass() * k1.getVx())) / (k1.getMass() + k2.getMass());
//                        float newVelY2 = (k2.getVx() * (k2.getMass() - k1.getMass())+(2 * k1.getMass() * k1.getVx())) / (k1.getMass() + k2.getMass());

                        k1.setVx(newVelX1);
                        k1.setVy(newVelY1);
                        k2.setVx(newVelX2);
                        k2.setVy(newVelY2);
                    }
                }
            }
        }
    }

    private void calculateKulkaPos() {

        for (JKulka k1 : kulkasArray) {

            int x = (int) (k1.getX() + k1.getVx() * deltaT);
            int y = (int) (k1.getY() + k1.getVy() * deltaT);


            if (x < 0 || x > (400 - k1.getRadius())){
                k1.setVx(-k1.getVx());
            }

            if (y < 0 || y > (300 - k1.getRadius()))
                k1.setVy(-k1.getVy());

            k1.setX(k1.getX() + (int)(k1.getVx() * deltaT));
            k1.setY(k1.getY() + (int)(k1.getVy() * deltaT));
        }
    }

    @Override
    public void run() {
        while (true) {


            calculateKulkaPos();
            //calculateCollisions();

            setChanged();
            notifyObservers(kulkasArray);

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}