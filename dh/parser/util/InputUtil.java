/**
 * 
 */
package dh.parser.util;

import java.util.Scanner;

/**
 * @author pako
 *
 */
public class InputUtil {

	public String path; //path del file
	public String pathMods; //path del file mods.csv	
	public String name; //nome del file
	public Integer choice; //scelta dell'utente
	public Integer choiceType; //modalità di generazione
	
	public String getPathMods() {
		return pathMods;
	}

	public void setPathMods(String pathMods) {
		this.pathMods = pathMods;
	}

	public Integer getChoiceType() {
		return choiceType;
	}

	public void setChoiceType(Integer choiceType) {
		this.choiceType = choiceType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChoice() {
		return choice;
	}

	private void setChoice(Integer choice) {
		this.choice = choice;
	}

	public void keyboardInput(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("**************************************** ");
		System.out.println("Event comments generator ");
		System.out.println("Made by Pako ");
		System.out.println("Version 1.0 beta");
		System.out.println("**************************************** ");
		System.out.println("");

		System.out.println("Select type of generator : ");
		System.out.println("1) Massive");
		System.out.println("2) Single File");
		System.out.print("> "); 
		String scelta = scanner.nextLine();
		setChoiceType(Integer.parseInt(scelta));
		
		System.out.println("Insert path file (add \\ (or / if you're on MAC) if not present at the end) : ");
		System.out.print("Path ---> "); 
		String pathTo = scanner.nextLine();
		setPath(pathTo);
		
		if(2==getChoiceType()){
			System.out.println("Insert file name : ");
			System.out.print("File ---> "); 
			String nomeFile = scanner.nextLine();
			setName(nomeFile);
			System.out.println("");		
		}
		
		System.out.println("Insert mods.csv path file (add \\ (or / if you're on MAC) if not present at the end) : ");
		System.out.print("Path ---> "); 
		String pathMods = scanner.nextLine();
		setPathMods(pathMods);

		System.out.println("Select type of comments : ");
		System.out.println("1) Minimal : id/country/name");
		System.out.println("2) Medium : id/country/name/date");
		System.out.println("3) Full : id/country/name/desc/date");
		System.out.print("> "); 
		Integer scelta2 = scanner.nextInt();
		setChoice(scelta2);
		System.out.println("\n");	
		
	}
	
	public void intestazione(){
		System.out.println("################################### ");
		System.out.println("### List of Events for " + getName());
		System.out.println("### Generated by Pako Comments Generator ");
		//System.out.println("### URL : thread paradox todo");
		System.out.println("################################### ");
		System.out.println("");	
	}
	
	public StringBuffer getIntestazione(){
		StringBuffer sb = new StringBuffer();
		sb.append("################################### " + "\n");
		sb.append("### List of Events for " + getName() + "\n");
		sb.append("### Generated by Pako Comments Generator " + "\n");
		//System.out.println("### URL : thread paradox todo");
		sb.append("################################### " + "\n");
		sb.append("" + "\n");	
		return sb;
	}
	
}
