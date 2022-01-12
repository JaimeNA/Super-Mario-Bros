package Input;

import java.awt.event.*;

public class Keyboard implements KeyListener{

    //PRIVATE
    
    //PUBLIC
    
    public boolean key[];
    
    public Keyboard(){
    
        this.key = new boolean[256];
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        key[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        key[e.getKeyCode()] = false;
        
    }
    
}
