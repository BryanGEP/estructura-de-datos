package tema4;

public class Nodo2T
{
	private Trabajador tra;
	private Nodo2T izq, der;

	public Nodo2T(Trabajador tra)
	{
		this.tra = tra;
		izq = null;
		der = null;
	}

	public Trabajador getTra()
	{
		return tra;
	}

	public void setTra(Trabajador tra)
	{
		this.tra = tra;
	}

	public Nodo2T getIzq()
	{
		return izq;
	}

	public void setIzq(Nodo2T izq)
	{
		this.izq = izq;
	}

	public Nodo2T getDer()
	{
		return der;
	}

	public void setDer(Nodo2T der)
	{
		this.der = der;
	}
}
