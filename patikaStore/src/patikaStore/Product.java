package patikaStore;

public class Product {

	private int id;
	private double birimFiyat;
	private double indirimOrani;
	private int stokMiktari;
	private String urunAdi;
	private Brand marka;

	public Product(int id, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, Brand marka) {
		this.id = id;
		this.birimFiyat = birimFiyat;
		this.indirimOrani = indirimOrani;
		this.stokMiktari = stokMiktari;
		this.urunAdi = urunAdi;
		this.marka = marka;
	}

	public int getId() {
		return id;
	}

	public double getBirimFiyat() {
		return birimFiyat;
	}

	public double getIndirimOrani() {
		return indirimOrani;
	}

	public int getStokMiktari() {
		return stokMiktari;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public Brand getMarka() {
		return marka;
	}
}
