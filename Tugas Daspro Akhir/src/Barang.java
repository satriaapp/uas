public class Barang {
    String namaBarang;
    int idBarang, hargaBarang, stockBarang;
    boolean isAvailable;
   
    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }
    public int getIdBarang() {
        return idBarang;
    }

    public void setNamaBarang(String namaBarang) {
       this.namaBarang = namaBarang;
    }
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setIsvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    
    public void setStockBarang(int stockBarang) {
        this.stockBarang = stockBarang;
    }
    public int getStockBarang() {
        return stockBarang;
    }
}
