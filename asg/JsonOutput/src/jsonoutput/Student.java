package jsonoutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Liam Geyer
 */
public class Student {
    private final String lastName, firstName;
    private final double gpa;
    private final PhoneNumber phoneNumber;
    private final ArrayList<String> skills;
    
    public Student(String input){
        String[] parsedInput = input.split(", ");
        this.lastName = parsedInput[0];
        this.firstName = parsedInput[1];
        this.gpa = Double.parseDouble(parsedInput[2]);
        this.phoneNumber = new PhoneNumber(parsedInput[3]);
        
        //  split sort and store skills
        this.skills = new ArrayList(List.of(parsedInput[4].split(";")));
        Collections.sort(this.skills);
    }
    
    @Override
    public String toString(){
        return String.format("firstName: %s, lastName: %s, gpa: %.2f phoneNumber=%s, skills: %s",
                firstName, lastName, gpa, phoneNumber, skills.toString());
    }
}
