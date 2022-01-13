package BaseGame;

import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Layers.Layer;
import Sprites.Sprite;
import Tiles.Form;
import Tiles.Tile;
import Tiles.TileMesh;
import FOO.Mario;
import Tiles.Text;

public class TitleScreen {

    //PRIVATE
    
    private Layer background, foreground;
    private Data gameData;
    private Tile selector;

    
    //PUBLIC
    
    public TitleScreen(Layer b, Layer f, Data gameData){
    
        // initializing
        
        this.background = b; // using the layers from the main application
        this.foreground = f;
        this.gameData = gameData;
        
        // tiles
        
        Sprite tilesSheet = new Sprite("tiles.png", 40); // all the sprites
        Sprite itemsSheet = new Sprite("items.png", 40); 
        
        TileMesh floor = new TileMesh(0, 520, 800, 80, true);
        floor.setSprite(tilesSheet, 0, 0); // getting the floor sprite
    
        Form plant = new Form(80, 400, (short)0);
        Form bush = new Form(520, 480, (short)1);
        
        this.selector = new Tile(190, 340, false); // mode selector
        this.selector.setSprite(itemsSheet, 0, 0);
        
        // background
        
        this.background.setBackgroundColor(new Color(100, 150, 250));
        
        this.background.addTileMesh(plant.getTileMesh()); // adding all the tiles
        this.background.addTileMesh(bush.getTileMesh());
        
        // foreground
       
        try {// title
            
        this.foreground.setImage(ImageIO.read(new File("title.png")), 180, 100);
       
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.foreground.addTileMesh(floor); // adding all the tiles
        
        Mario mario = new Mario(180, 480); // mario
        mario.setState(0);
        this.foreground.addFOO(mario);
        
        Text playerSel = new Text("1 PLAYER GAME", 250, 375); // mode selection
        this.foreground.addText(playerSel);
        playerSel = new Text("2 PLAYER GAME", 240, 425);
        this.foreground.addText(playerSel);
        playerSel = new Text("TOP " + gameData.getTop(), 325, 475); // top score
        this.foreground.addText(playerSel);
        
        this.foreground.addTile(selector);
    }
    
    public void setSelector(short i){
    
        if(i == 0){
        
            this.selector.setY(340);
        
        }else{
        
            this.selector.setY(390);
        
        }
    
    }
    
}
