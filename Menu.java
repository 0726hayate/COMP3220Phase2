import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    FileManager database;
    DownloadManager downloader;
    public Menu(FileManager database, DownloadManager downloader) {

        this.database = database;
        this.downloader = downloader;

        JFrame frame = new JFrame("City of Windsor Open Data");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon("src/img.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        frame.getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        contentPane.add(backgroundLabel, BorderLayout.CENTER); // Add the background label to the center of the content pane
        contentPane.setOpaque(false); // Make content pane non-opaque

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Download");
        JMenuItem menuItem1 = new JMenuItem("Select File");
        JMenuItem menuItem2 = new JMenuItem("Exit");

        // Set font and size for menu items
        Font menuFont = new Font("Arial", Font.PLAIN, 20); // Adjust the font and size as needed
        menuItem1.setFont(menuFont);
        menuItem2.setFont(menuFont);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a list of available files
                ArrayList<String> availableFiles = getAvailableFiles(); // Get available files
                String selectedFile = (String) JOptionPane.showInputDialog(
                        frame,
                        "Select a file to download:",
                        "Select File",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        availableFiles.toArray(),
                        null);

                if (selectedFile != null) {
                    // If a file is selected, prompt for the download format
                    String format = JOptionPane.showInputDialog(frame, "Enter the file format (.txt, .doc, .csv):");
                    if (format != null) {
                        ArrayList<String> allowedFormats = new ArrayList<>();
                        allowedFormats.add(".txt");
                        allowedFormats.add(".doc");
                        allowedFormats.add(".csv");

                        if (allowedFormats.contains(format)) {
                            try {
                                downloadFile(selectedFile, format);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid format. Please enter one of the following: .txt, .doc, .csv");
                        }
                    }
                }
            }
        });

        menuItem2.addActionListener(new ActionListener() {
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

    // method to get available files names
    private ArrayList<String> getAvailableFiles() {
        ArrayList<String> files = new ArrayList<>();
        for (int i = 0; i < database.getNumFiles(); i++) {
            ArrayList<File> allFiles = database.getFiles();
            files.add(allFiles.get(i).getFileName());
        }
        return files;
    }

    // Dummy method to handle file download
    private void downloadFile(String fileName, String format) throws IOException {
        downloader.downloadAs(format, database, 0);
        JOptionPane.showMessageDialog(null, "Downloading " + fileName + format + " format.");
    }
}
