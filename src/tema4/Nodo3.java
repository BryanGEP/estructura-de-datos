package tema4;

public class Nodo3
{
	private String cad;
	private Nodo3 izq, der, pad;

	public Nodo3(String cad)
	{
		this.cad = cad;
		izq = null;
		der = null;
		pad = null;
	}

	public String getCad()
	{
		return cad;
	}

	public void setCad(String cad)
	{
		this.cad = cad;
	}

	public Nodo3 getPad()
	{
		return pad;
	}

	public void setPad(Nodo3 pad)
	{
		this.pad = pad;
	}

	public Nodo3 getIzq()
	{
		return izq;
	}

	public void setIzq(Nodo3 izq)
	{
		this.izq = izq;
	}

	public Nodo3 getDer()
	{
		return der;
	}

	public void setDer(Nodo3 der)
	{
		this.der = der;
	}
}
