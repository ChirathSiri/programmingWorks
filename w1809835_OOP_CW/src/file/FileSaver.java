package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileSaver {
    public boolean saveData(IOFile ioFile, String fileName)
    {
        FileOutputStream f = null;
        ObjectOutputStream o = null;
        try {
            f = new FileOutputStream(new File(fileName));
            o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(ioFile);
            System.out.printf( "file successfully written." );
        }
        catch( IOException e )
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                if( o != null ){
                    o.close();
                }

                if( f != null ){
                    f.close();
                }
            }
            catch( IOException e )
            {
                System.out.println("file connection close was unsuccessful!");;
            }
        }
        return true;
    }
}
