package mathe;

public class Polynom {
	private static double fastNull = 0.0000000001;

	private double[] koeff;

	/*
	 * Konstruktor
	 */
	public Polynom(double ... werte) {
		koeff = werte.clone();
	}
	
	
	/*
	 * Polynom Methoden
	 * 
	 */
	public String toString() {
		String erg = "";
		for (int i = koeff.length - 1; i >= 0; i--) {
			erg += koeff[i] + "x^" + i;
			if (i != 0)
				erg += " + ";
		}
		return erg;
	}

	public double wert(double x0) {
		double sum = 0.0;
		for (int i = 0; i < koeff.length; i++) {
			sum += koeff[i] * Math.pow(x0, (double) i);
		}
		return sum;
	}

	public int grad() {
		int erg = -1;
		for (int i = 0; i < koeff.length; i++) {
			if (Math.abs(koeff[i]) > fastNull)
				erg = i;
		}
		return erg;
	}

	public Polynom ableiten() {
		if (koeff.length == 1)
			return new Polynom(0.0);
		double[] erg = new double[koeff.length - 1];

		for (int i = 0; i < erg.length; i++) {
			erg[i] = koeff[i + 1] * (double) (i + 1);
		}
		return new Polynom(erg);
	}

	public Polynom durchmultiplizieren(double r, int e) {
		double[] erg = new double[koeff.length + e];

		for (int i = 0; i < koeff.length; i++) {
			erg[i + e] = koeff[i] * r;
		}
		return new Polynom(erg);
	}

	public Polynom addiere(Polynom b) {
		Polynom a = this;
		Polynom c;

		if (b.koeff.length > a.koeff.length) {
			a = b;
			b = this;
		}
		// a ist das "längere" Polynom
		c = new Polynom(a.koeff);

		for (int i = 0; i < b.koeff.length; i++) {
			c.koeff[i] += b.koeff[i];
		}
		return c;
	}

	public Polynom div(Polynom q) {
		Polynom p = new Polynom(koeff);
		if (q.koeff.length > p.koeff.length)
			return new Polynom(0.0);

		double[] erg = new double[p.koeff.length - q.koeff.length + 1];

		int p_akt_koeff = p.koeff.length - 1;

		for (int i = erg.length - 1; i >= 0; i--) {
			erg[i] = p.koeff[p_akt_koeff] / q.koeff[q.koeff.length - 1];
			Polynom c = q.durchmultiplizieren(-1.0 * erg[i], i);
			p = p.addiere(c);
			p.koeff[p_akt_koeff] = 0.0;
			p_akt_koeff--;
		}
		return new Polynom(erg);

	}

	public Polynom mod(Polynom q) {
		Polynom p = new Polynom(koeff);
		if (q.koeff.length > p.koeff.length)
			return new Polynom(p.koeff);

		int p_akt_koeff = p.koeff.length - 1;
		int co = p.koeff.length - q.koeff.length + 1;
		for (int i = co - 1; i >= 0; i--) {
			double d = p.koeff[p_akt_koeff] / q.koeff[q.koeff.length - 1];
			Polynom c = q.durchmultiplizieren(-1.0 * d, i);
			p = p.addiere(c);
			p.koeff[p_akt_koeff] = 0.0;
			p_akt_koeff--;
		}
		int g = p.grad();
		if (g >= 0) {
			double[] erg = new double[g + 1];
			for (int i = 0; i <= g; i++)
				erg[i] = p.koeff[i];
			return new Polynom(erg);
		} else
			return new Polynom(0.0);
	}

	public Polynom ggT(Polynom b) {
		if (b.grad() < 0)
			return new Polynom(this.koeff);
		else
			return b.ggT(this.mod(b));
	}

	public static Polynom ggT(Polynom a, Polynom b) {
		if (b.grad() < 0)
			return a;
		else
			return ggT(b, a.mod(b));
	}
	
	/*
	 * Getter
	 */
	
	public static double getFastNull() {
		return fastNull;
	}
	
	public double[] getKoeff(){
		return this.koeff;
	}

	/*
	 * Sonstiges
	 */
	public Polynom clone(){
		Polynom p_ziel = new Polynom(this.getKoeff());
		return p_ziel;
	}


}
