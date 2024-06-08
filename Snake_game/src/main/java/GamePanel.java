import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class GamePanel extends JPanel implements ActionListener{
    String file;
    Sheet sheet;
    Play_music music;
    int BPM;
    int time = 0;
    int count = 0;
    ArrayList<Node> node = new ArrayList<Node>();
    ArrayList<Key> key = new ArrayList<Key>();
    static final int SCREEN_WIDTH = 1280;
    static final int SCREEN_HEIGHT = 720;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 25;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    boolean running = false;
    Timer timer;

    GamePanel(String file) throws IOException{
        this.sheet = new Sheet(file);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    private void setKey(){
        
    }
    private void startGame(){
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
            for(int i = 0;i < SCREEN_HEIGHT/UNIT_SIZE;i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            }
            for(Node node:this.node){
                switch(node.Key){
                    case 1:
                        g.setColor(Color.gray);
                        g.fillOval(node.x, node.y, UNIT_SIZE, UNIT_SIZE);
                        break;
                    case 2:
                        g.setColor(Color.white);
                        g.fillOval(node.x, node.y, UNIT_SIZE, UNIT_SIZE);
                        break;
                    case 3:
                        g.setColor(Color.white);
                        g.fillOval(node.x, node.y, UNIT_SIZE, UNIT_SIZE);
                        break;
                    case 4:
                        g.setColor(Color.gray);
                        g.fillOval(node.x, node.y, UNIT_SIZE, UNIT_SIZE);
                        break;
                }
            }
        }
        
    }
    private void move(){
        node.get(0).x = node.get(0).x - 1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(""+sheet.node(count));
        if(time == 0)
        {
            switch(sheet.node(count)){
                case 0:
                    time = 1000;
                    break;
                case 1:
                    node.add(new Node(1,600,600,UNIT_SIZE, UNIT_SIZE,Color.BLUE));
                    break;
                case 2:
                    node.add(new Node(2));
                    break;
                case 3:
                    node.add(new Node(3));
                    break;
                case 4:
                    node.add(new Node(4));
                    break;
            }
            count++;
        }
        move();
        if(time != 0){
            time--;
        }
    }
    
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            
        }
    }
    
}
