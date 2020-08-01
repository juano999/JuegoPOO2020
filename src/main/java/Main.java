
import java.util.ArrayList;
import java.util.Scanner;

// @author carl-
public class Main {

    public static void main(String[] args) {
        Movimiento mover = new Movimiento();
        Retos retos = new Retos();
        retos.initRetos();
        //inicializa a los jugadores y tabla
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int tamanio = 20;
       
        //Inresa los Jugadores
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("Figura: ");
            String fig = scanner.nextLine();

            Player jugador = new Player(name, fig);
            if (!players.contains(jugador)) {
                players.add(jugador);

            } else {
                System.out.println("El nombre o la figura ya ha sido elegido, intente otro");
            }
        }
        
        
        Tablero tablero = new Tablero(tamanio, players);
        System.out.println("Tablero creado con la siguiente informacion:");
        System.out.println(tablero);
        wait(2500);
        System.out.println("");
        tablero.print(retos);
        
        
        //comienza el juego
        boolean finalizar = false;
        while (!finalizar) {
            for (Player jugador : players) {
                
                System.out.println("Turno de: " + jugador.getName());

                int numAdvances = mover.avanzar(tamanio - jugador.getPosicion(), jugador);
                wait(3000);
                if (numAdvances == -1)// cuanto se mueve
                {
                    jugador.setPosicion(0);
                } else {
                    jugador.setPosicion(numAdvances + jugador.getPosicion());
                }
                
                for(Player anyPlayer : players) {
                    if(anyPlayer.getCash() <= 0) {
                        break;
                    }
                }

                tablero.print(retos);
                
                System.out.println(jugador.getName() + " ¿Deseas comprar esta Casilla?");
                int posicion = jugador.getPosicion();
                int puntos = retos.getQuantifier(posicion) * 2;
                System.out.println("Costo: " + puntos + " puntos y " + retos.getExercise(posicion));
                String hizo = scanner.nextLine();
                if (hizo.equals("Y") || hizo.equals("y")) {
                    
                    jugador.disminuirCash(puntos);
                } else {
                    System.out.println("OK! Pero debes cumplir con " + retos.getExercise(posicion));
                }
                System.out.println("Presione enter para continuar...");
                scanner.nextLine();
            }
        }
        
        
        
        
        //cuadro ganador
        Player win = players.get(0);
        for (Player jugador : players) {
            if (win.getCash() < jugador.getCash()) {
                win = jugador;
            }
        }
        System.out.print("Gana: " + win.toString());

    }

    public static void wait(int microSec) {
        try {
            Thread.sleep(microSec);
        } catch (Exception ex) {

        }
    }

    
}
