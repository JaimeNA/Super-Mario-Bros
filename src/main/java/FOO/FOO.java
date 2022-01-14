package FOO;

import java.awt.Rectangle;
import static java.lang.Math.abs;
import java.awt.Graphics2D;

import Sprites.SpriteAnimation;

public class FOO {
    
    //PRIVATE
    
    private int posX, posY, WIDTH, HEIGHT, gravity;
    private SpriteAnimation sprite;
    private Rectangle hitbox;
   
    //PUBLIC
    
    public FOO(int x, int y){
    
        this.posX = x;
        this.posY = y;
        
        // default values
        
        this.WIDTH = 40;
        this.HEIGHT = 40;
        
        this.gravity = 9;
        
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
    }
   
    public void render(Graphics2D graf){
    
        if(sprite == null){ // if it does not have sprite
        
            graf.drawRect(this.posX, this.posY, WIDTH, HEIGHT);
    
        }else{
        
            graf.drawImage(sprite.getSprite(), this.posX, this.posY, WIDTH, HEIGHT, null);  
            
        }
    }
    
    public void move(int x, int y){
        
        this.posX += x;
        this.posY += y;

    }    
    
    public boolean checkXCollision(Rectangle r){
            
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT); // update hitbox position
        
                System.out.println(abs(r.getCenterX()));
        
        if(abs(this.hitbox.getCenterX() - r.getCenterX()) < 60){ // check for collision
            
            return true;
            
        }
        
        return false;
        
    }
    
    public boolean checkYCollision(Rectangle r){
            
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT); // update hitbox position
        
        if(abs(this.hitbox.getCenterY() - r.getCenterY()) < 60){ // check for collision
            
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
    
    public void setX(int x){
    
        this.posX = x;
    
    }
    
    public void setY(int y){
    
        this.posY = y;
    
    }
    
    public int getWidth(){
    
        return this.WIDTH;
    
    }
    
    public int getHeight(){
    
        return this.HEIGHT;
    
    }
    
}
