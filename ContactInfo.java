/*
 * Morgan Philie
 * Asymmetrik Coding Challenge: Business Card OCR
 * Sept 2017
 * 
 * The ContactInfo Class is used by the BusinessCardParser Class
 *  to extract certain information about the digitally processed
 *  business card. Specifically, ContactInfo specifies the 
 *  individual's name, phone number, and email address, and returns
 *  them to BusinessCardParser class.
 */

public class ContactInfo
{
    String unparsed;
    String name;
    String phoneNum;
    String email;

    // constructor
    public ContactInfo(String document) {
        unparsed = document;
    }

    /*
     * sets the full name of individual
     * params: String nameToSet
     * return: void
     */
	public void setName(String nameToSet) {
        name = nameToSet;
	}

    /*
     * sets the phone number of the individual
     * params: String numToSet
     * return: void
     */
	public void setPhoneNumber(String numToSet) {
        phoneNum = numToSet;
    }
    
    /*
     * sets the email address of the individual
     * params: String emailToSet
     * return: void
     */
    public void setEmailAddress(String emailToSet) {
        email = emailToSet;
    }

    /*
     * returns the full name of individual
     * params: none
     * return: String name
     */
	public String getName() {
        return name;
	}

    /*
     * returns the phone number of the individual
     * params: none
     * return: String phoneNum
     */
	public String getPhoneNumber() {
        return phoneNum;
    }
    
    /*
     * returns the email address of the individual
     * params: none
     * return: String email
     */
    public String getEmailAddress() {
        return email;
    }
}