
import java.util.Scanner;

public class Castigos {

    private Player players;
    private Retos retos;

    public Castigos(Player players, Retos retos) {
        this.players = players;
        this.retos = retos;
    }

    private void esRetado(int puntos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(retos.retoDado());
        System.out.println("Ha cumplido(Y/N): ");
        String hizo = scanner.nextLine();
        if (hizo.equals("Y") || hizo.equals("y")) {
            System.out.println("Felicidades");
            this.players.setPosicion(players.getPosicion() + 1);

            this.players.cumpleReto(puntos);
        } else {
            System.out.println("Que pena");
            this.players.setPosicion(players.getPosicion() - 5);
        }

    }

    public void paga() {
        Scanner scanner = new Scanner(System.in);
        int puntos = ((int) (Math.random() * (50))) + 1;
        System.out.println("Paga " + puntos + " puntos para no hacer (Y/N): ");
        String hizo = scanner.nextLine();
        if (hizo.equals("Y") || hizo.equals("y")) {
            System.out.println("Que pena");
            this.players.disminuirCash(puntos);
        } else {
            System.out.println("Has sido retado");
            this.esRetado(puntos);
        }
    }

}
