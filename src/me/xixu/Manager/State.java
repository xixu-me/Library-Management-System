package me.xixu.manager;

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
import me.xixu.database.TableOperate;
import me.xixu.info.Information;

public class State extends JPanel implements ActionListener {
	private JLabel label;
	private JButton back;
	private JTextField tf_classname;
	private JLabel lb_classname;
	private JButton btn_search;

	/**
	 * Create the panel.
	 */
	public State() {
		setBackground(new Color(250, 250, 210));
		setLayout(null);

		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

		label = new JLabel("\u56FE\u4E66\u5E93\u72B6\u6001\u67E5\u8BE2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);

		lb_classname = new JLabel("\u4E66\u5E93\u7C7B\u522B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(241, 330, 283, 55);
		add(lb_classname);

		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(502, 320, 526, 75);
		add(tf_classname);

		btn_search = new JButton("\u67E5\u8BE2");
		btn_search.setFont(new Font("宋体", Font.BOLD, 35));
		btn_search.setBounds(558, 567, 251, 80);
		add(btn_search);
		btn_search.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			MainInterface.StatetoManager();
		} else if (e.getSource() == btn_search) {

			String classname = tf_classname.getText();

			Information.search_classname = classname;

			// 查询该类图书信息
			// 判定是否存在查询类别
			if (TableOperate.isExist_Table(classname + "book")) {
				JOptionPane.showMessageDialog(null, "欢迎", "查询成功", JOptionPane.OK_CANCEL_OPTION);
				TableOperate.search_classname(tf_classname.getText());
				MainInterface.StatetoStateInfo();
				StateInformation.setTextArea();
				tf_classname.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "不存在该类别", "查询失败", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
