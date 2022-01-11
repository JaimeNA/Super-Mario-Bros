package FOO;

import java.awt.Graphics;
import java.awt.Rectangle;
import static java.lang.Math.abs;

import Sprites.SpriteAnimation;

public class FOO {
    
    //PRIVATE
    
    private int posX, posY, velX, velY, WIDTH, HEIGHT, gravity;
    private SpriteAnimation sprite;
    private Rectangle hitbox;
   
    //PUBLIC
    
    public FOO(int x, int y){
    
        this.posX = x;
        this.posY = y;
        
        // default values
        
        this.velX = 0;
        this.velY = 0;
        
        this.WIDTH = 40;
        this.HEIGHT = 40;
        
        this.gravity = 9;
        
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
    }
   
    public void render(Graphics graf){
    
        if(sprite == null){ // if it does not have sprite
        
            graf.drawRect(this.posX, this.posY, WIDTH, HEIGHT);
    
        }else{
        
            graf.drawImage(sprite.getSprite(), this.posX, this.posY, null);  
        
        }
    }
    
    public void update(){
    
    }
    
    public void move(int x, int y){
        
        this.velX = x;
        this.velY = y;
        
        this.posX += velX;
        this.posY += velY;
        
    }    
    
    public boolean checkCollision(Rectangle r){
            
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT); // update hitbox position
        
        if(abs(this.hitbox.getCenterX() - r.getCenterX()) <= WIDTH 
            && abs(this.hitbox.getCenterY() - r.getCenterY()) <= HEIGHT){ // check for collision
            
            return true;
            
        }
        
        return false;
        
    }
    
    // accessors
    
    public void setSize(int w, int h){
    
        this.WIDTH = w;
        this.HEIGHT = h;
        
        // update the hitbox
        
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
    }
    
    public void setSprite(SpriteAnimation sprite){
    
        this.sprite = sprite;
    
    }
    
    public void setGravity(int g){
    
        this.gravity = g;
    
    }
    
}
