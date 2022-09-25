public class VagaoPassageiro extends Vagao
{
	protected int capacidadePassageiros;

	public VagaoPassageiro(int identificador, int capacidadePassageiros) 
	{
		super(identificador, capacidadePassageiros);
		this.capacidadePassageiros = capacidadePassageiros;
	}

	public int getCapacidadePassageiro() {
		return capacidadePassageiros;
	}

	public double getCapacidadeCarga(){
		return capacidadePassageiros * 75 / 1000;
	}

	@Override
	public String toString() {
		if (livre()){
			return "VagaoPassageiros [LIVRE, capacidadePassageiros=" + capacidadePassageiros + ", identificador="
			+ identificador + "]";
		}
		return "VagaoPassageiros [Engatado no trem=" + trem.getIdentificador() + "capacidadePassageiros=" + capacidadePassageiros + ", identificador="
		+ identificador + "]";
	}
}