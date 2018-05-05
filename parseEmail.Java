import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class AttendanceData {
		/*
		 * 1)sorted company in the first column and then person's name;
		 * separated by tab	
		 */

	public static void main(String[] args) throws Exception {
		File f = new File("/Users/mingmingqiu/eclipse-workspace/CS504/src/homework6/attendance");
		Scanner in = new Scanner(f);
		// parse and put file into a map structure, key=firstname.lastname;value=companyname
		Map<String,String> file = new TreeMap();
		while(in.hasNextLine()){
			String attendance = in.nextLine();
			Email e = new Email(attendance);
			file.put(e.getName(), e.getCompany());
		}
		printSortedAttendence(file);
		
		/*
		 * 2)	Create a histogram on the number of attendees per company for the conference. 
		 *  (can be in same program as #1)
		 */
		System.out.println("Histogram of attendees per company:");
		Map<String, Integer> companyCount = new HashMap();
		for(Map.Entry<String, String> entry: file.entrySet()) {
			String key = entry.getValue();
			int count =1;
			if(!companyCount.containsKey(key)) {
					companyCount.put(key, count);
			}else {
					count = companyCount.get(key)+1;
					companyCount.put(key, count);
			}
		}
		for(Map.Entry<String, Integer> entry : companyCount.entrySet()) {
			System.out.println(entry.getKey()+"  "+histogramHelper(entry.getValue()));
		}
		/*
		 * 	3) Check if bill.gates attended the conference.
		 */
		if(isAttended("Bill Gates",file))
				System.out.println( "Bill Gates attended conference!");
		else 
			System.out.println( "Bill Gates did not attend conference!");
	}//end main method
	
	//sort map by value(companyname) via comparator method
	private static void printSortedAttendence(Map<String, String> map) {
		List<Map.Entry<String,String>> list = new ArrayList(map.entrySet());
		list.sort(Entry.comparingByValue());
		for(Entry<String,String> entry:list) {
			System.out.println(entry.getValue() +"	" +entry.getKey());
		}
	}

	//A helper method to check if people attended
	private static boolean isAttended(String name,Map<String,String> attendents) {
		String[] nm = name.toLowerCase().split("\\s+");
		String nameNew = nm[0]+"."+nm[1];
		return attendents.containsKey(nameNew);
	}
	
	//A histogram helper to print stars
	private static String histogramHelper(int n) {
		String result ="";
		for(int i=0; i<n;i++) {
			result += "*";
		}
		return result;
	}
}
