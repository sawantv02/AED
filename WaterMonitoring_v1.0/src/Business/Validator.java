/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vishakha
 */
public class Validator {
   
    	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Validator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    
    public boolean validateEmail(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
    
    public boolean validatePhoneNumber(String sPhoneNumber)
    {
         Pattern pattern1 = Pattern.compile("^\\+[1]\\d{10}");
         Matcher matcher1 = pattern1.matcher(sPhoneNumber);
             return matcher1.matches();
    }
        
    public boolean validateLetters(String letters)
    {
        String regx="^[a-zA-Z-,]+(\\s{0,1}[a-zA-Z-, ])*$";
        Pattern pattern1 = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(letters);
        return matcher1.matches();
    }
    
    public boolean validatePassword(String password)
    {
        String regx="[\\S]{6,}";
        Pattern pattern1=Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher1=pattern1.matcher(password);
        return matcher1.matches();
    }
    
    public boolean validateNumber(String number)
    {
         char ch[]=number.toCharArray();
         boolean flag=false;
        for(int i=0;i<number.length();i++)
        {
           if(Character.isDigit(ch[i]))    
                flag=true;
           
        }
        return flag;
    }
}
