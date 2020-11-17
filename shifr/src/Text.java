import javax.crypto.*;
import java.security.*;
import java.util.Scanner;
public class Text {
    public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);
        System.out.println("Введите текст:");
        String str=s.nextLine();
        KeyGenerator keygen=KeyGenerator.getInstance("AES");
        keygen.init(256,new SecureRandom());
        Key key=keygen.generateKey();


        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted=cipher.doFinal(str.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, key);
        String decrypted=new String(cipher.doFinal(encrypted));
        System.out.println("1-зашифровать"+"\n"+"2-расшифровать"+"\n"+"0-завершить работу");
        int a= s.nextInt();
        while (a!=0){
            if (a==1){
                System.out.println(encrypted);
            }
            if(a==2){
                System.out.println(decrypted);
            }
            System.out.println("1-зашифровать"+"\n"+"2-расшифровать"+"\n"+"0-завершить работу");
            a= s.nextInt();
        }
    }
}
