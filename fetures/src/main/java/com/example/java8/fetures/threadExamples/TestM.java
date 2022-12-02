package com.example.java8.fetures.threadExamples;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class TestM implements Runnable {

    private int delay;

    public TestM(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        int cont=2;
        int maxx = 1000;
        int minx = 100;
        int maxy = 600;
        int miny = 200;
        boolean loopp = true;


        while (loopp) {
            double x = new Random().nextInt(maxx - minx + 1) + minx;// MouseInfo.getPointerInfo().getLocation().getX();
            double y = new Random().nextInt(maxy - miny + 1) + miny;//MouseInfo.getPointerInfo().getLocation().getY();

            try {
                Robot r = new Robot();
                r.mouseMove(  (int)x, (int)y);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                //System.out.println("x=" + x + " y=" + y);
                Thread.sleep(delay);
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cont++;
            System.out.println(".." + cont);
            if (cont==1440) {
                loopp=false;
            }
            //x = isPar(cont) ? x+10 : x-10;
           // cont++;
           // System.out.println("x=" + x);
        }
    }

    private boolean isPar(int value) {
        return  (value%2==0) ? true : false;
    }
}
