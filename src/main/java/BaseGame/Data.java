
package BaseGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Sprites.Sprite;
import Tiles.Tile;

public class Data {
    
    //PRIVATE
    
    private int score, coints, time, topscore;
    private Tile coint;
    
    //PUBLIC
    
    public Data(){
    
        this.score = 0;
        this.coints = 0;
        this.time = 0;
        this.topscore = 0;
        
        Sprite spriteSheet = new Sprite("tiles.png", 40); // all the sprites
        
        this.coint = new Tile(265, 40, false);
        this.coint.setSprite(spriteSheet, 24, 1); // getting the floor sprite
    
    }
    
    public void render(Graphics2D graf2d){
    
        graf2d.setColor(new Color(255, 255, 255)); // white color 
        graf2d.setFont(new Font("8-bit Arcade In", Font.PLAIN, 50));
        
        // score 
        
        graf2d.drawString("MARIO", 100, 50);
        graf2d.drawString(score + " ", 100, 80);
        
        // coints
        
        coint.render(graf2d); // coint icon
        graf2d.drawString("x" + coints, 300, 80);
        
        // world
        
        graf2d.drawString("WORLD", 425, 50);
        graf2d.drawString("1 1", 425, 80);
        
        // time
        
        graf2d.drawString("TIME", 600, 50);
        
        if(this.time > 0){
        
            graf2d.drawString(time + " ", 600, 80);
            
        }
        
    }
 
    // accessors
    
    public int getTop(){
    
        return this.topscore;
    
    }
    
    public void setTime(int t){
    
        this.time = t;
    
    }
 
    public int getTime(){
    
        return this.time;
        
    }
    
}
