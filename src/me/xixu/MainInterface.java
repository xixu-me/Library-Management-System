package me.xixu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import me.xixu.DataBase.TableOperate;
import me.xixu.Manager.InsertBook;
import me.xixu.Manager.ManagerInterface;
import me.xixu.Manager.NewClass;
import me.xixu.Manager.State;
import me.xixu.Manager.State_Information;
import me.xixu.Manager.UpdateBook;
import me.xixu.Static.Information;
import me.xixu.User.BorrowBook;
import me.xixu.User.BorrowBook_Information;
import me.xixu.User.PersonalInformation;
import me.xixu.User.ProlongBook;
import me.xixu.User.ReturnBook;
import me.xixu.User.UserInterface;

public class MainInterface extends JFrame implements ActionListener {

	// Main����
	public static JPanel contentPane;
	// Manager����
	public static ManagerInterface managerJPanel = new ManagerInterface();
	public static InsertBook insertJPanel = new InsertBook();
	public static NewClass newJPanel = new NewClass();
	public static UpdateBook updateJPanel = new UpdateBook();
	public static State stateJPanel = new State();
	public static State_Information stateInfoJPanel = new State_Information();
	// User����
	public static UserInterface userJPanel = new UserInterface();
	public static BorrowBook borrowJPanel = new BorrowBook();
	public static BorrowBook_Information borrowInfoJPanel = new BorrowBook_Information();
	public static ReturnBook returnJPanel = new ReturnBook();
	public static ProlongBook prolongJPanel = new ProlongBook();
	public static PersonalInformation personalJPanel = new PersonalInformation();
	// �����洰��
	private JTextField tf_user;
	private JTextField tf_password;
	private JLabel label_user;
	private JLabel label_password;
	private JRadioButton rb_customer;
	private JRadioButton rb_manager;
	private JButton btn_login;
	private JButton btn_register;
	private JButton btn_changePassword;
	private static boolean flage_manager = false;
	private static boolean flage_insert = false;
	private static boolean flage_newClass = false;
	private static boolean flage_update = false;
	private static boolean flage_state = false;
	private static boolean flage_stateInfo = false;
	private static boolean flage_user = false;
	private static boolean flage_borrow = false;
	private static boolean flage_borrowInfo = false;
	private static boolean flage_return = false;
	private static boolean flage_prolong = false;
	private static boolean flage_personal = false;
	private static Container container;
	private JLabel label;

	public MainInterface() {
		init();
	}

	// ��ʼ������
	public void init() {

		// ��ȡ����������
		container = getContentPane();

		// ��ʼ��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 1300, 1000);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.add(contentPane);
		contentPane.setLayout(null);

		// �˺������
		tf_user = new JTextField();
		tf_user.setFont(new Font("����", Font.BOLD, 35));
		tf_user.setBounds(409, 248, 526, 75);
		contentPane.add(tf_user);
		tf_user.setColumns(10);

		// ���������
		tf_password = new JTextField();
		tf_password.setFont(new Font("����", Font.BOLD, 35));
		tf_password.setColumns(10);
		tf_password.setBounds(409, 357, 526, 75);
		contentPane.add(tf_password);

		// �û�����ǩ
		label_user = new JLabel("\u8D26\u53F7\uFF1A");
		label_user.setFont(new Font("����", Font.BOLD, 35));
		label_user.setBounds(289, 261, 116, 48);
		contentPane.add(label_user);

		// �����ǩ
		label_password = new JLabel("\u5BC6\u7801\uFF1A");
		label_password.setFont(new Font("����", Font.BOLD, 35));
		label_password.setBounds(289, 370, 116, 48);
		contentPane.add(label_password);

		// ��ͨ�û���ѡ��ť
		rb_customer = new JRadioButton("\u666E\u901A\u7528\u6237");
		rb_customer.setSelected(true);
		rb_customer.setFont(new Font("����", Font.BOLD, 30));
		rb_customer.setBackground(Color.WHITE);
		rb_customer.setBounds(409, 515, 170, 37);
		contentPane.add(rb_customer);

		// ������Ա��ѡ��ť
		rb_manager = new JRadioButton("\u7BA1\u7406\u4EBA\u5458");
		rb_manager.setFont(new Font("����", Font.BOLD, 30));
		rb_manager.setBackground(Color.WHITE);
		rb_manager.setBounds(765, 515, 170, 37);
		contentPane.add(rb_manager);
		// ��ѡ�ť��ӵ�һ����ť��
		ButtonGroup bg = new ButtonGroup();// ��ʼ����ť��
		bg.add(rb_customer);// ��ͨ�û����밴ť��
		bg.add(rb_manager);// ������Ա���밴ť��

		// ��¼��ť
		btn_login = new JButton("\u767B\u5F55");
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("����", Font.BOLD, 35));
		btn_login.setBounds(409, 634, 170, 48);
		contentPane.add(btn_login);
		btn_login.addActionListener(this);

		// ע�ᰴť
		btn_register = new JButton("\u6CE8\u518C");
		btn_register.setFont(new Font("����", Font.BOLD, 35));
		btn_register.setBackground(Color.LIGHT_GRAY);
		btn_register.setBounds(765, 634, 170, 48);
		contentPane.add(btn_register);
		btn_register.addActionListener(this);

		// �޸����밴ť
		btn_changePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changePassword.setFont(new Font("����", Font.BOLD, 30));
		btn_changePassword.setBackground(Color.LIGHT_GRAY);
		btn_changePassword.setBounds(1011, 370, 170, 48);
		contentPane.add(btn_changePassword);

		label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setBounds(529, 69, 294, 105);
		contentPane.add(label);
		btn_changePassword.addActionListener(this);
	}

	// �л����ں���
	// Main->Manager
	public static void MaintoManager() {
		if (!flage_manager) {
			contentPane.setVisible(false);
			container.add(managerJPanel);
			flage_manager = true;
		} else {
			contentPane.setVisible(false);
			managerJPanel.setVisible(true);
		}
	}

	// Manager->Main
	public static void ManagertoMain() {
		managerJPanel.setVisible(false);
		contentPane.setVisible(true);
	}

	// Manager->Insert
	public static void ManagertoInsert() {
		if (!flage_insert) {
			managerJPanel.setVisible(false);
			container.add(insertJPanel);
			flage_insert = true;
		} else {
			managerJPanel.setVisible(false);
			insertJPanel.setVisible(true);
		}
	}

	// Insert->Manager
	public static void InserttoManager() {
		insertJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}

	// Manager->NewClass
	public static void ManagertoNewClass() {
		if (!flage_newClass) {
			managerJPanel.setVisible(false);
			container.add(newJPanel);
			flage_newClass = true;
		} else {
			managerJPanel.setVisible(false);
			newJPanel.setVisible(true);
		}
	}

	// NewClass->Manager
	public static void NewClasstoManager() {
		newJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}

	// Manager->UpdateBook
	public static void ManagertoUpdate() {
		if (!flage_update) {
			managerJPanel.setVisible(false);
			container.add(updateJPanel);
			flage_update = true;
		} else {
			managerJPanel.setVisible(false);
			updateJPanel.setVisible(true);
		}
	}

	// UpdateBook->Manager
	public static void UpdatetoManager() {
		updateJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}

	// Manager->State
	public static void ManagertoState() {
		if (!flage_state) {
			managerJPanel.setVisible(false);
			container.add(stateJPanel);
			flage_state = true;
		} else {
			managerJPanel.setVisible(false);
			stateJPanel.setVisible(true);
		}
	}

	// State->Manager
	public static void StatetoManager() {
		stateJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}

	// State->StateInfo
	public static void StatetoStateInfo() {
		if (!flage_stateInfo) {
			stateJPanel.setVisible(false);
			container.add(stateInfoJPanel);
			flage_stateInfo = true;
		} else {
			stateJPanel.setVisible(false);
			stateInfoJPanel.setVisible(true);
		}
	}

	// StateInfo->State
	public static void StateInfotoState() {
		stateInfoJPanel.setVisible(false);
		stateJPanel.setVisible(true);
	}

	// Main->User
	public static void MaintoUser() {
		if (!flage_user) {
			contentPane.setVisible(false);
			container.add(userJPanel);
			flage_user = true;
		} else {
			contentPane.setVisible(false);
			userJPanel.setVisible(true);
		}
	}

	// User->Main
	public static void UsertoMain() {
		userJPanel.setVisible(false);
		contentPane.setVisible(true);
	}

	// User->Borrow
	public static void UsertoBorrow() {
		if (!flage_borrow) {
			userJPanel.setVisible(false);
			container.add(borrowJPanel);
			flage_borrow = true;
		} else {
			userJPanel.setVisible(false);
			borrowJPanel.setVisible(true);
		}
	}

	// Borrow->User
	public static void BorrowtoUser() {
		borrowJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	// Borrow->BorrowInfo
	public static void BorrowtoBorrowInfo() {
		if (!flage_borrowInfo) {
			borrowJPanel.setVisible(false);
			container.add(borrowInfoJPanel);
			flage_borrowInfo = true;
		} else {
			borrowJPanel.setVisible(false);
			borrowInfoJPanel.setVisible(true);
		}
	}

	// BorrowInfo->Borrow
	public static void BorrowInfotoBorrow() {
		borrowInfoJPanel.setVisible(false);
		borrowJPanel.setVisible(true);
	}

	// User->Return
	public static void UsertoReturn() {
		if (!flage_return) {
			userJPanel.setVisible(false);
			container.add(returnJPanel);
			flage_return = true;
		} else {
			userJPanel.setVisible(false);
			returnJPanel.setVisible(true);
		}
	}

	// Return->User
	public static void ReturentoUser() {
		returnJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	// User->Prolong
	public static void UsertoProlong() {
		if (!flage_prolong) {
			userJPanel.setVisible(false);
			container.add(prolongJPanel);
			flage_prolong = true;
		} else {
			userJPanel.setVisible(false);
			prolongJPanel.setVisible(true);
		}
	}

	// Prolong->User
	public static void ProlongtoUser() {
		prolongJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	// User->Personal
	public static void UsertoPersonal() {
		if (!flage_personal) {
			userJPanel.setVisible(false);
			container.add(personalJPanel);
			flage_personal = true;
		} else {
			userJPanel.setVisible(false);
			personalJPanel.setVisible(true);
		}
	}

	// Personal->User
	public static void PersonaltoUser() {
		personalJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	// ��¼ע���¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_login) {
			// �����¼��ť
			// �ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			} else {
				// �ж����û����ǹ���Ա
				if (rb_customer.isSelected()) {
					// �û�
					boolean isExist = TableOperate.isExist_Customer(tf_user.getText(), tf_password.getText());
					if (isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "�û���¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
						Information.user = tf_user.getText();
						UserInterface.setUser();
						MaintoUser();
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�û���¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					// ����Ա
					boolean isExist = TableOperate.isExist_Manager(tf_user.getText(), tf_password.getText());
					if (isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "����Ա��¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
						Information.manager = tf_user.getText();
						ManagerInterface.setManager();
						MaintoManager();
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "����Ա��¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else if (e.getSource() == btn_register) {
			// ���ע�ᰴť
			// �ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			} else {
				// �ж����û����ǹ���Ա
				if (rb_customer.isSelected()) {
					boolean isExist = TableOperate.isExist_Customer_user(tf_user.getText(), tf_password.getText());
					if (isExist) {
						JOptionPane.showMessageDialog(null, "���û��Ѿ�����", "�û�ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "�û�ע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						TableOperate.regist_Customer(tf_user.getText(), tf_password.getText());
						TableOperate.newCustomer(tf_user.getText());
					}
				} else {
					boolean isExist = TableOperate.isExist_Manager_user(tf_user.getText(), tf_password.getText());
					if (isExist) {
						JOptionPane.showMessageDialog(null, "�ù���Ա�Ѿ�����", "����Աע��ʧ��", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "����Աע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						TableOperate.regist_Manager(tf_user.getText(), tf_password.getText());
					}
				}
			}
		} else if (e.getSource() == btn_changePassword) {
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			} else {
				// �ж����û����ǹ���Ա
				if (rb_customer.isSelected()) {
					// �û�
					boolean isExist = TableOperate.isExist_Customer(tf_user.getText(), tf_password.getText());
					if (isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							TableOperate.changePassword_Customer(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						} else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					// ����Ա
					boolean isExist = TableOperate.isExist_Manager(tf_user.getText(), tf_password.getText());
					if (isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							TableOperate.changePassword_Manager(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						} else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
