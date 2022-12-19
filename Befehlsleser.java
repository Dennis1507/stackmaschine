import java.io.*;

/**
 * Write a description of class Befehlsleser here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Befehlsleser {
	private FileReader reader; // dient dem Einlesen aus Datei
	private BufferedReader inBuffer; // dient dem Einlesen aus Datei
	private double[] befehlswort; // das an die Stackmaschine durchzureichende Befehlswort

	/**
	 * Constructor for objects of class Befehlsleser
	 */
	public Befehlsleser() throws IOException {
		reader = new FileReader("Eingabe.txt");
		inBuffer = new BufferedReader(reader);
		befehlswort = new double[2];
	}

	/**
	 * Die Methode liest die n�chste Befehlszeile aus der Eingabe und macht daraus
	 * ein
	 * Befehlswort f�r die Stackmaschine
	 * Wenn man so will, ist das hier das I von IO eines Computers
	 * 
	 * @param
	 * @return Das Befehlswort, ein Array mit zwei Feldern. Das erste enthaelt den
	 *         Befehl,
	 *         das zweite ggf. das Argument
	 */
	public double[] naechsterBefehl() throws IOException {
		String befehl;
		double befehlscode;
		double argument;

		befehl = this.zeileLesen();

		if (befehl == null)
			throw new IOException("Ungültige Eingabe");

		if (befehl.startsWith("00")) {
			befehlscode = 0; //
			argument = Double.parseDouble(befehl.substring(2));
			befehlswort[0] = befehlscode;
			befehlswort[1] = argument;
		}

		else if (befehl.startsWith("01")) {
			befehlscode = 1; //
			befehlswort[0] = befehlscode;
		} else if (befehl.startsWith("10")) {
			befehlscode = 2;
			befehlswort[0] = befehlscode;
		}

		return befehlswort;
	}

	private String zeileLesen() throws IOException
	/*
	 * Die Methode gibts, weil das Exceptionhandling f�r das Dateilesen sp�ter hier
	 * erfolgen soll
	 * sonst k�nnte man das auch einfach oben beim Einlesen hinschreiben
	 */
	{
		String line = inBuffer.readLine();

		Lexer lexer = new Lexer();
		boolean l = lexer.analyze(line);
		if (l)
			return line;
		else
			throw new IOException("Ungültige Eingabe: Unexpected " + lexer.c + " in " + line);
	}
}
