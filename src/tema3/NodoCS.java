package tema3;

public class NodoCS
{
	private int num;
	private NodoCS sig;

	public NodoCS(int num)
	{
		this.num = num;
		sig = null;
	}

	public int getNumero()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public NodoCS getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoCS sig)
	{
		this.sig = sig;
	}
}
