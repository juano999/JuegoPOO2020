
 // @author carl-
import java.util.ArrayList;


 
public class Tablero {
    private int tamanio;
    private ArrayList<Player> players;

    public Tablero(int tamanio, ArrayList<Player> players) {
        this.tamanio = tamanio;
        this.players = players;
    }
    
    public void printTable() {
        System.out.println("Casilla| Jugador| Orden");
        for(int i = 0; i <= tamanio; i++) {
            System.out.println(i + "      |");
        }
    }

    @Override
    public String toString() {
        return "Tablero de " + this.tamanio + " casillas \n Players: " + this.players ;
    }
    
    
    
    
}
