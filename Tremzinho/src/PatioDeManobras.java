import java.util.ArrayList;

public class PatioDeManobras {
	private ArrayList<Trem> trens;
	
	public PatioDeManobras(){
		trens = new ArrayList<>();
	}

	public void adicionaPatio(Trem t){
		trens.add(t);
	}

	public boolean removePatio(int id){
		if(trens.size() > 0){
			for(Trem trem : trens){
				if(trem.getIdentificador() == id){
					while(trem.getQtdadeVagoes() > 0){
						trem.desengataVagao();
					}
					while(trem.getQtdadeLocomotivas() > 1){
						trem.desengataLocomotiva();
					}
					trem.getLocomotiva(0).setLivre();
					trens.remove(trem);
					return true;
				}
			}
		}
		return false;
	}

	public int qtdade(){
		return trens.size();
	}

	public Trem getPorPosicao(int pos){
		return trens.get(pos);
	}

	public Trem getPorId(int id){
		for (int j = 0; j < trens.size(); j++) {
			if(trens.get(j).getIdentificador() == id){
				return trens.get(j);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Pátio de Manobras [trens=" + trens + "]";
	}
}