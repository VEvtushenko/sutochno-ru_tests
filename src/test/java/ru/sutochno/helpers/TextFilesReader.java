package ru.sutochno.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilesReader {

    public String getTextFirstString(File textDataFile) {
        try {
            return new Scanner(textDataFile).nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    public List<String> getListOfString(File textDataFile) {
        List<String> stringsList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(textDataFile);
            while (scanner.hasNext()) {
                stringsList.add(scanner.nextLine());
            }
            return stringsList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
}
