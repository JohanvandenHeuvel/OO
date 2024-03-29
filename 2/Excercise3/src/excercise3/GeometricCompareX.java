/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

import java.util.Comparator;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GeometricCompareX implements Comparator<Geometric> {
    
    @Override
    public int compare(Geometric o1, Geometric o2) {
        if(o1 == null && o2 == null){
            return 0;
        }
        if(o1 == null){
            return 1;
        }
        if(o2 == null){
            return -1;
        }
        return Double.compare(o1.getLeft(), o2.getLeft());
    }
}
