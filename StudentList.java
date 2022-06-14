import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String StudentName = bufferReader.readLine();
			String names[] = StudentName.split(", ");
			for(String j : names) {
				System.out.println(j); }
			}
			catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String readLine = bufferedReader.readLine();
			//System.out.println(r);
			String split[] = readLine.split(", ");
			int length=split.length;
			Random random = new Random();
				int nextInt = random.nextInt(length);
					System.out.println(split[nextInt]);
			}
			catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("students.txt", true));
			String substring = args[0].substring(1);
	        Date date = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String format= dateFormat.format(date);
			writer.write(", "+substring+"\nList last updated on "+format);
			writer.close();
			}
			catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String readLine = bufferedReader.readLine();
			String names[] = readLine.split(",");
			boolean done = false;
			String substring = args[0].substring(1);
			for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(substring)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			}
			catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			char a[] = line.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:a) {
				if(c ==' ') {
					if (!in_word) {
						count++; in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count +" word(s) found ");
			}
			catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
	}
}
