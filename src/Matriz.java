/* Martin Amado */
/* 19020 */
/* Matriz.java */
/* Encargada de realizar la matriz de adyacencia */

import java.util.*;

public class Matriz{
	long matriz[][];
	int tamano;
	public long [] [] crearMatriz(DiGraph d){
		long mAdy[][] = new long [d.getVertex().size()] [d.getVertex().size()];
		ArrayList<String> vertices = d.getVertex();
		tamano = vertices.size();
		for(int i=0; i<vertices.size(); i++){
			for(int j=0; j<vertices.size();j++){
				if(i == j){
					mAdy[i][j] = 0;
				}else{
					int c = d.findValue(vertices.get(i), vertices.get(j));
					mAdy[i][j] = c;
				}
			}
		}
		matriz = mAdy;
		


		return mAdy;
	}



	public String showMatriz(){
		String a = "";
		a+="\nLa matriz de adyacencia inicial es:\n";
		for(int i=0; i<tamano; i++){
			for(int j=0; j<tamano;j++){
				a+="["+matriz[i][j]+"]";
			}
			a+="\n";
		}
		return a;
	}
}