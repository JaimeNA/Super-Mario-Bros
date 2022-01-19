package FOO;

import java.awt.image.BufferedImage;

import Sprites.Sprite;
import Sprites.SpriteAnimation;
import java.awt.Rectangle;
import static java.lang.Math.abs;

public class Goomba extends FOO{
    
    //PRIVATE
    
    private int state;
    private SpriteAnimation animation;
    private final BufferedImage[] walkB, deadB;
    
    //PUBLIC
    
    public Goomba(int x, int y) {
        super(x, y);
        
        Sprite spriteSheet = new Sprite("Goomba.png", 16);
        
        BufferedImage[] temp = {spriteSheet.getSprite(0, 0), spriteSheet.getSprite(1, 0)};
        this.walkB = temp;
        BufferedImage[] temp1 = {spriteSheet.getSprite(2, 0)};
        this.deadB = temp1;
        
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
            
            this.animation = new SpriteAnimation(walkB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        
        case 1:
                
            this.animation = new SpriteAnimation(deadB, 10);
            this.animation.start();
            this.setSprite(this.animation);
            
            break;
        }
    }
    
}
