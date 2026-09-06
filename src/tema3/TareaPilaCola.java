package tema3;

import java.util.Stack;
import java.util.Vector;

import ed.Datos;
import ed.Formato;

public class TareaPilaCola
{
	private int nt, tot, op, val;
	private boolean ban;
	private String msj;
	private TDATarea tra;
	private Datos obd = new Datos();
	private Formato obf = new Formato();
	private Stack<TDATarea> pila, aux;
	private Vector<TDATarea2> cola = new Vector<TDATarea2>(4, 1);

	public TareaPilaCola()
	{
		pila = new Stack<TDATarea>();
		aux = new Stack<TDATarea>();
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
		System.out.println();
		System.out.println(obf.Izquierda("NO.CUENTA", 10) + " | " + obf.Izquierda("NOMBRE", 25) + " | "
				+ obf.Izquierda("FECHA", 12) + " | " + obf.Izquierda("SALDO", 20));
	}

	private void Titulo2()
	{
		System.out.println(obf.Derecho("MOVIMIENTO", 10) + " | " + obf.Izquierda("FECHA", 10) + " | "
				+ obf.Izquierda("MONTO", 50));
	}

	private void Intercambio()
	{
		while (!aux.empty())
			pila.push(aux.pop());
	}

	public void Insertar()
	{
		pila.push(new TDATarea(this.NoTarjeta()));
		System.out.println();
	}

	public void Consultar()
	{
		ban = true;
		if (!pila.empty())
		{
			do
				nt = obd.Entero("No. de cuenta a consultar: ");
			while (nt < 1);

			while (!pila.empty())
			{
				tra = pila.pop();
				if (tra.NoTarejta() == nt)
				{
					this.Titulos();
					if (cola.size() == 0)
						tra.Mostrar(tra.Saldo());
					else
						tra.Mostrar(this.Recorrido(0));
					System.out.println("\nMovimientos de la cuenta...");
					this.Titulo2();
					System.out.println(obf.Derecho("Deposito", 10) + " | " + obf.Izquierda(tra.Fecha(), 10) + " | "
							+ obf.Izquierda(obf.Pesos(tra.Saldo()), 10));
					this.Buscar(nt);
					ban = false;
					aux.push(tra);
					break;
				}
				aux.push(tra);
			}
			if (ban)
				System.out.println("La cuenta no existe...");
			this.Intercambio();
		}
		else
			System.out.println("No hay cuentas en la pila...");
	}

	public void Operacion(int op)
	{
		this.op = op;
		ban = true;
		if (op == 3)
			msj = "Deposito";
		else
			msj = "Retiro";
		if (!pila.empty())
		{
			do
				nt = obd.Entero("\nNo. de cuenta a la cual se le realizara el  " + msj + ": ");
			while (nt < 1);

			while (!pila.empty())
			{
				tra = pila.pop();
				if (tra.NoTarejta() == nt)
				{
					this.InsertarCola(msj);
					ban = false;
					aux.push(tra);
					break;
				}
				aux.push(tra);
			}
			if (ban)
				System.out.println("La cuenta no existe...");
			this.Intercambio();
		}
		else
			System.out.println("No hay cuentas en la pila...");
	}

	private boolean Vacia()
	{
		return cola.isEmpty();
	}

	public void InsertarCola(String msj)
	{
		if (cola.size() != 0)
			cola.add(new TDATarea2(msj, this.NoTarjeta(), this.Recorrido(0)));
		else
			cola.add(new TDATarea2(msj, this.NoTarjeta(), tra.Saldo()));
	}

	public int Recorrido(int op)
	{
		ban = true;
		if (op == 3 || op == 4)
			ban = false;
		if (!this.Vacia())
		{
			for (TDATarea2 mat : cola)
			{
				if (!ban)
					if (mat.Nulo().equals("Nulo"))
						;
					else
						mat.Mostrar2();
				else
					op = 0;
				if (mat.Movimiento().equals("Deposito"))
					tot += mat.Monto();
				else
					tot -= mat.Monto();
			}
			tot += tra.Saldo();
			val = tot;
			tot = 0;
		}
		return val;
	}

	public void Buscar(int clv)
	{
		if (!this.Vacia())
			for (TDATarea2 pro : cola)
				if (pro.Clave() == clv)
				{
					this.Recorrido(op);
					break;
				}
	}
}
