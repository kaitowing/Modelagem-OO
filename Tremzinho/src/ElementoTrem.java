public abstract class ElementoTrem {
    private int identificador;
	private Trem trem;

    public ElementoTrem(int identificador) {
		this.identificador = identificador;
		this.trem = null;
	}

	public int getIdentificador() {
		return identificador;
	}

	public Trem getTrem() {
		return trem;
	}

	public void setLivre(){
		this.trem = null;
	}

	public boolean livre(){
		return trem == null;
	}

	public void setTrem(Trem trem) {
		this.trem = trem;
	}
}
