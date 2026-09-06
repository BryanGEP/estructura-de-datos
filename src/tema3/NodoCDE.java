package tema3;

public class NodoCDE
{
	private int num;
	private NodoCDE sig, ant;
	
	public NodoCDE(int num)
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

	public NodoCDE getSiguiente() 
	{
		return sig;
	}

	public void setSiguiente(NodoCDE sig) 
	{
		this.sig = sig;
	}
	
	public NodoCDE getAnterior() 
	{
		return ant;
	}

	public void setAnterior(NodoCDE ant) 
	{
		this.ant = ant;
	}
}
