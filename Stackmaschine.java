import java.io.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.10.2014
 * @author
 */

public class Stackmaschine {

	// Anfang Attribute
	private Stack derstack;
	private Befehlsleser derbefehlsleser;
	private double[] aktuellerbefehl;
	// Ende Attribute

	public Stackmaschine() throws IOException {
		this.derstack = new Stack();
		this.derbefehlsleser = new Befehlsleser();
	}

	// Anfang Methoden
	public void step() throws IOException {
		aktuellerbefehl = derbefehlsleser.naechsterBefehl();
		if (aktuellerbefehl[0] == 0) {
			this.push();
		} // end of if
		else if (aktuellerbefehl[0] == 1) {
			this.add();
		}
	}

	private void add() {
		double x = derstack.pop();
		double y = derstack.pop();
		derstack.push(x + y);
	}

	private void push() {
		derstack.push(aktuellerbefehl[1]);
	}

	// Ende Methoden
} // end of Stackmaschine
