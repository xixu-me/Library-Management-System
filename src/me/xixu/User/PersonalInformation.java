package me.xixu.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import me.xixu.MainInterface;
import me.xixu.Static.Information;

public class PersonalInformation extends JPanel implements ActionListener {
	private JButton back;
	private static JTextArea textArea;
	private JLabel label;
	private static String info;

	/**
	 * Create the panel.
	 */
	public PersonalInformation() {
		setBackground(new Color(127, 255, 212));
		setLayout(null);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(111, 125, 1050, 782);
		add(textArea);

		info = "图书编号           分类名称            图书名称            还书期限\n";

	}

	public static void setTextArea() {
		info = "图书编号              分类名称                图书名称                            还书期限\n";

		for (int i = 0; i < Information.bookarray.size(); i++) {
			info = info + "  " + Information.bookarray.get(i).number + "                 ";
			info = info + Information.bookarray.get(i).classname;
			for (int j = 0; j < (24 - Information.bookarray.get(i).classname.length()); j++) {
				info = info + " ";
			}
			info = info + Information.bookarray.get(i).name;
			for (int j = 0; j < (30 - Information.bookarray.get(i).name.length()); j++) {
				info = info + " ";
			}
			info = info + "      " + Information.bookarray.get(i).dateoff + "        ";
		}
		textArea.setText(info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			MainInterface.PersonaltoUser();
		}
	}
}
