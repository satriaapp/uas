import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Penjualan {
    String idPenjualan;
    Pembeli pembeli;
    Penjual penjual;
    int total;
    LocalDate tanggal;
    ArrayList<DetilPenjualan> detilPenjuals;
    private ArrayList<DetilPenjualan> detilPenjualans;

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }
    public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }
    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }
    public Penjual getPenjual() {
        return penjual;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setDetilPenjualan(List<DetilPenjualan> tDetilPenjualans) {
        this.detilPenjualans = (ArrayList<DetilPenjualan>) tDetilPenjualans;
    }
    public ArrayList<DetilPenjualan> getDetilPenjualans() {
        return detilPenjualans;
    }
        
    }

