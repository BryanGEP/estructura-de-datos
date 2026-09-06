package tema3;

public class Materia2
{
	private int clv, hrst, hrsp, plan;
	private String nom, cre;

	public int getClave()
	{
		return clv;
	}

	public void setClave(int clv)
	{
		this.clv = clv;
	}

	public int getHorasTeo()
	{
		return hrst;
	}

	public void setHorasPrac(int hrsp)
	{
		this.hrsp = hrsp;
	}

	public int getHorasPrac()
	{
		return hrsp;
	}

	public void setHorasTeo(int hrst)
	{
		this.hrst = hrst;
	}

	public String getNombre()
	{
		return nom;
	}

	public void setNombre(String nom)
	{
		this.nom = nom;
	}

	public String getCreditos()
	{
		return cre;
	}

	public void setCreditos(String cre)
	{
		this.cre = cre;
	}

	public int getPlan()
	{
		return plan;
	}

	public void setPlan(int plan)
	{
		this.plan = plan;
	}

}
