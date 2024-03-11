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
    
    public static void printcontent(Field content,File file){
        int columns = file.numberOfColumns();
        int rows = file.numberOfRows();
        for(int i=0; i<columns; i++){
            System.out.format("%-25s",content.getColumns().get(i));
        }
        System.out.println();
        for(int i=0; i<rows; i++){
            System.out.format("%-24s %-24s %-24s %-24s %-24s\n", content.getValues("FID").get(i), content.getValues("ADDRESS").get(i),
                    content.getValues("X").get(i), content.getValues("Y").get(i), content.getValues("ARENA").get(i));
        }
    }





    
}


