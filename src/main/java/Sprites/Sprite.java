package Sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {

    //PRIVADO
    
    private final int TILE_SIZE;
    private BufferedImage img;
    
    //PUBLICO
    
    public Sprite(String filename, int size){
    
        this.TILE_SIZE = size; // size of the sprites
        
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // accessors
    
    public BufferedImage getSprite(int xGrid, int yGrid) {

        return img.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        
    }

}
