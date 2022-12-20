import java.util.Scanner;
import java.util.ArrayList;

public class Dados {
  public static void main(String [] args) {
    // Instanceamos el objeto propio de la clase
    Dados obj = new Dados();

    // Declaramos e inicializamos variables
    int cantDados; // La cantida de dados que va a ingresar el usuario
    // Imprimimos el mensaje por pantalla
    System.out.println("COMBINACIONES DE DADOS");
    
    Scanner leer = new Scanner(System.in); // instanceamos la clase scanner
    // para ultizar el método nextInt que obtendrá un en entero del usuario
    
    // Pedimos el ingreso por pantalla
    System.out.println("Ingrese el número de dados: ");
    
    cantDados = leer.nextInt(); // ejecutamos el método de la clase leer
    
    int[] dados = new int[cantDados]; // declaramos un arreglo con la longitud
    // de la cantidad de dados

    for (int i = 0; i < dados.length; i++) {
      dados[i] = 1; // rellenamos ese arreglo con los números 1 que serían la primera
      // combinación
    }

    obj.combinaciones(dados, "", 0); // ejecutamos el método de combinaciones
  }

  // Declaramos el método stringANumero que recibe un string y devuelve un entero
  public int stringANumero (String strNumero) {
    int numero = Integer.parseInt(strNumero);
    return numero;
  }

  // Métdo que realiza las combinaciones
  public void combinaciones(int[] dados, String suma, int tirada) {
    // Declaramos una lista que va a almacenar las combinaciones que nos interesan
    ArrayList<Integer> arregloMultiplos = new ArrayList<Integer>();

    // caso base: Si el numero de la tirada es igual a la cantidad de dados entra
    // es decir que entra cuando todos los dados se encuentran tirados
    if (tirada == dados.length) {
      // iteramos los dados sobre la mesa para ingresarlos a una variable temporal
      // que nos servirá
      for (int i = 0; i < dados.length; i++) {
        
        // Esta variable solo se va a llenar cuando la suma de los números(como cifras)
        // dividido por la cantidad de dados arroje de resto 0
        if(stringANumero(suma) % dados.length == 0) {
          String tmp = ""; 
          for(int j = 0; j < dados.length; j++) {
            tmp += dados[j];
          }
          
          // Si 
          if (stringANumero(tmp) % dados.length == 0 && !arregloMultiplos.contains(stringANumero(tmp))) {
            System.out.print(tmp + " ");
            arregloMultiplos.add(stringANumero(tmp));
          }
        }
      }
      
    } else if (tirada != dados.length) {

      for ( int i = 1; i <= 6; i++) {
        dados[tirada] = i;

        suma += i;

        combinaciones(dados, suma, tirada + 1);

        suma = "";
      }

    }
  }
}
