package tk.mosqitotorpedo;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        String dirPath = "/home/beau/Desktop/MoStorage"; // Path of the directory to list files from

        File dir = new File(dirPath); // Create a File object representing the directory
        File[] files = dir.listFiles(); // Obtain an array of File objects representing the files in the directory

        Arrays.sort(files, Comparator.comparing(File::getName)); // Sort the files array in alphabetical order based on file names

        for (File file : files) { // Iterate over each File object in the files array
            System.out.println(file.getName()); // Print the name of each file
        }
    }
}
