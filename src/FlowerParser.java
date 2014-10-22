import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class for parsing input .data files into POJOs.
 * @author Max Scheiber (scheiber), 14fa
 */
public class FlowerParser {
	/**
	 * In the event of a missing file, print the stack trace and
	 * terminate the program.
	 * 
	 * @param filename the input .data file
	 * @return the parsed data as an array of Flowers
	 * @throws IllegalArgumentException if the file is malformed
	 */
	public static Flower[] parse(String filename) {
		File file = new File("./src/" + filename);
		if (!file.exists()) {
			throw new IllegalArgumentException();
		}
		
		BufferedReader br = null;
		ArrayList<Flower> flowerArrList = new ArrayList<Flower>();
	
	    try{	       
	       // create new buffered reader
	       br = new BufferedReader(new FileReader(file));
	      
	       while (br.ready()) {
	    	   String curLine = br.readLine();
	    	   String[] attributes = curLine.split("	");
	    	   //note that i choose to 
	    	   Flower curFlower = new Flower(Double.parseDouble(attributes[0]), 
	    			   Double.parseDouble(attributes[1]), Double.parseDouble(attributes[2]), 
	    			   Double.parseDouble(attributes[3]), attributes[4]);
	    	   flowerArrList.add(curFlower);
	       }
	       
	    } catch(Exception e) {
	       e.printStackTrace();
	       throw new IllegalArgumentException();
	    } finally {
	       
	       // releases resources associated with the stream
	      if(br!=null) {
	          try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      }
	    }
	    Flower[] outputArr = new Flower[flowerArrList.size()];
	    for (int i = 0; i < outputArr.length; i++) {
	    	outputArr[i] = flowerArrList.get(i);
	    }
	    return outputArr;
	}
}