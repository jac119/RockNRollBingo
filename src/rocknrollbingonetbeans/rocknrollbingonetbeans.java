/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocknrollbingonetbeans;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jeff
 */
public class rocknrollbingonetbeans extends Application{
    public static void main(String[] args){
        BingoJFrame jframe = new BingoJFrame();
    }

    @Override
    public void start(Stage stage) throws Exception {
        BingoJFrame jframe = new BingoJFrame();
        jframe.setVisible(true);
    }
}
