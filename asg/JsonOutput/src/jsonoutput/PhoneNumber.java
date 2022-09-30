/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonoutput;

/**
 *
 * @author Liam Geyer
 */
public class PhoneNumber {
    
    private final int areaCode, prefix, lineNumber;
    
    public PhoneNumber(String phoneNumber){
        //  check for validity of phone number, only valid numbers can be instantiated
        if (!phoneNumber.matches("(\\d){3}-(\\d){3}-(\\d){4}")){
            throw new IllegalArgumentException("Phone numbers must be entered in the following format: XXX-XXX-XXXX");
        }
        
        //  parse and save input
        String[] parsedNumber = phoneNumber.split("-");
        this.areaCode = Integer.valueOf(parsedNumber[0]);
        this.prefix = Integer.valueOf(parsedNumber[1]);
        this.lineNumber = Integer.valueOf(parsedNumber[2]);
    }
    
    @Override
    public String toString(){
        return String.format("(%d) %d-%d",
                areaCode, prefix, lineNumber);
    }
}
