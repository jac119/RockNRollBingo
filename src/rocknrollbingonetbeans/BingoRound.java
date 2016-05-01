/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocknrollbingonetbeans;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Jeff
 */
public class BingoRound {
    SimpleMediaPlayer media;
    TreeSet<String> artistNames;
    File dir;
    //String currentFileName = "C:\\Users\\Jeff\\Desktop\\BarAndBingoStuff\\RockNRollBingo\\Bingo mp3s itunes\\Alanis Morissette - Everything.mp3";
    ArrayList<String> fileNames;
    boolean isPaused;
    boolean newGameStarted;
    JTextArea artistNameTextbox;
    private boolean isEnded;
    JLabel nowPlayingText;
    public BingoRound(File directory,ArrayList<String> fileNamesIn, JTextArea textbox, JLabel nowPlaying){
    if (media != null) media.close();
        newGameStarted = true;
        isPaused = false;
        artistNames = new TreeSet<String>();
        fileNames = fileNamesIn;
        Collections.shuffle(fileNames);
        doPlayingAndListing();
        artistNameTextbox = textbox;
        dir = directory;
        isEnded = false;
        nowPlayingText = nowPlaying; 
}
    
    public void doPlayingAndListing(){
        new Thread() {
            public void run() {
                String lastFileName = null;
                for (int songNum = 0; songNum < fileNames.size(); songNum++) {
                    if (isPaused) {
                        songNum--;
                    }
                    while (isPaused) {
                        try {
                            if(isEnded) return;
                            //TODO: if Ended, print to .txt backup file, in case of accidental click?
                            TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(BingoJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        };
                        String currentFileName = fileNames.get(songNum);
                                              
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
                                
                                nowPlayingText.setText(currentFileName.replace(dir.getPath()+"\\", ""));
                            } else {
                                artistNames.add(mp3tag.getId3v2Tag().getArtist());
                                nowPlayingText.setText(mp3tag.getId3v2Tag().getArtist() + " - " + mp3tag.getId3v2Tag().getTitle());
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(BingoJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedTagException ex) {
                            Logger.getLogger(BingoJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidDataException ex) {
                            Logger.getLogger(BingoJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        
                        artistNameTextbox.setText(artistNames.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
                        artistNameTextbox.validate();
                        
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BingoJFrame.class.getName()).log(Level.SEVERE, null, ex);
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

    void Pause() {
        media.close();
        isPaused = true;    }
    void Resume(){
        isPaused = false;
    }

    void End() {
        Pause();
        isEnded = true;
        
    }
}
