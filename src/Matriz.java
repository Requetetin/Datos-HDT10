/* Martin Amado */
/* 19020 */
/* Matriz.java */
/* Encargada de realizar la matriz de adyacencia */

import java.util.*;

public class Matriz{
	public long [] [] crearMatriz(DiGraph d){
		long mAdy[][] = new long [d.getVertex().size()] [d.getVertex().size()];
		ArrayList<String> vertices = d.getVertex();
		for(int i=0; i<vertices.size(); i++){
			System.out.println("Los vertices numerados son: "+ (i+1)+" "+vertices.get(i));
		}
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

		System.out.println("\n\nLa matriz de adyacencia inicial es:");
		for(int i=0; i<vertices.size(); i++){
			for(int j=0; j<vertices.size();j++){
				System.out.print("["+mAdy[i][j]+"]");
			}
			System.out.println();
		}


		return mAdy;
	}
}