package tema2;

import ed.Datos;

public class Factorial
{
	public int Numero()
	{
		int fact;
		fact = new Datos().Entero("Cual es el número: ");
		if (fact < 0)
			fact = this.Numero();
		return fact;
	}

	public int Calcular(int num)
	{
		if (num < 2)
			return 1;
		else
			return num * this.Calcular(num - 1);
	}

	public void Mostrar(int res)
	{
		System.out.println("El factorial es: " + res);
	}
}
