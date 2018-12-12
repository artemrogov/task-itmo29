package copyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static  void copyFile(File file, String nameFile){

        File copydFile = new File(nameFile);

        try(FileInputStream fileCurrent = new FileInputStream(file);
            FileOutputStream outFile = new FileOutputStream(copydFile)
        ){
            int count;

            byte[] sourceFile = new byte[fileCurrent.available()];

            while((count = fileCurrent.read(sourceFile))>0){

                outFile.write(sourceFile,0,count);
            }
        }catch (IOException o){
            o.printStackTrace();
        }
    }
}
