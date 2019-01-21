/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threat_verifier2.Message;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class MessageController implements Initializable {

    @FXML
    private ToggleGroup option;
    @FXML
    private JFXRadioButton SenderAddress;
    @FXML
    private JFXRadioButton Subjects;
    @FXML
    private TextArea textarea;
    @FXML
    private RadioButton MobileNo;
    @FXML
    private RadioButton RegLine;
    @FXML
    private RadioButton FaceBook;
    @FXML
    private RadioButton Twitter;
    @FXML
    private RadioButton Instagram;
    @FXML
    private RadioButton Others;
    @FXML
    private ToggleGroup email;
    @FXML
    private JFXRadioButton EmailBtn;
    @FXML
    private JFXRadioButton TxtBtn;
    @FXML
    private JFXRadioButton SocialBtn;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private AnchorPane paner;
   
    @FXML
    private AnchorPane statusPane;
    @FXML
    private Text status;
    @FXML
    private ImageView img;
    @FXML
    private Label count;
    @FXML
    private TextField SubjectEmailHolder;
    @FXML
    private JFXButton scanEmail;
    @FXML
    private JFXButton ScanText;
    @FXML
    private JFXButton scanSocial;
    @FXML
    private JFXButton closePaner;
    @FXML
    private JFXButton close1;
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
    private JFXRadioButton Address;
    @FXML
    private JFXRadioButton SubjectsandAddress;
    @FXML
    private TextField SubjectEmailHolder1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stridePane.setVisible(false);
           SubjectEmailHolder.setVisible(false);
        SubjectEmailHolder1.setVisible(false);
      SubjectsandAddress.setOnAction(e->{
           if(SubjectsandAddress.isSelected() == true){
         Subjects.setSelected(true);
         Address.setSelected(true);
         SubjectEmailHolder1.setVisible(true);
           SubjectEmailHolder.setVisible(true);
           SenderAddress.setSelected(false);
         }
     });
       Address.setOnAction(e->{
               if(Subjects.isSelected() == true || SubjectsandAddress.isSelected() == true || !Subjects.isSelected() == true || !SubjectsandAddress.isSelected() == true){
                  Subjects.setSelected(false);
                   SubjectsandAddress.setSelected(false);
                   Address.setSelected(true);
                    SubjectEmailHolder1.setVisible(true);
                    SubjectEmailHolder.setVisible(false);
                    SenderAddress.setSelected(false);
         }
     });
         Subjects.setOnAction(e->{
           if(Address.isSelected() == true || SubjectsandAddress.isSelected() == true || !Address.isSelected() == true || !SubjectsandAddress.isSelected() == true){
         Address.setSelected(false);
         SubjectsandAddress.setSelected(false);
          Subjects.setSelected(true);
           SubjectEmailHolder.setVisible(true);
           SubjectEmailHolder1.setVisible(false);
           SenderAddress.setSelected(false);
         }
     });
        closePaner.setOnAction(e->{
           barChart.getData().clear();
           paner.setVisible(false);
        });
        paner.setVisible(false);
        scanEmail.setVisible(false);
                ScanText.setVisible(false);
                scanSocial.setVisible(false);
                
              EmailBtn.setOnAction(e->{
                  if(EmailBtn.isSelected()){
                     scanEmail.setVisible(true);
                ScanText.setVisible(false);
                scanSocial.setVisible(false);
                 SubjectEmailHolder1.setVisible(false);
                    SubjectEmailHolder.setVisible(false);
                  }
              });
               TxtBtn.setOnAction(e->{
                  if(TxtBtn.isSelected()){
                      SubjectEmailHolder1.setVisible(false);
                    SubjectEmailHolder.setVisible(false);
                     scanEmail.setVisible(false);
                ScanText.setVisible(true);
                scanSocial.setVisible(false);
                  }
              });
                SocialBtn.setOnAction(e->{
                  if(SocialBtn.isSelected()){
                      SubjectEmailHolder1.setVisible(false);
                    SubjectEmailHolder.setVisible(false);
                     scanEmail.setVisible(false);
                ScanText.setVisible(false);
                scanSocial.setVisible(true);
                  }
              });
             
        close1.setOnAction(e->{
            barChart.getData().clear();
         statusPane.setVisible(false);  
      });
     
       
        SenderAddress.setOnAction(e->{
           if(SenderAddress.isSelected() == true){
               SubjectEmailHolder.setVisible(false);  
               SubjectEmailHolder1.setVisible(false);
               Subjects.setSelected(false);
               Address.setSelected(false);
               SubjectsandAddress.setSelected(false);
           }
        });
     
    }    

    private String ranger(int min , int max){
       double range =  min + (int)(Math.random() * ((max - min) + 1));
       String ka = String.format("%.0f" , range);
       return (ka +"%");
    }
    @FXML
    private void scanEmail(ActionEvent event) {
        statusPane.setVisible(false);
         if(textarea.getText().isEmpty()){
                 
             }else{
               
         if(SenderAddress.isSelected() || Address.isSelected()){
             String grabIt = SubjectEmailHolder.getText().toLowerCase();
                String grabIt1 = SubjectEmailHolder1.getText().toLowerCase();
                 double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do",
                         "cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
             if(b.contains(element) || grabIt.contains(element) || grabIt1.contains(element)){
             a++;
             found = true;
             String aa = String.format("%.0f", a);
             count.setText(aa);
     }
              if(found){
                  paner.setVisible(true);
              statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
                      }
if(!found){
    paner.setVisible(true);
    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
          
                }
           }
    if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
       showStride("YES","YES","YES","NO","YES","NO");
       // stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
       showStride("YES","NO","YES","YES","YES","YES");
      //  stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
       showStride("YES","YES","YES","YES","YES","NO");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
        showStride("NO","NO","YES","NO","YES","NO");
        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(10 , 20));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","NO","NO","YES","NO","NO");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(10 , 20));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
       showStride("YES","NO","NO","YES","NO","NO");
       // stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
           
                }
}else if(Subjects.isSelected() || SubjectsandAddress.isSelected()){
    paner.setVisible(true);
                String grabIt = SubjectEmailHolder.getText().toLowerCase();
                String grabIt1 = SubjectEmailHolder1.getText().toLowerCase();
                double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     
                 String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do","cashier check","certified check","bnkofamerica","profile","ATM","voucher","yahoo","we will pay you"};
             
                   boolean found =false;
                
           for(String element:baba){
               if(b.contains(element) || grabIt.contains(element) || grabIt1.contains(element)){
                    a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
                     paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
             
               }
               if(!found ){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }
           }
                   if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
       showStride("YES","YES","YES","NO","YES","NO");
      //  stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
       showStride("YES","NO","YES","YES","YES","YES");
        //stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
       showStride("YES","YES","YES","YES","YES","NO");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
        showStride("NO","NO","YES","NO","YES","NO");
    //    stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","NO","NO","YES","NO","NO");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
       showStride("YES","NO","NO","YES","NO","NO");
    //    stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
            }
            
                }
            
    }
    }

    @FXML
    private void scanText(ActionEvent event) {
        statusPane.setVisible(false);
         if(textarea.getText().isEmpty()){
         }else{
         if(MobileNo.isSelected()){
                 double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do",
                         "cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                   a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
              statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
              paner.setVisible(true);
           
           showStride("NO","NO","YES","NO","YES","NO");
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 

            showStride("NO","NO","YES","NO","YES","NO");
                }
                }
            if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
       showStride("YES","YES","YES","NO","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
        showStride("YES","YES","NO","YES","YES","YES");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
     showStride("YES","YES","NO","YES","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
        showStride("YES","NO","NO","NO","NO","NO");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","YES","NO","NO","NO","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
      showStride("NO","YES","NO","NO","NO","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
            
                
            }
            }else if(RegLine.isSelected()){
                double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach",
                         "bit.do","cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                    a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
                     paner.setVisible(true);
              statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
             
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }
           }
                   if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
       showStride("YES","YES","YES","NO","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
       showStride("YES","NO","YES","YES","YES","YES");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
       showStride("YES","YES","YES","YES","YES","NO");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
        showStride("NO","NO","YES","NO","YES","NO");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","NO","NO","YES","NO","NO");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 60));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
       showStride("YES","NO","NO","YES","NO","NO");//
    //    stridePane.setVisible(true);
        ThreatAccessment.setText("45%");
        ThreatIdentification.setText(ranger(10 , 20));  
              }
            
                }
            }
    }
    }

    @FXML
    private void scanSocial(ActionEvent event) {
        statusPane.setVisible(false);
        if(textarea.getText().isEmpty()){
                 
             }else{
         if(FaceBook.isSelected()){
             
                 double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do",
                         "cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                   a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
                     paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
              
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }   
                }
           if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(60 , 23 ,40 ,59, 14);
     showStride("YES","YES","NO","YES","YES","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 60));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
        showStride("YES","YES","NO","YES","YES","YES");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 60));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
       showStride("YES","YES","NO","YES","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 60));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
       showStride("NO","NO","NO","YES","NO","YES");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
    showStride("NO","YES","NO","NO","NO","NO");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
       showStride("NO","YES","NO","YES","NO","NO");
  //      stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
           }
             
            }else if(Twitter.isSelected()){
                double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do"
                             ,"cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                    a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
                     paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
             
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }
                }
              if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
     showStride("YES","YES","NO","NO","YES","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
        showStride("YES","YES","NO","NO","YES","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
        showStride("YES","YES","NO","YES","YES","NO");
  //      stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
      showStride("NO","YES","NO","NO","NO","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","YES","NO","NO","NO","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
      showStride("NO","YES","NO","NO","NO","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
           }
            }else if(Instagram.isSelected()){
                double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do",
                         "cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                    a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                 if(found){
                     paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
             
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }
                }
             if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
    showStride("NO","YES","YES","NO","YES","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
       showStride("YES","YES","NO","YES","NO","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
      showStride("YES","YES","NO","YES","NO","YES");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
       showStride("NO","YES","NO","NO","NO","NO");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("YES","NO","NO","YES","NO","NO");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
      showStride("YES","NO","NO","YES","NO","NO");
     //   stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
           }
            }else if(Others.isSelected()){
                double a = 0;
                 String b = textarea.getText().toLowerCase();
               
                     String[] baba = {"lucy.cs.wisc.edu","http","walmat shopper","email","username","password","attach","bit.do",
                         "cashier check","certified check","bnkofamerica","profile","atm","voucher","yahoo","we will pay you"};
        boolean found =false;
           for(String element:baba){
               if(b.contains(element)){
                   a++;
                   found = true;
                   String aa = String.format("%.0f", a);
                    count.setText(aa);
               }
                if(found){
                    paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have NOT been sent by the sender ");
              img.setImage(new Image("/images/icons8_High_Importance_96px.png")); 
             
               }
               if(!found){
                   paner.setVisible(true);
                    statusPane.setVisible(true);
              status.setText("This message may have been sent by the sender ");
              img.setImage(new Image("/images/owk.png")); 
                }
                 if(found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
        showChart(60 , 23 ,40 ,59, 14);
       showStride("YES","YES","YES","NO","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
               if(rand == 2){
                 showChart(87 , 15 ,35 ,87, 20);
       showStride("YES","NO","YES","YES","YES","YES");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
                if(rand == 3){
                 showChart(79 , 20 ,20 ,70, 30);
       showStride("YES","YES","YES","YES","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(40 , 80));  
              }
           }
            if(!found){
               int rand = (int)(Math.random()* 3 + 1);
             if(rand == 1){
                 showChart(23 , 89 ,78 ,24, 76);
        showStride("NO","NO","YES","NO","YES","NO");
 //       stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
               if(rand == 2){
                 showChart(30 , 67 ,78 ,25, 67);
       showStride("NO","NO","NO","YES","NO","NO");
   //     stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
                if(rand == 3){
                 showChart(20 , 56 ,89 ,20, 67);
       showStride("YES","NO","NO","YES","NO","NO");
//        stridePane.setVisible(true);
        ThreatAccessment.setText(ranger(40 , 80));
        ThreatIdentification.setText(ranger(10 , 20));  
              }
           }
            }
        }
        }
    }
    private void showChart(int g,int h,int i,int j,int k){
        paner.setVisible(true);
           XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data(" ", g));
        set1.getData().add(new XYChart.Data("  ",h));
        set1.getData().add(new XYChart.Data("   ", i));
        set1.getData().add(new XYChart.Data("     ", j));
        set1.getData().add(new XYChart.Data("      ", k));
        barChart.getData().addAll(set1);
       
        
        
    }
    private void showStride(String a,String b,String c,String d,String e,String f){


        spo.setText(a);
        tam.setText(b);
        repu.setText(c);
        infodisco.setText(d);
        denial.setText(e);
        elevation.setText(f);
//        stridePane.setVisible(true);   
    }
    }

