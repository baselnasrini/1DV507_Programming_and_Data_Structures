package mn223dn_assign1;

import java.io.File;
import java.io.IOException;

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {
		
		File startDir = new File("C:\\Users\\Basel Nasrini\\java_courses");
		listFilesForFolder(startDir);
		
	}

	

	 private static int depth = 1;   

	public static void listFilesForFolder(File folder) throws IOException {
		  String temp = ""  ;

	    for (final File fileEntry : folder.listFiles()) {
	      if (fileEntry.isDirectory()) {
	         depth++;
	        listFilesForFolder(fileEntry);
	         depth--;
	      } 
	      else if (! folder.isDirectory()){
	    	  throw new IOException("Is not a vaild folder"); 
	      }
	      else if (! folder.canRead()){
	    	  throw new IOException("Is not a read able folder");
	      }
	    	  
	      else {
	        if (fileEntry.isFile()) {
	          temp = fileEntry.getName();
	          if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("java")){
	        	printDir(fileEntry);}

	        }

	      }
	    }
	    
	}  
	
	
		private static int count = 0;
	    private static void printDir(File file) { 
			StringBuffer buf = new StringBuffer();
			for (int i=0;i<depth;i++)
				buf.append("  ");
			System.out.println((++count)+buf.toString()+file.getName());
	}
	
}


