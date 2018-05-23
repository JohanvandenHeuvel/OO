/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13_part1;

import java.io.File;

/**
 *
 * @author johan
 */
public class FileRun implements Runnable {
    
    final File rootDir;
    final String fileName;

    public FileRun(File rootDir, String fileName) {
        this.rootDir = rootDir;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    //New Thread here
                    FileRun fr = new FileRun(file, fileName);
                    Thread t = new Thread(fr);
                    t.start();
                }
            }
        }
    }

}
