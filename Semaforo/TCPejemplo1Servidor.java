package Semaforo;


public class TCPejemplo1Servidor implements Runnable {
	private Portero cola;

	public TCPejemplo1Servidor(Portero cola) {
		this.cola = cola;

	}
	public TCPejemplo1Servidor() {
	}
	@Override
	public void run() {
		try {
			cola.reponer();
		} catch (InterruptedException e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}
	}
	public String run(String cadena) {
		String mensaje1 = cadena.toLowerCase();//PASAR EL TEXTO A MINUSCULA
		String mensaje2 = quitarTildes(mensaje1);//PASAR EL TEXTO SIN TILDES
		String mensaje3 = removeSpaces(mensaje2);//PASAR EL TEXTO SIN ESPACIOS
		return mensaje3;
	}
	 //METODO QUE PASAS UN STRING Y LO PASAS A UN ARRAY DE CHAR
	  //EN UN BUCLE LEE CADA CARACTER Y SI ENCUENTRA TILDE LO REMPLAZA
	  private static  String quitarTildes(String cadena) {
			char str[] = cadena.toCharArray();
			for(int c=0;c<str.length;c++) {
			if(str[c]=='á') {str[c]='a';}if(str[c]=='Á') {str[c]='A';}
			if(str[c]=='é') {str[c]='e';}if(str[c]=='É') {str[c]='E';}
			if(str[c]=='í') {str[c]='i';}if(str[c]=='Í') {str[c]='I';}
			if(str[c]=='ó') {str[c]='o';}if(str[c]=='Ó') {str[c]='O';}
			if(str[c]=='ú') {str[c]='u';}if(str[c]=='Ú') {str[c]='U';}
			}
			String cad2="";
			for(int e=0;e<str.length;e++) {
				cad2+=str[e];
			}
			return cad2;
		}
	  	//METODO QUE PASAS UN STRING Y LO SEPARA POR ESPACIOS EN UN ARRAY
	  	//HACE UN BUCLE Y PONE UN UNICO ESPACIO ENTRE LAS PALABRAS
		static String removeSpaces(String cadena)
		{
			String str = "";
	        String[] newStr = cadena.split("\\s+");
	        for (int i = 0; i < newStr.length; i++) {
	            str+=newStr[i]+" ";
	        }
			return str;
		}
}