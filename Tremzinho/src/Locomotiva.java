public class Locomotiva extends ElementoTrem{
	private double pesoMaximo;
	private int qtdadeMaxVagoes;

	public Locomotiva(int identificador, double pesoMaximo, int qtdadeVagoes) {
		super(identificador);
		this.pesoMaximo = pesoMaximo;
		this.qtdadeMaxVagoes = qtdadeVagoes;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getQtdadeMaxVagoes() {
		return qtdadeMaxVagoes;
	}
	@Override
	public String toString() {
		if (livre()){
			return "Locomotiva [LIVRE, identificador=" + identificador + ", pesoMaximo="
			+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
		}
		return "Locomotiva [Engatada no trem=" + trem.getIdentificador() + ", identificador=" + identificador + ", pesoMaximo="
			+ pesoMaximo + ", qtdadeMaxVagoes=" + qtdadeMaxVagoes + "]";
	}
}
