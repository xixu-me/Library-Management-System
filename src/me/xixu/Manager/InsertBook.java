package me.xixu.Manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import me.xixu.MainInterface;
import me.xixu.DataBase.TableOperate;

public class InsertBook extends JPanel implements ActionListener {
	private JTextField tf_number;
	private JLabel lb_number;
	private JLabel lb_classnumber;
	private JLabel lb_name;
	private JLabel lb_classname;
	private JLabel lb_price;
	private JLabel lb_state;
	private JLabel lb_total;
	private JTextField tf_classnumber;
	private JTextField tf_name;
	private JTextField tf_classname;
	private JTextField tf_price;
	private JTextField tf_state;
	private JTextField tf_total;
	private JButton back;
	private JButton btn_submit;

	/**
	 * Create the panel.
	 */
	public InsertBook() {
		setBackground(Color.PINK);
		setLayout(null);

		JLabel label = new JLabel("\u65B0\u4E66\u5F55\u5165");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setBounds(530, 0, 294, 105);
		add(label);

		lb_number = new JLabel("\u7F16\u53F7\uFF1A");
		lb_number.setFont(new Font("����", Font.BOLD, 35));
		lb_number.setBounds(293, 137, 194, 55);
		add(lb_number);

		tf_number = new JTextField();
		tf_number.setFont(new Font("����", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(486, 127, 526, 75);
		add(tf_number);

		lb_classnumber = new JLabel("\u5206\u7C7B\u7F16\u53F7\uFF1A");
		lb_classnumber.setFont(new Font("����", Font.BOLD, 35));
		lb_classnumber.setBounds(293, 233, 194, 55);
		add(lb_classnumber);

		lb_name = new JLabel("\u4E66\u540D\uFF1A");
		lb_name.setFont(new Font("����", Font.BOLD, 35));
		lb_name.setBounds(293, 329, 194, 55);
		add(lb_name);

		lb_classname = new JLabel("\u5206\u7C7B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("����", Font.BOLD, 35));
		lb_classname.setBounds(293, 435, 194, 55);
		add(lb_classname);

		lb_price = new JLabel("\u4EF7\u683C\uFF1A");
		lb_price.setFont(new Font("����", Font.BOLD, 35));
		lb_price.setBounds(293, 521, 194, 55);
		add(lb_price);

		lb_state = new JLabel("\u5165\u85CF\u72B6\u6001\uFF1A");
		lb_state.setFont(new Font("����", Font.BOLD, 35));
		lb_state.setBounds(293, 617, 194, 55);
		add(lb_state);

		lb_total = new JLabel("\u6570\u91CF\uFF1A");
		lb_total.setFont(new Font("����", Font.BOLD, 35));
		lb_total.setBounds(293, 713, 194, 55);
		add(lb_total);

		tf_classnumber = new JTextField();
		tf_classnumber.setFont(new Font("����", Font.BOLD, 35));
		tf_classnumber.setColumns(10);
		tf_classnumber.setBounds(486, 223, 526, 75);
		add(tf_classnumber);

		tf_name = new JTextField();
		tf_name.setFont(new Font("����", Font.BOLD, 35));
		tf_name.setColumns(10);
		tf_name.setBounds(486, 319, 526, 75);
		add(tf_name);

		tf_classname = new JTextField();
		tf_classname.setFont(new Font("����", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(486, 415, 526, 75);
		add(tf_classname);

		tf_price = new JTextField();
		tf_price.setFont(new Font("����", Font.BOLD, 35));
		tf_price.setColumns(10);
		tf_price.setBounds(486, 511, 526, 75);
		add(tf_price);

		tf_state = new JTextField();
		tf_state.setFont(new Font("����", Font.BOLD, 35));
		tf_state.setColumns(10);
		tf_state.setBounds(486, 607, 526, 75);
		add(tf_state);

		tf_total = new JTextField();
		tf_total.setFont(new Font("����", Font.BOLD, 35));
		tf_total.setColumns(10);
		tf_total.setBounds(486, 703, 526, 75);
		add(tf_total);

		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("����", Font.BOLD, 35));
		btn_submit.setBounds(573, 833, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("����", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			// ������ذ�ť
			MainInterface.InserttoManager();
		} else if (e.getSource() == btn_submit) {
			// ����ύ��ť
			// �ж�¼����Ϣ�Ƿ��ͻ
			String number = tf_number.getText();
			String classnumber = tf_classnumber.getText();
			String name = tf_name.getText();
			String classname = tf_classname.getText();
			String price = tf_price.getText();
			String state = tf_state.getText();
			String total = tf_total.getText();

			if (TableOperate.search_bookstate(classname, number).equals("null")) {
				// �����鼮��Ϣ
				TableOperate.insertBook(number, classnumber, name, classname, price, state, total);
				tf_number.setText("");
				tf_classnumber.setText("");
				tf_name.setText("");
				tf_classname.setText("");
				tf_price.setText("");
				tf_state.setText("");
				tf_total.setText("");
				JOptionPane.showMessageDialog(null, "��ϲ", "�鼮¼��ɹ�", JOptionPane.OK_CANCEL_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "�鼮��Ϣ��ͻ", "�鼮¼��ʧ��", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
