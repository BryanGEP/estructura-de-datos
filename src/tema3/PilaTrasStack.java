package tema3;

import java.util.Stack;

import ed.*;

public class PilaTrasStack
{
	private int nt;
	private boolean ban;
	private Trabajador tra;
	private String nom;
	private double sue1, sue2;
	private Datos obd = new Datos();
	private Formato obf = new Formato();
	private Stack<Trabajador> pila, aux;

	public PilaTrasStack()
	{
		pila = new Stack<Trabajador>();
		aux = new Stack<Trabajador>();
	}

	private int NoTarjeta()
	{
		if (!pila.empty())
			return pila.peek().NoTarejta() + 1;
		else
			return 1;
	}

	private void Titulos()
	{
		System.out.println(
				obf.Izquierda("N.T", 5) + " - " + obf.Izquierda("NOMBRE", 25) + " - " + obf.Derecho("SUELDO", 12));
	}

	private void Intercambio()
	{
		while (!aux.empty())
			pila.push(aux.pop());
	}

	public void Insertar()
	{
		pila.push(new Trabajador(this.NoTarjeta()));
		System.out.println("Trabajador almacenado con exito...");
	}

	public void Extraer()
	{
		if (!pila.empty())
		{
			System.out.println("Trabajador eliminado...");
			this.Titulos();
			pila.pop().Mostrar();
		}
		else
			System.out.println("No hay trabajadores en la pila...");
	}

	public void Recorrido()
	{
		if (!pila.empty())
		{
			System.out.println("Lista de trabajadores...");
			this.Titulos();
			while (!pila.empty())
			{
				tra = pila.pop();
				tra.Mostrar();
				aux.push(tra);
			}
			System.out.println("Fin de la pila...");
			this.Intercambio();
		}
		else
			System.out.println("No hay trabajadores en la pila...");
	}

	public void Buscar(int op)
	{
		ban = true;
		if (!pila.empty())
		{
			switch (op)
			{
				case 1:
					do
						nt = obd.Entero("No. de tarjeta del trabajador a buscar: ");
					while (nt < 1);
					break;
				case 2:
					nom = obd.Cadena("Nombre o apellido del trabajador a buscar: ").toUpperCase();
					break;
				case 3:
					do
					{
						sue1 = obd.Doble("Sueldo inicial: ");
						sue2 = obd.Doble("Sueldo final: ");
					}
					while (sue1 < 1 || sue1 > sue2);
			}
			while (!pila.empty())
			{
				tra = pila.pop();
				if (op == 1)
					if (tra.NoTarejta() == nt)
					{
						System.out.println("Trabajador encontrado...");
						this.Titulos();
						tra.Mostrar();
						ban = false;
						aux.push(tra);
						break;
					}
				if (op == 2)
					if (tra.Nombre().contains(nom))
					{
						if (ban)
						{
							System.out.println("Lista de trabajadores...");
							this.Titulos();
						}
						tra.Mostrar();
						ban = false;
					}
				if (op == 3)
					if (tra.Sueldo() >= sue1 && tra.Sueldo() <= sue2)
					{
						if (ban)
						{
							System.out.println("Lista de trabajadores...");
							this.Titulos();
						}
						tra.Mostrar();
						ban = false;
					}
				aux.push(tra);
			}
			if (ban)
				System.out.println("Lo que busca no existe...");
			this.Intercambio();
		}
		else
			System.out.println("No hay trabajadores en la pila...");
	}

	public void Modificar()
	{
		ban = true;
		if (!pila.empty())
		{
			do
				nt = obd.Entero("NO. de tarjeta del trabajador a modificar: ");
			while (nt < 1);
			while (!pila.empty())
			{
				tra = pila.pop();
				if (tra.NoTarejta() == nt)
				{
					tra.Modificar();
					aux.push(tra);
					ban = false;
					break;
				}
				aux.push(tra);
			}
			if (ban)
				System.out.println("El trabajador no existe...");
			this.Intercambio();
		}
		else
			System.out.println("No hay trabajadores en la pila...");
	}

	public void Borrar()
	{
		pila = new Stack<Trabajador>();
		System.out.println("Pila borrada...");
	}
}
