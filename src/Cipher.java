//Abdul Khan
//C Block
//2/5/19

package Record;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Cipher {

	public static void main(String[] args) {
		Record array[] = new Record	[26];
		Record letter;
		Scanner input = new Scanner(System.in);
		String pathname = "Cipher.txt";
	    File file = new File(pathname);
		 try
		    {
		       
			 input = new Scanner(file);
			 
		     for(int i = 0; i < 26; i++) {
		    	
		    	 array[i] = new Record(Character.toUpperCase((char)(i+97)), 0);
		     }
		   
		     
		     while(input.hasNext()) {
					String word = input.next();
					int length = word.length();
					for(int i = 0; i < length ; i++) {
						for(int j = 0; j < 26; j++) {
							if(word.charAt(i) == array[j].getLet()) {
								int freq = array[j].getFreq();
								array[j].setFreq(freq+1);
							}

						}
					}
					}
		   
		        Arrays.sort(array);
		        
		        
		        	
		        	String pathname2 = "Replace.txt";
		    	    File file2 = new File(pathname2);
		        	 try
		 		    {
		 		        input = new Scanner(file2);
		 		       while(input.hasNext()) {
		 		        for(int i = 0; i < 26; i++) {
		 		        	
		 		        	char let = (input.next()).charAt(0);
		 		        	array[25-i].setUncoded(let);
		 		        	
		 		        }
		 		       }
		 		       
		 		       
		 		       
		 		      
		 		    }
		 		    catch (FileNotFoundException ex)
		 		    {
		 		        System.out.println("*** Cannot open " + pathname + " ***");
		 		        System.exit(1);  // quit the program
		 		    } 
		        	
		        	 input.close();
		        
		     
		        
		    }
		    catch (FileNotFoundException ex)
		    {
		        System.out.println("*** Cannot open " + pathname + " ***");
		        System.exit(1);  // quit the program
		    } 
		 input.close();

		 try
		    {
		       
			 input = new Scanner(file);
			 int counter = 0;
			 String line[] = new String[34];
			 while(input.hasNext()) {
		    	 	line[counter] = input.nextLine();
					counter++;
		     }
		     
		     for(int j = 0; j < 34; j++) {
		    	 
		    	 write(line[j]);
		    	 System.out.println(uncodedLine(line[j], array));
		     }
		     
					}
		 catch (FileNotFoundException ex)
		    {
		        System.out.println("*** Cannot open " + pathname + " ***");
		        System.exit(1);  // quit the program
		    } 
		 input.close();
	}

	
	public static String uncodedLine(String line, Record[] array) {
		
		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean equals = false, higher = false;
		String fline = "";
		int length = line.length();
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < 26; j++) {
				if(line.charAt(i) == array[j].getLet()) {
					if(array[j].getFreq() == array[(j+1)%26].getFreq()) {
						System.out.println(line.charAt(i)+" can be decoded as either "+array[j].getUncoded()+"(1) or "+array[j+1].getUncoded()+"(2):");
						option = input.nextInt();
						higher = true;
					}
					if(array[j].getFreq() == array[(j-1)%26].getFreq()) {
						System.out.println(line.charAt(i)+" can be decoded as either "+array[j].getUncoded()+"(1) or "+array[j-1].getUncoded()+"(2):");
						option = input.nextInt();
						higher = false;
					}
						if(option == 2 && higher == true) {
							fline = fline + array[j+1].getUncoded();
						}
						else if(option == 2 && higher == false) {
							fline = fline + array[j-1].getUncoded();
						}
						else {
							fline = fline + array[j].getUncoded();
						}
					
					
					equals = true;
				}
				else if(array[j].getLet() == 'Z' && equals == false) {
					fline = fline + line.charAt(i);
				}
				
			}
			equals = false;
			option = 0;
		}
		
		
	return "\n" + fline + "\n";
	}
	
	public static void write(String line) {
		
		 String pathname = "output.txt";
		    File file = new File(pathname);
		    PrintWriter output = null;
		    try
		    {
		       output = new PrintWriter(file);
		    }
		    catch (FileNotFoundException ex)
		    {
		       System.out.println("Cannot create " + pathname);
		       System.exit(1);  // quit the program
		    }
		    output.println(line);
		    output.close(); 

	}
	
}
