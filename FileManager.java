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
        toRename.setName(newName);
        return toRename;
    }
    
    //why?
    public int sizeOf(File file) {
        return (int) file.length();
    }
    

    
 public static void main(String[] args){
         System.out.println("hello");
        
        File file1 = new File(){};
    file1.fileContent = "XXX Street, XXXX";
        File file2 = new File(){};
    file2.fileContent = "XXX Street2, XXXX";
        File file3 = new File(){};
    file3.fileContent = "XXX Street3, XXXX";
        File file4 = new File(){};
    file4.fileContent = "XXX Street4, XXXX";
    // selectToDownload(file1) is called;
    
    FileManager manager1 = new FileManager(){};
    manager1.files.add(file1);
    manager1.files.add(file2);
    manager1.files.add(file3);
    manager1.files.add(file4);

for(int i=0; i<4; i++){
    System.out.println(manager1.files.get(i));
}


}
}

