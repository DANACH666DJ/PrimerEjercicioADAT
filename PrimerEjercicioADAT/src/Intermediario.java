
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Intermediario {

	private ClaseA encargadoFicheros;
	private ClaseB engargadoTecladoPantalla;
	private bbdda base;
	private Scanner teclado;	
	
	public Intermediario(){
		teclado = new Scanner(System.in); // Para leer las opciones de teclado
		encargadoFicheros = new ClaseA();
		engargadoTecladoPantalla = new ClaseB();
		base=new bbdda();
	}
	
	public void ejecucion(){
		int op = 0; // Opcion
		boolean salir = false;
		
		while (!salir) { // Estructura que repite el algoritmo del menu principal hasta que se la condicion sea falsa
			// Se muestra el menu principal
			System.out.println(".......................... \n" 
							+  ".  1 Leer de teclado y escribir en fichero  \n"
							+  ".  2 Leer de fichero y escribir en pantalla \n" 
							+  ".  3 Leer de fichero y escribir en bbdda \n" 
							+  ".  4 Leer de bbdda y escribir en fichero \n" 
							+  ".  5 Escribir en pantalla y insertar en bbdda \n" 
							+  ".  6 Leer de bbdda y escribir en pantalla \n" 
							+  ".  7 Salir \n" 
							+  "..........................");
			try{
				op = teclado.nextInt(); // Se le da a la variable op el valor del teclado
				System.out.println("OPCION SELECCIONADA:" + op);
				switch (op) {
					case 1:// Insertar Moneda
						tecladoFichero();
						break;
					case 2:// Retornar Monedas
						ficheroPantalla();
						break;
					case 3:
						
						break;
					case 4:
						bbddaFichero();
						break;
					case 5:
						
						break;
					case 6:
						
						break;
					case 7:// Salir
						salir = true;
						break;
					default:// No valido
						System.out.println("Opcion invalida: marque un numero de 1 a 7");
						break;
				}
			}catch (Exception e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 1 a 7");
	            // flushing scanner
				//e.printStackTrace();
				teclado.next();
			}
		}
		
		//teclado.close();

	}


	private void bbddaFichero() {
		// TODO Auto-generated method stub
		ArrayList<String> ed = base.leerBbdda();
		
		encargadoFicheros.escribirFichero(ed);
		
	}

	private void ficheroPantalla() throws IOException {
		System.out.println("Pasamos datos de fichero a pantalla");
		//Object ed = encargadoFicheros.leerFichero("fichero.txt");
		ArrayList<String> ed = encargadoFicheros.leerFichero("fichero.txt");
		
		
		engargadoTecladoPantalla.MostrarPersonajes(ed);
		
		/*boolean ok= engargadoTecladoPantalla.MostrarPersonajes(ed);
		if(ok){
			System.out.println("Se han mostrado correctamente los datos del fichero por pantalla");
		}else{
			System.out.println("Ha ocurrido un error");
		}
		*/
	}


	private void tecladoFichero() {
		System.out.println("Pasamos datos de teclado a fichero");
//		Object ed = engargadoTecladoPantalla.getPersonajes();
		
		ArrayList<String> ed = engargadoTecladoPantalla.getPersonajes();
		encargadoFicheros.escribirFichero(ed);
		/*boolean ok = encargadoFicheros.escribirFichero(ed);		
		if(ok){
			System.out.println("Se han guardado correctamente los datos en el fichero");
		}else{
			System.out.println("Ha ocurrido un error");
		}
		*/		
	}

}