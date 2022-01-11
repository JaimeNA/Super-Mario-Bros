package FOO;

import java.awt.image.BufferedImage;

import Sprites.Sprite;
import Sprites.SpriteAnimation;

public class Mario extends FOO{
    
    //PRIVATE
    
    private int posX, posY;
    
    private SpriteAnimation foward;
    
    //PUBLIC

    public Mario(int x, int y) {
        super(x, y);
        
        this.posX = x;
        this.posY = y;
        
        Sprite spriteSheet = new Sprite("index.png", 40);
        
        BufferedImage[] fowardI  = {spriteSheet.getSprite(2, 0), spriteSheet.getSprite(3, 0), spriteSheet.getSprite(4, 0), spriteSheet.getSprite(5, 0)};
        
        foward = new SpriteAnimation(fowardI, 10);

        foward.start();
        this.setSprite(foward);
        
    }    

    @Override
    public void update(){
    
        this.foward.update();
    
    }
    
}
