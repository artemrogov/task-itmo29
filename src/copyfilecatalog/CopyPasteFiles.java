package copyfilecatalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPasteFiles {


    public static void copyFilesCatalog(File locationCatalog, File targetLocation){

        if (locationCatalog.isDirectory()){

            if (!targetLocation.exists()){
                targetLocation.mkdir();
            }

            File[] files = locationCatalog.listFiles();

            for (File file: files){

                try (FileInputStream f1 = new FileInputStream(file);
                     FileOutputStream out = new FileOutputStream(targetLocation + "/" + file.getName())
                ){

                    byte[] sourceFiles = new byte[f1.available()];

                    int bufferSize;

                    while((bufferSize = f1.read(sourceFiles)) > 0){

                        out.write(sourceFiles, 0,bufferSize);
                    }

                }catch (IOException o){
                    o.printStackTrace();
                }
            }
        }
    }
}
