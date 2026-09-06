package tema3;

import ed.Datos;

public class BicolaMat
{
	private int tam, pos, clv;
	private Materia bicola[];
	private boolean ban;

	private Datos obd = new Datos();

	public BicolaMat()
	{
		do
			tam = obd.Entero("TAMAÑO DE LA BICOLA: ");
		while (tam < 1);
		bicola = new Materia[tam];
	}

	private boolean Vacia()
	{
		return tam == -1;
	}

	private boolean Llena()
	{
		return tam == bicola.length - 1;
	}

	private int Clave()
	{
		if (!this.Vacia())
			return bicola[tam].Clave() > bicola[0].Clave() ? bicola[tam].Clave() + 1 : bicola[0].Clave() + 1;
		else
			return 1;
	}

	public void InsertarIni()
	{
		if (!this.Vacia())
		{
			clv = this.Clave();
			for (pos = tam + 1; pos > 0; pos--)
				bicola[pos] = bicola[pos - 1];
			bicola[0] = new Materia(clv);
			// bicola[0].Nueva(0);
			System.out.println("Materia insertada con éxito");
		}
		else
			System.out.println("La bicola está llena...");
	}

	public void InsertarFin()
	{
		if (!this.Llena())
		{
			clv = this.Clave();
			bicola[++tam] = new Materia(clv);
			// bicola[tam].Nueva(clv);
			System.out.println("Nombre insertado con éxito...");
		}
		else
			System.out.println("La bicola está llena...");
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Materia extraida del inicio...");
			bicola[0].Mostrar();
			for (pos = 0; pos < tam; pos++)
				bicola[pos] = bicola[pos + 1];
			tam--;
		}
		System.out.println("La bicola está vacia...");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Materia extraida del final...");
			bicola[tam].Mostrar();
			tam--;
		}
		else
			System.out.println("La bicola está vacia...");

	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista");
			for (pos = 0; pos <= tam; pos++)
				bicola[pos].Mostrar();
			System.out.println("Fin de la lista...");
		}
		else
			System.out.println("La bicola está vacia...");
	}

	public void BuscarClv()
	{
		ban = true;
		if (!this.Vacia())
		{
			clv = obd.Entero("Clave de la materia que busca: ");
			for (pos = 0; pos <= tam; pos++)
				if (bicola[pos].Clave() == clv)
				{
					System.out.println("Materia encontrada...");
					bicola[pos].Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("La materia no existe");
		}
		else
			System.out.println("La bicola está vacia...");
	}

	public void BuscarPlan()
	{
		ban = true;
		if (!this.Vacia())
		{
			clv = obd.Entero("Plan de la materia que busca: ");
			for (pos = 0; pos <= tam; pos++)
				if (bicola[pos].Plan() == clv)
				{
					if (ban)
						System.out.println("Lista de materias por plan...");
					bicola[pos].Mostrar();
					ban = false;
				}
			if (ban)
				System.out.println("La materia no existe");
		}
		else
			System.out.println("La bicola está vacia...");
	}

	public void Modificar()
	{
		ban = true;
		if (!this.Vacia())
		{
			clv = obd.Entero("Clave de la materia que busca modificar: ");
			for (pos = 0; pos <= tam; pos++)
				if (bicola[pos].Clave() == clv)
				{
					bicola[pos].Modificar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("La materia no existe");
		}
		else
			System.out.println("La bicola está vacia...");
	}

	public void Borrar()
	{
		tam = -1;
		System.out.println("Bicola borrada...");
	}

}
