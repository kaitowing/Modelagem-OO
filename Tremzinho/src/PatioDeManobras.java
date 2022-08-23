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
		// TO DO
	}
	
	public String toString(){
		// TO DO
	}
}