import java.io.BufferedReader;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws Exception {
        TokoController tokoController = new TokoController();
        tokoController.setUp();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         boolean lanjut = true;
        while (lanjut) {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            String pilihan = reader.readLine();
            switch(pilihan){
                case "1":
                    tokoController.adminAtauPenyewa();
                    break;
                case "2":
                    tokoController.tampilkanlaporanpenjualan();
                     break;
                case "3":
                lanjut = false;
                    break;
            }
        }
        System.out.println("terimakasih");
    }
    public static void tampilkanMenu() {
        System.out.println("1. Menu Pilih : Admin atau Penyewa ?");
        System.out.println("2. Laporan Penyewaan");
        System.out.println("3. Keluar");
       
    }
  }
