import java.util.*;


public class FileManager {
    private ArrayList<File> files = new ArrayList<File>();
    private String path;
    private int numFiles;

    public String changePath(String pathname) {
        this.path = pathname;
        return this.path;
    }
    

    public File newFile() {
        File file = new File();
        files.add(file);
        numFiles++;
        return file;
    }
    

    public void deleteFile(File delete) {
        files.remove(delete);
        numFiles--;
    }
    

    public File renameFile(File toRename, String newName) {
        toRename.setFileName(newName);
        return toRename;
    }





    
}


