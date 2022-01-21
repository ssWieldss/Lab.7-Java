package Lab7;

import javax.swing.*;


class RacersMoving extends Thread {

    public static Painting frame;
    public JLabel racer = new JLabel();
    public int speed = 0;
    public int count;
    public boolean finish_status = false;

    RacersMoving(JLabel racer, int speed, int count) {
        this.racer = racer;
        this.speed = speed;
        this.count = count;
    }

    public int repaint() throws InterruptedException{
        int x;
        x = frame.repaint(racer, speed, count);
        if(x>500) {
            frame.setColor(count);
            frame.setFinishStatus(true);
            JOptionPane.showMessageDialog(null, "Победил "+ frame.getColor(count) + " гонщик!",
                    "Winner!", JOptionPane.WARNING_MESSAGE);
        }
        return x;

    }

    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(500);
                int x = 0;
                        while(!frame.getFinishStatus()) {
                        x = repaint();
                            Thread.sleep(500);
                }
                        System.out.println("Closed Thread");
            } catch (InterruptedException ignored) {
            }

        }
    }
}
