package mathcard.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsoleFrame extends JFrame {
	private static final long serialVersionUID = 1584277035078490147L;
	private JButton enter;
	private JTextField console;
	private JTextArea display;
	private PrintStream print;
	private PipedInputStream write;
	private PipedOutputStream writeIn;
	
	public ConsoleFrame()
	{
		super();
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Math Cards");
		setLocationRelativeTo(null);

		JPanel consolePanel = new JPanel(new BorderLayout());
		
		write = new PipedInputStream();
		try {
			writeIn = new PipedOutputStream(write);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		ActionListener writer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				print.println("> " + console.getText());
				try {
					String input = console.getText() + "\n";
					writeIn.write(input.getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				console.setText("");
			}
		};
		
		console = new JTextField();
		enter = new JButton("Enter");
		enter.setBackground(Color.WHITE);
		enter.addActionListener(writer);
		console.addActionListener(writer);
		
		consolePanel.add(enter, BorderLayout.EAST);
		consolePanel.add(console, BorderLayout.CENTER);
		
		display = new JTextArea();
		display.setEditable(false);
		display.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(display);
		
		print = new PrintStream(new TextAreaOutputStream(display));
		add(consolePanel, BorderLayout.SOUTH);
		add(scrollPane);
		
		setVisible(true);
	}
	
	public PrintStream getPrintStream()
	{
		return print;
	}
	
	public InputStream getInputStream()
	{
		return write;
	}
	
	public void flush()
	{
		display.setText("");
		print.flush();
	}

}
