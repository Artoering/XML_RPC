package WebClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;
 
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
 
public class Client {
    public static void main(String[] ars) throws MalformedURLException {
 
        // Deklarasikan URL Server
        // Masukkan IP Address si Server
        while(true){
            
        String serverUrl = "http://127.0.0.1:1717/RPC2";
 
        // Buat objek XmlRpcClient
        XmlRpcClient xmlRpcClient = new XmlRpcClient(serverUrl);
 
        // Buat objek Scanner
        Scanner scanner = new Scanner(System.in);
 
        // Buat vector yang akan digunakan untuk mengirimkan parameter ke server
        Vector<Integer> vector = new Vector<Integer>();
 
        // Buat 4 menu utama
        System.out.println("==Aplikasi Kalkulator Client Server ==");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.print("Masukkan pilihan Anda: ");
        String pilihan = scanner.nextLine();
       
        try {
            System.out.print("Masukkan nilai X: ");
            int x = scanner.nextInt();
            System.out.print("Masukkan nilai Y: ");
            int y = scanner.nextInt();
 
            // masukkan parameter ke vector
            vector.addElement(x);
            vector.addElement(y);
       
            switch (pilihan) {
            case "1":
                // kirim request beserta parameter ke server dan tampung pada
                // variable hasil
                int hasil = (int) xmlRpcClient.execute("server.hitungPenjumlahan", vector);
 
                // tampilkan pesan balasan dari server
                System.out.println("Hasil: " + hasil);
                break;
            case "2":
                hasil = (int)xmlRpcClient.execute("server.hitungPengurangan", vector);
                System.out.println("Hasil: "+hasil);
                break;
            case "3":
                hasil = (int)xmlRpcClient.execute("server.hitungPerkalian", vector);
                System.out.println("Hasil: "+hasil);
                break;
            case "4":
                hasil = (int)xmlRpcClient.execute("server.hitungPembagian", vector);
                System.out.println("Hasil: "+hasil);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
            }
        }catch(XmlRpcException xmle) {
            xmle.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        }
    }
}