/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.io.File;
import javafx.stage.FileChooser;

/**
 *
 * @author xhu
 */
public class MazeApp {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Panel panel = new Panel();

        // ---------------------------------------------
        // create the menu bar to open file
        JMenuItem openFile = new JMenuItem("Open");
        JMenu menu = new JMenu("File");
        JMenuBar menuBar = new JMenuBar();

        JFileChooser fileChooser = new JFileChooser();

        menu.add(openFile); // add the open file button to the menu
        menuBar.add(menu); // add the menu to the menu bar
        frame.setJMenuBar(menuBar); // add the menu bar to the frame

        // add action listener to the open file button
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stateImageFileChooser = fileChooser.showOpenDialog(frame);
                if (stateImageFileChooser == fileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    panel.initFileManager(selectedFile.getAbsolutePath());
                    panel.repaint();
                }
            }
        });

        // ---------------------------------------------
        frame.add(panel);
        frame.setSize(700, 600);
        frame.setVisible(true);

    }

}
