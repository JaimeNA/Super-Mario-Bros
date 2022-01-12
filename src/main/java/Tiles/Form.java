package Tiles;

import Sprites.Sprite;

public class Form {

    //PRIVATE
    
    private TileMesh form;
    
    //PUBLIC
    
    public Form(int x, int y, short i){
    
        Sprite tilesSheet = new Sprite("tiles.png", 40);
        
        if(i == 0){ // plant
        
            form = new TileMesh(x, y, 200, 120, true); // plant 5x3 tiless
            form.getTile(2).setSprite(tilesSheet, 8, 10); // column 1
            form.getTile(4).setSprite(tilesSheet, 8, 10); // column 2
            form.getTile(5).setSprite(tilesSheet, 8, 9);
            form.getTile(6).setSprite(tilesSheet, 9, 10); // column 3
            form.getTile(7).setSprite(tilesSheet, 9, 11);
            form.getTile(8).setSprite(tilesSheet, 9, 11);
            form.getTile(10).setSprite(tilesSheet, 10, 10); // column 4
            form.getTile(11).setSprite(tilesSheet, 10, 9);
            form.getTile(14).setSprite(tilesSheet, 10, 10); // colum 5
        
        }else if(i == 1){ // bush
        
            form = new TileMesh(x, y, 200, 40, true); // bush 5x1 tiless
            form.getTile(0).setSprite(tilesSheet, 11, 11); 
            form.getTile(1).setSprite(tilesSheet, 12, 11); 
            form.getTile(2).setSprite(tilesSheet, 12, 11);
            form.getTile(3).setSprite(tilesSheet, 12, 11);
            form.getTile(4).setSprite(tilesSheet, 13, 11);
        
        }
        
    }
    
    public TileMesh getTileMesh(){
    
        return this.form;
    
    }
    
}