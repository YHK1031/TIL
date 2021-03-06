package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener{

	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	private ServerBackground server = new ServerBackground();
	
	public ServerGUI() {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("Server area");
		server.setGui(this);
		server.setting();
		
	}
	
	public static void main(String[] args) {
		new ServerGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = jtf.getText();
		jta.append("[me]"+msg+"\n");
		System.out.println(msg);
		server.sendMessage(msg,"Server");
		jtf.setText("");
	}

	public void appendMsg(String message) {
		// TODO Auto-generated method stub
		jta.append(message);
		System.out.println("message from client : "+message);
	}
}
