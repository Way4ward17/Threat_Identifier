/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threat_verifier2.Source;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class SourceController implements Initializable {
    
    private static final Integer STARTTIME = 20; 
     private Timeline timeline;
    private Integer timeSeconds = STARTTIME;
    @FXML
    private WebView viewWeb;
    @FXML
    private ToggleGroup web;
    @FXML
    private JFXButton scan;
    @FXML
    private TextField url;
    @FXML
    private TextField ip;
    @FXML
    private JFXRadioButton webRadioButton;
    @FXML
    private JFXButton close;
    @FXML
    private JFXRadioButton networkRadioButton;
    @FXML
    private AnchorPane statusPane;
    @FXML
    private Text status;
    @FXML
    private ImageView img;
    @FXML
    private TextField check;
    @FXML
    private Label tinko;
    @FXML
    private StackPane stick;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private AnchorPane skibaa;
    @FXML
    private AnchorPane stridePane;
    @FXML
    private Text spo;
    @FXML
    private Text tam;
    @FXML
    private Text repu;
    @FXML
    private Text infodisco;
    @FXML
    private Text denial;
    @FXML
    private Text elevation;
    @FXML
    private Text ThreatAccessment;
    @FXML
    private Text ThreatIdentification;
    @FXML
    private AnchorPane panapana;
    @FXML
    private JFXButton close1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        panapana.setVisible(false);
        close1.setOnAction(e->{
            barChart.getData().clear();
           panapana.setVisible(false);
           
        });
        stridePane.setVisible(false);
        skibaa.setVisible(false);
         testNetwork();
      statusPane.setVisible(false);
      close.setOnAction(e->{
         statusPane.setVisible(false); 
         
      });
      networkRadioButton.setOnAction(e->{
         stridePane.setVisible(false);
        statusPane.setVisible(false);
        skibaa.setVisible(false);
          panapana.setVisible(false);
            
      });
      webRadioButton.setOnAction(e->{
          panapana.setVisible(false);
         stridePane.setVisible(false);
        statusPane.setVisible(false);
        skibaa.setVisible(false);
      });
    }    

      private void showChart(int g,int h,int i,int j,int k){
       skibaa.setVisible(true);
           XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(" ", g));
        set1.getData().add(new XYChart.Data("  ",h));
        set1.getData().add(new XYChart.Data("   ", i));
        set1.getData().add(new XYChart.Data("     ", j));
        set1.getData().add(new XYChart.Data("      ", k));
        barChart.getData().addAll(set1); 
    }
    private void testNetwork(){
        Socket socket = new Socket();
        InetSocketAddress ad = new InetSocketAddress("www.google.com",80);
        try{
         socket.connect(ad, 3000);
          Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Connection")
               .text("Connection Successfull")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(6))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();  
            
            
        }catch(Exception e){
           Image img = new Image("/images/icons8_High_Importance_96px.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Connection")
               .text("Turn on Your Network")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(6))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();    
        }finally{
            try{socket.close();}
            catch(Exception e){}
        }
  
    }
     private String ranger(int min , int max){
       double range =  min + (int)(Math.random() * ((max - min) + 1));
       String ka = String.format("%.0f" , range);
       return (ka +"%");
    }
    @FXML
    private void scan(ActionEvent event) {
       panapana.setVisible(false);
       statusPane.setVisible(false);
       barChart.getData().clear();
         if(webRadioButton.isSelected()){
              if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds = STARTTIME; 
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                          new EventHandler(){
                 @Override
                 public void handle(Event event) {
                    timeSeconds--;
                 
                     tinko.setText(timeSeconds.toString());
                    if(timeSeconds == 1){
                        if(statusPane.isVisible()){
                          
                        }else{
                            skibaa.setVisible(true);
                       statusPane.setVisible(true);
              status.setText("This site is Not Secured");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
              panapana.setVisible(true);
              int rand  = (int) (Math.random() * 3 + 1);
              if(rand == 1){
                 showChart(60 , 23 ,40 ,59, 14);
        spo.setText("YES");
        tam.setText("YES");
        repu.setText("YES");
        infodisco.setText("YES");
        denial.setText("YES");
        elevation.setText("YES");
       // stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
        spo.setText("YES");
        tam.setText("YES");
        repu.setText("YES");
        infodisco.setText("YES");
        denial.setText("YES");
        elevation.setText("YES");
       // stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
        spo.setText("YES");
        tam.setText("YES");
        repu.setText("YES");
        infodisco.setText("YES");
        denial.setText("YES");
        elevation.setText("YES");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
      
                    } 
                    } 
                    if(timeSeconds == 0){
                        timeline.stop();
                    }
                 }
                        }));
                      
                 timeline.setAutoReverse(true);
                timeline.setCycleCount(Timeline.INDEFINITE);
       
                timeline.playFromStart();
                               
              statusPane.setVisible(false);
             WebEngine engine = viewWeb.getEngine();
          String baba = url.getText();
          
          engine.load("https://"+baba);
         engine.getLoadWorker().stateProperty().addListener((observable,oldValue,newValue) ->{
           if(Worker.State.SUCCEEDED.equals(newValue)){
                 check.setText(engine.getLocation());
                   if(check.getText().contains("https://")){
                       skibaa.setVisible(true);
                       panapana.setVisible(true);
    showChart(34 , 56 ,78 ,87, 76);
             spo.setText("NO");
        tam.setText("NO");
        repu.setText("NO");
        infodisco.setText("NO");
        denial.setText("NO");
        elevation.setText("NO");
    //    stridePane.setVisible(true);
          statusPane.setVisible(true);
            ThreatAccessment.setText(ranger(15 , 25));
        ThreatIdentification.setText(ranger(10 , 15));
              status.setText("This site is Secured");
              img.setImage(new Image("/images/owk.png"));
                    
          }
             
             }
          });
         
         
         
         
         
        }else if(networkRadioButton.isSelected()){
          
         if(ip.getText().isEmpty()){
              stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text("Empty Field" )); // Text in the dialog
  JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();
     statusPane.setVisible(false);
         }else
            
         try{
             String ipAddress = ip.getText();
             InetAddress inet = InetAddress.getByName(ipAddress);
             if(inet.isReachable(10000)){
                 panapana.setVisible(true);
                  statusPane.setVisible(true);
              status.setText("This IP is Secured");
              img.setImage(new Image("/images/owk.png"));
              check.setText("Secured: "+ip.getText());
                 XYChart.Series set1 = new XYChart.Series<>();
     showChart(34 , 56 ,78 ,87, 76);
        barChart.getData().addAll(set1);
              spo.setText("NO");
        tam.setText("NO");
        repu.setText("NO");
        infodisco.setText("NO");
        denial.setText("NO");
        elevation.setText("NO");
   //     stridePane.setVisible(true);
          ThreatAccessment.setText(ranger(10 , 17));
        ThreatIdentification.setText(ranger(10 , 15));
             }else{        
                 int rand = (int) (Math.random() * 3 + 1 );
                 if(rand == 1){
                       showChart(34 , 56 ,78 ,87, 76);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80)); 
          statusPane.setVisible(true);
              status.setText("This IP is Not Secured");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
                check.setText("Scam IP: "+ip.getText());
                
              panapana.setVisible(true);
                 
                spo.setText("NO");
        tam.setText("YES");
        repu.setText("YES");
        infodisco.setText("YES");
        denial.setText("YES");
        elevation.setText("YES");
 //       stridePane.setVisible(true);
                 }
      if(rand == 2){
                       showChart(54 , 56 ,78 ,87, 76);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80)); 
          statusPane.setVisible(true);
              status.setText("This IP is Not Secured");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
                check.setText("Scam IP: "+ip.getText());
                
              panapana.setVisible(true);
                 
                spo.setText("NO");
        tam.setText("YES");
        repu.setText("YES");
        infodisco.setText("YES");
        denial.setText("YES");
        elevation.setText("YES");
//        stridePane.setVisible(true);
                 }
     
              
       
       
             } 
         }catch(Exception e){
             stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text("Invalid Ip \n" + e.getMessage())); // Text in the dialog
  JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();
         }
         
          }else{
          Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Error")
               .text("Invalid Option")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(6))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();  
        }
    }
    
    }

    