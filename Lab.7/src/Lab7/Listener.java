package Lab7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    private Painting frame;
    public Listener(Painting new_frame){
        this.frame = new_frame;
        frame.getStart().addActionListener(this);
        frame.getRestart().addActionListener(this);
        frame.getExit().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.getStart())
        {
            RacersMoving.frame = frame;

            RacersMoving racer1 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 0);
            RacersMoving racer2 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 1);
            RacersMoving racer3 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 2);

            racer1.start();
            racer2.start();
            racer3.start();
        }
        if(e.getSource() == frame.getRestart())
        {
            frame.setFinishStatus(true);
            frame.paintStartPosition();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            RacersMoving racer1 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 0);
            RacersMoving racer2 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 1);
            RacersMoving racer3 = new RacersMoving(new JLabel(), (int) ((Math.random()*((100-15)+1))+15), 2);

            frame.setFinishStatus(false);
            racer1.start();
            racer2.start();
            racer3.start();
        }
        if(e.getSource() == frame.getExit()){
            System.exit(0);
        }
    }
}
