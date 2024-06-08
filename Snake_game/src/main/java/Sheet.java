import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DragonLotus
 */
public class Sheet{
    private File file;
    ArrayList<Character> input = new ArrayList<Character>();
    ArrayList<Integer> key = new ArrayList<Integer >();

    public Sheet() {
    }

    public Sheet(String file) throws IOException{
        this.file = new File(file);
        this.add(file);
    }
    
    public void add(String file) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        String txt = " ";
        while ((line = br.readLine()) != null) {
            //array.add(line);
            txt = txt + line;
        }
        br.close();
        for(int i = 0; i < txt.length(); i++)
        {
            char currentCharacter = txt.charAt(i);//getting the character at current index
            this.input.add(currentCharacter);//adding the character to the list
        }
        for(char name:this.input) {
            System.out.println(""+name);
            switch(name){
                case 1:
                    this.key.add(1);
                    break;
                case 2:
                    this.key.add(2);
                    break;
                case 3:
                    this.key.add(3);
                    break;
                case 4:
                    this.key.add(4);
                    break;
                case ',':
                    this.key.add(0);
                    break;
            }
        }
    }
    
    public int node(int count){
        return this.key.get(count);
    }
}
