package tema3;

public class NodoLCDPro
{
	private Producto pro;
	private NodoLCDPro ant, sig;

	public NodoLCDPro(Producto pro)
	{
		ant = null;
		this.pro = pro;
		sig = null;
	}

	public Producto getPro()
	{
		return pro;
	}

	public void setPro(Producto pro)
	{
		this.pro = pro;
	}

	public NodoLCDPro getAnterior()
	{
		return ant;
	}

	public void setAnterior(NodoLCDPro ant)
	{
		this.ant = ant;
	}

	public NodoLCDPro getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoLCDPro sig)
	{
		this.sig = sig;
	}
}
