
public class Movimiento {

    private Dados dados;

    public Movimiento() {
        dados = new Dados();
    }

    public int avanzar(int espacio, Player jugador) {

        dados.tirada();
        if (dados.getSuma() <= espacio) {
            System.out.println("Te mueves " + this.dados.getSuma());
            return dados.getSuma();
        } else {//tira los dados y ve si hay espacio para moverse
        
            jugador.setPosicion(0);
            
            return dados.getSuma() - espacio;
        }

    }
}
