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
    private boolean dead;
   
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
        
        this.hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT); // update hitbox position
         
        //gravity
        
        if(!inGround || dead){ // if its dead or not on the ground
        
            this.velY += 1;
        
        }
        
        this.velX = 0;
        
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
    
    public void checkCollision(char map[][]){
        
        if(map[(posY / 40) + 1][posX / 40] == '#'){ // Y collision
        
            inGround = true;
            velY = 0;
            this.setY((posY / 40) * 40);
            
        }else if(map[(posY / 40)][posX / 40] == '#'){ // Y collision
        
            velY = +1;
            this.setY(((posY / 40) + 1) * 40);
            
        }else{
        
            inGround = false;
            
        }
        
        if(map[(posY / 40)][(posX / 40) + 1] == '#' && this.WIDTH > 0){ // X collision
        
            velX = 0;
            this.setX((posX / 40) * 40);
            
        }else if(map[(posY / 40)][(posX / 40) - 1] == '#' && this.WIDTH < 0){ // X collision
            
            velX = 0;
            this.setX(((posX / 40) + 1) * 40);
            
        }
        
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
    
    public Rectangle getHitbox(){
    
        return this.hitbox;
    
    }
    
    public boolean inGround(){
    
        return this.inGround;
    
    }
    
    public void die(){
    
        this.inGround = false; // fall through the floor
        this.dead = true;
    
    }
    
    public boolean isDead(){
    
        return this.dead;
    
    }
    
}
