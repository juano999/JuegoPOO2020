
 // @author carl-
 
public class Player {
    private String name;
    private int cash;

    public Player(String name) {
        this.name = name;
        this.cash = 100;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
    
    public void addCash(int aumento) {
        this.cash += aumento;
    }
    public void disminuirCash(int decremento) {
        if(this.cash >= decremento) {           
            this.cash -= decremento;
        } else {
            System.out.println("No tiene dinero");
        }
    }

    @Override
    public String toString() {
        return  this.name;
    }
    
    
    
    
    
    
}
