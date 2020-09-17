package com.cjzy;

import javax.swing.JFrame;

import com.cjzy.view.LoginFrame;

public class MainApplication {
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}
}
