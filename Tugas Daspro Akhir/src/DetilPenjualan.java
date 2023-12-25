
public class DetilPenjualan {
    String idDetilPenjualan;
    Penjualan penjualan;
    Barang barang;
    int hargaJual, jumlahBeli, subTotal;

    public void setIdDetilPenjualan(String idDetilpenjualan) {
        this.idDetilPenjualan = idDetilpenjualan;
    }
    public String getIdDetilPenjualan() {
        return idDetilPenjualan;
    }

    public void SetPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }
    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
    public Barang getBarang() {
        return barang;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }
    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void SetSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    public int getSubTotal() {
        return subTotal;
    }
    public void setHargaJual(int hargaJual) {
    }
    public int getHargaJual() {
        return hargaJual;
    }



}
