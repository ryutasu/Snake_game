
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Snake extends GameObject{
    GameObject snake[];
    int bodyPart;
    char direction;
    int skill;

    public Snake(int i,int bodyPart, char direction) {
        this.snake = new GameObject[i];
        for (int j = 0; j < i; j++) {
            this.snake[j] = new GameObject() {};
        }
        this.bodyPart = bodyPart;
        this.direction = direction;
        this.skill = 0;
    }

    public void AddSnake(int i,int x, int y, int width, int height, Color color) {
        this.snake[i].x = x;
        this.snake[i].y = y;
        this.snake[i].width = width;
        this.snake[i].height = height;
        this.snake[i].color = color;
    }
    
    public int getX(int i) {
        return this.snake[i].x;
    }

    public void setX(int i,int x) {
        this.snake[i].x = x;
    }

    public int getY(int i) {
        return this.snake[i].y;
    }

    public void setY(int i,int y) {
        this.snake[i].y = y;
    }

    public int getWidth(int i) {
        return this.snake[i].width;
    }

    public void setWidth(int i,int width) {
        this.snake[i].width = width;
    }

    public int getHeight(int i) {
        return this.snake[i].height;
    }

    public void setHeight(int i,int height) {
        this.snake[i].height = height;
    }

    public Color getColor(int i) {
        return this.snake[i].color;
    }

    public void setColor(int i,Color color) {
        this.snake[i].color = color;
    }
    
    public int getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(int bodyPart) {
        this.bodyPart = bodyPart;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}
