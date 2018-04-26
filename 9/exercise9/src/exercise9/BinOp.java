/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.function.BinaryOperator;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public enum BinOp implements BinaryOperator<Boolean> {
    AND("/\\") {
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 && a2;
        }
    },
    OR("\\/") {
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 || a2;
        }
    },
    IF("=>") {
        public Boolean apply(Boolean a1, Boolean a2) {
            return !a1 || a2;
        }
    };

    public final String string;

    private BinOp(String string) {
        this.string = string;
    }

}
