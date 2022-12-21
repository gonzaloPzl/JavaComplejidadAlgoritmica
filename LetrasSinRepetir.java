import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.text.Normalizer;

public class LetrasSinRepetir {
  public static void main(String[] args) throws Exception {
    // Utilizamos la estructura de datos map para tener clave y valor y así
    // poder contabilizar las apariciones
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

    // R U T A   A  M O D I F I C A R 
    String RUTA = "C:\\dev\\JavaComplejidadAlgoritmica\\secuenciaLetras.txt";

    // En este array pondremos las que no se encuentran repetidas
    ArrayList<Character> arrayNoRepetido = new ArrayList<>();
    // Declaramos e inicializamos variables
    String secuenciaLetras = ""; // string con la secuencia de letras
    int indexPrimeraNoRepetida = 0;
    int indexUltimaNoRepetida = 0;

    // instanciamos la clase File que recibe en su contructor la ruta donde tenemos
    // el archivo que queremos leer

    
    File documento = new File(RUTA);


    // Instanceamos la clase Scanner en leer que recibe la entra como parámetro
    // en este caso seria el objeto documento
    Scanner leer = new Scanner(documento);
    
    // Lee la linea con la secuencia de letras y la asigna como valor a la variable
    // tipo string secuenciaLetras
    secuenciaLetras = leer.nextLine();

    // Creamos el arreglo normalizado con nuestro método de normalizarString
    char[] arregloLetrasNormalizado = normalizarString(secuenciaLetras);

    // iteramos el arreglo de letras normalizado
    for (int i = 0; i < arregloLetrasNormalizado.length; i++) {
      // si el caracter no se encuentra en el map lo agregamos
      if(!map.containsKey(arregloLetrasNormalizado[i])) {
        map.put(arregloLetrasNormalizado[i], 1);
      // en caso de que se encuentre cambiamos su value amentandolo  
      } else {
        map.put(arregloLetrasNormalizado[i], map.get(arregloLetrasNormalizado[i]) + 1);
      }
    }

    // iteramos el map que llenamos con las letras y la cantidad de apariciones
    map.forEach(
          (k, v) -> {
              if (v == 1){ // en el caso del que el valor del key sea igual a 1 lo agregamos al array no repetido
                  arrayNoRepetido.add(k);
              }
          }
      );


    // Nos aseguramos de que haya palabras no repetidas, sino vamos directo al else
    if(arrayNoRepetido.size() >= 1) {
      // iteramos para obetener el indice de la primera no repetida
      for (int i = 0; i < arregloLetrasNormalizado.length; i++) {
        // en el caso de que el primer elemento del arreglo de caracteres
        // no repetidos sea igual al que estamos comparando en el arreglo normalizado entramos
        if(arrayNoRepetido.get(0) == arregloLetrasNormalizado[i]) {
          // le asignamos el valor de i al index de la primera no repetida
          indexPrimeraNoRepetida = i;
          // ejecutamos un break para que deje de iterar
          break;
        }
      }
      // obtenemos la posición de la última letra
      // en este caso el valor de la i será la última posición del arreglo para así poder iterarlo hacia atras
      for(int i = arregloLetrasNormalizado.length - 1; i > 0; i--) {
        // cuando haya concidencia entra
        if(arrayNoRepetido.get(arrayNoRepetido.size() - 1) == arregloLetrasNormalizado[i]) {
          // se le asigna el indice y se ejecuta el break
          indexUltimaNoRepetida = i;
          break;
        }
      }
      // Se imprimen por pantalla los resultados, agregamos 1 a los indices por la contabilidad desde 0 en programación
      System.out.println("La letra " + secuenciaLetras.charAt(indexPrimeraNoRepetida) + " en la posición "+ (indexPrimeraNoRepetida + 1) + " es la primera no repetida y la letra " + secuenciaLetras.charAt(indexUltimaNoRepetida) + " en la posición " + (indexUltimaNoRepetida + 1) + " es la última no repetida.");
    } else { // en caso de no haber palabras no repetidas
      System.out.println("No hay letras no repetidas");
    }

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
