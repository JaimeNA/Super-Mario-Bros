package Stages;

import java.awt.Color;

import Layers.Layer;
import Sprites.Sprite;
import Tiles.Text;
import FOO.Mario;
import Input.Keyboard;
import Tiles.TileMesh;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stage1 {

    //PRIVATE
    
    private Layer background, foreground;
    private int lives, time, count;
    private Keyboard input;
    private Mario mario;
    
    //PUBLIC
    
    public Stage1(Layer b, Layer f, Keyboard k){
        
        this.background = b;
        this.foreground = f;
        this.input = k;
        
        // default values
        
        this.lives = 3;
        
        // reseting the layers
        
        this.background.reset();
        this.foreground.reset();
    
        // initial screen
        
        this.background.setBackgroundColor(new Color(0, 0, 0));
        Text txt = new Text("WORLD 1 1", 300, 250);
        this.foreground.addText(txt);
        
        Mario mario = new Mario(320, 300); // mario
        mario.setState(0);
        this.foreground.addFOO(mario);
        
        txt = new Text("x  " + lives, 375, 335);
        this.foreground.addText(txt);

    }
    
    public void update(){
            
        count++;
        
        if(count >= 60){ // every second
        
            time--;
        
            count = 0; // reset the count
            
        }
        
        this.mario.update();
        
        // keyboard input
        
        if(input.key[39]){
        
            this.mario.foward();
        
        }else if(input.key[37]){
        
            this.mario.backward();
        
        }else if(input.key[32]){
        
            this.mario.jump();
        
        }else{
        
            mario.setState(0);
        
        }
        
        //EXPERIMENTAL
        
        for(int i = 0; i<this.foreground.getHitboxes().size();i++){
        
            if(this.mario.checkYCollision(this.foreground.getHitboxes().get(i)) && mario.velY > 0){
        
                mario.velY -= mario.velY;
        
            }
        }
    }
    
    public int getTime(){
    
        return this.time;
    
    }
    
    public void loadLevel(){
    
        try {
            TimeUnit.SECONDS.sleep(2); // 2 second delay
        } catch (InterruptedException ex) {
            Logger.getLogger(Stage1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // level loading

        Sprite tilesSheet = new Sprite("tiles.png", 40); // all the sprites
        Sprite itemsSheet = new Sprite("items.png", 40); 
        
        TileMesh floor = new TileMesh(0, 520, 800, 80, true);
        floor.setSprite(tilesSheet, 0, 0); // getting the floor sprite
     
        mario = new Mario(180, 480); // mario
        mario.setState(0);
       
        this.foreground.reset();
   
        // background
    
        this.background.setBackgroundColor(new Color(100, 150, 250));
        
        // foreground
       
        this.foreground.addTileMesh(floor);
        this.foreground.addFOO(mario);
        
        // data
        
        this.time = 400;
        
    }
    
}
