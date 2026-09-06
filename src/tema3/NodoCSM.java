package tema3;

public class NodoCSM
{
	private MateriaOp mat;
	private NodoCSM sig;

	public NodoCSM(MateriaOp mat)
	{
		this.mat = mat;
		sig = null;
	}

	public MateriaOp getMateria()
	{
		return mat;
	}

	public void setMatateria(MateriaOp mat)
	{
		this.mat = mat;
	}

	public NodoCSM getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoCSM sig)
	{
		this.sig = sig;
	}
}
