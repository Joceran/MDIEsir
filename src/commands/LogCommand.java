package commands;

import IHM.IHM;
import content.Buffer;

public class LogCommand {
	
	public static void logBefore(String command, IHM ihm, Buffer buffer) {
		System.out.println("--------------------");
		System.out.println("BEFORE " + command);
		log(ihm, buffer);
	}
	
	public static void logAfter(String command, IHM ihm, Buffer buffer) {
		System.out.println("--------------------");
		System.out.println("AFTER " + command);
		log(ihm, buffer);
		System.out.println("END " + command);
		System.out.println();
	}
	
	private static void log(IHM ihm, Buffer buffer) {
		System.out.println("Buffer       : " + buffer.getContent());
		System.out.println("Cursor IHM   : " + prettyCursorPosition(ihm.getCurseurPosition()));
		System.out.println("Cursor Buffer: " + prettyCursorPosition(buffer.getCurseur()));
		System.out.println("Clipboard    : " + buffer.getClipboardContent());
	}
	
	private static String prettyCursorPosition(int pos) {
		String res = "";
		for (int i = 0; i < pos; i++) {
			res += " ";
		}
		return res + "^" + "(" + pos + ")";
	}
}
