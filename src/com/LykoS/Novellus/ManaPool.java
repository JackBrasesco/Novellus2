package com.LykoS.Novellus;

public class ManaPool {
	Land[] lands;
	
	int manaCipher;
	public ManaPool(Land[] l) {
		for (int i = 0; i < l.length; i++) {
			lands[i] = l[i];
		}
	}
	public int getMana() {
		int fireMana = 0;
		int waterMana = 0;
		int earthMana = 0;
		int darkMana = 0;
		int lightMana = 0;
		int nuetralMana = 0;
		for (int i = 0; i < lands.length; i++) {
			switch (lands[i].type) {
			
			case "fire" : fireMana  += fireMana;
						  break;
			case "water": waterMana += waterMana;
						  break;
			case "earth": earthMana += earthMana;
						  break;
			case "dark" : darkMana  += darkMana;
						  break;
			case "light": lightMana += lightMana;
						  break;
			case "nuetral": nuetralMana += nuetralMana;
						  break;
			
			}
		}
		int cipher = Integer.parseInt(Integer.toString(fireMana) + Integer.toString(waterMana) + Integer.toString(earthMana) + Integer.toString(darkMana) + Integer.toString(lightMana));
		return cipher;
		
	}
}