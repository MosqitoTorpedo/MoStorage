package tk.mosqitotorpedo;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter FULL path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath); // Create a File object representing the directory
        File[] files = dir.listFiles(); // Obtain an array of File objects representing the files in the directory
        List<File> emptyFiles = new ArrayList<>();

        if (files.length != 0) {

            Arrays.sort(files, Comparator.comparing(File::getName)); // Sort the files array in alphabetical order based on file names


            for (File file : files) { // Iterate over each File object in the files array
                System.out.println(file.getName()); // Print the name of each file

                if (file.length() == 0) {
                    System.out.println("\tThis file is empty");
                    emptyFiles.add(file);
                }
            }
        } else {
            System.out.println("This directory is empty");
        }

        System.out.println("\n\nDo you want to delete empty files?");
        String delFilesInput = scanner.nextLine();
        switch (delFilesInput.toLowerCase()) {
            case "yes":
                for (File file : emptyFiles) {
                    file.delete();
                    System.out.println(String.format("Deleted '%s'", file.getName()));
                }
                break;
            case "no":
                System.out.println("Ok, bye");
                System.exit(0);
        }



    }
}
