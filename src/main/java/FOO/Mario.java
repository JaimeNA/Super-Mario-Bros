package FOO;

import java.awt.image.BufferedImage;

import Sprites.Sprite;
import Sprites.SpriteAnimation;

public class Mario extends FOO{
    
    //PRIVATE
    
    private int posX, posY;
    
    private SpriteAnimation foward, idle;
    
    //PUBLIC

    public Mario(int x, int y) {
        super(x, y);
        
        this.posX = x;
        this.posY = y;
        
        Sprite spriteSheet = new Sprite("index.png", 40);
        
        BufferedImage[] fowardB = {spriteSheet.getSprite(2, 0), spriteSheet.getSprite(3, 0), spriteSheet.getSprite(4, 0), spriteSheet.getSprite(5, 0)};
        BufferedImage[] idleB = {spriteSheet.getSprite(0, 0)};
        
        foward = new SpriteAnimation(fowardB, 10);
        idle = new SpriteAnimation(idleB, 10);

    }    

    @Override
    public void update(){
    
        this.foward.update();
    
    }
    
    public void setState(int i){
    
        switch(i){
        
        case 0:
                
            idle.start();
            this.setSprite(idle);
            
            break;
        
            
        
        }
    
    }
    
}
