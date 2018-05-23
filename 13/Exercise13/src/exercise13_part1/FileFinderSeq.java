package exercise13_part1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinderSeq {

    private final File rootDir;

    public FileFinderSeq(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
    }

    public void findFile(String file) {
        System.out.println("finding file");

        FileRun fr = new FileRun(rootDir, file);
        Thread t = new Thread(fr);
        t.start();
    }
}
