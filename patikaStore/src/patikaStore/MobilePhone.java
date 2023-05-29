package patikaStore;

public class MobilePhone extends Product {

	private String hafizaBilgisi;
	private String ekranBoyutu;
	private int pilGucu;
	private String ram;
	private String renk;

	public MobilePhone(int id, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, Brand marka,
			String hafizaBilgisi, String ekranBoyutu, int pilGucu, String ram, String renk) {
		super(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka);
		this.hafizaBilgisi = hafizaBilgisi;
		this.ekranBoyutu = ekranBoyutu;
		this.pilGucu = pilGucu;
		this.ram = ram;
		this.renk = renk;
	}

	public String getHafizaBilgisi() {
		return hafizaBilgisi;
	}

	public String getEkranBoyutu() {
		return ekranBoyutu;
	}

	public int getPilGucu() {
		return pilGucu;
	}

	public String getRam() {
		return ram;
	}

	public String getRenk() {
		return renk;
	}
}
