package FOO;

import java.awt.image.BufferedImage;

import Sprites.Sprite;
import Sprites.SpriteAnimation;

public class Mario extends FOO{
    
    //PRIVATE
    
    private int state;
    
    private SpriteAnimation animation;
    private final BufferedImage[] idleB, walkB;
    
    //PUBLIC

    public int velX, velY;
    
    public Mario(int x, int y) {
        super(x, y);
        
        Sprite spriteSheet = new Sprite("index.png", 40);
        
        BufferedImage[] temp = {spriteSheet.getSprite(1, 0), spriteSheet.getSprite(2, 0), spriteSheet.getSprite(3, 0)};
        this.walkB = temp;
        BufferedImage[] temp1 = {spriteSheet.getSprite(0, 0)};
        this.idleB = temp1;
        
    }    

    public void update(){
    
        this.animation.update();

        // movement
        
        this.move(velX, velY);
                
        // gravity
        
        velY += 1;
        
    }
    
    public void foward(){
   
        if(this.state != 1){ // if its not walking
        
            this.setState(1);
            
        }
        
        if(this.getWidth() < 0){ // if the sprite is not flipped
            
            this.move(-40, 0); // compensating the flipping
            this.setSize(40, 40); // flipping the sprite - inverse width

        }
        
        this.move(4, 0);
        
        this.animation.update(); // updating the sprites
    
    }
    
    public void backward(){
   
        if(this.state != 2){ // if its not walking
        
            this.setState(2);
            
        }
        
        if(this.getWidth() > 0){ // if the sprite is not flipped
        
            this.move(40, 0);
            this.setSize(-40, 40); // flipping the sprite - iverse width

        }
        
        this.move(-4, 0);
        
        this.animation.update(); // updating the sprites
    
    }
    
    public void jump(){
    
        if(velY == 0){
            this.velY = -10;
        }
        
    }
    
    // accessors
    
    public void setState(int i){
    
        this.state = i;
        
        switch(this.state){
        
        case 0:
            
            this.animation = new SpriteAnimation(idleB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        case 1:
                
            this.animation = new SpriteAnimation(walkB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        case 2:
                
            this.animation = new SpriteAnimation(walkB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        }
    
    }
    
}
