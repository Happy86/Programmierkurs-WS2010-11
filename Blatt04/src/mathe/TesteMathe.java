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
	}

}