/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocknrollbingonetbeans;

import com.mpatric.mp3agic.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Jeff
 */
public class NewJFrame extends javax.swing.JFrame {

    SimpleMediaPlayer media;
    TreeSet<String> artistNames;
    File dir;
    //String currentFileName = "C:\\Users\\Jeff\\Desktop\\BarAndBingoStuff\\RockNRollBingo\\Bingo mp3s itunes\\Alanis Morissette - Everything.mp3";
    ArrayList<String> fileNames;
    boolean isPaused;
    boolean newGameStarted;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        fileNames = new ArrayList<String>();
        isPaused = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        artistNameTextbox = new javax.swing.JTextArea();
        startNewRoundButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        selectFolderButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        fileChooser.setApproveButtonText("Select Folder");
        fileChooser.setCurrentDirectory(null);
        fileChooser.setDialogTitle("Select Folder With Clips For This Game");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        artistNameTextbox.setColumns(20);
        artistNameTextbox.setRows(5);
        jScrollPane1.setViewportView(artistNameTextbox);

        startNewRoundButton.setText("Start New Round");
        startNewRoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startNewRoundButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        resumeButton.setText("Resume Current Round");
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        selectFolderButton.setText("Select Folder for MP3 clips");
        selectFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFolderButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startNewRoundButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pauseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resumeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectFolderButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectFolderButton)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startNewRoundButton)
                        .addGap(18, 18, 18)
                        .addComponent(pauseButton)
                        .addGap(18, 18, 18)
                        .addComponent(resumeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startNewRoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startNewRoundButtonActionPerformed
        // TODO add your handling code here:
        if (media != null) media.close();
        newGameStarted = true;
        isPaused = false;
        artistNames = new TreeSet<String>();
        Collections.shuffle(fileNames);
        doPlayingAndListing();
    }//GEN-LAST:event_startNewRoundButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        // TODO add your handling code here:
        isPaused = false;
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        // TODO add your handling code here:
        media.close();
        isPaused = true;
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void selectFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFolderButtonActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == fileChooser.APPROVE_OPTION) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            dir = fileChooser.getCurrentDirectory();
            File file = fileChooser.getSelectedFile();
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".mp3");
                }
            });

            for (File thisFile : files) {
                fileNames.add(thisFile.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_selectFolderButtonActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea artistNameTextbox;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton resumeButton;
    private javax.swing.JButton selectFolderButton;
    private javax.swing.JButton startNewRoundButton;
    // End of variables declaration//GEN-END:variables

    private void doPlayingAndListing(){
        new Thread() {
            public void run() {
                String lastFileName = null;
                for (int songNum = 0; songNum < fileNames.size(); songNum++) {
                    if (isPaused) {
                        songNum--;
                    }
                    while (isPaused) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        };
                        String currentFileName = fileNames.get(songNum);
                      
                        if (lastFileName != null && songNum > 0) {
                            if(lastFileName != fileNames.get(songNum-1)) {
                                return;
                            }
                    }
                        if (media != null) {
                            media.close();
                    }
                        media = new SimpleMediaPlayer(currentFileName);
                        media.play();
                        try {
                            //Grab artist name when media plays
                            Mp3File mp3tag = new Mp3File(currentFileName);
                            if (!mp3tag.hasId3v2Tag()) {
                                artistNames.add(currentFileName.replace(dir.getPath()+"\\", "") + "(Track Missing ID3V2 Tag)");
                            } else {
                                artistNames.add(mp3tag.getId3v2Tag().getArtist());
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedTagException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidDataException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        
                        artistNameTextbox.setText(artistNames.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
                        artistNameTextbox.validate();
                        
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (songNum == 0){
                            newGameStarted = false;
                        }
                            if (!isPaused)
                            lastFileName = currentFileName;
                        
                    }
                }
            
        }.start();
        
    }
}
