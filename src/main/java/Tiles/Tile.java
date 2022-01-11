
package Tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import Sprites.Sprite;

public class Tile {

    //PRIVADO
    
    private int posX, posY, xGrid, yGrid;
    private final int WIDTH, HEIGHT;
    private Sprite sprite;
    private Rectangle hitbox;
    private boolean solid;

    //PUBLICO
    
    public Tile(int x, int y, boolean solid){
    
        // default value
        
        this.WIDTH = 40;
        this.HEIGHT = 40;
        
        this.solid = false;
        
        // choosen values
        
        this.posX = x;
        this.posY = y;
    
        this.solid = solid;
        
        // init hitbox
        
        if(this.solid){
        
            hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
        }
        
    }
    
    public void render(Graphics graf){
    
        if(sprite == null){ // if sprite is not specified
        
            graf.drawRect(this.posX, this.posY, this.WIDTH, this.HEIGHT); // draw empty square

        }else{
            
            graf.drawImage(this.sprite.getSprite(xGrid, yGrid), this.posX, this.posY, null); // draw specified image
        
        }
    }
    
    //Accessors
    
    public void setX(int x){
    
        this.posX = x;
       
    }

    public void setY(int y){
    
        this.posY = y;
       
    }
    
    public void setSprite(Sprite sprite, int xGrid, int yGrid){
        
        this.xGrid = xGrid;
        this.yGrid = yGrid;
        
        this.sprite = sprite;
    
    }
    
    public void setSolid(boolean b){
    
        this.solid = b;
    
    }
    
    public int[] getSize(){
    
        return new int[]{WIDTH, HEIGHT};
    
    }
    
    public Rectangle getHitbox(){
    
        return this.hitbox;
    
    }
    
}
