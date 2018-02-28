/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public enum Field {
    EMPTY("."), RED("X"), YELLOW("O");

    private final String asciiString;

    private Field(String s) {
        this.asciiString = s;
    }

    //Make compare
    public Field other() {
        if (this.equals(RED)) {
            return YELLOW;
        } else if (this.equals(YELLOW)) {
            return RED;
        } else {
            return EMPTY;
        }
    }

    @Override
    public String toString() {
        return asciiString;
    }
}
