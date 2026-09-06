package tema3;

import java.util.Vector;
import ed.Datos;
import ed.Formato;

public class ColaDProducto
{
	private int clv;
	private boolean ban;
	private Datos obd = new Datos();
	private Vector<Producto> cola = new Vector<Producto>(4, 1);

	private boolean Vacia()
	{
		return cola.isEmpty();
	}

	private int Clave()
	{
		if (!this.Vacia())
			return cola.get(cola.size() - 1).Clave() + 1;
		else
			return 1;
	}

	private void Titulo()
	{
		Formato obf = new Formato();
		System.out.println(
				obf.Izquierda("Clave", 5) + " | " + obf.Izquierda("Nombre", 25) + " | " + obf.Derecho("Precio", 12));
	}

	public void Insertar()
	{
		cola.add(new Producto(this.Clave()));
		System.out.println("Producto insertado con exito...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto extraido...");
			this.Titulo();
			cola.remove(0).Mostrar();
		}
		else
			System.out.println("Cola de productos vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Lista de productos de la cola");
			this.Titulo();
			for (Producto pro : cola)
				pro.Mostrar();
			System.out.println("Final de la cola de productos...");
		}
		else
			System.out.println("Cola de productos vacia...");
	}

	public void Buscar()
	{
		ban = true;
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("Clave del producto que busca: ");
			while (clv < 1);
			for (Producto pro : cola)
				if (pro.Clave() == clv)
				{
					System.out.println("Producto encontrado...");
					this.Titulo();
					pro.Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("La clave no existe....");

		}
		else
			System.out.println("Cola de productos vacia...");
	}

	public void Modificar()
	{
		ban = true;
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("Clave del producto que busca modificar: ");
			while (clv < 1);
			for (Producto pro : cola)
				if (pro.Clave() == clv)
				{
					pro.Modificar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("Laclave no existe....");

		}
		else
			System.out.println("Cola de productos vacia...");
	}

	public void Borrar()
	{
		cola.clear();
		System.out.println("Cola borrada...");
	}
}
