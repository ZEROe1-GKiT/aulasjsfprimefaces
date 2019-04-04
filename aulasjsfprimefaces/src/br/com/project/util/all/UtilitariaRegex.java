package br.com.project.util.all;

public class UtilitariaRegex {
	
	public String retiraAcentos(String string) {
		String aux = new String(string);
		aux = aux.replaceAll("[àáâäÀÁÂÄ]", "a");
		aux = aux.replaceAll("[èeêëÈÉÊË]", "e");
		aux = aux.replaceAll("[ìíîïÌÍÎÏ]", "i");
		aux = aux.replaceAll("[òóôöÒÓÔÖ]", "o");
		aux = aux.replaceAll("[ùúûüÙÚÛÜ]", "u");
		return aux;
	}

}
