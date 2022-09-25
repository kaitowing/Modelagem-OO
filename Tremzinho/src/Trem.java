import java.util.ArrayList;

public class Trem {
    private int identificador;
    private ArrayList<ElementoTrem> elementos;

    public Trem(int identificador){
        this.identificador = identificador;
        elementos = new ArrayList<>();
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public int getQtdadeLocomotivas() {
      int contL = 0;
      for (ElementoTrem elementoTrem : elementos) {
        if(elementoTrem instanceof Locomotiva){
          contL++;
        }
      }
        return contL;
    }

    public ElementoTrem getLocomotiva(int posicao) {
      if(posicao >= 0 && posicao < getQtdadeLocomotivas()){
        return elementos.get(posicao);
      }else{
        return null;
      }
    }

    public int getQtdadeVagoes() {
      int contV = 0;
      for (ElementoTrem elementoTrem : elementos) {
        if(elementoTrem instanceof Vagao || elementoTrem instanceof VagaoPassageiro){
          contV++;
        }
      }
        return contV;
    }

    public ElementoTrem getVagao(int posicao) {
      if (posicao > 0 && posicao < getQtdadeVagoes()) {
        return elementos.get(posicao + getQtdadeLocomotivas());
      } else {
        return null;
      }
    }

    public int maxVagoesNoTrem() {
        int totalVagoes = 0;
        for(ElementoTrem elemento : elementos){
          if(elemento instanceof Locomotiva){
            totalVagoes += ((Locomotiva) elemento).getQtdadeMaxVagoes();
          }
        }

        // for(int i = 0; i < locomotivas.size(); i++){
        //     totalVagoes += locomotivas.get(i).getQtdadeMaxVagoes();
        // }
        
        if(getQtdadeLocomotivas() != 1){
          totalVagoes = (int)(totalVagoes * (1 - (0.1 * (getQtdadeLocomotivas()-1))));
        }
        
        return totalVagoes;
    }

    public double pesoMaxNoTrem() {
		  double pesoMaximo = 0;

      for(ElementoTrem elemento : elementos){
        if(elemento instanceof Locomotiva){
          pesoMaximo += ((Locomotiva)elemento).getPesoMaximo();
        }
      }

		  return pesoMaximo;
    }

    public double pesoAtualDoTrem() {
		  double pesoAtual = 0;

		  for(ElementoTrem elemento : elementos){
        if(elemento instanceof Vagao){
          pesoAtual += ((Vagao)elemento).getCapacidadeCarga();
        }
      }
      
		  return pesoAtual;
    }

    public boolean engataLocomotiva(ElementoTrem elementoTrem) {
		if(getQtdadeVagoes() > 0){
			return false;
		}else{
			elementos.add((Locomotiva) elementoTrem);
			return true;
		}
    }

    public boolean engataVagao(ElementoTrem elementoTrem) {
		if(getQtdadeLocomotivas() == 0){
			return false;
		}else{
			elementos.add((Vagao) elementoTrem);
			return true;
		}
    }

    public boolean desengataLocomotiva() {
      if(getQtdadeLocomotivas() > 1){
        elementos.get(getQtdadeLocomotivas()-1).setLivre();
			  elementos.remove(getQtdadeLocomotivas()-1);
			return true;
		}
		return false;
    }

    public boolean desengataVagao() {
		if(getQtdadeVagoes() > 0){
      elementos.get(getQtdadeVagoes()+getQtdadeLocomotivas()-1).setLivre();
			elementos.remove(getQtdadeVagoes()+getQtdadeLocomotivas()-1);
			return true;
		}
		return false;
    }

    @Override
	public String toString() {
		return "Trem [identificador=" + identificador + ", elementos=" + elementos + "]";
	}
}