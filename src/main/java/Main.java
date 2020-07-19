
import java.util.ArrayList;
import java.util.Scanner;


 // @author carl-
 
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Player> players = new ArrayList<>();
            int tamanio;
            do{
                System.out.println("Tamaño del tablero: ");
                tamanio = Integer.valueOf(scanner.nextLine());
            }while(!numValido(30, tamanio));
            
            while(true) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                if(name.isEmpty()) {
                    break;
                }
                Player jugador = new Player(name);
                if(!players.contains(jugador)) {
                    players.add(jugador);

                }else {
                    System.out.println("El nombre ya ha sido elegido, intente otro");
                }
            }
            Tablero tablero = new Tablero(tamanio, players);
            System.out.println("Tablero creado con la siguiente informacion:");
            System.out.println(tablero);
            wait(2500);
            System.out.println("");
            tablero.printTable();
    }
    
    public static void wait(int microSec) {
        try {
                Thread.sleep(microSec);
            }catch (Exception ex) {
                
            }
    }
    
    public static boolean numValido(int min, int max, int num) {
        if (num <= max && num >= min) {
            return true;
        }
        return false;
    }
    public static boolean numValido(int min, int num) {
        if (num >= min) {
            return true;
        } else {
            System.out.println("no valido!");
        }
        return false;
    }
}