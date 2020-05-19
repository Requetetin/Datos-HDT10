/* Martin Amado */
/* 19020 */
/* Main.java */
/* Encargado de recibir y separar la base de datos del txt */


import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]){

		DiGraph grafo = new DiGraph();

		int distancia = 0;
		String line = "";
		try{
				Scanner reader = new Scanner(new File("guategrafo.txt"));
			while(reader.hasNextLine()){
				line = reader.nextLine();
				String[] parts = line.split(" ");

				distancia = Integer.parseInt(parts[2]);

				grafo.add(parts[0], parts[1], distancia);
			}

			System.out.println("El grafo ha sido ingresado");


		}
		catch(Exception e){
			System.out.println("El archivo 'guategrafo' no existe");
		}

	}
}