package Lab7;

import javax.swing.*;
import java.awt.*;

public class Painting extends JFrame {

    private static JFrame frame = new JFrame();
    private static boolean finish_status = false;

    private final JButton start = new JButton("Start");
    private final JButton restart = new JButton("Restart");
    private final JButton exit = new JButton("Exit");

    private static Image firstCarImage = new ImageIcon("src/YellowCar.png").getImage();
    private static Image secondCarImage = new ImageIcon("src/BlueCar.png").getImage();
    private static Image thirdCarImage = new ImageIcon("src/GreenCar.png").getImage();
    private static Image raceTrackImage = new ImageIcon("src/RaceTrack.png").getImage();

    private final JLabel firstCar = new JLabel(new ImageIcon(firstCarImage));
    private final JLabel secondCar = new JLabel(new ImageIcon(secondCarImage));
    private final JLabel thirdCar = new JLabel(new ImageIcon(thirdCarImage));
    private final JLabel raceTrack = new JLabel(new ImageIcon(raceTrackImage));

    public JButton getStart() {
        return start;
    }
    public JButton getRestart() {return restart;}
    public JButton getExit() {return exit;}

    public boolean getFinishStatus() {return finish_status;}
    public void setFinishStatus(boolean status) {this.finish_status = status;}

    Painting(){

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 425);
        frame.setLayout(null);

        start.setBounds(0, 300, 100, 100);
        start.setForeground(Color.BLACK);
        start.setFont(new Font("Calibre", Font.BOLD, 25));
        start.setFocusable(false);

        restart.setBounds(100, 300, 150, 100);
        restart.setForeground(Color.BLACK);
        restart.setFont(new Font("Calibre", Font.BOLD, 25));
        restart.setFocusable(false);

        exit.setBounds(250, 300, 100, 100);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Calibre", Font.BOLD, 25));
        exit.setFocusable(false);

        frame.add(firstCar).setBounds(0,20,50,50);
        frame.add(secondCar).setBounds(0,110,50,50);
        frame.add(thirdCar).setBounds(0,195,50,50);
        frame.add(raceTrack).setBounds(0,0,600,300);
        frame.add(restart);
        frame.add(start);
        frame.add(exit);

    }
    public int repaint(JLabel car, int speed, int count)
    {
        if(count == 0) {
            car = this.firstCar;
            car.setBounds(car.getX() + speed, car.getY(), 50, 50);
            frame.repaint();
        }
        if(count == 1) {
            car = this.secondCar;
            car.setBounds(car.getX() + speed, car.getY(), 50, 50);
            frame.repaint();
        }
        if(count == 2) {
            car = this.thirdCar;
            car.setBounds(car.getX() + speed, car.getY(), 50, 50);
            frame.repaint();
        }
        return car.getX();
    }
    public void paintStartPosition(){
        firstCar.setBounds(0,20,50,50);
        secondCar.setBounds(0,110,50,50);
        thirdCar.setBounds(0,195,50,50);
    }
    public void setColor(int count)
    {
        if(count == 0) {
            frame.getContentPane().setBackground(Color.YELLOW);
        }
        if(count == 1) {
            frame.getContentPane().setBackground(Color.BLUE);
        }
        if(count == 2) {
            frame.getContentPane().setBackground(Color.GREEN);
        }
    }
    public String getColor(int count){

        String color_str = null;

        if(count == 0)
            color_str = "Желтый";
        if(count == 1)
            color_str = "Синий";
        if(count == 2)
            color_str = "Зеленый";

        return color_str;
    }

}
