import javax.swing.*;

public class Main {
    JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main app = new Main();
                app.createGUI();
                app.frame.setVisible(true);
            }
        });
    }

    private void createGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Model model = new Model(1f);
//        model.createKulka(150,150, 10,1 , 1);
//        model.createKulka(100,100, 5,2 , -1);
//        model.createKulka(50,50,12,-3,2);

        for (int i = 0; i < 5; i++) {

//            int radius = (int)(Math.random() * 10 + 5);
            int radius = 20;
            int x = (int) (Math.random() * (400 - ((radius + 1) * 2)) + radius + 1);
            int y = (int) (Math.random() * (300 - ((radius + 1) * 2)) + radius + 1);
            float vx = (float) (Math.random() * 12 - 6);
            float vy = (float) (Math.random() * 12 - 6);

            model.createKulka(x, y, radius, vx, vy);
        }

        JTable table = new JTable();
        model.addObserver(table);

        Thread modelThread = new Thread(model);
        modelThread.start();

        frame.add(table);
        frame.pack();
    }
}