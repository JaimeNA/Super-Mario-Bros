package BaseGame;

import FOO.Mario;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Layers.Layer;
import Sprites.Sprite;
import Tiles.Tile;
import Tiles.TileMesh;

public class TitleScreen {

    //PRIVATE
    
    private Layer background, foreground;
    private Data gameData;
    private Tile selector;

    
    //PUBLIC
    
    public TitleScreen(int w, int  h){
    
        // initializing
        
        this.background = this.foreground = new Layer(w, h);
        
        // tilea
        
        Sprite tilesSheet = new Sprite("tiles.png", 40); // all the sprites
        Sprite itemsSheet = new Sprite("items.png", 40); 
        
        TileMesh floor = new TileMesh(0, 520, w, 80, true);
        floor.setSprite(tilesSheet, 0, 0); // getting the floor sprite
    
        TileMesh plant = new TileMesh(80, 400, 200, 120, true); // plant 5x3 tiless
        plant.getTile(2).setSprite(tilesSheet, 8, 10); // column 1
        plant.getTile(4).setSprite(tilesSheet, 8, 10); // column 2
        plant.getTile(5).setSprite(tilesSheet, 8, 9);
        plant.getTile(6).setSprite(tilesSheet, 9, 10); // column 3
        plant.getTile(7).setSprite(tilesSheet, 9, 11);
        plant.getTile(8).setSprite(tilesSheet, 9, 11);
        plant.getTile(10).setSprite(tilesSheet, 10, 10); // column 4
        plant.getTile(11).setSprite(tilesSheet, 10, 9);
        plant.getTile(14).setSprite(tilesSheet, 10, 10); // colum 5
        
        TileMesh bush = new TileMesh(520, 480, 200, 40, true); // bush 5x1 tiless
        bush.getTile(0).setSprite(tilesSheet, 11, 11); 
        bush.getTile(1).setSprite(tilesSheet, 12, 11); 
        bush.getTile(2).setSprite(tilesSheet, 12, 11);
        bush.getTile(3).setSprite(tilesSheet, 12, 11);
        bush.getTile(4).setSprite(tilesSheet, 13, 11);
        
        this.selector = new Tile(190, 340, false); // mode selector
        this.selector.setSprite(itemsSheet, 0, 0);
        
        // background
        
        this.background.setBackgroundColor(new Color(100, 150, 250));
        
        for(int i = 0; i < plant.getSize(); i++){ // plant
        
            this.background.addTile(plant.getTile(i)); // adding all the tiles
        
        }
        
        for(int i = 0; i < bush.getSize(); i++){ // plant
        
            this.background.addTile(bush.getTile(i)); // adding all the tiles
        
        }
        
        // foreground
       
        try {// title
            
        this.foreground.setImage(ImageIO.read(new File("title.png")), 180, 100);
       
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < floor.getSize(); i++){ // ground
        
            this.foreground.addTile(floor.getTile(i)); // adding all the tiles
            
        }
        
        Mario mario = new Mario(180, 480); // mario
        mario.setState(0);
        this.foreground.addFOO(mario);

        this.gameData = new Data();
        
    }
    
    public void render(Graphics2D graf2D){
    
        // drawing all the layers
        
        this.background.render(graf2D);    
        this.foreground.render(graf2D);
        
        // text
        
        this.gameData.render(graf2D);
        
        // mode selection
        
        graf2D.drawString("1 PLAYER GAME", 250, 375);
        graf2D.drawString("2 PLAYER GAME", 240, 425);
        
        selector.render(graf2D);
        
        // top score
        
        graf2D.drawString("TOP " + gameData.getTop(), 325, 475);
        
    }
    
    public void setSelector(short i){
    
        if(i == 0){
        
            this.selector.setY(340);
        
        }else{
        
            this.selector.setY(390);
        
        }
    
    }
    
}
