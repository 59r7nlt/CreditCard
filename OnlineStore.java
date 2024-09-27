/*
    Ritika Lama
    Course: CS 181
    Professor: Dr. Kafi
    Purpose: The purpose of this program is to check the validity and  invalidity of a credit card using the JOptionPane
*/
import javax.swing.JOptionPane; //for producing the dialogue box

public class OnlineStore 
{
    /**
        * This checks whether the credit card number is valid or invalid.
        * 
        * @param creditCardNumber The credit card number which is to be checked.
        * @return true if the credit card number is valid, false otherwise.
    */
    public boolean validCreditCard(String creditCardNumber) 
    {
        // check the length of credit card is 16
        if (creditCardNumber.length() != 16) 
        {
            return false;
        }
          
        // check the credit card number is between 0 and 9 inclusive
        for (int i = 0; i < 16; i++) 
        {
            //return false if it contains digits
            if (!Character.isDigit(creditCardNumber.charAt(i))) 
            {
                return false;
            }
        }
        
        // convert the string of credit card number into an integer array
        int[] number = new int[16];
        for (int i = 0; i < 16; i++) 
        {
            //convert character into integer
            number[i] = Character.getNumericValue(creditCardNumber.charAt(i));
        }
       
        // Calculate sum to check validity of the credit card
        int sum = 0; //initialize sum to zero
        //loop until the last digit
        for (int i = 0; i < 16; i++) 
        {
            //get the number at index i
            int digit = number[i];
            //double every digit at an even index
            if (i % 2 == 0) 
            {
                digit *= 2;
                //If the doubled digit is greater than or equal to  10
                //sum its individual digit number
                if (digit >= 10) 
                {
                    digit = digit / 10 + digit % 10;
                }
            }
            //sum of all digits
            sum += digit; 
        }
        
        // Check if sum is a multiple of 10
        if (sum % 10 == 0) 
        {
             return true; // Credit card number is valid
        } 
        else 
        {
            return false; // Credit card number is invalid
        }
    }
    
    public static void main(String[] args) 
    {
        //create the instance of the onlinestore class
        OnlineStore store = new OnlineStore();
        //ask user to input credit card number
        String creditCardNumber = JOptionPane.showInputDialog(null, "Enter credit card number:");

        boolean isValid = store.validCreditCard(creditCardNumber);
        //print if isValid returns true
        if (isValid) 
        {
            JOptionPane.showMessageDialog(null, "The credit card number is valid!");
        } 
        //print if isValid returns false
        else 
        {
            JOptionPane.showMessageDialog(null, "The credit card number is invalid.");
        }
    }
}

