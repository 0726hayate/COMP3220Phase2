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

        printcontent(content,file);


    }

    
}


