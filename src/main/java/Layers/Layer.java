
package Layers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;

import Tiles.Tile;
import FOO.FOO;

public class Layer {
    
    //PRIVATE
    
    private BufferedImage image;
    private ArrayList<Tile> tiles;
    private ArrayList<FOO> foo;
    private Color backCo;
    
    private int imgX, imgY;
    
    private final int WIDTH, HEIGHT;
    
    //PUBLIC
    
    public Layer(int w, int h){
    
        this.WIDTH = w;
        this.HEIGHT = h;
        
        tiles = new ArrayList<>();
        foo = new ArrayList<>();
        
    }
    
    public void render(Graphics2D graf2D){
    
        // background color
        
        if(backCo != null){
        
            graf2D.setColor(backCo);
            graf2D.fillRect(0, 0, WIDTH, HEIGHT);
        
        }
        
        // image
        
        if(image != null){ // if the image is not null then draw it
    
            graf2D.drawImage(this.image, imgX, imgY, null);
            
        }
        
        // tiles
        
        if(!this.tiles.isEmpty()){
        
            for(int i = 0; i < this.tiles.size(); i++){ // traverse the list and draw everything
            
                this.tiles.get(i).render(graf2D);
            
            }
        
        }
        
        // FOO
        
        if(!this.foo.isEmpty()){
        
            for(int i = 0; i < this.foo.size(); i++){ 
            
                this.foo.get(i).render(graf2D);
            
            }
        
        }
        
    }
    
    // accessors
    
    public void addTile(Tile tile){
    
        this.tiles.add(tile);
    
    }
    
    public void addFOO(FOO f){
    
        this.foo.add(f);
        
    }
    
    public void setImage(BufferedImage i, int x, int y){
    
        this.imgX = x;
        this.imgY = y;
        
        this.image = i;
        
    }
    
    public void setBackgroundColor(Color c){
    
        this.backCo = c;
    
    }
    
}
