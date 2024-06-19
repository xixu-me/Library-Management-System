package me.xixu.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import me.xixu.MainInterface;
import me.xixu.info.Information;

public class StateInformation extends JPanel implements ActionListener {
	private JButton back;
	private static JTextArea textArea;
	private static String info;

	/**
	 * Create the panel.
	 */
	public StateInformation() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 35, 1085, 863);
		add(textArea);

		textArea.setEditable(false);

		info = "图书编号     分类编号     图书名称                分类名称      价格     状态     获取人     终止日期\n";

	}

	public static void setTextArea() {
		info = "图书编号     分类编号     图书名称                分类名称      价格     状态     获取人     终止日期\n";

		for (int i = 0; i < Information.bookarray.size(); i++) {
			info = info + "  " + Information.bookarray.get(i).number + "          ";
			info = info + Information.bookarray.get(i).classnumber + "          ";
			info = info + Information.bookarray.get(i).name;
			for (int j = 0; j < (19 - Information.bookarray.get(i).name.length()); j++) {
				info = info + " ";
			}
			info = info + "      " + Information.bookarray.get(i).classname + "       ";
			info = info + Information.bookarray.get(i).price + "        ";
			info = info + Information.bookarray.get(i).state;
			for (int j = 0; j < (9 - Information.bookarray.get(i).state.length()); j++) {
				info = info + " ";
			}
			info = info + Information.bookarray.get(i).current + "      ";
			info = info + Information.bookarray.get(i).dateoff + "\n";

		}
		textArea.setText(info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			MainInterface.StateInfotoState();
		}
	}
}
