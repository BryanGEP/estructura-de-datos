package tema3;

public class NodoCDM
{
	private MateriaOp mat;
	private NodoCDM sig, ant;
	
	public NodoCDM(MateriaOp mat)
	{
		this.mat = mat;
		sig = null;
	}

	public MateriaOp getMateria() 
	{
		return mat;
	}

	public void setMateria(MateriaOp mat) 
	{
		this.mat = mat;
	}

	public NodoCDM getSiguiente() 
	{
		return sig;
	}

	public void setSiguiente(NodoCDM sig) 
	{
		this.sig = sig;
	}
	
	public NodoCDM getAnterior() 
	{
		return ant;
	}

	public void setAnterior(NodoCDM ant)
	{
		this.ant = ant;
	}
}
