/**
 * File class represents an individual file that contains information regarding a given dataset
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Mar-11-24
 */
public class File {
    private String fileName;
    private int fileSize = 0;
    private String fileContent;
    private Field field;

    /**
     * default constructor
     */
    public File(){
        this.fileName = "sample-file.txt";
        this.fileContent = "";
        this.field = null; // no field assigned yet
    }

    /**
     * overloaded constructor: add parameters yourself
     * @param fileName the name of the file
     * @param fileContent the content of the file in string
     * @param field the field associated with the file
     */
    public File(String fileName, String fileContent, Field field){
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.field = field;
        this.fileSize = fileContent.length();
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
     * getter for fileContent
     * @return fileContent
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * setter for fileContent
     * @param fileContent the content of the file
     */
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    /**
     * getter for field
     * @return field
     */
    public Field getField() {
        return field;
    }

    /**
     * setter for field
     * @param field the field associated with the file
     */
    public void setField(Field field) {
        this.field = field;
    }
}
