package FOO;

import java.awt.Rectangle;
import static java.lang.Math.abs;
import java.awt.Graphics2D;

import Sprites.SpriteAnimation;

public class FOO {
    
    //PRIVATE
    
    private int posX, posY,velX, velY, WIDTH, HEIGHT;
    private boolean inGround;
    private SpriteAnimation sprite;
    private Rectangle hitbox;
   
    //PUBLIC
    
    public FOO(int x, int y){
    
        this.posX = x;
        this.posY = y;
        
        // default values
        
        this.WIDTH = 40;
        this.HEIGHT = 40;
        this.inGround = true;
        
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
    }
   
    public void update(){
    
        // movement
        
        this.move(velX, velY);
        
        //gravity
        
        if(!inGround){
        
            this.velY += 1;
        
        }
        
    }
    
    public void render(Graphics2D graf){
    
        if(sprite == null){ // if it does not have sprite
        
            graf.drawRect(this.posX, this.posY, WIDTH, HEIGHT);
    
        }else{
        
            graf.drawImage(sprite.getSprite(), this.posX, this.posY, WIDTH, HEIGHT, null);  
            
        }
    }
    
    public void foward(){
   
        if(this.WIDTH < 0){ // if the sprite is not flipped
            
            this.move(-40, 0); // compensating the flipping
            this.setSize(40, 40); // flipping the sprite - inverse width

        }
        
        this.velX = 4;
        
    }
    
    public void backward(){
   
        if(this.WIDTH > 0){ // if the sprite is not flipped
        
            this.move(40, 0);
            this.setSize(-40, 40); // flipping the sprite - iverse width

        }
        
        this.velX = -4;
        
    }
    
    public void jump(){
    
        if(inGround){
            
            this.velY = -20;
            this.inGround = false;
        }
        
    }
    
    public void move(int x, int y){
        
        this.posX += x;
        this.posY += y;

    }    
    
    public boolean checkCollision(Rectangle r){
            
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT); // update hitbox position
        
        if(abs(this.hitbox.getCenterY() - r.getCenterY()) <= 40 &&
        abs(this.hitbox.getCenterX() - r.getCenterX()) <= 40){ // check for collision
            
            if(abs(this.hitbox.getCenterX() - r.getCenterX()) < 40){
                
                if(this.hitbox.getCenterY() - r.getCenterY() >= 0){ // if the collision is from bellow
                
                    this.velY = 1;
                    this.setY((int)r.getCenterY() + 20);
                    
                }else if(this.hitbox.getCenterY() - r.getCenterY() <= 0){ // if the collision is from above
            
                    this.inGround = true;
                    this.velY = 0; // go down
                    this.setY((int)r.getCenterY() - 60);
                    
                }
                
            }
            if(abs(this.hitbox.getCenterY() - r.getCenterY()) < 40){ // if the collision is on the sides
                
                if(this.hitbox.getCenterX() - r.getCenterX() > 0){ 
                
                    this.velX = 0;
                    this.setX((int)r.getCenterX() + 20);
                    
                }else if(this.hitbox.getCenterX() - r.getCenterX() < 0){
            
                    this.velX = 0;
                    this.setX((int)r.getCenterX() - 60);
                    
                }
                
            }
            
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
    
    public int getX(){
    
        return this.posX;
    
    }
    
    public int getY(){
    
        return this.posY;
    
    }
    
    public boolean inGround(){
    
        return this.inGround;
    
    }
    
}
