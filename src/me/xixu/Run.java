package me.xixu;

import java.awt.EventQueue;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ʵ����������
					MainInterface frame = new MainInterface();
					// ��ʾ������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
