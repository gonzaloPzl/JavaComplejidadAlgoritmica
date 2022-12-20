import java.util.Scanner;
import java.util.ArrayList;

public class Dados {
  public static void main (String [] args) {
    int cantDados = 0;
    ArrayList<Integer> dadosCombinaciones = new ArrayList<Integer>(); 
    System.out.println("dados");

    Scanner leer = new Scanner(System.in);

    System.out.println("Ingrese el número de dados: ");
    cantDados = leer.nextInt();

    System.out.println("La cantidad dedos es: " + cantDados);
    // La cantida de combinaciones es N**2

  }
}
