package tema2;

import ed.Datos;

public class Producto
{
	public int Numero(String msj)
	{
		int num;
		do
			num = new Datos().Entero(msj);
		while (num < 0);
		return num;
	}

	public int Productos(int num1, int num2)
	{
		if (num1 == 0)
			return 0;
		else
			return num2 + this.Productos(num1 - 1, num2);
	}

	public void Mostrar(int res)
	{
		System.out.println("La multiplicacion es: " + res);
	}
}
