import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * menu class that will show a visual menu for the user to make selections
 *
 * @author Liam MacKenzie and Vu
 * @version 1.1
 * @since March 8th 2024
 */
public class Menu {
    FileManager database; // will be the fileManager for the system
    DownloadManager downloader; // will be the download manager for our system

    /**
     * on instance of a menu we will set up the JFrame and menu
     * @param file
     * @param path
     * @param content
     */
    public Menu(String file, String path, Field content) {

        database = new FileManager();
        database.newFile(file, content);
        database.changePath(path);

        downloader = new DownloadManager();
        downloader.selectToDownload(path);

        // title the jframe and size it
        JFrame frame = new JFrame("City of Windsor Open Data");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set background image
        ImageIcon backgroundImage = new ImageIcon("src/img.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        frame.getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(backgroundLabel, BorderLayout.CENTER);
        contentPane.setOpaque(false);

        // set up the selections in the menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Download");
        JMenuItem menuItem1 = new JMenuItem("Select File");
        JMenuItem menuItem2 = new JMenuItem("Exit");

        // set font and size for menu items
        Font menuFont = new Font("Arial", Font.PLAIN, 24);
        menuItem1.setFont(menuFont);
        menuItem2.setFont(menuFont);


        menuItem1.addActionListener(new ActionListener() {
            /**
             * when the user clickes on the download button it will get a list of avalable files and check the format of what they wish to download
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // show a list of available files
                ArrayList<String> availableFiles = getAvailableFiles(); // get available files
                String selectedFile = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select a file to download:",
                        "Select File",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        availableFiles.toArray(),
                        null);

                // once the user has selected on of the options
                if (selectedFile != null) {
                    String format = JOptionPane.showInputDialog(frame, "Enter the file format (.txt, .doc, .csv):");
                    //get the format the user wishes to download
                    if (format != null) {
                        ArrayList<String> allowedFormats = new ArrayList<>();
                        allowedFormats.add(".txt");
                        allowedFormats.add(".doc");
                        allowedFormats.add(".csv");
                        //check if its one of the following avalible options and if it is then attempt to download
                        if (allowedFormats.contains(format)) {
                            try {
                                downloadFile(selectedFile, format);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        // if its not one of the specified formats
                        else {
                            JOptionPane.showMessageDialog(frame, "Invalid format. Please enter one of the following: .txt, .doc, .csv");
                        }
                    }
                }
            }
        });
        // the exit option in the menu
        menuItem2.addActionListener(new ActionListener() {
            /**
             * when the user clickes on this button it will exit and close the program
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.addSeparator();
        menuBar.add(menu);

        // Set font and size for menu
        menu.setFont(menuFont);
        menuBar.setFont(menuFont);

        frame.setJMenuBar(menuBar); // Add menu bar to the frame

        frame.setVisible(true);
    }

    /**
     * will give our menu a list of the avalable files
     * @return a list of the avalible files in our system that the user can pick from
     */
    private ArrayList<String> getAvailableFiles() {
        ArrayList<String> files = new ArrayList<>();
        for (int i = 0; i < database.getNumFiles(); i++) {
            ArrayList<File> allFiles = database.getFiles();
            files.add(allFiles.get(i).getFileName());
        }
        return files;
    }

    /**
     * will download your file in another file of which you specify
     * @param fileName the name of the file that you wish to download
     * @param format the type extension of the format in which you want to download
     * @throws IOException to catch the exseption thrown by downloader
     */
    private void downloadFile(String fileName, String format) throws IOException {
        downloader.downloadAs(format, database);
        JOptionPane.showMessageDialog(null, "Downloading " + fileName + format + " format.");
    }
}
