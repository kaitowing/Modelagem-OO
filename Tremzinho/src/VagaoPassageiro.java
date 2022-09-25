public class VagaoPassageiro extends Vagao
{
	protected double capacidadePassageiros;

	public VagaoPassageiro(int identificador, double capacidadePassageiros) 
	{
		super(identificador, capacidadePassageiros);
		this.capacidadePassageiros = (capacidadePassageiros*1000.0)/70.0;
	}

	public double getCapacidadePassageiro() {
		return capacidadePassageiros;
	}

	public void setCapacidadePassageiros(double capacidadePassageiros) {
		this.capacidadePassageiros = capacidadePassageiros;
	}

	@Override
	public String toString() {
		return "VagaoPassageiros [capacidadePassageiros=" + (int) capacidadePassageiros + ", trem=" + trem + ", identificador="
		+ identificador + "]";
	}
}