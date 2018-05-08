import java.util.*;
import java.io.*;

public class Attendees {

  public static void main(String[] args) {

     File f;
     Scanner scan;

     TreeMap<String,ArrayList<String>> tm = new TreeMap<String,ArrayList<String>>();

     try {
       f = new File("attendance.txt");
       scan = new Scanner(f);

       while(scan.hasNextLine()) {
         String emailStr = scan.nextLine();

         Emailhw emailObj = new Emailhw(emailStr);
         String company = emailObj.getCompany();
         String name = emailObj.getName();

         if (tm.containsKey(company)) {
           ArrayList<String> al = tm.get(company);
           al.add(name);
           Collections.sort(al);
           tm.put(company,al);
         } else {
           ArrayList<String> al = new ArrayList<String>();
           al.add(name);
           tm.put(company,al);          

         }

         // System.out.println("company=" + company + "  name=" + name);
       }
       

     } catch (IOException ie) {
       ie.printStackTrace();
     } catch (Exception e) {
       e.printStackTrace();
     }


     Iterator it = tm.entrySet().iterator();

     
     BufferedWriter output = null;
     try {
            File file = new File("example.txt");
            output = new BufferedWriter(new FileWriter(file));

            while (it.hasNext()) {
      		Map.Entry<String,ArrayList<String>> pair = (Map.Entry)it.next();
      		String key = pair.getKey();
      		ArrayList<String> value = pair.getValue();

		String text = "";
      		for (String s: value) {
        	   text = key + "\t" + s + "\r\n";
		   output.write(text);
                }	
	    }
            
     } catch ( IOException e ) {
            	    e.printStackTrace();
     } finally {
          if ( output != null ) {
             try {
                output.close();  // need to close file to write to a file
             } catch (IOException ie) {
                ie.printStackTrace();
             }
          }
    }
  }

}
