package me.xixu;

import java.awt.EventQueue;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 实例化主界面
					MainInterface frame = new MainInterface();
					// 显示主界面
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
