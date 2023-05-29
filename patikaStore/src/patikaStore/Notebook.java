package patikaStore;

public class Notebook extends Product {
	private String ram;
	private String depolama;
	private String ekranBoyutu;

	public Notebook(int id, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, Brand marka,
			String ram, String depolama, String ekranBoyutu) {
		super(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka);
		this.ram = ram;
		this.depolama = depolama;
		this.ekranBoyutu = ekranBoyutu;
	}

	public String getRam() {
		return ram;
	}

	public String getDepolama() {
		return depolama;
	}

	public String getEkranBoyutu() {
		return ekranBoyutu;
	}
}
