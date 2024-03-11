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
    private Field content;
    private String filePath = "./arenas-data.txt";

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
    public File(String fileName, Field content){
        this.fileName = fileName;
        this.content = content;
        this.fileSize = content.getFieldNames().size();
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
    public Field getContent() {
        return content;
    }

    /**
     * setter for file content
     * @param content the content is a list of fields
     */
    public void setContent(Field content) { this.content = content; }

    /**
     * getter for file path
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * setter for file path
     * @param filePath the path of the file
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * get number of columns of the content
     * @return the number of columns
     */
    public int numberOfColumns(){
        return content.getFieldSize();
    }

    public int numberOfRows(){
        return content.getValuesCountPerField();
    }
}
