import java.util.ArrayList;

public class Garagem {
    private ArrayList<ElementoTrem> elementos;
	private int qtLocomotivas;
	private int qtVagoes;

    public Garagem(){
		elementos = new ArrayList<>();
	}

	public void adicionaGaragem(ElementoTrem l){
		elementos.add(l);
		if(l instanceof Vagao) qtVagoes++;
		else qtLocomotivas++;
	}

	public boolean removeGaragem(int id){
		for (int j = 0; j < elementos.size(); j++) {
			if(elementos.get(j).getIdentificador() == id){
				if(elementos.get(j) instanceof Vagao) qtVagoes--;
				else qtLocomotivas--;
				elementos.remove(j);
				return true;
			}
		}
		return false;
	}

	public int qtdade(){
		return elementos.size();
	}

	public int getQtLocomotivas() {
		return qtLocomotivas;
	}

	public int getQtVagoes() {
		return qtVagoes;
	}

	public ElementoTrem getPorPosicao(int pos){
		return elementos.get(pos);
	}

	public ElementoTrem getPorId(int id){
		for (int i = 0; i < elementos.size(); i++) {
			if(elementos.get(i).getIdentificador() == id){
				return elementos.get(i);
			}
		} return null;
	}

	public String toString(){
		return "Garagem de Locomotivas [locomotivas=" + elementos + "]";
	}
}
