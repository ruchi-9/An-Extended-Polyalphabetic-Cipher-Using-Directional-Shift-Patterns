import java.util.Scanner;
public class Vigenere_Cipher_New
{   
    public static String encrypt(String text, String key)
    {
        String result = "";
        text = text.toUpperCase();
        key=key.toUpperCase();
        for(int i = 0; i < text.length(); i++)
        {
            result += (char)(((text.charAt(i) +i+ key.charAt(i)) % 26) + 'A');
        } 
        return result;
    }
    public static String decrypt(String text, String key)
    {
        String res = "";
        text = text.toUpperCase();
        key=key.toUpperCase();
        for(int i = 0; i < text.length(); i++)
        {
            res += (char)((((text.charAt(i) -i-key.charAt(i)) + 26) % 26) + 'A');
        }  
        return res;
    }
    public static String keygen( String text,String key)
    {
        char a;
        int i,j;
        String newkey="";
        char[] aa = new char[20];
        for(i = 0, j = 0; i <text.length(); ++i, ++j)
        {
            if(j == key.length())  
            j = 0;
            aa[i] = key.charAt(j);
        }
        newkey = String.valueOf(aa);
        return newkey;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message:");
        String message = sc.next().trim();
        System.out.println("Enter a keyword:");
        String key = sc.next().trim();
        String  newkey=keygen(message, key);
        String encryptedMsg = encrypt(message, newkey);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, newkey));
    }
}
