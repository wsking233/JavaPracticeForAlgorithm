package noiseremoving;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

/**
 *
 * @author William Wang
 * @StudnetID 18017970
 *
 * This class is used to create the GUI for the noise removing program. Will be
 * new in the main method of the NoiseRemoving class to show the GUI.
 *
 *
 */
public class App {

    // frame and panel
    private JFrame frame;
    private JPanel Panel;
    // buttons
    private JButton openButton;
    private JButton processButton;
    private JButton saveButton;
    // other components
    private JFileChooser fileChooser;
    private File selectedFile;
    BufferedImage image;
    private JLabel imageLabel;

    private ImageProcess imageProcess;

    public App() {
        this.frame = new JFrame("Image Noise Remover");
        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null); // set the frame to the center of the screen

        this.imageLabel = new JLabel();
        this.imageLabel.setSize(600, 400);

        this.selectedFile = null;
        this.image = null;
        this.imageProcess = null;
        this.fileChooser = new JFileChooser(System.getProperty("user.dir")); // set the default directory to the current
        // directory

        // Open image button:
        this.openButton = new JButton("Open Image");
        this.openButton.addActionListener((ActionEvent e) -> {
            int stateImageFileChooser = fileChooser.showOpenDialog(frame);
            if (stateImageFileChooser == JFileChooser.APPROVE_OPTION) {

                selectedFile = fileChooser.getSelectedFile();
                try {
                    image = ImageIO.read(selectedFile);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(frame, exception.getMessage());
                }
                if (image != null) { // check if image is not null before setting the icon
                    imageLabel.setIcon(new ImageIcon(image));
                    frame.setSize(image.getWidth() + 10, image.getHeight() + 100);
                }
            }
        } // add action listener to the buttons
        // this button is used to open file chooser to select image
        );

        // Process image button:
        this.processButton = new JButton("Remove Noise");
        this.processButton.addActionListener((ActionEvent e) -> {
            // this button is used to process the image
            // if the image is not opened, then show error message
            // if the image is opened, then process the image
            if (image == null) {
                JOptionPane.showMessageDialog(null, "Please open an image first!");
            } else {
                imageProcess = new ImageProcess(selectedFile.getPath());
                imageProcess.cleanNoise();
                image = imageProcess.buffered_image;
                imageLabel.setIcon(new ImageIcon(image));
                frame.setSize(image.getWidth() + 10, image.getHeight() + 100);
            }
        });

        // Save image button:
        this.saveButton = new JButton("Save Image");
        this.saveButton.addActionListener((ActionEvent e) -> {
            // this button is used to save the image
            // if the image is not processed, then save the original image
            // if the image is processed, then save the processed image
            if (imageLabel.getIcon() == null) {
                JOptionPane.showMessageDialog(null, "Please open an image first!");
            } else {
                // imageProcess.save("noise_removed.jpg");
                // imageLabel.setIcon(null);
                int stateImageFileChooser = fileChooser.showSaveDialog(frame);
                if (stateImageFileChooser == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write(image, "jpg", saveFile);
                        JOptionPane.showMessageDialog(null, "Image saved!");
                        image = null;  //clear the image a
                        imageLabel.setIcon(null);   // clear the image label after the image is saved.
                    } catch (IOException exception) {
                        // exception.printStackTrace();
                        JOptionPane.showMessageDialog(frame, exception.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No image to save!");
                }
            }
        });

        // add buttons to the panel
        this.Panel = new JPanel();
        this.Panel.add(this.openButton);
        this.Panel.add(this.processButton);
        this.Panel.add(this.saveButton);
        // add panel to the frame
        this.frame.add(this.Panel, BorderLayout.NORTH);
        this.frame.add(this.imageLabel, BorderLayout.CENTER);
        this.frame.setVisible(true);    // set the frame to be visible
    }

}
