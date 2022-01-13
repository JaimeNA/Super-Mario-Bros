package Stages;

import java.awt.Color;

import Layers.Layer;
import Sprites.Sprite;
import Tiles.Text;
import FOO.Mario;
import Tiles.TileMesh;

public class Stage1 {

    //PRIVATE
    
    private Layer background, foreground;
    private int lives;
    
    //PUBLIC
    
    public Stage1(Layer b, Layer f){
        
        this.background = b;
        this.foreground = f;
        
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

        // level loading

        Sprite tilesSheet = new Sprite("tiles.png", 40); // all the sprites
        Sprite itemsSheet = new Sprite("items.png", 40); 
        
        TileMesh floor = new TileMesh(0, 520, 800, 80, true);
        floor.setSprite(tilesSheet, 0, 0); // getting the floor sprite
     
        this.foreground.reset();
   
        // background
    
        this.background.setBackgroundColor(new Color(100, 150, 250));
        
        // foreground
       
        this.foreground.addTileMesh(floor);
        
    }
    
}
