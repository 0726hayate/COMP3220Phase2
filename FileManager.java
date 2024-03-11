import java.util.ArrayList;

public class FileManager {
    private ArrayList<File> files = new ArrayList<File>();
    private int numFiles;
    private String path;
    

    public String changePath(String pathname) {
        this.path = pathname;
        return this.path;
    }
    

    
    //why?
    public File newFile() {
        File file = new File();
        files.add(file);
        numFiles++;
        return file;
    }
    
    //why?
    public void deleteFile(File delete) {
        files.remove(delete);
        numFiles--;
    }
    
    //why?
    public File renameFile(File toRename, String newName) {
        toRename.setFileName(newName);
        return toRename;
    }
    
    //why?
    public int sizeOf(File file) {
        return (int) file.getFileSize();
    }
    
    public  getContent(){
      
    }


}

