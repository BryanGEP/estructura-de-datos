package tema3;

import ed.Datos;

public class PilaPromedio
{
	private String pila[], cal;
	private int pos, tam;
	private Datos obd = new Datos();

	public PilaPromedio()
	{
		do
			tam = obd.Entero("Cual es el tamaño de la pila: ");
		while (tam < 1);
		pila = new String[tam];
		tam = -1;
	}

	private boolean Vacia()
	{
		return tam == -1;
	}

	private boolean LLena()
	{
		return tam == pila.length - 1;
	}

	public void Insertar()
	{
		int num;
		if (!this.LLena())
		{
			do
				num = obd.Entero("Nueva calificaccion: ");
			while (num < 0 || num > 100);
			cal = num < 70 ? "NA" : num + "";
			pila[++tam] = cal;
			System.out.println("\nCalificacion almacenada en la pila...");
		}
		else
			System.out.println("\nPila llena...");
	}

	public void Extrarer()
	{
		if (!this.Vacia())
			System.out.println("\nCalificacion extraida " + pila[tam--]);
		else
			System.out.println("\nPila vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Elementos de la pila...");
			for (pos = tam; pos >= 0; pos--)
				System.out.println(pila[pos]);
			System.out.println("\nFin de la pila...");
		}
		else
			System.out.println("\nPila vacia...");
	}

	public void Buscar()
	{
		int con = 0;
		if (!this.Vacia())
		{
			cal = obd.Cadena("\nCual es la calificacion a buscar: ").toUpperCase();
			for (pos = tam; pos >= 0; pos--)
				if (pila[pos].equals(cal))
					con++;
			System.out.println("\nLa calificacion " + cal + " se encontro " + con + " veces");
		}
		else
			System.out.println("\nPila vacia...");
	}

	public void Borrar()
	{
		/*if (!this.Vacia())
			tam=-1;
		else
			System.out.println("Pila vacia...");*/
		
		boolean ban = true;
		if (!this.Vacia())
		{
			cal = obd.Cadena("\nCual es la calificacion a borra: ").toUpperCase();
			for (pos = tam; pos >= 0; pos--)
				if (pila[pos].equals(cal))
				{
					for (; pos < tam; pos++)
						pila[pos] = pila[pos + 1];
					tam--;
					ban = false;
					break;
				}
			if (ban)
				System.out.println("\nLa calificacion existe...");
		}
		else
			System.out.println("\nPila Vacia...");
	}
}
