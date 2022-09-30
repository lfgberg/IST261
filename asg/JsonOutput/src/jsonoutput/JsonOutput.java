/*s
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jsonoutput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liam Geyer
 * lfg5289@psu.edu
 */
public class JsonOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] studentInfo = {"Juan, Don, 3.3, 888-555-1212, snoozing;dreaming",
            "Jones, Tom, 3.5, 866-555-1212, kayaking;surfing;hiking;",
            "Woodhouse, Emma, 3.9, 860-555-1212, Java;Python;Javascript"};
        
        //  Create 3 students and make a list of them
        List<Student> students = List.of(new Student(studentInfo[0]), new Student(studentInfo[1]), new Student(studentInfo[2]));
        
        //  create gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        //  parse to string
        String jsonOutput = gson.toJson(students);
        
        //  parse from string to arrayList
        ArrayList<Student> arrayListOutput = gson.fromJson(jsonOutput, new TypeToken<ArrayList<Student>>(){}.getType());
        
        //  print both
        System.out.println(jsonOutput);
        for (Student student : arrayListOutput){
            System.out.printf("[%s]\n", student);
        }
    }
    
}
