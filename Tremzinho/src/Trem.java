import java.util.ArrayList;

public class Trem {
    private int identificador;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;

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
      if(posicao >= 0 && posicao < locomotivas.size()){
        return locomotivas.get(posicao);
      }else{
        return null;
      }
    }

    public int getQtdadeVagoes() {
        return vagoes.size();
    }

    public Vagao getVagao(int posicao) {
      if (posicao >= 0 && posicao < vagoes.size()) {
        return vagoes.get(posicao);
      } else {
        return null;
      }
    }

    public int maxVagoesNoTrem() {
        int totalVagoes = 0;
        for(Locomotiva locomotiva : locomotivas){
            totalVagoes = locomotiva.getQtdadeMaxVagoes() + totalVagoes;
        }

        // for(int i = 0; i < locomotivas.size(); i++){
        //     totalVagoes += locomotivas.get(i).getQtdadeMaxVagoes();
        // }
        
        if(locomotivas.size() != 1){
          totalVagoes = (int)(totalVagoes * (1 - (0.1 * (locomotivas.size()-1))));
        }
        
        return totalVagoes;
    }

    public double pesoMaxNoTrem() {
		  double pesoMaximo = 0;

      for(Locomotiva locomotiva : locomotivas){
        pesoMaximo += locomotiva.getPesoMaximo();
      }

		  return pesoMaximo;
    }

    public double pesoAtualDoTrem() {
		  double pesoAtual = 0;

		  for(Vagao vagao : vagoes){
			  pesoAtual += vagao.getCapacidadeCarga();
      }
      
		  return pesoAtual;
    }

    public boolean engataLocomotiva(ElementoTrem elementoTrem) {
		if(vagoes.size() > 0){
			return false;
		}else{
			locomotivas.add((Locomotiva) elementoTrem);
			return true;
		}
    }

    public boolean engataVagao(ElementoTrem elementoTrem) {
		if(locomotivas.size() == 0){
			return false;
		}else{
			vagoes.add((Vagao) elementoTrem);
			return true;
		}
    }

    public boolean desengataLocomotiva() {
      if(locomotivas.size() > 1){
        locomotivas.get(locomotivas.size()-1).setLivre();
			  locomotivas.remove(locomotivas.size()-1);
			return true;
		}
		return false;
    }

    public boolean desengataVagao() {
		if(vagoes.size() > 0){
      vagoes.get(vagoes.size()-1).setLivre();
			vagoes.remove(vagoes.size()-1);
			return true;
		}
		return false;
    }

    @Override
	public String toString() {
		return "Trem [identificador=" + identificador + ", locomotivas=" + locomotivas + ", vagoes=" + vagoes + "]";
	}
}