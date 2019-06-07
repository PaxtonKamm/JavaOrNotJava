//Assignment 8 JavaOrNot
// Author: Paxton Kammermeier
import java.io.*;
  
public class JavaOrNot{
   //Inside the main method there are two try-catch methods. The outer method tries to print out 
   //out the outFile in which there is no file found yet so we throw the issue. Then inside
   // the outside try loop, we fill the printWriter with files(written in String) that are non-Java
   // files. We will use our NotJavaException class to find files that are not .java and put them
   // inside the blank nonJava.txt file.
   //Once that is complete, we have an outgoing message that says
   //nonJava.txt is filled and completed.
   public static void main(String [] args) throws NotJavaException, IOException 
   {
        File folder = new File(".");  //dot is current directory
        File[] listOfFiles = folder.listFiles(); //we now have array of File objects
        String name = "";
        String lastFiveChar;
        NotJavaException problem = new NotJavaException("This is not a java file");
        FileNotFoundException issue = new FileNotFoundException();
        File nonJavaFile = new File("nonJava.txt");
        PrintWriter outFile = new PrintWriter(nonJavaFile); 
       //the outer try loop tries to print the outfile in which there is nothing inside. 
       try{
         outFile.println();
         throw issue;
        }
        //It is going to go through all our files in the directory to fill the nonJava.txt
        // with nonJava files.
        catch(FileNotFoundException e) {
           String nonJavaFileName = " "; 
           for (File file : listOfFiles) {
               //#check it's a file not subdirectory
               if (file.isFile()) 
               {
                       name = file.getName(); //each file name is a String
                       //System.out.println(name);
               }   
               if (name.length() > 5)
               {
                  lastFiveChar = name.substring(name.length()-5);
               }
               else
               {
                  lastFiveChar = name;
               }
               //Above, we truncated the file names to print out the last five characters. 
               //If the last five characters are .java, don't do anything. However, if they
               // do not equal java, put them in the NotJavaException catch in order to put 
               // those files(currenlty in String state) inside the new .txt file.               
               try{
                 if (lastFiveChar.equals(".java"))
                 {
                   
                 }
                  else
                  {
                    throw problem;
                  }
               }
               catch(NotJavaException except)
                 {
                  nonJavaFileName = nonJavaFileName + name + "\n";
                  outFile.print(name+" ");
                  }
              outFile.println();    
             }
             outFile.close();
             System.out.println("Output file has been created: " + nonJavaFile);
           }
        } 
      } 
   
   