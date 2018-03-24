/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public interface Configuration extends Comparable<Configuration> {

    /**
     * To obtain the parent of the current configuration, i.e. the configuration
     * which had this as one of its successors
     *
     * @return a reference to the parent
     */
    public abstract Configuration parent();

    /**
     * To obtain the successors for a specific configuration
     *
     * @return a collection of configurations containing the successors
     */
    public abstract Collection<Configuration> successors();

    /**
     * For marking final / solution configurations.
     *
     * @return true if a this is a solution, false otherwise
     */
    public abstract boolean isSolution();

    /**
     * To build a path from the root configuration to the current one.
     *
     * @return a list of successive configurations from the root to 'this'
     */
    public default List<Configuration> pathFromRoot() {

        ArrayList<Configuration> path = new ArrayList<>();
        Configuration currentGame = this;
        path.add(currentGame);
        boolean hasParent = true;

        while (hasParent) {
            path.add(currentGame.parent());
            currentGame = currentGame.parent();
            if (currentGame.parent() == null) {
                hasParent = false;
            }
        }

        Collections.reverse(path);

        return path;
    }
}
