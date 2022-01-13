package Tiles;

import java.awt.Color;
import java.awt.Font;
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
   
        // text configuration
        graf2D.setColor(new Color(255, 255, 255)); // white color 
        graf2D.setFont(new Font("8-bit Arcade In", Font.PLAIN, 50));
        
        graf2D.drawString(this.string, this.posX, this.posY);
    
    }
    
}

