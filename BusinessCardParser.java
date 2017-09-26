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
            if(tokens[i].contains("@")) {
                parsed.setEmailAddress(tokens[i]);
            }
        }

        //set name, phone num, email along the way with setter funcs in ContactInfo

        return parsed;
    }
    
    public static void main(String []args) {
        String document = "Marco Polo\nAsymmetrik LTD\nTour Guide\n443-896-4833\nme@me.com";

        ContactInfo result = getContactInfo(document);
        //print results with get___() functions from ContactInfo class
        //System.out.println("Name: " + result.getName());
        //System.out.println("Phone: " + result.getPhoneNumber());
        System.out.println("Email: " + result.getEmailAddress());
        

    }

}