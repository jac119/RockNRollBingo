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
        NewJFrame jframe = new NewJFrame();
    }

    @Override
    public void start(Stage stage) throws Exception {
        NewJFrame jframe = new NewJFrame();
        jframe.setVisible(true);
    }
}
