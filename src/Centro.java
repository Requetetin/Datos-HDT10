/* Martin Amado */
/* 19020 */
/* Centro.java */
/* Encargado de encontrar el centro del grafo */

import java.util.*;

public class Centro{
	public String encontrarCentro(long [] [] mAdy, DiGraph d){
		ArrayList<Integer> maximos = new ArrayList<Integer>();
		ArrayList<Integer> temporal = new ArrayList<Integer>();
		ArrayList<String> vertex = d.getVertex();

		for(int i=0; i<mAdy.length; i++){
			for(int j=0; j<mAdy.length; j++){
				temporal.add((int)mAdy[j][i]);
			}
			Collections.sort(temporal);
			maximos.add(temporal.get(temporal.size()-1));
			temporal.clear();
		}

		ArrayList<Integer> orden = (ArrayList<Integer>) maximos.clone();
		Collections.sort(orden);
		return "\n\nEl Centro del grafo es: "+ vertex.get(maximos.indexOf(orden.get(0)));

		
	}
}