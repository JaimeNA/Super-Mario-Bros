package Tiles;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;

import Sprites.Sprite;

public class TileMesh {

    //PRIVAD
    
    private int posY, posX;
    private final int WIDTH, HEIGHT;
    private boolean solid;
    private ArrayList<Tile> mesh;
    private Sprite mainSprite;
    private Rectangle hitbox;
    
    //PUBLIC
    
    public TileMesh(int x, int y, int w, int h, boolean solid){
    
        this.posX = x;
        this.posY = y;
        
        this.WIDTH = w;
        this.HEIGHT = h;
    
        this.solid = solid;
        
        this.mesh = new ArrayList<>();
        
        // creando la mesh
        for(int i = 0; i < this.WIDTH / 40; i++){ //O(n^2)
            for(int j = 0; j < this.HEIGHT / 40; j++){
            
                mesh.add(new Tile(posX + (i * 40), posY + (j * 40), this.solid));
            
            }
        }
        
        if(this.solid){
        
            hitbox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        
        }
        
    }
    
    public void render(Graphics graf){
    
        for(int i = 0; i < this.mesh.size(); i++){ // dibujando cada elemento
            
            mesh.get(i).render(graf);
            
        }
    }
    
    // accessors
    
    public Tile getTile(int index){
    
        return mesh.get(index);
    
    }
    
    public int getSize(){ 
    
        return mesh.size();
    
    }
    
    public Rectangle getHitbox(){
    
        return this.hitbox;
    
    }
    
    public void setSprite(Sprite sprite, int xGrid, int yGrid){
    
        this.mainSprite = sprite;
    
        for(int i = 0; i < this.mesh.size(); i++){ // drawing all elements
            
            mesh.get(i).setSprite(this.mainSprite, xGrid, yGrid);
            
        }
        
    }
    
}
