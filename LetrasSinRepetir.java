import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.text.Normalizer;

public class LetrasSinRepetir {
  public static void main(String[] args) throws Exception {
    String secuenciaLetras = "";
    String primeraNoRepetida = "";
    String ultimaNoRepetida = "";
    File documento = new File("C:\\dev\\JavaComplejidadAlgoritmica\\secuenciaLetras.txt");
    Scanner leer = new Scanner(documento);
    
    while (leer.hasNextLine())
    secuenciaLetras = leer.nextLine();
    System.out.println(secuenciaLetras);
    char[] arregloLetrasNormalizado = normalizarString(secuenciaLetras);
    System.out.println(arregloLetrasNormalizado);

    for(int i = 0; i < arregloLetrasNormalizado.length; i++) {
      System.out.println(arregloLetrasNormalizado[i]);
    }
  }


  public static char[] normalizarString(String texto) {
    char[] arregloTexto = new char[texto.length()];
    texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
    texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();

    for (int i = 0; i < texto.length(); i++) {
      arregloTexto[i] = texto.charAt(i);
    }

    return arregloTexto;
}
}
