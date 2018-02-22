/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

import java.util.Comparator;

/**
 *
 * @author johan
 */
public class GeometricCompareX implements Comparator<Geometric> {
    
    @Override
    public int compare(Geometric o1, Geometric o2) {
        return Double.compare(o1.getLeft(), o2.getLeft());
    }
}
