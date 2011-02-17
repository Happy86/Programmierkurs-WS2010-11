package mathe;

public class TesteMathe {

	public static void main(String[] args) {
		Polynom p = new Polynom(1.0, 2.0, 4.0);
		System.out.println(p);
		System.out.println(p.wert(2));
		System.out.println(p.ableiten());
		System.out.println(p.ableiten().ableiten());
		System.out.println(p.ableiten().ableiten().ableiten());
		System.out.println(p.durchmultiplizieren(0.5, 4));

		Polynom a = new Polynom(1, 3, 0, 7, 5, 1, 2);
		Polynom b = new Polynom(7, 5, 4, 3, 1);

		Polynom c = a.addiere(b);
		System.out.println(c);

		Polynom p1 = new Polynom(-3, 1, -3, 1);
		Polynom q1 = new Polynom(-3, 1);

		System.out.println(p1.div(q1));

		System.out
				.println("Spezialfälle mod :  \n==================================================");
		a = new Polynom(1, 2, 3);
		b = new Polynom(0.0);
		System.out.println(a + " mod " + b + " = " + a.mod(b));

		a = new Polynom(1.0);
		b = new Polynom(0.0);
		System.out.println(a + " mod " + b + " = " + a.mod(b));

		a = new Polynom(1, 2, 3);
		b = new Polynom(1.0);
		System.out.println(a + " mod " + b + " = " + a.mod(b));

		System.out
				.println("Spezialfälle ggT :  \n==================================================");
		a = new Polynom(1, 2, 3);
		b = new Polynom(1.0);
		System.out.println("ggT (" + a + ", " + b + ") = " + a.ggT(b));

		a = new Polynom(1, 2, 3);
		System.out.println("ggT (" + a + ", " + a + ") = " + a.ggT(a));

		System.out
				.println("Beispiel:\n===============================================");
		// 15x^4 + 42x^3 + 21x^2 + 3x + 18
		a = new Polynom(18, 3, 21, 42, 15);
		// 6x^6 + 15x^5 - 9x^4 - 39x^3 - 12x^2 + 6x - 12
		b = new Polynom(-12, 6, -12, -39, -9, 15, 6);
		System.out.println("ggT (" + a + "\n, " + b + ") = \n" + a.ggT(b));

	}

}
