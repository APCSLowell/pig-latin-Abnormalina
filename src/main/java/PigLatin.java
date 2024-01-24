import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
 for(int i = 0; i < sWord.length(); i++){
    if(sWord.equals("a") || sWord.equals("e") || sWord.equals("i") || sWord.equals("o") || sWord.equals("u")){  
      return i;
    }
  }
  return -1;
}

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
   	 if(findFirstVowel(sWord) == -1) {
		    return sWord + "ay";
	    }
	else if(findFirstVowel(sWord) == 0){
		return sWord + "way";
	}
	else if(sWord.startsWith("qu")){
		return sWord.substring(2) + "quay";
	}
	else if(findFirstVowel(sWord) != -1){
	       return sWord.substring(findFirstVowel(sWord), sWord.length()) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
       }
	    else {
		return "ERROR!";
	    }
}//end PigLatin class
}
