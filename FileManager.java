import java.util.*;


public class FileManager {
    private ArrayList<File> files = new ArrayList<File>();
    private String path;
    private int numFiles;

    public String changePath(String pathname) {
        this.path = pathname;
        return this.path;
    }

    public String getfilePath(){
        return path;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public File newFile(String fileName, Field content) {
        File file = new File(fileName, content);
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


