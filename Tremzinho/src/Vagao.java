public class Vagao extends ElementoTrem{
	private int identificador;
	private double capacidadeCarga;

	public Vagao(int identificador, double capacidadeCarga) {
		super(identificador);
		this.identificador = identificador;
		this.capacidadeCarga = capacidadeCarga;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}
	@Override
	public String toString() {
        return "Vagao [capacidadeCarga=" + capacidadeCarga + ", trem=" + getTrem() + ", identificador="
        + identificador + "]";
    }
}