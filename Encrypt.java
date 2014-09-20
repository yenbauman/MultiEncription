package multiencryption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encrypt { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file(full) location in computer");
        String location = in.nextLine();
        System.out.println("Enter new file's name");
        String name = in.nextLine();
        File file = new File(location);
        try {
            FileReader FR = new FileReader(file);
            BufferedReader BR = new BufferedReader(FR);
            String data = "";
            while(BR.ready()) {
                data += BR.readLine() + '\n';
            }
            BR.close();
            FR.close();
            if(data.length() %2 == 0){
                data += "#";
            }
            String key = "";
            for (int i = 0; i < data.length(); i+=2) {
                key += data.charAt(i);
            }            
            int k = 0;
            String key_data_length = "";           
            for (int i = 0; i < data.length(); i++) {
                key_data_length += key.charAt(k);
                k++;               
                if(k == key.length())
                    k = 0;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
