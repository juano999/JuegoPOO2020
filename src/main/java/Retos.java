//falta mejorar
import java.util.ArrayList;
public class Retos {
    private ArrayList<String> retos;
    private ArrayList<Integer> quantifier;

    public Retos() {
        this.retos = new ArrayList<>();
        this.quantifier = new ArrayList<>();
    }
    
    public void initRetos() {
        this.retos.add(" ");
        
        this.quantifier.add(0);
        String exercise[] = {"Sapitos", "Abdominales", "Sentadillas", "Flecciones de Pecho", "Burpees"};
        for(int i = 5; i <= 20; i += 5) {
            for(int j = 0; j < 5; j++) {
                this.retos.add(i + " " + exercise[j]);
                this.quantifier.add(i);
            }
        }
    }

    public ArrayList<String> getRetos() {
        return retos;
    }
    
    public String getExercise(int position) {
        return retos.get(position);
    }

    public int getQuantifier(int position) {
        return quantifier.get(position);
    }
    
    
    
    
    public void nuevoReto(String newReto){
        //añade un nuevo reto
        if(retos.size()<=30)
            this.retos.add(newReto);
    }
    
    public void quitarReto(int indice){
        retos.remove(indice);
    }
    public void quitarReto(String reto){
        retos.remove(reto);
    }
    //quita retos
    
    public String retoDado(){
        // reto al azar
       int indiceR=(int)(Math.random()*(this.retos.size()));
       return retos.get(indiceR);
    }
    
    public void  print(){
        //imorime todos los retos
        System.out.println("Los retos registrados son:");
        for(String reto:retos){
            System.out.println(reto);
            
        }
    }
     
}
