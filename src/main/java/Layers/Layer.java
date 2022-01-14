
package Layers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;

import FOO.FOO;
import Tiles.Text;
import Tiles.Tile;
import Tiles.TileMesh;
import java.awt.Rectangle;

public class Layer {
    
    //PRIVATE
    
    private BufferedImage image;
    private ArrayList<TileMesh> tiles;
    private ArrayList<Tile> tile;
    private ArrayList<FOO> foo;
    private ArrayList<Text> text;
    private Color backCo;
    
    private int imgX, imgY;
    
    private final int WIDTH, HEIGHT;
    
    //PUBLIC
    
    public Layer(int w, int h){
    
        this.WIDTH = w;
        this.HEIGHT = h;
        
        tiles = new ArrayList<>();
        tile = new ArrayList<>();
        foo = new ArrayList<>();
        text = new ArrayList<>();
        
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
        
        if(!this.tile.isEmpty()){
        
            for(int i = 0; i < this.tile.size(); i++){ // traverse the list and draw everything
            
                this.tile.get(i).render(graf2D);
            
            }
        
        }
        
        // FOO
        
        if(!this.foo.isEmpty()){
        
            for(int i = 0; i < this.foo.size(); i++){ 
            
                this.foo.get(i).render(graf2D);
            
            }
        
        }
        
        // texts
        
        if(!this.text.isEmpty()){
        
            for(int i = 0; i < this.text.size(); i++){ 
            
                this.text.get(i).render(graf2D);
            
            }
        
        }
        
    }
    
    // accessors
    
    public void addTileMesh(TileMesh mesh){
    
        this.tiles.add(mesh);
    
    }
    
    public void addTile(Tile tile){
    
        this.tile.add(tile);
    
    }
    
    public void addFOO(FOO f){
    
        this.foo.add(f);
        
    }
    
    public void addText(Text t){
    
        this.text.add(t);
        
    }
    
    public void setImage(BufferedImage i, int x, int y){
    
        this.imgX = x;
        this.imgY = y;
        
        this.image = i;
        
    }
    
    public void setBackgroundColor(Color c){
    
        this.backCo = c;
    
    }
    
    public void reset(){
    
        this.backCo = null;
        this.image = null;
        this.tile.clear();
        this.tiles.clear();
        this.foo.clear();
        this.text.clear();
    
    }
    
    public ArrayList<Rectangle> getHitboxes(){ // get all the hitboxes on scene
    
        ArrayList<Rectangle> temp = new ArrayList<>();
        
        // tile list
        for(int i = 0; i < tile.size(); i++){
        
            if(tile.get(i).getHitbox() != null){ // only add if it have a hitbox
            
                temp.add(tile.get(i).getHitbox());
        
            }
        }
        
        // tile mesh list
        for(int i = 0; i < tiles.size(); i++){
        
            if(tiles.get(i).getHitbox() != null){ // only add if it have a hitbox
            
                    temp.add(tiles.get(i).getHitbox());
        
            }
            
        }
        
        return temp;
    
    }
    
}
