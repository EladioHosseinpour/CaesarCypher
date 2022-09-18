import java.util.Scanner;
import java.util.ArrayList;
public class Cypher {
    private static Scanner input = new Scanner(System.in);
    public static void run(){
        while (true){
            System.out.println(
                    """
                    ------------------------------
                    Select an option:
                    1. Encrypt to Caesar cypher
                    2. Decrypt from Caesar cypher
                    3. Quit
                    ------------------------------
                    
                    Type the number of your choice:\s
                    """
            );
            int choice = input.nextInt();
            input.nextLine();

            if(choice == 1){
                encrypt();
            }
            else if(choice == 2){
                decrypt();
            }
            else if(choice == 3){
                System.exit(0);
            }
            else{
                System.out.println("You have not typed a valid option.");
            }
        }
    }
    public static void encrypt(){
        System.out.println("Enter the text to encrypt: ");
        String secret = input.nextLine();
        System.out.println("Enter a key: ");
        int key = input.nextInt();

        char[] secretChars = secret.toCharArray();
        String encryption = "";
        ArrayList<Integer> asciiValues = new ArrayList<Integer>();
        for (int i = 0; i < secret.length(); i++){
            asciiValues.add((int)(secretChars[i]));
        }
        ArrayList<Boolean> lowerCase = new ArrayList<Boolean>();
        for (int i = 0; i < asciiValues.size(); i++){
            if(asciiValues.get(i) >= 97){
                lowerCase.add(true);
            }
            else{
                lowerCase.add(false);
            }
        }
        for (int i = 0; i < asciiValues.size(); i++){
            if(asciiValues.get(i) == 32){
                continue;
            }
            asciiValues.set(i, asciiValues.get(i) + key);
            if(lowerCase.get(i) == true){
                if(asciiValues.get(i) < 97){
                    asciiValues.set(i, 122 - (97 - asciiValues.get(i)) + 1);
                }
                else if(asciiValues.get(i) > 122){
                    asciiValues.set(i, 97 + (asciiValues.get(i) - 122) - 1);
                }
            }
            else{
                if(asciiValues.get(i) < 65){
                    asciiValues.set(i, 90 - (65 - asciiValues.get(i)) + 1);
                }
                else if(asciiValues.get(i) > 90){
                    asciiValues.set(i, 65 + (asciiValues.get(i) - 90) - 1);
                }
            }
        }
        for (int i = 0; i < asciiValues.size(); i++){
            int primValue = (int)(asciiValues.get(i));
            char letter = (char)(primValue);
            encryption += letter;
        }
        System.out.println(encryption);
    }
    public static void decrypt(){
        System.out.println("Enter code to decrypt: ");
        String code = input.nextLine();
        System.out.println("Enter key: ");
        int key = input.nextInt();

        String decryption = "";
        ArrayList<Integer> asciiNums = new ArrayList<Integer>();
        ArrayList<Boolean> lowerCase = new ArrayList<Boolean>();
        char[] encoded = code.toCharArray();
        for (int i = 0; i < code.length(); i++){
            int asciiNum = (int)(encoded[i]);
            asciiNums.add(asciiNum);
        }
        for (int i = 0; i < asciiNums.size(); i++){
            if(asciiNums.get(i) >= 97){
                lowerCase.add(true);
            }
            else{
                lowerCase.add(false);
            }
        }
        for (int i = 0; i < asciiNums.size(); i++){
            if(asciiNums.get(i) == 32){
                continue;
            }
            asciiNums.set(i, (asciiNums.get(i) - key));
            if(lowerCase.get(i) == true){
                if(asciiNums.get(i) < 97){
                    asciiNums.set(i, 122 - (97 - asciiNums.get(i)) + 1);
                }
                else if(asciiNums.get(i) > 122){
                    asciiNums.set(i, 97 + (asciiNums.get(i) - 122) - 1);
                }
            }
            else{
                if(asciiNums.get(i) < 65){
                    asciiNums.set(i, 90 - (65 - asciiNums.get(i)) + 1);
                }
                else if(asciiNums.get(i) > 90){
                    asciiNums.set(i, 65 + (asciiNums.get(i) - 90) - 1);
                }
            }
        }
        for (int i = 0; i < asciiNums.size(); i++){
            int primValue = (int)asciiNums.get(i);
            char letter = (char)primValue;
            decryption += letter;
        }
        System.out.println(decryption);
    }
}
