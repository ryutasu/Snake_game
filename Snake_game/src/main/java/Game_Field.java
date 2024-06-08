
import java.awt.*;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Game_Field extends JFrame{
    Game_Field() throws IOException{
        this.add(new GamePanel("sheetdata.txt"));
        this.setTitle("Rhythm_Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
