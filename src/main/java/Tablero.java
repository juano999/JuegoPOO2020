
 // @author carl-
import java.util.ArrayList;


 
public class Tablero {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private int tamanio;
    private ArrayList<Player> players;
    private ArrayList<Integer> casillasTrampa;
    public static int CONT_SPACES = 0;


    public Tablero(int tamanio, ArrayList<Player> players) {
        this.tamanio = tamanio;
        this.players = players;
        
    }
    

    public void print(Retos lista){//imprime el tablero
        System.out.println(ANSI_PURPLE + "# |PLAYERS       Retos [propietario]" + ANSI_WHITE );
        for(int i = 0; i <= tamanio; i++) {
            if (i < 10){
                System.out.print(i + " |");
            } else {
                System.out.print(i + "|");
            }
            this.printPlayerLine(i);
            System.out.println(blankSpaces() + "|    " + lista.getRetos().get(i) + ANSI_CYAN + " [" + owner(i).getName() + "]" + ANSI_WHITE );
            System.out.println("");
        }
        
    }
    private void printPlayerLine( int indice){//imorime a los jugadores
        this.CONT_SPACES = 0;
        for(Player jugador:players){
            if(jugador.getPosicion()==indice){
                System.out.print(ANSI_GREEN + " "+jugador.getFigura());
                this.CONT_SPACES++;
            }
                
        }
    }
  
    public Player owner(int posicion) {
        Player newJugador = new Player("Banco", ".");
        
        for ( Player owner : this.players) {
            if (owner.casillasCompradas.contains(posicion)) {
                newJugador = owner;
                break;
            }
        }
        return newJugador;
    }
    
    public String blankSpaces() {
        String spaces = "";
        for(int i = this.players.size(); i >= CONT_SPACES; i--) {
            spaces += "  ";
        } 
        return spaces;
    }
    @Override
    public String toString() {
        return "Tablero de " + this.tamanio + " casillas \n Players: " + this.players ;
    }
    
    
    
    
}
