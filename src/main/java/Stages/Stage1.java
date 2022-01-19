package Stages;

import FOO.Goomba;
import java.awt.Color;
import Layers.Layer;
import Sprites.Sprite;
import Tiles.Text;
import FOO.Mario;
import Input.Keyboard;
import Tiles.Tile;
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
    private Goomba g;
    private TileMesh floor;
    private char[][] map;
    
    //PUBLIC
    
    public Stage1(Layer b, Layer f, Keyboard k){
        
        this.background = b;
        this.foreground = f;
        this.input = k;
        
        // default values
        
        char m[][] = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','#','#','#','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','#','#','#','.','.','#','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.','.','.',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'.','.','.','.','.','.','#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}};
        
        this.map = m;
        this.lives = 3;
        
        this.startScreen();
        
    }
    
    public void update(){
            
        count++;
        
        if(count >= 60){ // every second
        
            time--;
            
            // removing dead goombas
            
            if(g.getState() == 1){
            
                g.setX(900);
                
            }
            
            count = 0; // reset the count
            
        }
        
        // MARIO
        
        if(!this.mario.isDead()){
        
            // movement
         
            if(input.key[39]){
        
                this.mario.foward();
                   
                if(mario.getState() != 1 && mario.inGround()){ // if the state is not set
                    this.mario.setState(1);
                }
                    
            }else if(input.key[37]){
        
                this.mario.backward();
               
                if(mario.getState() != 1 && mario.inGround()){ // if the state is not set
                    this.mario.setState(1);
                }
                    
            }else{ // if its not jumping
        
                if(mario.inGround()){ // if it is on the ground
                    mario.setState(0);
                }
            
            }
        
            if(input.key[32]){ // jump if its on the ground
        
                this.mario.jump();
           
                if(mario.getState() != 2){ // if the state is not set
                    this.mario.setState(2);
                }
                
            }
            
        }
        
        this.mario.update();
        
        this.mario.updateAnimation();
                
        // Collision
        
        mario.checkCollision(this.map);
        
        //GOOMBA
        
        this.g.update();
        
        this.g.updateAnimation();
        
    }
    
    public int getTime(){
    
        return this.time;
    
    }
    
    public void startScreen(){
    
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
    
    public void loadLevel(){
    
        try {
            TimeUnit.SECONDS.sleep(2); // 2 second delay
        } catch (InterruptedException ex) {
            Logger.getLogger(Stage1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        // level loading

        Sprite tilesSheet = new Sprite("tiles.png", 16); // all the sprites
        Sprite itemsSheet = new Sprite("items.png", 40); 
        
        floor = new TileMesh(0, 520, 800, 80, true);
        floor.setSprite(tilesSheet, 0, 0); // getting the floor sprite
     */
        mario = new Mario(200, 200); // mario
        mario.setState(0);
       
       g = new Goomba(200, 400);
       g.setState(0);
        /*
        Tile t = new Tile(220, 480, true);
        t.setSprite(tilesSheet, 1, 0);
        
        Tile t2 = new Tile(260, 360, true);
        t2.setSprite(tilesSheet, 1, 0);*/
        this.foreground.reset();
   
        // background
    
        this.background.setBackgroundColor(new Color(100, 150, 250));
        
        // foreground
       
        /*this.foreground.addTileMesh(floor);
        this.foreground.addTile(t);
        this.foreground.addTile(t2);*/
        this.foreground.addFOO(mario);
        this.foreground.addFOO(g);
        this.foreground.loadMap(this.map);
        
        // data
        
        this.time = 400;
        
    }
    
}
