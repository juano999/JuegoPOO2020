
public class Player {
    private String name;
    private String figura;
    private int cash;
    private int posicion;
    private int retosCumplidos;

    public Player(String name, String figura) {
        this.name = name;
        this.cash = 100;
        this.figura=figura;
        this.posicion=0;
        this.retosCumplidos=0;
    }

    public String getName() {
        return name;
    }

    public String getFigura() {
        return figura;
    }

    public int getPosicion() {
        return posicion;
    }
    
    public int getCash() {
        return cash;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
        
    public void addCash(int aumento) {
        this.cash += aumento;
    }
    public void disminuirCash(int decremento) {
        if(this.cash >= decremento) {           
            this.cash -= decremento;
        } else {
            System.out.println("No tiene puntos");
        }
    }
    
    public void cumpleReto(int puntos){
        this.retosCumplidos++;
        if(this.retosCumplidos%3==0)
            this.addCash(puntos);
    }

    @Override
    public String toString() {
        return  this.name+" tiene "+this.cash+" puntos";
    }
    
    public boolean equals(Object compared) {
        // if the variables are located in the same place, they are the same.
        if (this == compared) {
            return true;
        }

        // if the object is not instance of SimpleDate, the objects are not the same
        if (!(compared instanceof Player)) {
            return false;
        }

        // let's cast the object to SimpleDate
        Player jugador = (Player) compared;

        // if the object's values are the same, the objects are the same
        if (this.name.equals(jugador.name) || this.figura.equals(jugador.figura)) {
            return true;
        }

        // other wise, the objects are not the same
        return false;
    }
    
    
    
    
}
