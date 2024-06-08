
import java.awt.Color;
import java.awt.Component;
import javax.accessibility.AccessibleContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public abstract class GameObject extends Component{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    public GameObject() {
        super();
        this.x = 0;
        this.y = 0;
        this.width = 100;
        this.height = 100;
        this.color = Color.BLACK;
    }

    public GameObject(int x, int y, int width, int height, Color color) {
        //super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
    public int getCenterX(){
        return x+width/2;
    }
    
    public int getCenterY(){
        return y+height/2;
    }

    @Override
    public String toString() {
        return "GameObject{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }
    
    
    
    
}
