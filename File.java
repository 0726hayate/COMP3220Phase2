import java.util.*;

/**
 * File class represents an individual file that contains information regarding a given dataset
 *
 * @author Farzana Moury
 * @version 1.1
 * @since Mar-11-24
 */
public class File {
    private String fileName;
    private int fileSize = 0;
    private Map<String, List<Object>> content;

    /**
     * default constructor
     */
    public File(){
        this.fileName = "sample-file.txt";
        this.content = null;
    }

    /**
     * overloaded constructor: add parameters yourself
     * @param fileName the name of the file
     * @param content the content of the file as a list of fields
     */
    public File(String fileName, Map<String, List<Object>> content){
        this.fileName = fileName;
        this.content = content;
        this.fileSize = content.size();
    }

    /**
     * getter for fileName
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * setter for fileName
     * @param fileName the name of the file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * getter for fileSize
     * @return fileSize
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * setter for fileSize
     * @param fileSize the size of the file
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * getter for file content
     * @return content
     */
    public Map<String, List<Object>> getContent() {
        return content;
    }

    /**
     * setter for file content
     * @param content the content is a list of fields
     */
    public void setContent(Map<String, List<Object>> content) {
        this.content = content;
    }
}
