package FOO;

import java.awt.image.BufferedImage;

import Sprites.Sprite;
import Sprites.SpriteAnimation;

public class Mario extends FOO{
    
    //PRIVATE
    
    private int state;
    private SpriteAnimation animation;
    private final BufferedImage[] idleB, walkB, jumpB, deadB;
    
    //PUBLIC
    
    public Mario(int x, int y) {
        super(x, y);
        
        Sprite spriteSheet = new Sprite("index.png", 40);
        
        BufferedImage[] temp = {spriteSheet.getSprite(1, 0), spriteSheet.getSprite(2, 0), spriteSheet.getSprite(3, 0)};
        this.walkB = temp;
        BufferedImage[] temp1 = {spriteSheet.getSprite(0, 0)};
        this.idleB = temp1;
        BufferedImage[] temp2 = {spriteSheet.getSprite(5, 0)};
        this.jumpB = temp2;
        BufferedImage[] temp3 = {spriteSheet.getSprite(6, 0)};
        this.deadB = temp3;
        
    }    

    public void updateAnimation(){
    
        this.animation.update();
    
    }
    
    // accessors
    
    public int getState(){
    
        return this.state;
    
    }
    
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
                
            this.animation = new SpriteAnimation(jumpB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        case 3:
                
            this.animation = new SpriteAnimation(deadB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        }
    
    }
    
    public void dead(){
    
        jump();
        this.die();
        this.setState(3);
        
    }
    
}
