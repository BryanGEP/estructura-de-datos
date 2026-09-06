package tema3;

import ed.Datos;
import ed.Formato;

public class ColasAlu
{
	private int tam, pos;
	private boolean ban;
	private String nc;
	private Alumno cola[];
	private Datos obd = new Datos();

	public ColasAlu()
	{
		do
			tam = obd.Entero("Cantidad de alumnos: ");
		while (tam < 1);
		cola = new Alumno[tam];
		tam = -1;
	}

	private void Titulo()
	{
		Formato obf = new Formato();
		System.out.println(obf.Izquierda("NC CONTROL", 10) + " | " + obf.Izquierda("NOMBRE", 25) + " | "
				+ obf.Derecho("PROMEDIO", 5));
	}

	private boolean Vacia()
	{
		return tam == -1;
	}

	private boolean LLena()
	{
		return tam == cola.length - 1;
	}

	public void Insertar()
	{
		if (!this.LLena())
		{
			cola[++tam] = new Alumno();
			System.out.println("Alumno almacenado insertado con exito...");
		}
		else
			System.out.println("Cola llena...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("Alumno extraido....");
			this.Titulo();
			cola[0].Mostrar();
			if (tam != 0)
			{
				for (pos = 0; pos < tam; pos++)
					cola[pos] = cola[pos + 1];
				tam--;
			}
			else
				tam = -1;
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Nombres de la lista...");
			this.Titulo();
			for (pos = 0; pos <= tam; pos++)
				cola[pos].Mostrar();
			System.out.println("Fin de la cola...");
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Buscar()
	{
		ban = true;
		if (!this.Vacia())
		{
			nc = obd.Cadena("No de Control a buscar: ").toUpperCase();
			for (pos = 0; pos <= tam; pos++)
				if (cola[pos].NoControl().equals(nc))
				{
					System.out.println("Alumno encontrado..");
					this.Titulo();
					cola[pos].Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El Alumno no se encuentra en la cola...");
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Modificar()
	{
		ban = true;
		if (!this.Vacia())
		{
			nc = obd.Cadena("No de Control a buscar: ").toUpperCase();
			for (pos = 0; pos <= tam; pos++)
				if (cola[pos].NoControl().equals(nc))
				{
					cola[pos].Modificar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El Alumno no se encuentra en la cola...");
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Borrar()
	{
		tam = -1;
		System.out.println("Cola borrada...");
	}
}
