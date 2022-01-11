package Input;

import java.awt.event.*;

import FOO.FOO;

public class Keyboard implements KeyListener{

    //PRIVADO
    
    //PUBLICO
    
    public boolean tecla[];
    
    public Keyboard(){
    
        this.tecla = new boolean[256];
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        tecla[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        tecla[e.getKeyCode()] = false;
        
    }
    
}
