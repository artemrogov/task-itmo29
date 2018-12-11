package DeletedWordsFile;
import java.io.*;
import java.util.Scanner;

/**
 * Задача 1
 * Написать программу, которая удаляет из файла все слова, содержащие заданное количество символов
 * (количество символов задается диапазоном, например 4-6).
 * Для вывода результатов создавать новую директорию и файл средствами класса File
 */

public class AppMain {

    public static void main(String[] args)  {

        int countSymbol;
        int beforeCountSymbol;

        Scanner countInput;
        Scanner countInput2;

        File dir = new File("results");

        dir.mkdir();

        File fh = new File(dir.getPath()+"/res.txt");

        try ( BufferedReader in = new BufferedReader(new FileReader("files/task01.txt"));

              FileWriter fileW = new FileWriter(fh);
              Writer out = new BufferedWriter( fileW)) {

            String line;

            String[] results = null;

            countInput = new Scanner(System.in);

            System.out.println("Введите начало диапазона: ");

            countSymbol = countInput.nextInt();

            System.out.println("Введите конец диапазона: ");

            countInput2 = new Scanner(System.in);

            beforeCountSymbol = countInput2.nextInt();

            while((line=in.readLine())!=null){

                results = line.split("[\\s,-;.]+");

                    for (String x:results){

                    StringBuilder str = new StringBuilder(x);

                    // например диапозон символов от 4 до 6

                    if (str.length() >= countSymbol && str.length()<=beforeCountSymbol) str.delete(0,str.length());

                    out.write(str + System.lineSeparator());

                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
