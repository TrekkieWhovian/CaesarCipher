import java.util.Scanner;
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String l = input.nextLine();

        System.out.print("Enter the key: ");
        int key = input.nextInt();
        //Takes the string and key values

        String encrypted = encode(l, key);
        //Gets the encrypted text from the encode method

        String decrypted = decode(l, key);
        //Gets the decrypted text from the decode method

        System.out.println("The encrypted message is: " + encrypted);
        System.out.println("The decrypted message is: " + decrypted);

        String b[] = breakCode(encrypted);
        //Gets the array from the breakcode method

        System.out.println("\nBreak code:");

        for(int count = 0; count < 26; count++){
            System.out.println(count + ": " + b[count]);
        }

    }

    /**
     * Encodes the string l by adding the key variable
     * @param l The inputted text that will be encoded
     * @param key The key number that will shift the text
     * @return Returns the variable encrypted, which is the encrypted text
     */
    public static String encode(String l, int key){
        //Method for the encrypted text
        String encrypted = "";
        key = key % 26;

        for(int i = 0; i < l.length(); i++){
            //Loop is responsible  for shifting the characters in the input text by the value of the key
            char c = l.charAt(i);

            if(c != ' ' || c != '?' || c != '!' || c != ',' || c != '.'){
                //Makes exceptions for special characters
                if(c <= 'z' && c >= 'a'){
                    //Shifts the characters if they're lower case letters
                    c = (char)(c + key);
                    if(c > 'z'){
                        //Makes sure the shifts loop
                        c = (char)((c - 'z') + 'a' - 1);
                    }
                }
                else if(c <= 'Z' && c >= 'A'){
                    //Shifts the characters if they're upper case letters
                    c = (char)(c + key);
                    if(c > 'Z'){
                        //Makes sure the shifts loop
                        c = (char)((c - 'Z') + 'A' - 1);
                    }
                }
            }

            encrypted += c;
            //Adds the encrypted characters to the new string
        }

        return encrypted;
        //Returns the encrypted variable to the main method
    }

    /**
     * Decodes the string l by subtracting the key variable
     * @param l The inputted text that will be decoded
     * @param key The key value that will shift the text
     * @return Returns the decrypted variable, which is the decrypted text
     */
    public static String decode(String l, int key){
        //Method for the decrypted text
        String decrypted = "";
        key = key % 26;

        for(int i = 0; i < l.length(); i++){
            //Loop is responsible for the shifting the characters in the input text by the value of the key
            char c = l.charAt(i);

            if(c != ' ' || c != '?' || c != '!' || c != ',' || c != '.'){
                //Makes exceptions for special characters
                if(c <= 'z' && c >= 'a'){
                    //Shifts the characters if they're lower case letters
                    c = (char)(c - key);
                    if(c < 'a'){
                        //Makes sure the shift loops
                        c = (char)((c + 'z') - 'a' + 1);
                    }
                }
                else if(c <= 'Z' && c >= 'A'){
                    //Shifts the characters if they're upper case letters
                    c = (char)(c - key);
                    if(c < 'A'){
                        //Makes sure the shift loops
                        c = (char)((c + 'Z') - 'A' + 1);
                    }
                }
            }

            decrypted += c;
            //Adds the decrypted character to the new String
        }

        return decrypted;
    }

    /**
     * Breaks the encrypted code by decrypting it for every key from 0 to 25
     * @param encrypted The encrypted text that was taken from the encode method
     * @return Returns the array b which contains the decryption for all possible key values
     */
    public static String[] breakCode(String encrypted){
        //Method for breaking the encrypted code
        String b[] = new String[26];

        for(int key = 0; key < 26; key++){
            //Goes through all 26 possibilites for breaking the encrypted text by running the decode method
            b[key] = decode(encrypted, key);
        }

        return b;
        //Returns the array to the main method
    }
}
