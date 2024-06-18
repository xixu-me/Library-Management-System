package me.xixu.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import me.xixu.MainInterface;
import me.xixu.DataBase.TableOperate;
import me.xixu.Static.Information;

public class BorrowBook_Information extends JPanel implements ActionListener {
	private JButton back;
	private static JTextArea textArea;
	private static String info;
	private JTextField tf_number;
	private JLabel lb_number;
	private JButton btn_borrow;
	private JLabel lb_dateoff;
	private JTextField tf_dateoff;

	/**
	 * Create the panel.
	 */
	public BorrowBook_Information() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("����", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 142, 1111, 782);
		add(textArea);

		textArea.setEditable(false);

		lb_number = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lb_number.setFont(new Font("����", Font.BOLD, 35));
		lb_number.setBounds(152, 39, 185, 55);
		add(lb_number);

		tf_number = new JTextField();
		tf_number.setFont(new Font("����", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(317, 29, 226, 75);
		add(tf_number);

		btn_borrow = new JButton("\u501F\u4E66");
		btn_borrow.setFont(new Font("����", Font.BOLD, 35));
		btn_borrow.setBounds(926, 26, 251, 80);
		add(btn_borrow);
		btn_borrow.addActionListener(this);

		lb_dateoff = new JLabel("\u671F\u9650\uFF1A");
		lb_dateoff.setFont(new Font("����", Font.BOLD, 35));
		lb_dateoff.setBounds(575, 39, 185, 55);
		add(lb_dateoff);

		tf_dateoff = new JTextField();
		tf_dateoff.setFont(new Font("����", Font.BOLD, 35));
		tf_dateoff.setColumns(10);
		tf_dateoff.setBounds(679, 29, 226, 75);
		add(tf_dateoff);

		info = "ͼ����     ������     ͼ������                ��������      �۸�     ״̬     ��ȡ��     ��ֹ����\n";

	}

	public static void setTextArea() {
		info = "ͼ����     ������     ͼ������                ��������      �۸�     ״̬     ��ȡ��     ��ֹ����\n";

		for (int i = 0; i < Information.bookarray.size(); i++) {
			info = info + "  " + Information.bookarray.get(i).number + "          ";
			info = info + Information.bookarray.get(i).classnumber + "          ";
			info = info + Information.bookarray.get(i).name;
			for (int j = 0; j < (19 - Information.bookarray.get(i).name.length()); j++) {
				info = info + " ";
			}
			info = info + "      " + Information.bookarray.get(i).classname + "        ";
			info = info + Information.bookarray.get(i).price + "      ";
			info = info + Information.bookarray.get(i).state;
			for (int j = 0; j < (9 - Information.bookarray.get(i).state.length()); j++) {
				info = info + " ";
			}
			info = info + Information.bookarray.get(i).current;
			for (int j = 0; j < (6 - Information.bookarray.get(i).current.length()); j++) {
				info = info + " ";
			}
			info = info + "     " + Information.bookarray.get(i).dateoff + "\n";

		}
		textArea.setText(info);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			// ������ذ�ť
			MainInterface.BorrowInfotoBorrow();
		}
		if (e.getSource() == btn_borrow) {
			// ������鰴ť
			// ���ж��Ƿ��д���
			if (TableOperate.search_bookname(Information.search_classname, tf_number.getText()).equals("null")) {
				JOptionPane.showMessageDialog(null, "���������Ϣ����", "����ʧ��", JOptionPane.ERROR_MESSAGE);
				tf_number.setText("");
				tf_dateoff.setText("");
			} else {
				// �ж������Ƿ��ѱ����
				if (TableOperate.search_bookstate(Information.search_classname, tf_number.getText()).equals("in")) {
					TableOperate.borrowBook_Update(Information.search_classname, tf_number.getText(), Information.user,
							tf_dateoff.getText().toString());
					TableOperate.borrowBook_Insert(Information.search_classname, tf_number.getText(), Information.user,
							tf_dateoff.getText().toString());
					tf_number.setText("");
					tf_dateoff.setText("");
					MainInterface.BorrowInfotoBorrow();
					MainInterface.BorrowtoUser();
				} else {
					JOptionPane.showMessageDialog(null, "�����ѽ������"
							+ TableOperate.search_bookdateoff(Information.search_classname, tf_number.getText()),
							"����ʧ��", JOptionPane.ERROR_MESSAGE);
					tf_number.setText("");
					tf_dateoff.setText("");
				}
			}
		}
	}
}
