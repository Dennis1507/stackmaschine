import java.io.*;

/**
 * Write a description of class Befehlsleser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Befehlsleser
{
  private FileReader reader; // dient dem Einlesen aus Datei
  private BufferedReader inBuffer; // dient dem Einlesen aus Datei
  private double [] befehlswort; // das an die Stackmaschine durchzureichende Befehlswort
  
  /**
  * Constructor for objects of class Befehlsleser
  */
  public Befehlsleser() throws IOException
  {
    reader = new FileReader("Eingabe.txt");
    inBuffer = new BufferedReader(reader);
    befehlswort = new double [2];
  }
  
  /**
  * Die Methode liest die n�chste Befehlszeile aus der Eingabe und macht daraus ein
  * Befehlswort f�r die Stackmaschine
  * Wenn man so will, ist das hier das I von IO eines Computers
  * 
  * @param
  * @return     Das Befehlswort, ein Array mit zwei Feldern. Das erste enthaelt den Befehl,
  * das zweite ggf. das Argument
  */
  public double [] naechsterBefehl() throws IOException
  {
    String befehl;
    double befehlscode;
    double argument;
    
    befehl = this.zeileLesen();
    
    if (befehl == null) throw new IOException("Ungültige Eingabe");

    if (befehl.startsWith("00"))
    {
      befehlscode=0; //
      argument = Double.parseDouble(befehl.substring(2));
      befehlswort[0]=befehlscode;
      befehlswort[1]=argument;
    }
    
    else if (befehl.startsWith("01"))
    {
      befehlscode=1; //
      befehlswort[0]=befehlscode;
    }
    
    return befehlswort;
  }
  
  private String zeileLesen() throws IOException
  /* Die Methode gibts, weil das Exceptionhandling f�r das Dateilesen sp�ter hier erfolgen soll
  * sonst k�nnte man das auch einfach oben beim Einlesen hinschreiben
  */
  {
    String line = inBuffer.readLine();
    
    if (line.startsWith("10") || line.startsWith("01")) return line;
    else if (line.startsWith("00")) {

		boolean isDecimal = false;
		boolean isNegative = false;

      for (int i = 2; i < line.length(); i++ ) {
        char c = line.charAt(i);

		char[] validChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.', 'e'};
		if (!(new String(validChars).contains(new String(new char[] {c})))) return null;

		if (c == '-') {
			if (i != 2) return null;
			isNegative = true;
		}
		if (c == '.') {
			if (isDecimal) return null;
			isDecimal = true;
		}
		if (c == 'e') {
			if (isNegative && i < 4) return null;
			if (!isNegative && i < 3) return null;
		}

      } // end of for

	  return line;
    }
    return null;
  }  
}
