package Lab7;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Painting frame = new Painting();
        Listener listen = new Listener(frame);

    }
}
