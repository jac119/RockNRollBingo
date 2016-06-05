/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocknrollbingonetbeans;

import java.util.ArrayList;

/**
 *
 * @author Jeff
 */
public class BingoCard {
    
    BingoSquare[][] card; 
    ArrayList<String> possibleArtists;
    public BingoCard(ArrayList<String> artists){
        card = new BingoSquare[5][5];
        possibleArtists = artists;
        for (int horiz = 0; horiz < 5; horiz++) {
            for(int vert = 0; vert < 5; vert++) {
                card[horiz][vert] = new BingoSquare("null");//TODO: possibleArtists.remove(random int));
            }
        }
        
    }
    
    
    private class BingoSquare{
        boolean marked;
        boolean artistPlayed; //TODO, do we need this? or we just check when we 'Call Bingo'
        String artistName;
        
        public BingoSquare(String artist){
            artistName = artist;
            marked = false;
            artistPlayed = false;
        }
        public void toggleMarked(){
            marked = !marked;
        }
    }
    
}

 