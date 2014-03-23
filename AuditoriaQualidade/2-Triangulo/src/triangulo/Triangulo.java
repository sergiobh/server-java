package triangulo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgard Davidson
 */
public class Triangulo {
	public final static int ISOSCELES = 1;
	public final static int ESCALENO = 2;
	public final static int EQUILATERO = 3;
	public final static int INEXISTENTE = 4;

	private double lado1, lado2, lado3;

	public Triangulo() {
		atribuirLados(0, 0, 0);
	}

	public Triangulo(double lado1, double lado2, double lado3) {
		atribuirLados(lado1, lado2, lado3);
	}

	public boolean eTriangulo(double lado1, double lado2, double lado3) {
		if (lado1 < (lado2 + lado3) && lado2 < (lado1 + lado3)
				&& lado3 < (lado1 + lado2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean possuiValoresNulosNeg(double lado1, double lado2,
			double lado3) {
		if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void atribuirLados(double lado1, double lado2, double lado3) {
		if (eTriangulo(lado1, lado2, lado3)
				&& !possuiValoresNulosNeg(lado1, lado2, lado3)) {
			this.lado1 = lado1;
			this.lado2 = lado2;
			this.lado3 = lado3;
		} else {
			this.lado1 = 0;
			this.lado2 = 0;
			this.lado3 = 0;
		}

	}

	public String obterTextoTriangulo() {
		switch (obterTriangulo()) {
		case ISOSCELES:
			return (new String("O triângulo é isósceles."));
		case ESCALENO:
			return (new String("O triângulo é escaleno."));
		case EQUILATERO:
			return (new String("O triângulo é equilátero."));
		case INEXISTENTE:
			return (new String("Os valores não formam um triângulo."));
		default:
			return (new String("Tipo inválido."));
		}
	}

	public int obterTriangulo() {
		if (eTriangulo(lado1, lado2, lado3)
				&& !possuiValoresNulosNeg(lado1, lado2, lado3)) {
			if (lado1 == lado2 && lado2 == lado3) {
				return EQUILATERO;
			} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
				return ISOSCELES;
			} else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
				return ESCALENO;
			} else {
				return INEXISTENTE;
			}
		} else {
			return INEXISTENTE;
		}
	}

}