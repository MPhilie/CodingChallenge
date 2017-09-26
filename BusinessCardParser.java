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
        //set name, phone num, email along the way with setter funcs in ContactInfo
        parsed.setName("Anthony");
        return parsed;
    }
    
    public static void main(String []args) {
        String document = "test";

        ContactInfo result = getContactInfo(document);
        //print results with get___() functions from ContactInfo class
        System.out.println("Name is: " + result.getName());
    }

}