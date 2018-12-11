package showcatalog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Написать программу, которая создает текстовый файл и записывает в него список файлов из заданного каталога.
 * Программа запускается с параметром: имя каталога.
 *
 * Информацию о файлах записывать следующим образом:
 *
 * информация по каждому файлу записывается с новой строки и содержит:
 * путь к файлу, имя файла, дата создания файла.
 */
public class ShowCatalog {


    public static void main(String[] args) {


        String nameCatalog;

        System.out.println("Введите имя каталога: ");

        Scanner inputCatalogName = new Scanner(System.in);

        nameCatalog = inputCatalogName.nextLine();

        File[] files = new File(nameCatalog).listFiles();

        File fileResult = new File("result.txt");

        BasicFileAttributes attributesFile = null;

        try(FileWriter fileWriter = new FileWriter(fileResult)){

        for (int i = 0; i<files.length; i++){

            Path path = files[i].toPath();

            attributesFile = Files.readAttributes(path,BasicFileAttributes.class);

            fileWriter.write("Путь к файлу: " + files[i].getPath() +" Имя файла: " +files[i].getName() + " Дата создания: "+ attributesFile.creationTime() + "\n");
        }

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
