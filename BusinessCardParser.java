/*
 * Morgan Philie
 * Asymmetrik Coding Challenge: Business Card OCR
 * Sept 2017
 * 
 * As the executable class, BusinessCardParser parses the results of the OCR
 *  and stores the parsed pieces in a ContactInfo object. It then prints the
 *  parsed results to stdout.
 */

import java.util.*;

public class BusinessCardParser
{
    /*
     * parses results of OCR to get the full name of individual
     * params: OCR string
     * return: String name
     */
	public static ContactInfo getContactInfo(String document) {
        //for use later on in name comparisons
        List notNames = Arrays.asList("LTD", "Technologies", "Developer", "Engineer", 
        "Software", "Company", "Analytic", "Security", "Senior", "Junior", "INC", "Corporation");

        //init ContactInfo object
        ContactInfo parsed = new ContactInfo(document);

        //parse document by 'newlines', create array of lines in document
        String delimiter = "\n";
        String[] tokens = document.split(delimiter);

        //look at each line in the document
        for (int i = 0; i < tokens.length; i++) {
            //init digit count and starting index for phone number
            int digitCount = 0;
            int startIndex = 0;

            //see if this line is an email
            //exception: if we already have an email, keep the first one, do nothing
            if (tokens[i].contains("@") && parsed.getEmailAddress() == null) {
                //contains the @ symbol, deduce that it's an email
                parsed.setEmailAddress(tokens[i]);
            }

            //count the number of digits in this line to see if it's a phone number
            for (int j = 0; j < tokens[i].length(); j++) {
                //for each char in this line
                char c = tokens[i].charAt(j);
                if (Character.isDigit(c)) {
                    if (digitCount == 0) {
                        //note that this is the first digit
                        startIndex = tokens[i].indexOf(c);
                    }
                    //char is digit, so increment the digit count
                    digitCount++;
                }
            }

            //if it's enough digits for a phone number, deduce that it's a phone number
            //exception: if we already have a phone number, assume this line
            //is a fax number or secondary phone number
            if (digitCount >= 10 && parsed.getPhoneNumber() == null) {
                //cut out the "phone: " descriptor
                String trimmedNum = tokens[i].substring(startIndex, tokens[i].length());
                //take only the digits -- no other chars
                String digitString = trimmedNum.replaceAll("[^0-9]", "");
                parsed.setPhoneNumber(digitString);
            }

            //parse document by 'newlines', create array of lines in document
            String secondaryDelimiter = " ";
            String[] names = tokens[i].split(secondaryDelimiter);
            if (names.length == 2) {
                //we have 2 words in this line that we can consider as a name
                if ((!notNames.contains(names[0])) && (!notNames.contains(names[1])) && (parsed.getName() == null)) {
                    //the line does not have any obvious company/title names
                    parsed.setName(tokens[i]);
                }
            }
        }

        return parsed;
    }
    
    public static void main(String []args) {
        String document1 = "Marco Polo\nAsymmetrik LTD\nTour Guide\nphone:443-896-4833\nfax:1234567890\nme@me.com\n";
        String document2 = "Foobar Technologies\nAnalytic Developer\nLisa Haung\n1234 Sentry Road\nColumbia, MD 12345\nPhone: 410-555-1234\nFax: 410-555-4321\nlisa.haung@foobartech.com\n";
        String document3 = "Arthur Wilson\nSoftware Engineer\nDecision & Security Technologies\nABC Technologies\n123 North 11th Street\nSuite 229\nArlington, VA 22209\nTel: +1 (703) 555-1259\nFax: +1 (703) 555-1200\nawilson@abctech.com\n";
        
        ContactInfo result1 = getContactInfo(document1);
        ContactInfo result2 = getContactInfo(document2);
        ContactInfo result3 = getContactInfo(document3);
        
        //print results with get___() functions from ContactInfo class
        System.out.println("OCR document: \n" + document1);
        System.out.println("Name: " + result1.getName());
        System.out.println("Phone: " + result1.getPhoneNumber());
        System.out.println("Email: " + result1.getEmailAddress());
        System.out.println();
        
        System.out.println("OCR document: \n" + document2);
        System.out.println("Name: " + result2.getName());
        System.out.println("Phone: " + result2.getPhoneNumber());
        System.out.println("Email: " + result2.getEmailAddress());
        System.out.println();
        
        System.out.println("OCR document: \n" + document3);
        System.out.println("Name: " + result3.getName());
        System.out.println("Phone: " + result3.getPhoneNumber());
        System.out.println("Email: " + result3.getEmailAddress());        
    }
}
