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
        return this.identificador;
    }

    public int getQtdadeLocomotivas() {
        return locomotivas.size();
    }

    public Locomotiva getLocomotiva(int posicao) {
        return locomotivas.get(posicao);
    }

    public int getQtdadeVagoes() {
        return vagoes.size();
    }

    public Vagao getVagao(int posicao) {
        return vagoes.get(posicao);
    }

    private int maxVagoesNoTrem() {
        int totalVagoes = 0;
        for(Locomotiva locomotiva : locomotivas){
            totalVagoes += locomotiva.getQtdadeMaxVagoes();
        }

        // for(int i = 0; i < locomotivas.size(); i++){
        //     totalVagoes += locomotivas.get(i).getQtdadeMaxVagoes();
        // }

        totalVagoes = (int)(totalVagoes * (0.1 * (locomotivas.size()-1)));
        return totalVagoes;
    }

    private double pesoMaxNoTrem() {
		double pesoMaximo = 0;
		int totalVagoes = maxVagoesNoTrem();
		for(Vagao vagao : vagoes){
            if(vagao.getCapacidadeCarga() > pesoMaximo){
				pesoMaximo = vagao.getCapacidadeCarga();
			}
        }
		pesoMaximo = pesoMaximo * totalVagoes;
		return pesoMaximo;
    }

    private double pesoAtualDoTrem() {
		double pesoAtual = 0;
		for(Vagao vagao : vagoes){
				pesoAtual += vagao.getCapacidadeCarga();
        }
		return pesoAtual;
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