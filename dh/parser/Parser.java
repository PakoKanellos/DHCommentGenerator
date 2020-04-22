/**
 * 
 */
package dh.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dh.parser.commenti.Commento;
import dh.parser.commenti.CommentoCompleto;
import dh.parser.commenti.CommentoMedio;
import dh.parser.commenti.CommentoMinimale;
import dh.parser.util.InputUtil;

/**
 * @author pako 
 * 
 */

public class Parser {

	public static void main(String[] args) {
		try {
			InputUtil input = new InputUtil();
			Commento commento = null;
			
			input = startMenu(input);
			commento = getComment(input);
			writeEventsLog(input, commento);

		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("File reading error");
 		} catch (Exception e) {
			System.err.println("Generic exception ");
			e.printStackTrace();
		}		
	}

	private static InputUtil startMenu(InputUtil input) {
		boolean choice = false;
		while (!choice) {
			try {
				input.generatorTypeChoice();
				choice = true;
			} catch (NumberFormatException e) {
				input = new InputUtil();
			}
		}
		return input;
	}

	private static Commento getComment(InputUtil input) {
		Commento commento = null;
		if (1 == input.getTypeOfCommentChoice())
			commento = new CommentoMinimale();
		if (2 == input.getTypeOfCommentChoice())
			commento = new CommentoMedio();
		if (3 == input.getTypeOfCommentChoice())
			commento = new CommentoCompleto();
		return commento;
	}

	private static void writeEventsLog(InputUtil input, Commento commento)
			throws FileNotFoundException, IOException {
		
		FileWriter fileWriter = new FileWriter("events.txt");
		ArrayList<Integer> totalEvents = new ArrayList<Integer>();
		
		// massivo
		if (1 == input.getChoiceType()) {
			File folder = new File(input.getPath());
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
				if (file.isFile()) {
					if (file.getName().substring(file.getName().length() - 3)
							.equals("txt")) {
						input.setName(file.getName());
						BufferedReader reader = commento.leggiFileLocale(
								input.getPath(), input.getPathMods(),
								input.getName());
						int nEvents = commento.scriviCommento(reader, input, fileWriter);
						System.out.println("# ----------------");
						System.out.println("# Number of events " + nEvents);
						System.out.println("");
						totalEvents.add(nEvents);
					}
				}
			}
			// puntuale
		} else {
			BufferedReader reader = commento.leggiFileLocale(input.getPath(),
					input.getPathMods(), input.getName());
			int nEvents = commento.scriviCommento(reader, input, fileWriter);
			System.out.println("# ----------------");
			System.out.println("# Number of events " + nEvents);
			System.out.println("");
			totalEvents.add(nEvents);
		}		
		
		int tot = 0;
		for (Iterator iterator = totalEvents.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			tot = tot + integer;
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("# ######################################## ");
		System.out.println("# TOTAL Number of events " + tot);
		System.out.println("# ######################################## ");
		
		fileWriter.write("\n");
		fileWriter.write("\n");
		fileWriter.write("# ######################################## \n");
		fileWriter.write("# TOTAL Number of events " + tot + "\n");
		fileWriter.write("# ######################################## \n");
		fileWriter.close();
	}

	
	
	
	
	
	
	public String massiveSwing(String directory, String modsDirectory,
			Commento commento) {

		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		InputUtil input = new InputUtil();
		input.setPath(directory);
		input.setPathMods(modsDirectory);

		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (file.getName().substring(file.getName().length() - 3)
						.equals("txt")) {
					input.setName(file.getName());
					try {
						BufferedReader reader = commento.leggiFileLocale(
								input.getPath(), input.getPathMods(),
								input.getName());
						int nEvents = commento.scriviCommento(reader, input, null);
						// commento.getCommento().append("----------------" +
						// "\n");
						// commento.getCommento().append("Number of events " +
						// nEvents + "\n");
						// commento.getCommento().append("----------------" +
						// "\n");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//
					// System.out.println("----------------");
					// System.out.println("Number of events " + nEvents);
					// System.out.println("");
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