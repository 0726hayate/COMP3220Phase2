import java.io.FileWriter;
import java.io.IOException;

/**
 * Download manager that is responsible for downloading the requested file in the specified available file formats
 * @author Samarveer Manku
 * @version 1.1
 * @since March 11 2024
 */

public class DownloadManager {
    private String fileToDownload;

    /**
     * Specify file to download
     * @param fileName file that user wants to download
     */
    public void selectToDownload(String fileName) {
        fileToDownload = fileName;//create file
    }

    /**
     * Get the file format from user and download it as that file
     * @param fileType File extension the user requested
     * @param files    File manager with all available files used that will be used to get file content to download
     * @throws IOException FileWriter needs to throw an I/O exception if it fails write into the specified file
     */
    public void downloadAs(String fileType, FileManager files) throws IOException {
        files.changePath(fileToDownload);
        String name = files.getFile().getFileName();
        File file = files.getFile();
        Field content = file.getContent();
        name = name + fileType;

        FileWriter w = new FileWriter(name);
        String columns[] = new String[file.numberOfColumns()];
        String fileContent = "";
        // printing the contents of the file
        for (int i = 0; i < file.numberOfColumns(); i++) {
            fileContent += String.format("%-25s", content.getColumns().get(i));
            if (fileType.equals(".csv")) {
                fileContent += ",";
            }
            columns[i] = content.getColumns().get(i);
        }

        fileContent += "\n";


        for (int i = 0; i < file.numberOfRows(); i++) {
            for (int j = 0; j < file.numberOfColumns(); j++) {
                fileContent += String.format("%-24s ", content.getValues(columns[j]).get(i));
                if (fileType.equals(".csv")) {
                    fileContent += ",";
                }
            }
            fileContent += "\n";
        }

        w.write(fileContent);
        w.close();
    }
}
