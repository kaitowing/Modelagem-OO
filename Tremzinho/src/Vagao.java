public class Vagao extends ElementoTrem{
	protected int identificador;
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
		if (livre()){
			return "Vagao [LIVRE, capacidadeCarga=" + capacidadeCarga +  ", identificador="
			+ identificador + "]";
		}
        return "Vagao [Engatado no trem=" + trem.getIdentificador() + "capacidadeCarga=" + capacidadeCarga +  ", identificador="
        + identificador + "]";
    }
}