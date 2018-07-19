package dotcom;

import java.util.ArrayList;

public class GameHelper {

	private static final String alphabet = "abcdefg";
	private static final String numeric = "1234567";
	
	private int gridLength = 7;			//OJO arrays van de 0 - 6
	private int comCount = 0;
	
	private ArrayList<String> listCoorDotCom;	// lista coordenadas del dotcom
	private ArrayList<String> listCoorUsed = new ArrayList<>(); 	// lista coordenadas utilizadas
	
	
	public ArrayList<String> placeDotCom (int comSize) {
		
		listCoorDotCom = new ArrayList<>();	// inicializamos la lista de coordenadas del dotcom (vacia)
		
		StringBuilder coor = new StringBuilder();
		String newCoor;
		boolean success = false;
		int rndNum;
		int rndAlpha;
		int attemps = 0;
		
		while (!success & attemps < 200) {

			rndNum = (int) (Math.random() * gridLength);
			rndAlpha = (int) (Math.random() * gridLength); 
						
			coor.setLength(0);
			coor.append(alphabet.charAt(rndAlpha));
			coor.append(numeric.charAt(rndNum));
			newCoor = coor.toString();

			int incr = 1;
			success = true;
		  
			int x = 0;
			while (success && x < comSize) {
				if (listCoorUsed.indexOf(newCoor) < 0) {
					listCoorDotCom.add(newCoor);
	
					rndNum += incr;
					
					// probamos la siguiente adyacente
					coor.setLength(0);
					coor.append(alphabet.charAt(rndAlpha));
					
					// aumentamos coordenada numerica 
					// los dotcom se van a colocar
					// a lo largo del numero y
					// de menor a mayor valor
					// OJO: no estamos desplegando dotcoms en la coordenada de letra
					if (rndNum < gridLength) {	// nos hemos pasado del grid??
						
						// NO
						coor.append(numeric.charAt(rndNum));
				    	newCoor = coor.toString();
				    	x++;
					} else {				
						// SI
						success = false;
				    	// no hemos tenido exito, limpiamos el arraylist
				    	listCoorDotCom.clear();
				    	attemps++;
					}
					
			      
			    } else {
			    	success = false;
			    	
			    	// no hemos tenido exito, limpiamos el arraylist
			    	listCoorDotCom.clear();
			    	attemps++;
			    }
		  }

		}


		// hemos colocado todos las coordenadas
		// ahora tenemos que guardarlas en la lista de utilizadas
		for (String coordinate: listCoorDotCom) {
		  listCoorUsed.add(coordinate);
		  
		  System.out.println(coordinate);	// testing
		}
		
		// devolvemos la lista de coordenadas
		return listCoorDotCom;
		
	}
}




	
	
	
	



