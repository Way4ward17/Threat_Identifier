
package threat_verifier2.App;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class AppController implements Initializable {

    private AnchorPane paner;
   
  
    @FXML
    private ImageView loader;
 
    @FXML
    private TextField url;

    /** 
     * Initializes the controller class.
     */
 //  final ObservableList baba =  FXCollections.observableArrayList();
    final ObservableList baba1 =  FXCollections.observableArrayList();
    @FXML
    private Text bababa;
    @FXML
    private WebView webView;
    @FXML
    private Text bravo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     loader.setVisible(false);
     
    }    

    @FXML
    private void Scan(ActionEvent event) {
        loader.setVisible(true);
         WebEngine engine = webView.getEngine();
          String baba = url.getText();
          //engine.load("http://www.imob.com/chart/top");
         engine.load("http://cve.mitre.org/cgi-bin/cvekey.cgi?keyword="+baba);
         
         engine.getLoadWorker().stateProperty().addListener((observable,oldValue,newValue) ->{
           if(Worker.State.SUCCEEDED.equals(newValue)){
               //  check.setText(engine.getLocation());
                 //  if(check.getText().contains("https://")){
            doScrapping(engine.getLocation()); 
            bravo.setText(baba);
             loader.setVisible(false);
           }
             if(Worker.State.FAILED.equals(newValue)){
              Image img = new Image("/images/owk.png");
            Notifications notificationBuilder = Notifications.create()
               .title("Error")
               .text("Nothing Found in CVE List\n\nor Poor Network")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();   
           }
        
          });
        
        
            loader.setVisible(true);
        RotateTransition rt1 = new RotateTransition();
            rt1.setCycleCount(1);
            rt1.setAutoReverse(false);
            rt1.setDuration(Duration.seconds(30));
            rt1.setFromAngle(720);
            rt1.setToAngle(0);
            rt1.setNode(loader);
         rt1.play();
         rt1.setOnFinished(e->{
             
             });
    }  
    
    /**
   public void doScrapping(String url){
  
       Document website = null;
       try{
           website = Jsoup.connect(url).get();
            Elements tbody = website.select("div#TableWithRules");
            int i = 0;
            for(Element row:tbody){ 
                i++;
              //   System.out.print(i+""+row.getElementsByTag("td").text());
              //    System.out.print(i+""+row.getElementsByTag("tr").text() +"\n");
                  baba.add(row.getElementsByTag("td").text()+"\t");
                  baba1.add(row.getElementsByTag("tr").text()+"\t");
                  code.setItems(baba);
                  desc.setItems(baba1);
            }
             System.out.println();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null ,  e);
       }
   } 
       
   
    public void doScrapping1(String url){
  
       Document website = null;
       try{
           website = Jsoup.connect(url).get();
       }catch(Exception e){
           e.printStackTrace();
       }
       Elements tbody = website.getElementsByTag("tbody");
       Elements rows = tbody.get(0).select("tr");
       for(Element row:rows){
           Elements columns = row.getElementsByTag("td");
           for(int i=1;i < 3 ; i++){
               baba.addAll(columns.get(i).text() + "\t");
               System.out.print(columns.get(i).text() + "\t");
                 code.setItems(baba);
           }
        //  baba.addAll("\n");
          System.out.println("");
       }
   }
   
**/
  public void doScrapping(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            Elements temp = doc.select("div#TableWithRules");
     
            int i = 0;
            for(Element cve : temp){
                i++;
                System.out.print(i+""+cve.getElementsByTag("a").text());
                 System.out.println("");
               //  baba.addAll(cve.getElementsByTag("a").text() + "\t");
               //  code.setItems(baba);
                 bababa.setText(cve.getElementsByTag("a").text());
            }
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }  
    
}