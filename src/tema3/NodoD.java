package tema3;

public class NodoD
{
	private String np;
	private NodoD ant, sig;

	public NodoD(String np)
	{
		ant = null;
		this.np = np.toUpperCase();
		sig = null;
	}

	public String getProducto()
	{
		return np;
	}

	public void setProducto(String np)
	{
		this.np = np;
	}

	public NodoD getAnterior()
	{
		return ant;
	}

	public void setAnterior(NodoD ant)
	{
		this.ant = ant;
	}

	public NodoD getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoD sig)
	{
		this.sig = sig;
	}
}
