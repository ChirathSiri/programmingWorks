package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader
{
    public IOFile readData(String fileName)
    {
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        try
        {
            fi = new FileInputStream( new File( fileName ) );
            oi = new ObjectInputStream( fi );

            // Write objects to file
            IOFile ioFile1 = (IOFile ) oi.readObject(  );
            System.out.printf( "file successfully written." );
            return ioFile1;
        }
        catch( IOException | ClassNotFoundException e )
        {

            System.out.println("Please enter correct file name" );
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                if( oi != null )
                {
                    oi.close();
                }

                if( fi != null )
                {
                    fi.close();
                }
            }
            catch( IOException e )
            {
                System.out.println( "file connection close was unsuccessful!" );
            }
        }
    }
}
