package tema3;

import ed.Datos;
import java.util.Vector;

public class ColaDinamica
{
	private Vector<String> cola = new Vector<String>(4, 1);
	private Datos obd = new Datos();

	private boolean Vacia()
	{
		return cola.isEmpty();
	}

	public void Insertar()
	{
		cola.add(obd.Cadena("Nombre de la materia a insertar: ").toUpperCase());
		System.out.println("Materia insertada con exito...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
			System.out.println("Materia Extraida " + cola.remove(0));
		else
			System.out.println("Cola de materias vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Materias de la cola...");
			for (String mat : cola)
				System.out.println(mat);
			System.out.println("Final de la cola...");
		}
		else
			System.out.println("Cola de materias vacia...");
	}

	public void Buscar()
	{
		String dat;
		boolean ban = true;
		if (!this.Vacia())
		{
			dat = obd.Cadena("Dato a buscar: ").toUpperCase();
			for (String mat : cola)
				if (mat.indexOf(dat) != -1)
				{
					System.out.println(mat);
					ban = false;
				}
			if (ban)
				System.out.println("El dato no existe en la cola");
		}
		else
			System.out.println("Cola de materias vacia...");
	}

	public void Borrar()
	{
		cola.clear();
		System.out.println("Cola borrada...");
	}
}
