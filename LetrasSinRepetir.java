import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.text.Normalizer;

public class LetrasSinRepetir {
  public static void main(String[] args) throws Exception {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    ArrayList<Character> arrayNoRepetido = new ArrayList<>();
    // Declaramos e inicializamos variables
    String secuenciaLetras = ""; // string con la secuencia de letras
    String primeraNoRepetida = "";
    String ultimaNoRepetida = "";

    // instanciamos la clase File que recibe en su contructor la ruta donde tenemos
    // el archivo que queremos leer
    File documento = new File("C:\\dev\\JavaComplejidadAlgoritmica\\secuenciaLetras.txt");
    // Instanceamos la clase Scanner en leer que recibe la entra como parámetro
    // en este caso seria el objeto documento
    Scanner leer = new Scanner(documento);
    
    // Lee la linea con la secuencia de letras y la asigna como valor a la variable
    // tipo string secuenciaLetras
    secuenciaLetras = leer.nextLine();
    System.out.println(secuenciaLetras);

    // Creamos el arreglo normalizado con nuestro método de normalizarString
    char[] arregloLetrasNormalizado = normalizarString(secuenciaLetras);
    System.out.println(arregloLetrasNormalizado);

    for (int i = 0; i < arregloLetrasNormalizado.length; i++) {
      if(!map.containsKey(arregloLetrasNormalizado[i])) {
        map.put(arregloLetrasNormalizado[i], 1);
      } else {
        map.put(arregloLetrasNormalizado[i], map.get(arregloLetrasNormalizado[i]) + 1);
      }
    }

    System.out.println(map);

    // for(int i = 0; i < map.size(); i++) {
    //   if(map.get(i) == 1) {
    //     map.remove(arregloLetrasNormalizado[i]);
    //   }
    // }
    map.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

    // System.out.println(map);

  }

  // método para normalizar el texto devolviendo un arrego de caracteres normalizados
  public static char[] normalizarString(String texto) {
    // creamos el arreglo de caracteres con el largo del texto
    char[] arregloTexto = new char[texto.length()];
    // Ejecutamos el método normalize de la clase Normalizer importada que recibe de primer parámetro
    // el texto y de segundo parámetro una constante de normalización que provee la clase
    // lo que se logra en este paso es separar las letras de sus diacritipos así por ejemplo
    // lo acentos se separan de esta forma áB => a´B
    texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
    // Ahora debemos borrar esos diacriticos que quedaron en el nuevo texto por lo que usamos
    // el método replaceAll de los Strings que recibe de primer parámetro eso que queremos cambiar y de segundo
    // por lo que qeuremos cambiar, en este caso lo que queremos cambiar son todos los 
    // diacriticos por lo que mediante una expresión regular se los pasamos reemplazandolos
    // por ningún simbolo.
    texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();

    // iteramos el el arregloTexto agregando a cada posición el caracter correspondiente
    for (int i = 0; i < texto.length(); i++) {
      arregloTexto[i] = texto.charAt(i);
    }

    return arregloTexto;

  }
}
