package Tiles;

import java.awt.Graphics2D;

public class Text {
    
    //PRIVATE
    
    private int posX, posY;
    private String string;
    
    //PUBLIC
    
    public Text(String s, int x, int y){
    
        // initializing
        
        this.posX = x;
        this.posY = y;
        
        this.string = s;
        
    }

    public void render(Graphics2D graf2D){
   
        graf2D.drawString(this.string, this.posX, this.posY);
    
    }
    
}

