import java.nio.file.Path;

public class fileutilities {

    Path readme = Paths.get("src/readme.md");
    Path p = Path.createFile(readme);
    File f = p.toFile();
    // Permissions - canRead(), canWrite(), canExecute()
    // Information - isFile(), isDirectory(), length(), exists()
    // File operations - delete(), mkdir(), renameTo()

    public void readfilewithbuffer(){
        byte[] buffer = new byte[1024]; 
        int size = 0; InputStream is = new FileInputStream("myfile.txt"); 
        OutputStream os = new FileOutputStream("copy of myfile."); 
        while (-1 != (size = is.read(buffer))) 
            os.write(buffer, 0, size); 
        os.flush(); 
        os.close(); 
        is.close();
    }

}
