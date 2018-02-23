package excercise3;

/**
*  @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Excercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeometricGroup gg = new GeometricGroup(10);
        while (true) {  
            run(gg);
        }
    }
    
    public static void run(GeometricGroup gg){
        gg.commands();
    }
    
}  
