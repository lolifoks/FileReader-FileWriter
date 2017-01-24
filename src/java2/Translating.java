/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;
import java.io.*;
/**
 *
 * @author azrap
 */
public class Translating {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        FileReader input = null;
        FileWriter output = null;
        try{
        input = new FileReader("test.txt");
        output = new FileWriter("test1.txt");
        
        boolean CapLet = true;
        boolean Space = true;
        int n = 0;
        
        while((n=input.read()) != -1){
        
        if(n>=65 && n<=90){
        
            if(!CapLet){
            output.write(Character.toLowerCase(n));
            n=input.read();
            }
            else{
            output.write(n);
            CapLet = false;
            }
            Space = true;
        }
        else if((CapLet)&& (n>=97 && n<=122)){
        
            output.write(Character.toUpperCase(n));
            CapLet = false;
            Space = true;
        }
        
        else if(Character.isWhitespace(n)){
        if(Space) output.write(n);
        Space = false;
        }
        else if((char)n == '.' || (char)n == '!' || (char)n == '?'){
        
            CapLet = true;
            output.write(n);
            output.write(32);
            Space = false;
        
        }
        
        else{
        output.write(n);
        Space = true;
        }
        
        
        }}
              catch (FileNotFoundException ex) {   
                System.out.println("The file is missing!");
            } 
            catch (IOException ex) { 
                System.out.println(ex.toString());
            }
            
        finally {
            try {
                input.close();
                output.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        } 
        
    }
    
}
