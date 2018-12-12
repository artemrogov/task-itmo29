package copyfilecatalog;


import java.io.File;
import java.util.Scanner;

/**
 * Задача 3
 * Написать программу, которая копирует файлы из одного каталога в другой
 * (имена каталогов задаются при запуске программы)
 */

public class CopyFileInCatalog {

   public static void main(String[] args) {

       Scanner cat1 = new Scanner(System.in);
       File targetDir = new File(cat1.nextLine());

       Scanner cat2 = new Scanner(System.in);
       File locationDir = new File(cat2.nextLine());

       CopyPasteFiles.copyFilesCatalog(targetDir, locationDir);



   }


}
