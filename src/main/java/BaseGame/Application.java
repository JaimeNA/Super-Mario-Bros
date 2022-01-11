package BaseGame;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

// internal clases

import Tiles.TileMesh;
import FOO.FOO;
import Input.Keyboard;
import Layers.Layer;
import Sprites.Sprite;
import Sprites.SpriteAnimation;

// subclase de Canvas que usa elementos de la interfaz runnablee(similar to thread)
public class Application extends JComponent implements Runnable{ // para no dibujar directo sobre la ventana
    
    //PRIVATE
    
    private final int WIDTH, HEIGHT;
    private static String title;
    private final JFrame frame;
        
    private Thread thread;
    private boolean runing = false;
    
    private Graphics2D graf2D;
    private RenderingHints rh;
    
    private TitleScreen ts;
     
    @Override
    protected void paintComponent(Graphics graf){
       
        super.paintComponent(graf);
        
        render(graf);
        
    }
    
    private void render(Graphics graf){
    
        this.graf2D = (Graphics2D) graf;
        
        ts.render(graf2D);
        
        Toolkit.getDefaultToolkit().sync(); // sincroniza el dibujado en algunos sistemas que usan buffers, como linux
    
    }
    
    private void update(){
    
    }
    
    //PUBLIC
    
    public Application(String title, int w, int h){ // constructor

        this.WIDTH = w;
        this.HEIGHT = h;
        this.title = title;
       
        this.frame = new JFrame();

        Dimension dimensions = new Dimension(WIDTH, HEIGHT);
        
        ts = new TitleScreen(this.WIDTH, this.HEIGHT);
        
        this.setPreferredSize(dimensions);
        
        this.setFocusable(true);
    }
    
    public static void main(String[] args){
    
        Application MarioBros = new Application("Super Mario Bros", 800, 600);// ccreando objeto juego

        //configuración de ventana
        MarioBros.frame.setTitle(title);
        MarioBros.frame.add(MarioBros);
        MarioBros.frame.pack();
        MarioBros.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarioBros.frame.setLocationRelativeTo(null);
        MarioBros.frame.setResizable(false);
        MarioBros.frame.setVisible(true);

        MarioBros.start();
    
    }
    
    public void start(){
    
        runing = true;
        
        this.thread = new Thread(this, "MarioBros");

        this.thread.start(); // initialising the threat

    }
    
    public void stop(){
    
        runing = false;
        
        try{ // try and catch block

            this.thread.join(); // stopping the thread

        } catch(InterruptedException e){

            e.printStackTrace(); // print the errors on the console

        }

    }
    
    @Override // taking this method from other classes
    public void run(){
        
        // clock parameters
        long lastTime = System.nanoTime();
        long now = 0;
        long timer = System.currentTimeMillis();
        final double nanoSecs = 1000000000.0 / 60.0; // 60 updates per second - 1B nanoseconds = 1 seond
        double deltaTime = 0;
        int FPS = 0;

        //MAIN LOOP
        
        while(runing){
                    
            // CLOCK
            now = System.nanoTime();
            deltaTime += (now - lastTime) / nanoSecs;
            lastTime = now;

            while(deltaTime >=1){ // 60 updates per seconds

                update();

                deltaTime--;
                
                this.repaint(); // repaint
                
                FPS++; // frame per second
    
            }

            // show FPS
            if(System.currentTimeMillis() - timer > 1000){

                timer += 1000;
                this.frame.setTitle("Super Mario Bros || FPS: " + FPS); // showing fps on the title

                FPS = 0; // reseting FPS
            }
        }
        
    }
    
}