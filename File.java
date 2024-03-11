import java.util.*;

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


    public static void main(String[] args) {
        Field content = new Field();

        // adding the FID field with values
        List<Object> fid_values = Arrays.asList(0, 1, 2, 3);
        List<Object> list = new ArrayList<>(fid_values);
        content.addField("FID", list);

        // adding the arena field with values
        List<Object> arena_values = Arrays.asList("Capri Pizzeria Recreation Complex", "Adie Knox Arena", "Forest Glade Arena", "WFCU Centre");
        list = new ArrayList<>(arena_values);
        content.addField("ARENA", list);

        // adding the address field with values
        List<Object> address_values = Arrays.asList("2555 Pulford St", "1551 Wyandotte St W" , "3205 Forest Glade Dr", "8787 McHugh St");
        list = new ArrayList<>(address_values);
        content.addField("ADDRESS", list);

        // adding the x field with values
        List<Object> x_values = Arrays.asList(-83.035508601, -83.0531282837 , -82.9150971889, -82.9276320926);
        list = new ArrayList<>(x_values);
        content.addField("X", list);

        // adding the y field with values
        List<Object> y_values = Arrays.asList(42.2579203855, 42.3068279246, 42.3042142342, 42.3187335808);
        list = new ArrayList<>(y_values);
        content.addField("Y", list);

        File file = new File("Arenas", content);
        System.out.println(file.getContent().getFieldNames());

        //get the number of columns and rows
        System.out.println(file.numberOfColumns());
        System.out.println(file.numberOfRows());

        // printing the contents of the file
        for(int i=0; i<file.numberOfColumns(); i++){
            System.out.format("%-25s",content.getColumns().get(i));
        }

        System.out.println();

        for(int i=0; i<file.numberOfRows(); i++){
            System.out.format("%-24s %-24s %-24s %-24s %-24s\n", content.getValues("FID").get(i), content.getValues("ADDRESS").get(i),
                    content.getValues("X").get(i), content.getValues("Y").get(i), content.getValues("ARENA").get(i));
        }

    }

}
