/*();
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13_part2;

/**
 *
 * @author johan
 */
public class MergeSeq implements Runnable {

    int[] part1, part2, dest;

    public MergeSeq(int[] part1, int[] part2, int[] dest) {
        this.part1 = part1;
        this.part2 = part2;
        this.dest = dest;
    }

    @Override
    public void run() {
        int part1Index = 0, part2Index = 0, destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index]) {
                dest[destIndex++] = part1[part1Index++];
            } else {
                dest[destIndex++] = part2[part2Index++];
            }
        }
        // copy elements when at most one of the parts contains elements
        while (part1Index < part1.length) {
            dest[destIndex++] = part1[part1Index++];
        }
        while (part2Index < part2.length) {
            dest[destIndex++] = part2[part2Index++];
        }
    }
}
