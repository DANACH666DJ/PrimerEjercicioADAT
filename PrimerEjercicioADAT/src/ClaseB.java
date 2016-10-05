
import java.util.ArrayList;
import java.util.Scanner;

public class ClaseB {

	private ArrayList<String> Personajes;
	private Scanner sc;
	private int numP;
	private String person;

	public ClaseB() {
		Personajes = new ArrayList();
		sc = new Scanner(System.in);
		numP=0;
		person="";
	}

	public ArrayList getPersonajes() {

		System.out.println("Introduce el número de personajes :");
		numP = sc.nextInt();

		for (int i = 0; i < numP; i++) {
			System.out.println("Introduce el nombre del personaje número " + (i + 1));
		    person = sc.next();
			Personajes.add(person);
		}

		return Personajes;
	}

	public void MostrarPersonajes(ArrayList<String> ed) {
		int i = 1;
		for (String Personajes : ed) {
			System.out.println("El personaje " + i + " es :" + Personajes);
			i++;
		}

	}

}
