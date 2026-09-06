package tema3;

import java.util.Vector;

import ed.*;

public class PilaDAlumno
{
	private Vector<Alumno> pila, aux;
	private Alumno alu;
	private String nc;
	private boolean ban;
	private Datos obd = new Datos();

	public PilaDAlumno()
	{
		pila = new Vector<Alumno>(4, 2);
		aux = new Vector<Alumno>(4, 2);
	}

	private boolean Vacia()
	{
		return pila.isEmpty();
	}

	private void Intercambio()
	{
		while (!aux.isEmpty())
			pila.add(aux.remove(aux.size() - 1));
	}

	private void Mensaje()
	{
		Formato obf = new Formato();
		System.out.println(obf.Izquierda("No ctrl", 10) + " | " + obf.Izquierda("Nombre", 25) + " | "
				+ obf.Derecho("Promedio", 5));
	}

	public void Insertar()
	{
		pila.add(new Alumno());
		System.out.println("Alumno amacenado..");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("Alumno eliminado...");
			this.Mensaje();
			pila.remove(pila.size() - 1).Mostrar();
		}
		else
			System.out.println("Pila vacia");
	}

	public void Recorrido()
	{
		int con = 1;
		if (!this.Vacia())
		{
			System.out.println("Lista de alumnos...");
			this.Mensaje();
			while (!this.Vacia())
			{
				alu = pila.remove(pila.size() - 1);
				alu.Mostrar();
				if (con == 5)
				{
					obd.Enter();
					con = 0;
				}
				con++;
				aux.add(alu);
			}
			this.Intercambio();
		}
		else
			System.out.println("Pila vacia");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			ban = true;
			nc = obd.Cadena("Nombre o apellido a buscar: ").toUpperCase();
			while (!this.Vacia())
			{
				alu = pila.remove(pila.size() - 1);
				if (alu.Nombre().contains(nc))
				{
					if (ban)
					{
						System.out.println("Alumno encontrado: ");
						this.Mensaje();
					}
					alu.Mostrar();
					ban = false;
				}
				aux.add(alu);
			}
			this.Intercambio();
			if (ban)
				System.out.println("El alumno no esta en la pila...");
		}
		else
			System.out.println("Pila vacia");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			ban = true;
			nc = obd.Cadena("No de control a modificar: ").toUpperCase();
			while (!this.Vacia())
			{
				alu = pila.remove(pila.size() - 1);
				if (alu.NoControl().equals(nc))
				{
					System.out.println("Alumno encontrado: ");
					this.Mensaje();
					alu.Modificar();
					ban = false;
					aux.add(alu);
					break;
				}
				aux.add(alu);
			}
			this.Intercambio();
			if (ban)
				System.out.println("El alumno no esta en la pila...");
		}
		else
			System.out.println("Pila vacia");
	}

	public void Borrar()
	{
		pila.clear();
		System.out.println("Pila borrada...");
	}
}
