/**
 * 
 */
package dh.parser.commenti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dh.parser.util.InputUtil;

/**
 * @author pako
 *
 */
public abstract class Commento {

	public abstract int scriviCommento(BufferedReader reader,InputUtil input) throws IOException;
	public abstract BufferedReader leggiFileLocale(String path,String pathMods, String name) throws FileNotFoundException;
	public abstract BufferedReader leggiFileUpload(InputStream is) throws UnsupportedEncodingException;
	
	StringBuffer commento = new StringBuffer();
	
	public StringBuffer getCommento(){
		return commento;
	}
	
	public void setCommento(StringBuffer commento) {
		this.commento = commento;
	}

	
	protected boolean parseId(String line){
		String s = "id = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}
	
	protected boolean parseCountry(String line){
		String s = "country = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		if (!b) {
			s = "TAG = ";
			p = Pattern.compile(s);
			m = p.matcher(line);
			b = m.find();
		}
		return b;
	}
	
	protected boolean parseName(String line){
		String s = "name = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}

	protected boolean parseDesc(String line){
		String s = "desc = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}

	protected boolean parseDate(String line){
		String s = "date = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}
	
	protected boolean parseDeathDate(String line){
		String s = "deathdate = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}
	
	protected boolean parseYear(String line){
		String s = "year = ";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(line);
		boolean b = m.find();
		return b;
	}
	
	/**
	 * 
	 * @param percorsoFileMods
	 *            Il path del file
	 * @param nomeEvento
	 *            Il nome del file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected String parseMods(String percorsoFileMods, String nomeEvento)
			throws FileNotFoundException, IOException {

		BufferedReader br = new BufferedReader(new FileReader(percorsoFileMods));
		String line = br.readLine();
			
		while (line != null) {
			if(nomeEvento.startsWith("\"")) { //fix per eventi con nome del tipo "EVT_23" (con doppi apici prima e dopo)
				nomeEvento = nomeEvento.substring(1,nomeEvento.length()-1);				
			}
			
			Pattern p = Pattern.compile(nomeEvento);
			Matcher m = p.matcher(line);
			boolean b = m.find();
			
			if(b){ //evento trovato, ritorno solo la descrizione inglese
				String temp = line.substring(line.indexOf(';') + 1);
				String temp2 = temp.substring(0, temp.indexOf(';') + 1);
				nomeEvento = temp2;
			}
			line = br.readLine();
		}
		return nomeEvento;
	}

}
