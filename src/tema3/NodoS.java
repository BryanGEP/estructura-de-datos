package tema3;

public class NodoS
{
	private String dato;
	private NodoS sig;

	public NodoS(String dato)
	{
		this.dato = dato;
		sig = null;
	}

	public String getDato()
	{
		return dato;
	}

	public void setDato(String dato)
	{
		this.dato = dato;
	}

	public NodoS getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoS sig)
	{
		this.sig = sig;
	}

}
