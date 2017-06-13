/**
 * 
 */
package dh.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import dh.parser.commenti.Commento;
import dh.parser.commenti.CommentoCompleto;
import dh.parser.commenti.CommentoMedio;
import dh.parser.commenti.CommentoMinimale;
import dh.parser.util.InputUtil;

/**
 * @author pako
 * Per test su MAC 
 * /Users/admin/Downloads/events/Fatherland/GER/
 * /Users/admin/Downloads/events/Fatherland/COMINTERN/
 * 
 */
public class Parser {

	public static void main(String[] args) {

		try {
			InputUtil input = new InputUtil();
			input.keyboardInput();
			
			Commento commento = null;
			if(1==input.getChoice())
				commento = new CommentoMinimale();
			if(2==input.getChoice())
				commento = new CommentoMedio();
			if(3==input.getChoice())
				commento = new CommentoCompleto();

			//x test
			input.setPath("/Users/admin/Downloads/events/Fatherland/COMINTERN/");
			input.setPathMods("/Users/admin/Downloads/events/Fatherland/COMINTERN/");
			
			//massivo
			if(1==input.getChoiceType()){
				File folder = new File(input.getPath());
				File[] listOfFiles = folder.listFiles();
				
				for (File file : listOfFiles) {
				    if (file.isFile()) {
				    	if (file.getName().substring(file.getName().length()-3).equals("txt")){
				    		input.setName(file.getName());
				    		BufferedReader reader = commento.leggiFileLocale(input.getPath(), input.getPathMods(), input.getName());
							int nEvents = commento.scriviCommento(reader,input);
							System.out.println("----------------");
							System.out.println("Number of events " + nEvents);
							System.out.println("");
				    	}
				    }
				}
			//puntuale
			}else{
	    		BufferedReader reader = commento.leggiFileLocale(input.getPath(),input.getPathMods(), input.getName());
				int nEvents = commento.scriviCommento(reader,input);
				System.out.println("----------------");
				System.out.println("Number of events " + nEvents);
				System.out.println("");			
			}
						
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			//e.printStackTrace();
		} catch (IOException e) {
			System.err.println("File reading error");
			//e.printStackTrace();
		}
	}
	
	public String massiveSwing(String directory,String modsDirectory,Commento commento){
		
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		InputUtil input = new InputUtil();
		input.setPath(directory);
		input.setPathMods(modsDirectory);
		
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if (file.getName().substring(file.getName().length()-3).equals("txt")){		    		
		    		input.setName(file.getName());
		    		try {
						BufferedReader reader = commento.leggiFileLocale(input.getPath(), input.getPathMods(), input.getName());
						int nEvents = commento.scriviCommento(reader,input);
//						commento.getCommento().append("----------------" + "\n");
//						commento.getCommento().append("Number of events " + nEvents + "\n");
//						commento.getCommento().append("----------------" + "\n");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//
//					System.out.println("----------------");
//					System.out.println("Number of events " + nEvents);
//					System.out.println("");
		    		catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
	}
		return commento.getCommento().toString();
}
}