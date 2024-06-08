import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class GamePanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 96;
    
    Apple apple = new Apple();
    Snake snake = new Snake(GAME_UNITS,6,'R');
    ArrayList<Block> block = new ArrayList<Block>();
    Music music = new Music();
    
    int score = 0;
    boolean running = false;
    boolean gamestart = false;
    Timer timer;
    Random random;
    
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        running = true;
    }
    
    public void startGame(){
        music.playmusic(10,"track_game.wav");
        newSnake();
        newBlock();
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        if(running){
            g.setColor(apple.color);
            g.fillOval(apple.x, apple.y, apple.width, apple.height);
            for(int i = 0 ; i < snake.bodyPart;i++){
                g.setColor(snake.snake[i].color);
                g.fillRect(snake.snake[i].x, snake.snake[i].y, snake.snake[i].width, snake.snake[i].height);
            }
            for (int i = 0; i < block.size(); i++) {
                g.setColor(block.get(i).getColor());
                g.fillRect(block.get(i).x, block.get(i).y, block.get(i).width, block.get(i).height);
            }
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free",Font.BOLD,40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score:"+score, (SCREEN_WIDTH - metrics.stringWidth("Score:"+score))/2, g.getFont().getSize());
            if(!gamestart){
            g.setColor(Color.white);
            g.setFont(new Font("Ink Free",Font.BOLD,45));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("press space to start", (SCREEN_WIDTH - metrics1.stringWidth("press space to start"))/2, SCREEN_HEIGHT/2);
            }
        }
        else{
            music.Stop();
            if(score >= 40){
                gamewin(g);
            }
            else{
                gameover(g);
            }
        }
    }
    public void newSnake(){
        for (int i = 0; i < snake.bodyPart; i++) {
            if(i==0){
                snake.snake[i].color = Color.GREEN;
            }
            else{
                snake.snake[i].color = new Color(45,180,0);
            }
            snake.snake[i].width = UNIT_SIZE;
            snake.snake[i].height = UNIT_SIZE;
        }
    }
    
    public void addSnake(){
        for (int i = 0; i < snake.bodyPart; i++) {
            if(i==0 || i==1){
                snake.snake[i].color = snake.snake[i].color;
            }
            else{
                snake.snake[i].color = snake.snake[snake.bodyPart-1].color;
            }
            snake.snake[i].width = UNIT_SIZE;
            snake.snake[i].height = UNIT_SIZE;
        }
    }
    
    public void newApple(){
        apple.setType(random.nextInt(2));
        apple.setHeight(UNIT_SIZE);
        apple.setWidth(UNIT_SIZE);
        apple.setX(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        apple.setY(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
        switch(apple.getType()){
            case 0:
                apple.setColor(new Color(255,204,51));
                break;
            default:
                apple.setColor(Color.red);
                break;
        }
        for (int i = 0; i < block.size(); i++) {
            if(apple.x == block.get(i).x && apple.y == block.get(i).y){
                newApple();
            }
        }
    }
    
    public void newBlock(){
        int count;
        if(score >= 5 && score <15){
            count = 5;
        }
        else if(score >= 15 && score <25){
            count = 7;
        }
        else if(score >= 25 && score <35){
            count = 11;
        }
        else if(score >= 35){
            count = 13;
        }
        else{
            count = 3;
        }
        while(block.size() < count){
            block.add(new Block());
        }
        for (int i = 0; i < block.size(); i++) {
            block.get(i).setHeight(UNIT_SIZE);
            block.get(i).setWidth(UNIT_SIZE);
            block.get(i).setX(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
            block.get(i).setY(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
            block.get(i).setColor(Color.CYAN);
        }
    }
    
    public void move(){
        for (int i = snake.bodyPart; i > 0; i--) {
            snake.snake[i].x = snake.snake[i-1].x;
            snake.snake[i].y = snake.snake[i-1].y;
        }
        if(snake.skill == 0){
            switch(snake.direction){
                case 'U':
                    snake.snake[0].y = snake.snake[0].y - UNIT_SIZE;
                    break;
                case 'D':
                    snake.snake[0].y = snake.snake[0].y + UNIT_SIZE;
                    break;
                case 'L':
                    snake.snake[0].x = snake.snake[0].x - UNIT_SIZE;
                    break;
                case 'R':
                    snake.snake[0].x = snake.snake[0].x + UNIT_SIZE;
                    break;
            }
        }
        else if(snake.skill == 1){
            switch(snake.direction){
                case 'U':
                    snake.snake[0].y = snake.snake[0].y - UNIT_SIZE*4;
                    break;
                case 'D':
                    snake.snake[0].y = snake.snake[0].y + UNIT_SIZE*4;
                    break;
                case 'L':
                    snake.snake[0].x = snake.snake[0].x - UNIT_SIZE*4;
                    break;
                case 'R':
                    snake.snake[0].x = snake.snake[0].x + UNIT_SIZE*4;
                    break;
            }
            snake.skill = 0;
        }
    }
    
    public void checkApple(){
    if((snake.snake[0].x == apple.x) && (snake.snake[0].y == apple.y)){
        if(apple.color == Color.red){
            score++;
        }
        else{
            score = score + 3;
        }
            snake.bodyPart++;
            newBlock();
            newApple();
            addSnake();
        }
    }
    
    public void checkCollisions(){
        for(int i = snake.bodyPart ; i > 0;i--){
            if((snake.snake[0].x == snake.snake[i].x) && (snake.snake[0].y == snake.snake[i].y))
            {
                running = false;
            }
        }
        
        for (int i = 0; i < block.size(); i++) {
            if((snake.snake[0].x == block.get(i).x) && (snake.snake[0].y == block.get(i).y)){
                running = false;
            }
        }
        
        if(snake.snake[0].x < 0){
            running = false;
        }
        
        if(snake.snake[0].x > SCREEN_WIDTH){
            running = false;
        }
        
        if(snake.snake[0].y < 0){
            running = false;
        }
        
        if(snake.snake[0].y > SCREEN_HEIGHT){
            running = false;
        }
        
        if(!running){
            timer.stop();
        }
    }
    
    public void checkpoint(){
        if(score >= 40){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }
    
    public void gameover(Graphics g){
        music.playmusic(0,"track_fail.wav");
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score:"+score, (SCREEN_WIDTH - metrics2.stringWidth("Score:"+score))/2, g.getFont().getSize());
    }
    
    public void gamewin(Graphics g){
        music.playmusic(0,"track_win.wav");
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Congratulations", (SCREEN_WIDTH - metrics1.stringWidth("Congratulations"))/2, SCREEN_HEIGHT/2);
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score:"+score, (SCREEN_WIDTH - metrics2.stringWidth("Score:"+score))/2, g.getFont().getSize());
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gamestart){
            move();
            checkApple();
            checkCollisions();
            checkpoint();
        }
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter{   
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(snake.direction !='R'){
                        snake.direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snake.direction !='L'){
                        snake.direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snake.direction !='D'){
                        snake.direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snake.direction !='U'){
                        snake.direction = 'D';
                    }
                    break;
                case KeyEvent.VK_A:
                    if(snake.skill == 0){
                        snake.skill = 1;
                    }
                    break;
                case KeyEvent.VK_X:
                    Color color = new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225));
                    for (int i = 0; i < snake.bodyPart; i++) {
                        if(i==0){
                            snake.snake[i].color = new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225));
                        }
                        else{
                            snake.snake[i].color = color;
                        }
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(running && !gamestart){
                        gamestart = true;
                        startGame();
                    }
                    break;
            }
        }
    }
    
}
