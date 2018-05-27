package exercise13_part1;

import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OO15FileFinderTest fft = new OO15FileFinderTest();
        FileFinderTest();
    }

    public static void FileFinderTest() {
        try {            
            String goal = "FileFinder.java";
//            String goal = "goal.txt";
            String root = "C://";
            FileFinder ff = new FileFinder(root);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
            System.out.println("Done");
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }
}
