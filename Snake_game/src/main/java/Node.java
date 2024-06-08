
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Node extends MoveableObject{
    protected int Key;

    public Node(int Key) {
        super(0, 0, 100, 100, Color.BLACK);
        this.Key = Key;
    }

    public Node(int Key, int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        this.Key = Key;
    }
    
    public Node(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public int getKey() {
        return Key;
    }

    public void setKey(int Key) {
        this.Key = Key;
    }

    private void Switch(int Key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
