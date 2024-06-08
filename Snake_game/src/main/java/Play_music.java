
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Play_music {
    
    void playmusic(String musicLocation)
    {
        try{
            File music = new File(musicLocation);
            
            if(music.exists())
            {
                AudioInputStream audioinput = AudioSystem.getAudioInputStream(music);
                Clip clip = AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
                
                JOptionPane.showMessageDialog(null,"Press OK to stop playing");
            }
            else
            {
                System.out.println("Can't find file");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
