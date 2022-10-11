/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class NewtableController implements Initializable {
    
    

   @FXML
   TableView <Student> table;
   @FXML
   TableColumn <Student,Integer> idS;
   @FXML
   TableColumn <Student,String> fname;
   @FXML
   TableColumn <Student,String> lname;
   @FXML
   TableColumn <Student,String> tel;
   @FXML
   TableColumn <Student,String> course;
   @FXML
   TableColumn <Student,String> clas;
   
   @FXML
   TextField idT;
   @FXML
   TextField fnameT;
   @FXML
   TextField lnameT; 
   @FXML
   TextField tel1T; 
   @FXML
   TextField courseT;
   @FXML
   TextField classT;
   
   @FXML
   TextField search;
   
    int index;
   
    ObservableList<Student>list=FXCollections.observableArrayList(
    
            new Student(1, "Abdelmaksoud", "Eid", "01015864793","Software","The Third"),
            new Student(2, "Mohammad", "Fayez", "01096946204","Cloud Computing","The Third"),
            new Student(3, "Abdalla", "Shehap", "01027439388","Operating System","The Third"),
            new Student(4, "Abdalla", "Nader", "01021026981","Data Base","The Third")
    
    
    );
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchtonewtable(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("theloginpro.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void switchtotheloginpro(ActionEvent event) throws IOException
//    {
//        Parent p1 = FXMLLoader.load(getClass().getResource("theloginpro.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(p1);
//        stage.setScene(scene);
//        stage.show();
//    }
    public void sendinput()
    {
//        Integer id = Integer.parseInt(idT.getText());
//        String fname = fnameT.getText();
//        String lname = lnameT.getText();
//        String tel1 = tel1T.getText();
//        String tel2 = tel2T.getText();
        
         table.getItems().add(getdata());
        // ممكن تستخدم السطر الى اوله  تيبل او السطر الى اوله لست علشان تضيف العناصر  الى الجدول عن طريق البوتن
         //list.add(new Student(id, fname, lname, tel1, tel2));   
         
    }
   
    public void getselected()
    {
       index = table.getSelectionModel().getSelectedIndex();
       
       if(index <= -1)
       {
       return;
       }
           
       
       idT.setText(idS.getCellData(index).toString());
       fnameT.setText(fname.getCellData(index));
       lnameT.setText(lname.getCellData(index));
       tel1T.setText(tel.getCellData(index));
       courseT.setText(course.getCellData(index));
       classT.setText(clas.getCellData(index));
    }
    
    public void editstudent()
    {
        
        list.set(index,getdata());
    }
    public Student getdata()
    {
        Integer id = Integer.parseInt(idT.getText());
        String fname = fnameT.getText();
        String lname = lnameT.getText();
        String tel = tel1T.getText();
        String course = courseT.getText();
        String clas = classT.getText();
        return new Student(id, fname, lname, tel,course,clas);
    }
    
    public void deletestudendt()
    {
        if(index <= -1)
       {
       return;
       }
        
        table.getItems().remove(index);
        index = -1;
        idT.clear();
        fnameT.clear();
        lnameT.clear();
        tel1T.clear();
        courseT.clear();
        classT.clear();
    }
    public void cleartextfield()
    {
        idT.clear();
        fnameT.clear();
        lnameT.clear();
        tel1T.clear();
        courseT.clear();
        classT.clear();
    }
    
    public void searchdata()
    {
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                
                if(search.textProperty().get().isEmpty())
                {
                    table.setItems(list);
                    return;
                }
                
                ObservableList<Student> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Student,?>>column = table.getColumns();
                
                for(int row = 0 ; row<list.size() ; row++){
                 for(int col = 0 ; col<column.size() ; col++){
                    TableColumn colvar = column.get(col);
                    String cellvalue = colvar.getCellData(list.get(row)).toString();
                    cellvalue = cellvalue.toLowerCase();
                    
                    if(cellvalue.contains(search.getText().toLowerCase()) && cellvalue.startsWith(search.getText().toLowerCase())){
                        items.add(list.get(row));
                        break;
                    }
                }
                }
                table.setItems(items);
            }
        });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idS.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Student,String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Student,String>("lname"));
        tel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));
        course.setCellValueFactory(new PropertyValueFactory<Student,String>("course"));
        clas.setCellValueFactory(new PropertyValueFactory<Student,String>("clas"));

        
        
        table.setItems(list);
    }    
    
}
