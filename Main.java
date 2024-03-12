import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
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

        FileManager database = new FileManager();
        database.newFile("Arenas", content);
        database.changePath("./Arenas.txt");
        DownloadManager d = new DownloadManager();
        d.selectToDownload("./Arenas.txt");
        d.downloadAs("doc", database);

        Menu menu = new Menu(database);
    }
}
