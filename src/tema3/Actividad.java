package tema3;

import java.util.LinkedList;
import ed.Datos;

public class Actividad
{
	private Datos obd = new Datos();
	private LinkedList<MateriaOp> lista = new LinkedList<MateriaOp>();
	private int pos, clv, ind = 1;

	private int Clave()
	{
		return lista.isEmpty() ? 1 : ++ind;
	}

	public void Insertar()
	{
		lista.add(new MateriaOp(this.Clave()));
		this.Ordenar();
	}

	private void Ordenar()
	{
		for (int i = 0; i < lista.size() - 1; i++)
			for (int j = 0; j < lista.size() - i - 1; j++)
				// Comparar dos elementos adyacentes
				if (lista.get(j).Nombre().compareTo(lista.get(j + 1).Nombre()) > 0)
				{
					// Intercambiarlos si están desordenados
					MateriaOp temp = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, temp);
				}

	}

	public void Extraer()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a extraer: ");
			while (clv < 1 || clv > lista.getLast().Clave());
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Materia extraido...");
					lista.remove(pos).Mostrar();
					break;
				}
			if (pos > lista.size())
				System.out.println("La materia no existe..");
		}
		else
			System.out.println("lista vacia");
	}

	public void Recorrido()
	{
		if (!lista.isEmpty())
		{
			System.out.println("Lista");
			for (MateriaOp pro : lista)
				pro.Mostrar();
			System.out.println("Fin de la lista");
		}
		else
			System.out.println("lista vacia");
	}

	public void Buscar()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a buscar: ");
			while (clv < 1 || clv > lista.size() + 1);
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Materia encontrado...");
					lista.get(pos).Mostrar();
					break;
				}
			if (pos > lista.size())
				System.out.println("La materia no existe..");
		}
		else
			System.out.println("lista vacia");
	}

	public void Modificar()
	{
		if (!lista.isEmpty())
		{
			do
				clv = obd.Entero("Clave a modificar: ");
			while (clv < 1 || clv > lista.size() + 1);
			for (pos = 0; pos < lista.size(); pos++)
				if (lista.get(pos).Clave() == clv)
				{
					System.out.println("Producto encontrado...");
					lista.get(pos).Modificar();
					this.Ordenar();
					break;
				}
			if (pos > lista.size())
				System.out.println("La materia no existe..");
		}
		else
			System.out.println("lista vacia");
	}
}
