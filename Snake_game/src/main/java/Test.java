
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String musicfile = "track.wav";
        String file = "sheetdata.txt";
        Play_music music = new Play_music();
        music.playmusic(musicfile);
        Sheet sheet = new Sheet(file);
        
    }
    
    
    
}
