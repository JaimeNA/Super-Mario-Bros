
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
    private ArrayList<Tile> tile;
    private ArrayList<FOO> foo;
    private ArrayList<Text> text;
    private char map[][];
    private Color backCo;
    
    private int imgX, imgY, posX, posY;
    
    private final int WIDTH, HEIGHT;
    
    //PUBLIC
    
    public Layer(int w, int h){
    
        this.WIDTH = w;
        this.HEIGHT = h;
        
        this.posX = 0;
        this.posY = 0;
        
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
    
            graf2D.drawImage(this.image, imgX + posX, imgY + posY, null);
            
        }
        
        // tiles
        
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
    
        for(int i = 0; i < mesh.getSize(); i++){
        
            this.tile.add(mesh.getTile(i));
    
        }
        
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
    
    public void move(int x, int y){
    
        this.posX += x;
        this.posY += y;
    
    }
    
    public void reset(){
    
        this.backCo = null;
        this.image = null;
        this.tile.clear();
        this.foo.clear();
        this.text.clear();
    
    }
    
    public void loadMap(char m[][]){
    
        // map 
        
        for(int i = 0; i < 16; i++){
            
            for(int j = 0; j < 24; j++){
        
                if(m[i][j] == '#'){
                
                    this.tile.add(new Tile(j * 40, i * 40, true));
                    
                }
        
            }
        
        }
    }
    
    public ArrayList<Rectangle> getHitboxes(){ // get all the hitboxes on scene
    
        ArrayList<Rectangle> temp = new ArrayList<>();
        
        // tile list
        for(int i = 0; i < tile.size(); i++){
        
            if(tile.get(i).getHitbox() != null){ // only add if it have a hitbox
            
                temp.add(tile.get(i).getHitbox());
        
            }
        }
        
        return temp;
    
    }
    
}
