/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author Soft
 */
public class Student {
    
    Integer id;
    String fname,lname,tel,course,clas;

    public Student(Integer id, String fname, String lname, String tel,String course,String clas) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.course=course;
        this.clas=clas;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getTel() {
        return tel;
    }
    
    public String getCourse() {
        return course;
    }

    public String getClas() {
        return clas;
    }
    
   
    
    
}
