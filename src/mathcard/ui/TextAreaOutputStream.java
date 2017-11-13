package mathcard.ui;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaOutputStream extends OutputStream {
	private final JTextArea textArea;
	private final StringBuilder sb = new StringBuilder();

	public TextAreaOutputStream(final JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() {
	}

	@Override
	public void write(int b) throws IOException {

		if (b == '\r')
			return;

		if (b == '\n') {
			final String text = sb.toString() + "\n";
			SwingUtilities.invokeLater(new Displayer(text));
			sb.setLength(0);

			return;
		}

		sb.append((char) b);
	}
	
	private class Displayer implements Runnable {
		private String text;
		
		private Displayer(String text)
		{
			this.text = text;
		}
		
		public void run() {
			textArea.append(text);
		}
	}

}
