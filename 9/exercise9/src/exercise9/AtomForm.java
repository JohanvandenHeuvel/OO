/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

/**
 *
 * @author johan
 */
public class AtomForm implements Form{
    
    private String name;

    public AtomForm(String name) {
        this.name = name;
    }

    @Override
    public <R> R accept(FormVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }
    
    
    
}
