package copyfile;

import java.io.File;

public class AppMain {

    public static void main(String[] args) {
        CopyFile.copyFile(new File("files/task01.txt"), "copyfile.txt");

    }
}
