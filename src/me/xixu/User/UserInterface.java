package me.xixu.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import me.xixu.MainInterface;
import me.xixu.DataBase.TableOperate;
import me.xixu.Static.Information;

public class UserInterface extends JPanel implements ActionListener {
	private JButton back;
	private JLabel label;
	private static JLabel lb_user;
	private JButton btn_return;
	private JButton btn_borrow;
	private JButton btn_prolong;
	private JButton btn_personal;

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("����", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		label = new JLabel("\u7528\u6237\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setBounds(512, 47, 294, 105);
		add(label);

		lb_user = new JLabel("New label");
		lb_user.setHorizontalAlignment(SwingConstants.CENTER);
		lb_user.setFont(new Font("����", Font.BOLD, 28));
		lb_user.setBounds(944, 0, 356, 56);
		add(lb_user);

		btn_borrow = new JButton("\u501F\u4E66");
		btn_borrow.setFont(new Font("����", Font.BOLD, 40));
		btn_borrow.setBounds(31, 233, 280, 505);
		add(btn_borrow);
		btn_borrow.addActionListener(this);

		btn_return = new JButton("\u8FD8\u4E66");
		btn_return.setFont(new Font("����", Font.BOLD, 40));
		btn_return.setBounds(351, 233, 280, 505);
		add(btn_return);
		btn_return.addActionListener(this);

		btn_prolong = new JButton("\u7EED\u501F");
		btn_prolong.setFont(new Font("����", Font.BOLD, 40));
		btn_prolong.setBounds(674, 233, 280, 505);
		add(btn_prolong);
		btn_prolong.addActionListener(this);

		btn_personal = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btn_personal.setFont(new Font("����", Font.BOLD, 40));
		btn_personal.setBounds(999, 233, 280, 505);
		add(btn_personal);
		btn_personal.addActionListener(this);

	}

	public static void setUser() {
		lb_user.setText("��ǰ�û���" + Information.user);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			MainInterface.UsertoMain();
		} else if (e.getSource() == btn_borrow) {
			MainInterface.UsertoBorrow();
		} else if (e.getSource() == btn_return) {
			MainInterface.UsertoReturn();
		} else if (e.getSource() == btn_prolong) {
			MainInterface.UsertoProlong();
		} else if (e.getSource() == btn_personal) {
			TableOperate.search_personal(Information.user);
			PersonalInformation.setTextArea();
			MainInterface.UsertoPersonal();
		}

	}
}
