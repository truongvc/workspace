package p4;

/*************************************************************************
 *  Compilation:  javac Turtle.java
 *  Execution:    java Turtle
 *
 *  Singleton Turtle graphics.
 *
 *************************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

// for images and audio
import java.net.URLConnection;
import java.net.URL;

// for audio files only
import java.applet.Applet;
import java.applet.AudioClip;

// Support for saving the canvas to a file
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

public class Turtle extends JFrame {
     static private Turtle turtle;

     static private Image offscreenImage;        // double buffered image
     static private Graphics2D offscreen;

     static private double x = 0.0, y = 0.0;     // turtle is at coordinate (x, y)
     static private double orientation = 0.0;    // facing this many degrees counterclockwise
     static private Insets insets;               // border around JFrame that we shouldn't use
     static private int width, height;           // size of drawing area in pixels
     static private Color bg;                    // background color

     // singleton class - user is not allowed to create new ones 
//     private Turtle() { }
     Turtle() { }

    // create a canvas with drawing area width-by-height
    static public void create(int width, int height) {

        // If we don't already have a JFrame, open up a new one
        if (turtle == null) {
            turtle = new Turtle();
            Turtle.width = width;
            Turtle.height = height;
            turtle.setSize(new Dimension(width, height));
            turtle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            turtle.setTitle("Turtle Graphics");
            turtle.setResizable(false);
            turtle.setVisible(true);          // let us see the frame

            // re-adjust the size of the frame so that we don't lose space for insets
            insets = turtle.getInsets();
            turtle.setSize(new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom)); System.out.println(width  + " x " + height);

            // Initialize the picture
            init();
        }
    }

    static private void init() {
        // create double buffered image and graphics handle
        offscreenImage = turtle.createImage(width, height);
        offscreen = (Graphics2D) offscreenImage.getGraphics();

        // rescale and translate so that (0, 0) is lower left
        offscreen.translate(0, height);
        offscreen.scale(1.0, -1.0);

        // clear the screen
        clear(Color.white);
    }

    // close the window
    public static void done() {
        turtle.dispose();
        turtle = null;
    }


    // clear the background
    public static void clear() {
        Color fg = offscreen.getColor();
        offscreen.setColor(bg);
        offscreen.fillRect(0, 0, width, height);    // should this be width - 1, height - 1 ?
        offscreen.setColor(fg);
    }

    // clear the background with a new color
    public static void clear(Color bg) {
        Turtle.bg = bg;
        clear();
    }

    // wait for a short while
    public static void pause(int delay) {
        try { Thread.currentThread().sleep(delay); }
        catch (InterruptedException e) { }
    }

    // change the color of the paint
    public static void setColor(Color color) { offscreen.setColor(color); }

    public static void fly(double x, double y) {
        Turtle.x = x;
        Turtle.y = y;
    }

    public static void go(double x, double y) {
        offscreen.draw(new Line2D.Double(Turtle.x, Turtle.y, x, y));
        Turtle.x = x;
        Turtle.y = y;
    }

    public static void spot(double size) {
        offscreen.fill(new Rectangle2D.Double(x - size/2, y - size/2, size, size));
    }

    // circle of radius = size
    // public static void spot(double size) {
    //    offscreen.fill(new Ellipse2D.Double(x - size, y - size, 2*size, 2*size));
    // }


    // draw spot using gif - fix to be centered at (x, y)
    public static void spot(String s) {
        //  needed to load from jar
        URL url = Turtle.class.getResource(s); 
        Image image = Toolkit.getDefaultToolkit().getImage(url); 

        // Image image = Toolkit.getDefaultToolkit().getImage(s);

        offscreen.scale(1.0, -1.0);
        offscreen.translate(0, -height);

        offscreen.drawImage(image, (int) x - image.getWidth(null)  / 2,
                                   (int) y - image.getHeight(null) / 2, null);
        offscreen.translate(0, height);
        offscreen.scale(1.0, -1.0);
/*
        offscreen.drawImage(image, (int) x, (int) y ,
                                   (int) x + image.getWidth(null), (int) y -image.getHeight(null),
                                   0, 0, image.getWidth(null), image.getHeight(null), null);
  */
    }


    public static void pixel(int x, int y) {
        offscreen.drawRect(x, y, 1, 1);
    }

    // rotate counterclockwise in degrees
    public static void rotate(double angle) {
        orientation += angle;
    }

    public static void forward(double d) {
        double oldx = x;
        double oldy = y;
        x += d * Math.cos(Math.toRadians(orientation));
        y += d * Math.sin(Math.toRadians(orientation));
        offscreen.draw(new Line2D.Double(x, y, oldx, oldy));
    }

    public static void grunt(String s) {
        URL url = Turtle.class.getResource(s); 
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    }

    public void paint(Graphics g) {
        if (g != null && offscreenImage != null)
            g.drawImage(offscreenImage, insets.left, insets.top, this);
    }

    public static void render() { turtle.repaint(); }

    public static void save(String s) {
        BufferedImage bi = (BufferedImage) offscreenImage;
        System.out.println("Saving to " + s);
        try {
            File f = new File(s);
            ImageIO.write(bi, "png", f);
        }
        catch (IOException e) {
            System.out.println("Unable to write to file " + s);
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
  		// TODO Auto-generated method stub
  		
  		Turtle t = new Turtle();
  		t.create(500,500);
  		t.setColor(Color.red);
  		t.fly(t.width/2,t.height/2);
  		t.forward(100);
  		t.rotate(90);
  		t.forward(100);
  		t.rotate(90);
  		t.forward(100);
  		t.rotate(90);
  		t.forward(100);
  		t.rotate(90);
  		t.forward(100);
  		
  		
  		t.render();


  	}

}