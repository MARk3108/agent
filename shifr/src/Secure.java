import javax.crypto.*;
import java.security.*;
import java.io.File;
import java.util.Scanner;

public class Secure {
    public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);
        String str1=s.nextLine();
        String str2=s.nextLine();
        File file= new File(str1,str2);
        while (!file.isFile()){
            System.out.println("Введи еще раз");
            str1=s.nextLine();
            str2=s.nextLine();
            file= new File(str1,str2);
        }




        KeyGenerator keygen=KeyGenerator.getInstance("AES");
        keygen.init(256,new SecureRandom());
        Key key=keygen.generateKey();

        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        String styp=file.getPath();
        byte[] encrypted=cipher.doFinal(styp.getBytes());


        cipher.init(Cipher.DECRYPT_MODE,key);
        String decrypted=new String(cipher.doFinal(encrypted));
        System.out.println("1-зашифровать" + "\n" + "2-расшифровать" + "\n" + "0-завершить работу");
        int a= s.nextInt();
        while (a!=0) {
            if (a == 1) {
                System.out.println(encrypted+"\n");
            }
            if (a == 2) {
                System.out.println(decrypted+"\n");
                System.out.println(new File(decrypted).exists());
            }
            System.out.println("1-зашифровать" + "\n" + "2-расшифровать" + "\n" + "0-завершить работу");
            a = s.nextInt();
        }
    }
}
