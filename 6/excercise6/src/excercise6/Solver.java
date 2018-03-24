/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Solver {

    PriorityQueue<Configuration> toExamine;
    HashMap<Integer, Configuration> visited;

    boolean solvable;

    public Solver(Configuration g) {
        solvable = ((SlidingGame) g).isSolvable();
        visited = new HashMap<>();
        toExamine = new PriorityQueue<>();
        toExamine.add(g);
    }

    /**
     * Solves the current configuration. The returned goal contains its parent,
     * which in turn contains it parent etc. up till the root node.
     * @return 
     */
    public Configuration solve() {

        if (!solvable) {
            System.out.println("This puzzle cannot be solved");
        }

        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            visited.put(next.hashCode(), next);
            if (next.isSolution()) {
                System.out.println("Succes");
                return next;
            } else {
                for (Configuration succ : next.successors()) {
                    if (!visited.containsKey(succ.hashCode())) {
                        toExamine.add(succ);
                    }
                }
            }
        }
        System.out.println("Failure");
        return null; 
    }

}
