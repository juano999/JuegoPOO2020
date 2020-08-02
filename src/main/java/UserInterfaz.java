import java.util.Scanner;
import java.util.ArrayList;
public class UserInterfaz {
    private Scanner scanner;
    private ArrayList<Player> players;
    private int tamanio;
    private Movimiento mover;
    private Retos retos;
    public UserInterfaz(){
        this.scanner = new Scanner(System.in);
        this.players = new ArrayList<>();
        this.tamanio =20;
        this.mover = new Movimiento();
        this.retos = new Retos();
        
    }
    
    public void start(){
        this.retos.initRetos();
        while (true) {
            System.out.print("Name(Vacio para terminar): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("Figura: ");
            String fig = scanner.nextLine();
            fig=fig.substring(0,1);

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
                int posicion = jugador.getPosicion();
                int puntos = retos.getQuantifier(posicion) * 2;
                Player dueno = tablero.owner(posicion);
//                System.out.println(dueno.getName());
                if (dueno.getName().equals("Banco")) {
                    
                    System.out.println(jugador.getName() + " ¿Deseas comprar esta Casilla?");
                    System.out.println("Usted tiene " +  jugador.getCash() + " puntos");
                    System.out.println("Costo: " + puntos + " puntos y " + retos.getExercise(posicion));
                    System.out.print("(Y/N) ");
                    String hizo = scanner.nextLine();
                    if (hizo.equals("Y") || hizo.equals("y")) {
                        if(jugador.getCash() >= puntos) {
                           jugador.compra(posicion);
                        jugador.disminuirCash(puntos); 
                        } else {
                            System.out.println("NO tienes suficietes puntos para comprar esta Casilla!");
                            System.out.println("OK! Pero debes cumplir con " + retos.getExercise(posicion));
                        }
                        
                    } else {
                        System.out.println("OK! Pero debes cumplir con " + retos.getExercise(posicion));
                    }
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                } else {
                       System.out.println("El dueño de esta casilla es " + dueno.getName());
                       System.out.println("Se te restará " + puntos + "puntos");
                       jugador.disminuirCash(puntos);
                       dueno.addCash(puntos);
                }
                
                printPoints(players);
                System.out.println("Enter para continuar...");
                scanner.nextLine();
                for(Player otherPlayer: players) {
                    if(otherPlayer.getCash() < 0) {
                        System.out.println("EL JUEGO SE TERMINÓ..");
                        wait(2000);
                        finalizar = true;
                    }
                }
                
                
            }
    }
        //asigna al jugador ganador
        Player win = players.get(0);
        for (Player jugador : players) {
            if (win.getCash() < jugador.getCash()) {
                win = jugador;
            }
        }
        System.out.print("Gana: " + win.toString());

    }
    
    // Puntuaciones de los jugadores
    public  void printPoints(ArrayList<Player> players) {
        for (int i =0; i<players.size(); i++) {
            System.out.println(players.get(i).getName()+ "| " +  players.get(i).getCash() + " puntos" );  
        }
    }      
    //Metodo para que el programa espere un tiempo      
    public  void wait(int microSec) {
        try {
            Thread.sleep(microSec);
        } catch (Exception ex) {

        }
    }
    
}
