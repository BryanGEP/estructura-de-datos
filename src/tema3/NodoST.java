package tema3;

public class NodoST
{
	private Trabajador dato;
	private NodoST sig;

	public NodoST(Trabajador dato)
	{
		this.dato = dato;
		sig = null;
	}

	public Trabajador getDato()
	{
		return dato;
	}

	public void setDato(Trabajador dato)
	{
		this.dato = dato;
	}

	public NodoST getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoST sig)
	{
		this.sig = sig;
	}
}
