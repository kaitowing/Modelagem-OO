import java.util.ArrayList;

public class Trem {
	private int identificador;
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;

	public Trem(int identificador){
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
	}

	public int getIdentificador() {
		// TO DO
	}

	public int getQtdadeLocomotivas() {
		// TO DO
	}

	public Locomotiva getLocomotiva(int posicao) {
		// TO DO
	}

	public int getQtdadeVagoes() {
		// TO DO
	}

	public Vagao getVagao(int posicao) {
		// TO DO
	}

	private int maxVagoesNoTrem() {
		// TO DO
	}

	private double pesoMaxNoTrem() {
		// TO DO
	}

	private double pesoAtualDoTrem() {
		// TO DO
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		// TO DO
	}

	public boolean engataVagao(Vagao vagao) {
		// TO DO
	}

	public boolean desengataLocomotiva() {
		// TO DO
	}

	public boolean desengataVagao() {
		// TO DO
	}

	public String toString(){
		// TO DO
	}
}
