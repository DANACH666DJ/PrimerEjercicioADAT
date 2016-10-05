import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ClaseA {
	private String sFichero;
	private String element;
	private ArrayList<String> al1; 
	private String cadena;
	
	
	public ClaseA(){
		sFichero="";
		element="";
		al1=new ArrayList<String>();
		cadena="";
	}
	
	
	public void escribirFichero(ArrayList<String> al) {
		sFichero = "fichero.txt";
		try {
			File fichero = new File(sFichero);
			FileWriter fi=new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fi);
			
			Iterator<String> itr = al.iterator();
			while (itr.hasNext()) {
				element = itr.next();
				bw.write(element + "\n");

			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> leerFichero(String fichero) throws IOException {
		FileReader f = new FileReader(fichero);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			al1.add(cadena);
			//System.out.println(al1);
		}

		b.close();
		
		return al1;
	}
}
