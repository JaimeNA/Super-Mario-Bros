package BaseGame;

import FOO.Mario;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import Layers.Layer;
import Sprites.Sprite;
import Tiles.TileMesh;

public class TitleScreen {

    //PRIVATE
    
    private Layer background, foreground;
    private JButton player1, player2;
    
    //PUBLIC
    
    public TitleScreen(int w, int  h){
    
        // initializing
        
        this.background = this.foreground = new Layer(w, h);
        
        // tilea
        
        Sprite spriteSheet = new Sprite("tiles.png", 40); // all the sprites
        
        TileMesh floor = new TileMesh(0, 520, w, 80, true);
        floor.setSprite(spriteSheet, 0, 0); // getting the floor sprite
    
        TileMesh plant = new TileMesh(80, 400, 200, 120, true); // plant 5x3 tiless
        plant.getTile(2).setSprite(spriteSheet, 8, 10); // column 1
        plant.getTile(4).setSprite(spriteSheet, 8, 10); // column 2
        plant.getTile(5).setSprite(spriteSheet, 8, 9);
        plant.getTile(6).setSprite(spriteSheet, 9, 10); // column 3
        plant.getTile(7).setSprite(spriteSheet, 9, 11);
        plant.getTile(8).setSprite(spriteSheet, 9, 11);
        plant.getTile(10).setSprite(spriteSheet, 10, 10); // column 4
        plant.getTile(11).setSprite(spriteSheet, 10, 9);
        plant.getTile(14).setSprite(spriteSheet, 10, 10); // colum 5
        
        TileMesh bush = new TileMesh(520, 480, 200, 40, true); // bush 5x1 tiless
        bush.getTile(0).setSprite(spriteSheet, 11, 11); 
        bush.getTile(1).setSprite(spriteSheet, 12, 11); 
        bush.getTile(2).setSprite(spriteSheet, 12, 11);
        bush.getTile(3).setSprite(spriteSheet, 12, 11);
        bush.getTile(4).setSprite(spriteSheet, 13, 11);
        
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
            
        this.foreground.setImage(ImageIO.read(new File("title.png")), 222, 100);
       
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < floor.getSize(); i++){ // ground
        
            this.foreground.addTile(floor.getTile(i)); // adding all the tiles
            
        }
        
        player1 = new JButton();
        player1.setSize(100, 100);
        
    }
    
    public void render(Graphics2D graf2D){
    
        // drawing all the layers
        
        this.background.render(graf2D);    
        this.foreground.render(graf2D);
    
        Mario mario = new Mario(100, 100);
        mario.update();
        mario.render(graf2D);
    }
    
}
