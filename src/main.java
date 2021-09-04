import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		File file = new File("C:/Users/David Nogales/Desktop/G_BD-6/archivo-1.txt");	
		if (!file.exists() || !file.isFile()) return;
		 try (FileInputStream fis = new FileInputStream(file);
			       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			       BufferedReader reader = new BufferedReader(isr)	   
			  ) {
			 		
			      String str;
			     ArrayList <String> resultado = new ArrayList<>();

			      while ((str = reader.readLine()) != null) {
			    	 
			    	  String[] line = str.split(",");
			    	  if(!line[5].equalsIgnoreCase("halado")) {
			    		  resultado.add(str);
			    	  }
			      }
			      String nuevo = "";
			      for (int i = 0; i < resultado.size(); i++) {
					nuevo = nuevo + resultado.get(i) + "\n";
			      }
			      
			      try (OutputStreamWriter writer =
			              new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)){
			    	  writer.write(nuevo);
			     // do stuff
			 	}catch(Exception e1){
			 		
			 	}
	
				System.out.println("Se han borrado correctamente los delitos de modalidad Halado");
				System.out.println("Quedan " + countLineBufferedReader("C:/Users/David Nogales/Desktop/G_BD-6/archivo-1.txt") + " restantes");
				reader.close();
			      
			      
			  } catch (IOException e) {
			      e.printStackTrace();
			  }
		 
		
		

	}
	
	 public static long countLineBufferedReader(String fileName) {

	      long lines = 0;
	      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	          while (reader.readLine() != null) lines++;
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return lines;

	  }
	
	

}
