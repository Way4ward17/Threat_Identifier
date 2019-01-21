/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threat_verifier2.Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setNode(Node node){
        pane.getChildren().clear();
        pane.getChildren().add((Node)node);
     
        
        
        //FADE TRANSITION
        FadeTransition ft = new FadeTransition();
       ft.setDuration(Duration.seconds(3));
       ft.setNode(node);
       ft.setFromValue(0.1);
       ft.setToValue(1);
       ft.setCycleCount(1);
       ft.setAutoReverse(false);
       ft.play();
    }
    public void createPage(AnchorPane pane,String loc) throws IOException{
       pane = FXMLLoader.load(getClass().getResource(loc)); 
       setNode(pane);
    }
    @FXML
    private void app(ActionEvent event) throws IOException{
         this.createPage(pane, "/threat_verifier2/App/App.fxml");
    }
  @FXML
    private void message(ActionEvent event) throws IOException{
         this.createPage(pane,"/threat_verifier2/Message/Message.fxml");
    }
     @FXML
    private void source(ActionEvent event) throws IOException{
         this.createPage(pane, "/threat_verifier2/Source/Source.fxml");
    }
    @FXML
    private void quiz(ActionEvent event) throws IOException{
      this.createPage(pane, "/About/About.fxml");
     
    }
 
}
