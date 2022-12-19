/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 16.12.2022
 * @author
 */

public class Lexer {

	// Anfang Attribute
	private int state = 0;
	public char c;
	// Ende Attribute

	// Anfang Methoden
	public boolean analyze(String befehl) {

		state = 0;

		for (int i = 0; i < befehl.length(); i++) {
			c = befehl.charAt(i);
			switch (state) {
				case 0:
					switch (c) {
						case '0':
							state = 1;
							break;
						case '1':
							state = 2;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 1:
					switch (c) {
						case '0':
							state = 4;
							break;
						case '1':
							state = 3;
							break;
						default:
							return false;
					} // end of switch

					break;
				case 2:
					switch (c) {
						case '0':
							state = 3;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 3:
					return false;
				case 4:
					switch (c) {
						case '.':
							state = 9;
							break;
						case '-':
							state = 5;
							break;
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 7;
							break;
						case '0':
							state = 6;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 5:
					switch (c) {
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 7;
							break;
						case '0':
							state = 6;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 6:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 7;
							break;
						case '.':
							state = 8;
							break;
						case 'e':
						case 'E':
							state = 10;
							break;
						case 'x':
							state = 13;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 7:
					switch (c) {
						case 'e':
						case 'E':
							state = 10;
							break;
						case '.':
							state = 8;
							break;
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							break;
						default:
							return false;
					} // end of switch
					break;
				case 8:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							break;
						case 'e':
						case 'E':
							state = 10;
							break;
						default:
							return false;
					} // end of switch
					break;
				case 9:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 8;
							break;
						default:
							return false;
					}
					break;
				case 10:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 12;
							break;
						case '-':
							state = 11;
							break;
						default:
							return false;
					}
					break;
				case 11:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							state = 12;
							break;
						default:
							return false;
					}
					break;
				case 12:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							break;
						default:
							return false;
					}
					break;
				case 13:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							state = 14;
							break;
						default:
							return false;
					}
					break;
				case 14:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							state = 14;
							break;
						case 'p':
							state = 15;
							break;
						default:
							return false;
					}
					break;
				case 15:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							state = 16;
							break;
						default:
							return false;
					}
					break;
				case 16:
					switch (c) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							state = 16;
							break;
						default:
							return false;
					}
					break;
				default:
					return false;
			}
		}
		if (state == 3 || state == 6 || state == 7 || state == 8 || state == 12 || state == 14 || state == 16)
			return true;
		return false;
	}
}
