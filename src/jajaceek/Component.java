package jajaceek;

import java.applet.Applet;
import java.awt.*;


public class Component extends Applet implements Runnable {

    private static boolean isRunning;

    public static Graphics g;
    public static Image screen;

    public static Window w = new Window();

    public static void main(String[] args) {
        Component component = new Component();
        w.add(component);

        component.init();
    }

    public void init() {
        isRunning = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (isRunning) {
            tick();
            render(g);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        screen = createImage(Window.width, Window.height);
        g = screen.getGraphics();

        // tło

        g.setColor(Color.white);
        g.fillRect(0, 0, Window.width, Window.height);
        g.setColor(Color.black);
        g.fillOval(25, 25, 550, 550);
        g.setColor(Color.white);
        g.fillOval(50, 50, 500, 500);

        // ustawienia godzin

        int size = Window.width;
        int center = size / 2;
        int time;
        int anim, anim2;
        int radius = size - 120;

        // wskazówka sekund

        time = (int) System.currentTimeMillis();

        radius += 10;


        time = (int) ((time + 14000) % 60000 / 60000.0 * Math.PI * 2);
        System.out.println(time);
        anim = (int) (center - (Math.sin(time)) * radius / 2);
        anim2 = (int) (center + (Math.cos(time)) * radius / 2);

        g.setColor(Color.red);
        g.drawLine(center, center, anim, anim2);
        g.drawLine(center + 1, center, anim + 1, anim2);
        g.drawLine(center, center + 1, anim, anim2 + 1);
        g.drawLine(center - 1, center, anim - 1, anim2);
        g.drawLine(center, center - 1, anim, anim2 - 1);

        // linie
        g.setColor(Color.black);
        for (int i = 0; i < 60; i++) {
            int a1, a2, a3, a4;
            radius = size - 100;
            a1 = (int) ((center) + Math.sin(i / 60.0 * Math.PI * 2) * radius / 2);
            a2 = (int) ((center) - Math.cos(i / 60.0 * Math.PI * 2) * radius / 2);
            radius = size - 140;
            a3 = (int) ((center) + Math.sin(i / 60.0 * Math.PI * 2) * radius / 2);
            a4 = (int) ((center) - Math.cos(i / 60.0 * Math.PI * 2) * radius / 2);

            g.drawLine(a1, a2, a3, a4);
            if (i % 5 == 0) {
                g.drawLine(a1 + 1, a2, a3 + 1, a4);
                g.drawLine(a1, a2 + 1, a3, a4 + 1);
                g.drawLine(a1 - 1, a2, a3 - 1, a4);
                g.drawLine(a1, a2 - 1, a3, a4 - 1);
            }
        }
        g.setFont(new Font("arial", 1, 30));
        for (int i = 0; i < 12; i++) {
            int a1, a2;
            radius = size - 180;
            a1 = (int) ((center) + Math.sin(i / 12.0 * Math.PI * 2) * radius / 2);
            a2 = (int) ((center) - Math.cos(i / 12.0 * Math.PI * 2) * radius / 2);

            if (i > 5) {
                g.drawString((i ) + "", a1 - 10, a2 + 5);
            } else {
                g.drawString((i ) + "", a1, a2 + 5);
            }
        }


        // wskazówka minut

        time = (int) System.currentTimeMillis();

        time = (int) ((time + 14000 + 360000) % 3600000 / 3600000.0 * Math.PI * 2);
        anim = (int) (center + (Math.sin(time)) * radius / 2);
        anim2 = (int) (center - (Math.cos(time)) * radius / 2);

        g.setColor(Color.black);
        g.drawLine(center, center, anim, anim2);
        g.drawLine(center + 1, center, anim + 1, anim2);
        g.drawLine(center, center + 1, anim, anim2 + 1);
        g.drawLine(center - 1, center, anim - 1, anim2);
        g.drawLine(center, center - 1, anim, anim2 - 1);

        // wskazówka godzin

        time = (int) System.currentTimeMillis();
        radius -= 200;

        time = (int) ((time + 14000 + 360000) % 43200000 / 43200000.0 * Math.PI * 2);
        anim = (int) (center + (Math.sin(time)) * radius / 2);
        anim2 = (int) (center - (Math.cos(time)) * radius / 2);

        g.setColor(Color.black);
        g.drawLine(center, center, anim, anim2);
        g.drawLine(center + 1, center, anim + 1, anim2);
        g.drawLine(center, center + 1, anim, anim2 + 1);
        g.drawLine(center - 1, center, anim - 1, anim2);
        g.drawLine(center, center - 1, anim, anim2 - 1);

        g.drawLine(center + 2, center + 2, anim + 2, anim2 + 2);
        g.drawLine(center - 2, center + 2, anim - 2, anim2 + 2);
        g.drawLine(center + 2, center - 2, anim + 2, anim2 - 2);
        g.drawLine(center - 2, center - 2, anim - 2, anim2 - 2);
        g.fillOval(anim - 3, anim2 - 3, 6, 6);
        g.fillOval(center - 5, center - 5, 14, 14);

        g = this.getGraphics();
        g.drawImage(screen, 0, 0, null);
    }


}
