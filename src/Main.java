/* Martin Amado */
/* 19020 */
/* Main.java */
/* Encargado de recibir y separar la base de datos del txt */


import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]){

		DiGraph grafo = new DiGraph();
		Matriz mat = new Matriz();
		Floyd fl = new Floyd();
		Centro c = new Centro();
		int ingreso = 0;
		int distancia = 0; 
		String line = "";
		Scanner scan = new Scanner(System.in);
		try{
				Scanner reader = new Scanner(new File("guategrafo.txt"));
			while(reader.hasNextLine()){
				line = reader.nextLine();
				String[] parts = line.split(" ");

				distancia = Integer.parseInt(parts[2]);

				grafo.add(parts[0], parts[1], distancia);
			}

			System.out.println("\nEl grafo ha sido ingresado\n");
			long myAdy[][] = mat.crearMatriz(grafo);
			System.out.println(mat.showMatriz());

			String a="", b="";
			int d=0;
			while(ingreso != 5){
				System.out.println("\n\n\n1. Agregar una conexion\n2. Eliminar una conexion\n3. Encontrar centro del grafo\n4. Mostrar las distancias mas cortas y la matriz de adyacencia final\n5. Salir");
				try{
					ingreso = scan.nextInt();
					if(ingreso == 1){
						d=0;
						scan.nextLine();
						System.out.println("Ingrese la primera ciudad");
						a =scan.nextLine();
						System.out.println("Ingrese la segunda ciudad");
						b =scan.nextLine();
						System.out.println("Ingrese la distancia entre estos");
						while (d==0){
							try{
								d=scan.nextInt();
								
								if(d == 0){
									System.out.println("La distancia ingresada no puede ser 0");	
								}else{
									grafo.add(a, b, d);
									System.out.println("Conexion ingresada de manera correcta");
									
								}

							}catch(Exception e){
								System.out.println("No ha ingresado un numero");
							}
							scan.nextLine();
						}
						
						
					}else if(ingreso == 2){
						scan.nextLine();
						System.out.println("Ingrese la primera ciudad");
						a =scan.nextLine();
						System.out.println("Ingrese la segunda ciudad");
						b =scan.nextLine();
						
						System.out.println(grafo.deleteEdge(a,b));

						
						
					}else if(ingreso == 3){
						myAdy = mat.crearMatriz(grafo);
						fl.shortestPath(myAdy, grafo);
						myAdy = fl.getMatriz();
						System.out.println(c.encontrarCentro(myAdy, grafo));
					}else if(ingreso == 4){
						myAdy = mat.crearMatriz(grafo);
						System.out.println("\n"+fl.shortestPath(myAdy, grafo));
					}else if(ingreso == 5){
						System.out.println("Fue un gusto atenderle");
					}else{
						System.out.println("El valor ingresado no esta entre 1 y 5");
					}
				}catch(Exception e){
					System.out.println("El valor ingresado no es valido");
				}
			}
			
			


		}
		catch(Exception e){
			System.out.println("El archivo 'guategrafo' no existe");
		}

	}
}