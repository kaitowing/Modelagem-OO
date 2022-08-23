import java.util.ArrayList;

public class GaragemLocomotivas {
	private ArrayList<Locomotiva> locomotivas;
	
	public GaragemLocomotivas(){
		locomotivas = new ArrayList<>();
	}

	public void adicionaGaragem(Locomotiva l){
		locomotivas.add(l);
	}

	public boolean removeGaragem(int id){
		for (int j = 0; j < locomotivas.size(); j++) {
			if(locomotivas.get(j).getIdentificador() == id){
				locomotivas.remove(j);
				return true;
			}
		}
		return false;
	}

	public int qtdade(){
		return locomotivas.size();
	}

	public Locomotiva getPorPosicao(int pos){
		return locomotivas.get(pos);
	}

	public Locomotiva getPorId(int id){
		for (int i = 0; i < locomotivas.size(); i++) {
			if(locomotivas.get(i).getIdentificador() == id){
				return locomotivas.get(i);
			}
		} return null;
	}

	public String toString(){
		return "GaragemLocomotivas [locomotivas=" + locomotivas + "]";
	}
}