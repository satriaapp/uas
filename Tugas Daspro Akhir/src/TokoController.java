import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TokoController {
    ArrayList<Barang> barangs = new ArrayList<>();
    ArrayList<Penjualan> penjualans = new ArrayList<>();
    HashMap<Integer, Pembeli> pembelis = new HashMap<>();
    HashMap<Integer, Penjual> penjuals = new HashMap<>();

    public void setUp(){
        tambahAdmin(1, "Bandung", "usop", "nama");
        tambahMenu(1, "Paket 1 Jam", 4500, true, 5);
        tambahMenu(2, "Paket 3 Jam", 12000, true, 4);
        tambahMenu(3, "Paket Malam + Mie Instan + Air Minum", 30000, true, 8);
    }

    private void tambahAdmin(int id, String alamat, String nama, String password) {
        Penjual penjual = new Penjual();
        penjual.setIdPenjual(id);
        penjual.setAlamat(alamat);
        penjual.setName(nama);
        penjual.setPassword(password);
        penjuals.put(id, penjual);
    }

    private void tambahMenu(int id, String nama, int harga, boolean tersedia, int stok) {
        Barang barang = new Barang();
        barang.setIdBarang(id);
        barang.setNamaBarang(nama);
        barang.setHargaBarang(harga);
        barang.setIsvailable(tersedia);
        barang.setStockBarang(stok);
        barangs.add(barang);
    }

    public void adminAtauPenyewa(){
        Scanner input = new Scanner(System.in);
        boolean ulang = true;
        while (ulang) {
            int pilihan = tampilkanMenu(input);
            switch (pilihan) {
                case 1:
                    loginSebagaiAdmin(input);
                    break;
                case 2:
                    penyewa(input);
                    break;
                case 3:
                    System.out.println("Terima kasih dan sampai jumpa.");
                    ulang = false;
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.\nSilakan pilih lagi !\n");
                    break;
            }
        }
    }
    
    public int tampilkanMenu(Scanner input) {
        System.out.println("Apakah Anda ingin menjadi Admin atau Penyewa?");
        System.out.println("1. Admin Warnet");
        System.out.println("2. Penyewa");
        System.out.println("3. Keluar");
        System.out.print("Pilihan Anda: ");
        return Integer.parseInt(input.nextLine());
    }

    public void loginSebagaiAdmin(Scanner input) {
        // Deklarasi variabel untuk kontrol loop
        boolean lanjut = true;
    
        // Loop sampai user memilih untuk berhenti
        while (lanjut) {
            System.out.println();
            System.out.println("[-Login Terlebih Dahulu-]");
    
            // Minta input nama dan password dari user
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            System.out.print("Masukkan Password: ");
            String password = input.nextLine();
    
            // Cek apakah login berhasil
            boolean loginBerhasil = false;
            for (Penjual penjual : penjuals.values()) {
                if (penjual.getName().equals(nama) && penjual.getPassword().equals(password)) {
                    System.out.println("Selamat datang, " + penjual.getName());
                    loginBerhasil = true;
                    break;
                }
            }
    
            // Jika login gagal, tanya user apakah ingin mencoba lagi
            if (!loginBerhasil) {
                System.out.println("Nama atau password salah.");
                System.out.print("Apakah Anda ingin lanjut login? (y/n): ");
                String pilihan2 = input.nextLine();
                if (!pilihan2.equalsIgnoreCase("y")) {
                    System.out.println("Terima kasih dan sampai jumpa.");
                    lanjut = false;
                }
            } else {
                // Jika login berhasil, minta input untuk menambah waktu sewa
                System.out.println();
                System.out.println("-Menambahkan Waktu Sewaan-");
                System.out.print("Masukkan ID PC : ");
                int idBarang = Integer.parseInt(input.nextLine());
                System.out.print("Atur Waktu Rental (Jam) : ");
                int jumlahTambah = Integer.parseInt(input.nextLine());
    
                // Cari barang berdasarkan ID dan tambah waktu sewa
                for (Barang barang : barangs) {
                    if (barang.getIdBarang() == idBarang) {
                        int stokSekarang = barang.getStockBarang();
                        barang.setStockBarang(stokSekarang + jumlahTambah);
                        System.out.println("Waktu Telah Diubah.");
                        return;
                    }
                }
    
                // Jika ID barang tidak ditemukan, beri pesan error
                System.out.println("ID PC Tidak Ditemukan.");
            }
        }
    }
            
        public void tampilkanMenuSewaan() {
        System.out.println("[--------------------------------------------]");
        System.out.println("\t Selamat datang di Warnet SRR");
        System.out.println("[--------------------------------------------]");
        System.out.println("Berikut adalah daftar PC yang tersedia : ");
        for (Barang barang : barangs) {
            System.out.println(barang.getIdBarang() + " " + barang.getNamaBarang() + " - Rp." + barang.getHargaBarang() + " - Tersedia (" + barang.getIsAvailable() + ")" );
        }
        System.out.println();
    }

    public void penyewa(Scanner input) {
        // Inisialisasi list detil penjualan dan variabel increment
        List<DetilPenjualan> tDetilPenjualans = new ArrayList<>();
        int increment = 0;
    
        // Loop sampai user memilih untuk berhenti
        while (true) {
            System.out.println("Masukkan Data Anda Untuk Akun Baru : ");
    
            // Minta input ID, nama, dan alamat dari user
            int idPembeli = mintaInput(input, "Masukkan ID : ");
            String nama = mintaInputString(input, "Masukkan Nama: ");
            String alamat = mintaInputString(input, "Masukkan Alamat: ");
    
            // Buat objek pembeli baru dan simpan di map pembelis
            Pembeli pembeliBaru = new Pembeli();
            pembeliBaru.setIdPembeli(idPembeli);
            pembeliBaru.setName(nama);
            pembeliBaru.setAlamat(alamat);
            pembelis.put(idPembeli, pembeliBaru);
    
            System.out.println("Data pembeli baru telah ditambahkan.");
            System.out.println();
    
            // Tampilkan menu sewaan dan minta input barang dan jumlah beli dari user
            tampilkanMenuSewaan();
            int idBarang = mintaInput(input, "Masukkan No Yang Ingin Disewa : ");
            int jumlahBeli = mintaInput(input, "Mau Berapa ? ");
    
            // Cari barang berdasarkan ID dan cek stok barang
            for (Barang barang : barangs) {
                if (barang.getIdBarang() == idBarang && barang.getStockBarang() >= jumlahBeli) {
                    increment++;
                    int totalHarga = barang.getHargaBarang() * jumlahBeli;
    
                    // Tampilkan detail penjualan dan minta konfirmasi pembayaran dari user
                    System.out.println("Anda telah memilih " + barang.getNamaBarang() + "Dengan Sebanyak  " + jumlahBeli + " Jam");
                    System.out.println("Total harga yang harus Anda bayar adalah Rp. " + totalHarga);
                    if (konfirmasi(input, "Apakah Anda ingin melanjutkan pembayaran? (y/n): ")) {
                        System.out.println("Terima kasih telah Datang.");
                        barang.setStockBarang(barang.getStockBarang() - jumlahBeli);
    
                        // Jika user tidak ingin menyewa lagi, tambahkan penjualan dan keluar dari loop
                        if (!konfirmasi(input, "Apakah Anda ingin Lanjut Menyewa ? (y/n): ")) {
                            System.out.println("Terima kasih dan sampai jumpa.");
                            tambahPenjualan(tDetilPenjualans, increment, barang, jumlahBeli, totalHarga);
                            return;
                        }
                    } else {
                        // Jika user membatalkan penyewaan, tanya apakah mereka ingin melihat menu lagi
                        System.out.println("Anda telah membatalkan Penyewaan.");
                        if (!konfirmasi(input, "Apakah Anda ingin lanjut Melihat Menu? (y/n): ")) {
                            return;
                        }
                    }
                }
            }
        }
    }
        
    // Metode untuk meminta input berupa angka dari pengguna
    public int mintaInput(Scanner input, String pesan) {
        System.out.print(pesan); // Menampilkan pesan ke pengguna
        return Integer.parseInt(input.nextLine()); // Membaca input dari pengguna dan mengubahnya menjadi angka
    }

    // Metode untuk meminta input berupa teks dari pengguna
    public String mintaInputString(Scanner input, String pesan) {
        System.out.print(pesan); // Menampilkan pesan ke pengguna
        return input.nextLine(); // Membaca input dari pengguna
    }

    // Metode untuk meminta konfirmasi dari pengguna
    public boolean konfirmasi(Scanner input, String pesan) {
        System.out.print(pesan); // Menampilkan pesan ke pengguna
        return input.nextLine().equalsIgnoreCase("y"); // Membaca input dari pengguna dan memeriksa apakah itu "y" atau "Y"
    }

    // Metode untuk menambah penjualan
    public void tambahPenjualan(List<DetilPenjualan> tDetilPenjualans, int increment, Barang barang, int jumlahBeli, int totalHarga) {
        DetilPenjualan dp = new DetilPenjualan(); // Membuat objek baru dari kelas DetilPenjualan
        dp.setIdDetilPenjualan("dp" + increment); // Mengatur ID detil penjualan
        dp.setBarang(barang); // Mengatur barang yang dijual
        dp.setHargaJual(barang.getHargaBarang()); // Mengatur harga jual
        dp.setJumlahBeli(jumlahBeli); // Mengatur jumlah beli
        dp.SetSubTotal(totalHarga); // Mengatur subtotal
        tDetilPenjualans.add(dp); // Menambahkan detil penjualan ke list

        Penjualan penjualan = new Penjualan(); // Membuat objek baru dari kelas Penjualan
        penjualan.setDetilPenjualan(tDetilPenjualans); // Mengatur detil penjualan
        penjualan.setIdPenjualan("Penyewa \t \t : " + (penjualans.size() + 1)); // Mengatur ID penjualan
        penjualan.setPembeli(getPembeli(1)); // Mengatur pembeli
        penjualan.setPenjual(getPenjual(1)); // Mengatur penjual
        penjualan.setTanggal(LocalDate.now()); // Mengatur tanggal penjualan
        penjualan.setTotal(hitungTotalBelanja(tDetilPenjualans)); // Mengatur total penjualan
        penjualans.add(penjualan); // Menambahkan penjualan ke list
    }

    // Metode untuk mendapatkan barang berdasarkan ID
    public Barang getBarang(Integer idBarang) {
        return barangs.get(idBarang); // Mengembalikan barang dengan ID yang diberikan
    }

    // Metode untuk mendapatkan penjual berdasarkan indeks
    public Penjual getPenjual(int i) {
        return penjuals.get(i); // Mengembalikan penjual dengan indeks yang diberikan
    }

    // Metode untuk mendapatkan pembeli berdasarkan indeks
    public Pembeli getPembeli(int i) {
        return pembelis.get(i); // Mengembalikan pembeli dengan indeks yang diberikan
    }

    // Metode untuk menghitung total belanja berdasarkan list detil penjualan
    public int hitungTotalBelanja(List<DetilPenjualan> tDetilPenjualans) {
        int total = 0; // Inisialisasi variabel total
        // Loop untuk setiap detil penjualan dalam list
        for (DetilPenjualan detilPenjualan : tDetilPenjualans) {
            total += detilPenjualan.getSubTotal(); // Menambahkan subtotal detil penjualan ke total
        }
        return total; // Mengembalikan total belanja
    }

    // Metode untuk menampilkan laporan penjualan
    public void tampilkanlaporanpenjualan(){
        // Loop untuk setiap penjualan dalam list penjualans
        for (Penjualan penjualan : penjualans) {
            System.err.println();
            System.out.println("[----------------------------]");
            System.out.println(penjualan.getIdPenjualan()); // Menampilkan ID penjualan
            System.out.println("Tanggal transaksi\t : "+penjualan.getTanggal()); // Menampilkan tanggal transaksi
            System.out.println("Admin   \t \t : "+penjualan.getPenjual().getName()); // Menampilkan nama admin
            System.out.println("Penyewa \t \t : " + penjualan.getPembeli().getName()); // Menampilkan nama penyewa
            System.out.println("------------------------------");

            // Mendapatkan list detil penjualan dari penjualan
            ArrayList<DetilPenjualan> detilPenjualans = penjualan.getDetilPenjualans();
            // Loop untuk setiap detil penjualan dalam list
            for (DetilPenjualan dp : detilPenjualans) {
                System.out.println("Nama Paket Sewa \t : " + dp.getBarang().getNamaBarang()); // Menampilkan nama paket sewa
                System.out.println("Jumlah \t \t \t : " + dp.getJumlahBeli()); // Menampilkan jumlah beli
                System.out.println("Subtotal \t \t : " + dp.getSubTotal()); // Menampilkan subtotal
            }
            System.out.println("[----------------------------]");
        }
    }
}