
 // @author carl-
import java.util.ArrayList;


 
public class Tablero {
    private int tamanio;
    private ArrayList<Player> players;
    private ArrayList<Integer> casillasTrampa;
    public static int CONT_SPACES = 0;


    public Tablero(int tamanio, ArrayList<Player> players) {
        this.tamanio = tamanio;
        this.players = players;
        
    }
    

    public void print(Retos lista){//imprime el tablero
        System.out.println("# |PLAYERS       Retos");
        for(int i = 0; i <= tamanio; i++) {
            if (i < 10){
                System.out.print(i + " |");
            } else {
                System.out.print(i + "|");
            }
            this.printPlayerLine(i);
            System.out.println(blankSpaces() + "|    " + lista.getRetos().get(i));
            System.out.println("");
        }
        
    }
    private void printPlayerLine( int indice){//imorime a los jugadores
        this.CONT_SPACES = 0;
        for(Player jugador:players){
            if(jugador.getPosicion()==indice){
                System.out.print(" "+jugador.getFigura());
                this.CONT_SPACES++;
            }
                
        }
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
