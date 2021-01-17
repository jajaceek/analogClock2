package jajaceek;

import javax.swing.*;

public class Window extends JFrame {
    public static final int width = 600;
    public static final int height = 600;
    public static final String TITLE = "Analog Clock";

    public Window() {
        setSize(width + 6, height + 29);
        setTitle(TITLE);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
