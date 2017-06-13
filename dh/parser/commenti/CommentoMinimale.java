/**
 * 
 */
package dh.parser.commenti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import dh.parser.util.InputUtil;

/**
 * @author pako
 *
 */
public class CommentoMinimale extends Commento {

	String path;
	String pathMods;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathMods() {
		return pathMods;
	}

	public void setPathMods(String pathMods) {
		this.pathMods = pathMods;
	}

	@Override
	public int scriviCommento(BufferedReader reader,InputUtil input) throws IOException,FileNotFoundException {
		String line = reader.readLine();
		
		boolean idFound = false;
		boolean nameFound = false;
		boolean countryFound = false;
		
		StringBuffer stringa = null;
		
		input.intestazione();
		this.getCommento().append(input.getIntestazione());
		
		int counter = 0;
		while (line != null) {
			if (parseId(line)) {
				if(line.trim().startsWith("id = ")){ //per evitare di tirarsi dentro eventi non well-formed (trig con riferimenti a id di altri eventi)
					stringa = new StringBuffer("#" + line.trim());
					idFound = true;
					nameFound = false;
					countryFound = false;
				}
				else idFound = false; 
			}
			if (!countryFound) {
				if (idFound) {
					if (parseCountry(line)) {
						if (null != stringa)
							if(line.trim().startsWith("country = ") || line.trim().startsWith("TAG = ")){ //per evitare di tirarsi dentro eventi non well-formed (con triggger prima di name)
								stringa.append(" - " + line.trim());
								countryFound = true;
							}
					}
				}
			}
			if (!nameFound) {
				if (idFound && countryFound) {
					if (parseName(line)) {
						nameFound = true;
						stringa.append(" - "
								+ parseMods(pathMods + "mods.csv",
										line.substring(line.indexOf('=') + 1)
												.trim()));
						System.out.println(stringa);
						this.getCommento().append(stringa + "\n");
						counter++;
						stringa = null;
						idFound = false;
					}
				}
			}
			line = reader.readLine();
		}
		this.getCommento().append("----------------" + "\n");
		this.getCommento().append("Number of events " + counter+ "\n");
		this.getCommento().append("" + "\n");
		return counter;
	}


	@Override
	public BufferedReader leggiFileLocale(String path, String pathMods, String name) throws FileNotFoundException {
		setPath(path);
		setPathMods(pathMods);
		return new BufferedReader(new FileReader(path + name));
	}

	@Override
	public BufferedReader leggiFileUpload(InputStream is) throws UnsupportedEncodingException {
		return new BufferedReader(new InputStreamReader(is, "UTF-8"));
	}
	
}
