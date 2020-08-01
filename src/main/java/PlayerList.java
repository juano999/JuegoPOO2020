
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList() {
        players=new ArrayList<>();
        players.add(new Player(".","."));        
    }
//    public void inicializar(){
//        Scanner scanner =new Scanner(System.in); 
//        System.out.println("Ingrese los nombres y figuras de los jugadores");
//        while(true) {
//                System.out.print("Nombre (vacio para terminar): ");
//                String name = scanner.nextLine();
//                String figura;
//                if(name.isEmpty()) {
//                    break;
//                }
//                if(!players.contains(name)){
//                    System.out.println("El nombre ya ha sido elegido, intente otro");
//                    continue;
//                }
//                while(true){
//                    System.out.print("Figura:");
//                    figura = scanner.nextLine();
//                    if (!players.contains(figura)) {
//                        System.out.println("Ya esta escogido");
//                        continue;
//                    }
//                    else
//                        break;
//                }
//                
//                players.add(new Player(name,figura));
//            }
//    }
    
}
