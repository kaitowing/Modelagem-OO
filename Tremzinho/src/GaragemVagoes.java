import java.util.ArrayList;

public class GaragemVagoes {
	private ArrayList<Vagao> vagoes;

	public GaragemVagoes(){
		vagoes = new ArrayList<>();
	}

	public void adicionaGaragem(Vagao v){
		vagoes.add(v);
	}

	public boolean removeGaragem(int id){
		for (int j = 0; j < vagoes.size(); j++) {
			if(vagoes.get(j).getIdentificador() == id){
				vagoes.remove(j);
				return true;
			}
		}
		return false;
	}

	public int qtdade(){
		return vagoes.size();
	}

	public Vagao getPorPosicao(int pos){
		return vagoes.get(pos);
	}

	public Vagao getPorId(int id){
		for (int i = 0; i < vagoes.size(); i++) {
			if(vagoes.get(i).getIdentificador() == id){
				return vagoes.get(i);
			}
		} return null;
	}
	
	public String toString(){
		return "Vagões na garagem [vagões=" + vagoes + "]";
	}
}