/*
 * Morgan Philie
 * Asymmetrik Coding Challenge: Business Card OCR
 * Sept 2017
 * 
 * As the executable class, BusinessCardParser parses the results of the OCR
 *  and stores the parsed pieces in a ContactInfo object. It then prints the
 *  parsed results to stdout.
 */

public class BusinessCardParser
{
    /*
     * parses results of OCR to get the full name of individual
     * params: OCR string
     * return: String name
     */
	public static ContactInfo getContactInfo(String document) {
        ContactInfo parsed = new ContactInfo(document);

        //parse document
        String delimiter = "\n";
        String[] tokens = document.split(delimiter);
        for (int i = 0; i < tokens.length; i++) {
            int digitCount = 0;
            int startIndex = 0;
            //see if this line is an email
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
            if (digitCount == 10 && parsed.getPhoneNumber() == null) {
                String trimmedNum = tokens[i].substring(startIndex, tokens[i].length());
                parsed.setPhoneNumber(trimmedNum);
            }
        }

        //set name, phone num, email along the way with setter funcs in ContactInfo

        return parsed;
    }
    
    public static void main(String []args) {
        String document = "Marco Polo\nAsymmetrik LTD\nTour Guide\nphone:443-896-4833\nfax:1234567890\nme@me.com";

        ContactInfo result = getContactInfo(document);
        //print results with get___() functions from ContactInfo class
        //System.out.println("Name: " + result.getName());
        System.out.println("Phone: " + result.getPhoneNumber());
        System.out.println("Email: " + result.getEmailAddress());
        

    }

}