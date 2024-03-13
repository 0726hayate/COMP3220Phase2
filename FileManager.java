import java.util.ArrayList;

/**
 * The FileManager class provides a way to manage a collection of File objects.
 * It allows for the creation, deletion, and renaming of files, as well as the ability to change and retrieve the current path.
 *
 * @author Wei Wei
 * @version 1
 * @since Mar-10-24
 */
public class FileManager {
    private ArrayList<File> files = new ArrayList<File>();
    private String path;
    private int numFiles;

    /**
     * Changes the current path of the file manager to the specified pathname base on the user request
     *
     * @param pathname The new path to set.
     * @return The updated path.
     */
    public String changePath(String pathname) {
        this.path = pathname;
        return this.path;
    }

    /**
     * Retrieves the current file path managed by the file manager.
     * @return The current file path as a String.
     */
    public String getfilePath() {
        return path;
    }

    /**
     * Gets the number of files currently managed by the file manager.
     * @return The number of files as an integer.
     */
    public int getNumFiles() {
        return numFiles;
    }

    /**
     * Retrieves a list of all files currently managed by the file manager.
     * @return An ArrayList of File objects.
     */
    public ArrayList<File> getFiles() {
        return files;
    }

    /**
     * Retrieves a File object based on the current path of the file manager.
     * The method parses the path to extract the filename and returns the File object with a matching name.
     * @return The File object with a name matching the filename in the current path, or null if no match is found or reach the end of files 
     */
    public File getFile() {
        int index1 = path.lastIndexOf("./")+2;
        int index2 = path.lastIndexOf(".");
        String fname = path.substring(index1, index2);

        for(File f : files){
            if(f.getFileName().contentEquals(fname)){
                return f;
            }
        }
        return null;
    }

    /**
     * Creates a new File object with the given fileName and content, adds it to the files managed by FileManager, and increments the file count.
     * @param fileName The name of the file to create.
     * @param content The content to include in the file.
     * @return The newly created File object.
     */
    public File newFile(String fileName, Field content) {
        File file = new File(fileName, content);
        files.add(file);
        numFiles++;
        return file;
    }
    
    /**
     * Deletes the specified File object from the list of files managed by FileManager and decrements the file count.
     * @param delete The File object to delete.
     */
    public void deleteFile(File delete) {
        files.remove(delete);
        numFiles--;
    }
    
    /**
     * Renames the specified File object to the new name provided.
     * @param toRename The File object to rename.
     * @param newName The new name for the File.
     * @return The renamed File object.
     */
    public File renameFile(File toRename, String newName) {
        toRename.setFileName(newName);
        return toRename;
    }
}

