public class Matrix {
	private double[][] a;

	public Matrix(int zeilen, int spalten) {
		a = new double[zeilen][spalten];
	}

	protected Matrix(double[][] a) {
		// this.a = a.clone(); // lol
		this.a = new double[a.length][a.length];
		for (int z = 0; z < a.length; z++) {
			for (int s = 0; s < a[0].length; s++) {
				this.a[z][s] = a[z][s];
			}
		}
	}

	public String toString() {
		String erg = "";
		erg += "(";
		for (int zeile = 0; zeile < this.a.length; zeile++) {
			erg += "(";
			for (int spalte = 0; spalte < this.a[0].length; spalte++) {
				erg += this.a[zeile][spalte] + " ";
			}
			erg += ")";
			if (zeile < this.a.length - 1) {
				erg += "\n";
			}
		}
		erg += ")";

		return erg;
	}

	public Matrix erweitere(double r) {
		double[][] hilf = new double[a.length][a[0].length];
		for (int zeile = 0; zeile < hilf.length; zeile++) {
			for (int spalte = 0; spalte < hilf[0].length; spalte++) {
				hilf[zeile][spalte] = this.a[zeile][spalte] * r;
			}
		}

		return new Matrix(hilf);
	}

	public Matrix addieren(Matrix matB) throws Exception {
		double[][] ergebnis = new double[this.a.length][this.a[0].length];
		if (this.sameRowCount(matB) && this.sameColCount(matB)) {
			for (int Zeile = 0; Zeile < this.a.length; Zeile++) {
				for (int Spalte = 0; Spalte < this.a[0].length; Spalte++) {
					ergebnis[Zeile][Spalte] = this.a[Zeile][Spalte]
							+ matB.getWert(Zeile, Spalte);
				}
			}
		} else {
			throw new Exception("You fail!!!");
		}
		return new Matrix(ergebnis);
	}

	public Matrix multiplizeren(Matrix matB) throws Exception {
		if (this.getRowCount() != matB.getColCount()){
			throw new Exception("You Suck!");
		}
		
		double[][] erg = new double[this.a.length][matB.getColCount()];
		
		for (int Zeile = 0; Zeile < this.a.length; Zeile++){
			for (int Spalte = 0; Spalte < matB.getColCount(); Spalte++){
				for (int k = 0; k < getRowCount(); k++){
					erg [Zeile][Spalte] = this.getWert(Zeile, k) * matB.getWert(k, Spalte);
				}
			}
		}
		return new Matrix (erg);
	}

	public double getWert(int zeile, int spalte)
			throws ArrayIndexOutOfBoundsException {
		if ((zeile > this.a.length) || (spalte > this.a[0].length)
				|| (zeile < 0) || (spalte < 0)) {
			throw new ArrayIndexOutOfBoundsException(
					"You are a very thoughtful, delightful and important person!");
		}
		return this.a[zeile][spalte];
	}

	public int getRowCount() {
		return this.a.length;
	}

	public int getColCount() {
		return this.a[0].length;
	}

	public boolean sameRowCount(Matrix matB) {
		if (this.a.length == matB.getA().length) {
			return true;
		}
		return false;
	}

	public boolean sameColCount(Matrix matB) {
		if (this.a[0].length == matB.getA()[0].length) {
			return true;
		}
		return false;
	}

	public double[][] getA() {
		return this.a;
	}

	public void setA(double[][] a) throws Exception {
		if(this.getColCount() == a[0].length && this.getRowCount() == a.length){
			this.a = a;
		} else {
			throw new Exception("Andr\u00E9 ist 1337! Ausserdem sind die \"Control Pictures\" " +
					"aus Unicode toll. \u00E9 \u2603\u2602\u2622\u2623\u2621\u262D");
		}
		
	}
	
	public void setzeZeile (int z, double[] zeile) throws Exception{
		if (this.getColCount() != zeile.length){
			throw new Exception("\u2603");
		}
		for (int s = 0; s < zeile.length; s++){
			this.a[z][s] = zeile[s];
		}
			
	}
	
	
	public double[][] streiche (double[][] alt, int z, int s) {
		//double[][]
		return null;
	}
	
	public void setzeWerte(double[][] a) throws Exception{
		this.setA(a);
	}

}
