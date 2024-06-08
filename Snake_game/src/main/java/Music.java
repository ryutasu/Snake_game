import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Music {
    AudioInputStream audioinput;
    Clip clip;
    int loop;
    void playmusic(int loop,String musicLocation)
    {
        try{
            File music = new File(musicLocation);
            
            if(music.exists())
            {
                this.audioinput = AudioSystem.getAudioInputStream(music);
                this.clip = AudioSystem.getClip();
                this.clip.open(audioinput);
                if(loop != 0){
                    this.clip.loop(loop);
                }
                else{
                    this.clip.start();
                }
                
                //JOptionPane.showMessageDialog(null,"Press OK to stop playing");
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
    void Stop(){
        this.clip.stop();
    }
}
