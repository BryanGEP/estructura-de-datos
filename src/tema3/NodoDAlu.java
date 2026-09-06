package tema3;

public class NodoDAlu
{
	Alumno alu;
	private NodoDAlu ant, sig;

	public NodoDAlu(Alumno alu)
	{
		ant = null;
		this.alu = alu;
		sig = null;
	}

	public Alumno getAlumno()
	{
		return alu;
	}

	public void setAlumno(Alumno alu)
	{
		this.alu = alu;
	}

	public NodoDAlu getAnterior()
	{
		return ant;
	}

	public void setAnterior(NodoDAlu ant)
	{
		this.ant = ant;
	}

	public NodoDAlu getSiguiente()
	{
		return sig;
	}

	public void setSiguiente(NodoDAlu sig)
	{
		this.sig = sig;
	}
}
