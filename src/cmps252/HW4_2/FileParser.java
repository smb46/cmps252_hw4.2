package cmps252.HW4_2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;


public class FileParser {
	
	public static ArrayList<Customer> getCustomers(String fileName) throws FileNotFoundException { //returns an arraylist of the customers
		ArrayList<Customer> Customers = new ArrayList<Customer>();
		
		try (Scanner reader = new Scanner(new File(fileName));){
			int lineCount=0;
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				if (lineCount++ == 0) continue; //to skip the first line
				String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				if (fields ==null) {
					continue;
				}
				Customer c = new Customer(clean(fields[0]), clean(fields[1]), clean(fields[2]), clean(fields[3]), clean(fields[4]), clean(fields[5]), clean(fields[6]), clean(fields[7]), clean(fields[8]), clean(fields[9]), clean(fields[10]), clean(fields[11]));
				Customers.add(c);
			}
		}
		return Customers;
	}
	
	private static String clean(String s) {
		return s.substring(1,  s.length()-1); //to remove the extra double quotes 
	}

}
