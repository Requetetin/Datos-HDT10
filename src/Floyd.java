/* Martin Amado */
/* 19020 */
/* Floyd.java */
/* Encargado de recibir y separar la base de datos del txt */
import java.util.*;
public class Floyd{
	ArrayList<String> vertex;
	Centro c = new Centro();
	long matrizAdyacencia[][];
	public String shortestPath(long [] [] mAdy, DiGraph d){
		int vertices = mAdy.length;
		matrizAdyacencia= mAdy;
		vertex = d.getVertex();

		String caminos [] [] = new String [vertices] [vertices];
		String caminosAuxiliares[] [] = new String [vertices] [vertices];
		String caminoRecorrido = "", cadena = "", caminitos = "";
		int i, j, k;
		float temporal1, temporal2, temporal3, temporal4, minimo;
		for(i=0; i<vertices;i++){
			for(j=0;j<vertices;j++){
				caminos [i] [j] = "";
				caminosAuxiliares [i] [j] ="";
			}
		}

		for(k=0; k<vertices;k++){
			for(i=0; i<vertices;i++){
				for(j=0; j<vertices;j++){
					temporal1 = matrizAdyacencia [i][j];
					temporal2 = matrizAdyacencia [i][k];
					temporal3 = matrizAdyacencia [k][j];
					temporal4 = temporal2 + temporal3;

					minimo = Math.min(temporal1, temporal4);

					if(temporal1 != temporal4){
						if(minimo == temporal4){
							caminoRecorrido = "";
							caminosAuxiliares[i][j] = k +"";
							caminos[i][j] = caminosR(i, k, caminosAuxiliares,caminoRecorrido)+vertex.get(k);
						}
					}

					matrizAdyacencia[i][j]=(long) minimo;
				}
			}
		}

		for(i=0; i<vertices;i++){
			for(j=0;j<vertices;j++){
				cadena = cadena+"["+matrizAdyacencia[i][j]+"]";
			}
			cadena += "\n";
		}


		for(i=0; i<vertices;i++){
			for(j=0;j<vertices;j++){
				if(matrizAdyacencia[i][j] != 100000000){
					if(i!= j){
						if(caminos[i][j].equals("")){
							caminitos += "De ("+ vertex.get(i)+"--->"+vertex.get(j)+") Irse Por... ("+vertex.get(i)+", "+vertex.get(j)+")\n";
						}else{

							caminitos += "De ("+vertex.get(i)+"--->"+vertex.get(j)+") Irse Por...("+vertex.get(i) +", "+caminos [i][j]+", "+vertex.get(j)+")\n";
						}
					}
				}
			}
		}
		c.encontrarCentro(matrizAdyacencia, d);
		return "La Matriz de Caminos mas cortos entre los lugares es: \n"+cadena+"\nLos diferentes caminos mas cortos entre vertices son:\n"+caminitos;
	}

	private String  caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido){
			if(caminosAuxiliares[i][k].equals("")){
			return "";
		}else{
			caminoRecorrido += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido)+ vertex.get(Integer.parseInt(caminosAuxiliares[i][k].toString()))+", ";
			return caminoRecorrido;
		}
	}

	public long[][] getMatriz(){
		return matrizAdyacencia;
	}
	
}