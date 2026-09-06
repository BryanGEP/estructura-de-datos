package tema4;

public class NodoActi
{
	private Articulo arti;
	private NodoActi izq, der, pad;

	public NodoActi(Articulo arti)
	{
		pad = null;
		this.arti = arti;
		izq = null;
		der = null;
	}

	public Articulo getCue()
	{
		return arti;
	}

	public void setCue(Articulo arti)
	{
		this.arti = arti;
	}

	public NodoActi getIzq()
	{
		return izq;
	}

	public void setIzq(NodoActi izq)
	{
		this.izq = izq;
	}

	public NodoActi getDer()
	{
		return der;
	}

	public void setDer(NodoActi der)
	{
		this.der = der;
	}

	public NodoActi getPad()
	{
		return pad;
	}

	public void setPad(NodoActi pad)
	{
		this.pad = pad;
	}
}
