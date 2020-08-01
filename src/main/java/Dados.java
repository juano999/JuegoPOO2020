
import java.util.Scanner;

public class Dados {

    private int dado1;
    private int dado2;
    private int sumaDados;
    


    

    public void tirada() {
        int cont = 0;
        this.sumaDados = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Pulse enter para Tirar los dados");
            scanner.nextLine();
            
            //Asignar valores aleatorios entre 1 y 6 a dados
            this.dado1 = ((int) (Math.random() * (6))) + 1;
            this.dado2 = ((int) (Math.random() * (6))) + 1;
            
            
            int suma = this.dado1 + this.dado2;
            System.out.println("Sacas: \nDado1: " + this.dado1 + " Dado2: " + this.dado2 + " en total:" + suma);
            sumaDados += suma;
            if (this.dado1 == this.dado2) {
                System.out.println("Tienes Par");
                cont++;
            }

            if (cont == 2) {
                sumaDados = -1;
                System.out.println("Sacaste mas de 2 pares vuelve al principio");
                break;
            }
            if (this.dado1 != this.dado2) {
                break;
            }
        }
    }// tira dados y repite si es par

    public int getSuma() {
        return sumaDados;
    }//da la suma de los dados

}
