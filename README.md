# Collections_CS504
using TreeMap to read and sort student name and classes from File
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class collection01 {

	public static void main(String[] args) throws Exception {
		
		File f = new File("Text.txt");
		Scanner in = new Scanner(f);
		TreeMap<String,ArrayList<String>> tm = new TreeMap<>();
		
		while(in.hasNextLine()) {
		String s = in.nextLine();
		String[] s_arr = s.split("\t");
		
		String nm = s_arr[0];
		String course = s_arr[1];
		
		 if(tm.containsKey(nm)) {
			 //contains key
			 ArrayList<String> al = tm.get(nm);
			 al.add(course);
			 Collections.sort(al);
			 tm.put(nm, al);
		 }else {
			 //does not contain the key
			 ArrayList<String> al = new ArrayList<>();
			 al.add(course);
			 Collections.sort(al);
			 tm.put(nm, al);
		 }
		}
		
		for(Map.Entry<String, ArrayList<String>> entry : tm.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> al = entry.getValue();
			System.out.println("NAme = "+key);
			
			for(String s :al)
				System.out.print("  "+s);
			System.out.println();
		}
	}
}
