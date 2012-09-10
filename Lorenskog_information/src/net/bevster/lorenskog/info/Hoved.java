package net.bevster.lorenskog.info;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import net.bevster.lorenskog.info.read.*;
import net.bevster.lorenskog.info.sql.Mysql;

//Festen
public class Hoved extends JPanel {
	static BufferedImage image;
	static Reading r = new Reading();
	static UERL url = new UERL();
	static Mysql sql;

	static Hoved contentPane;

	public static final String STUDENT_ID = "E9726CD9-4FE2-4F35-B009-744116253817";
	public static final int UKE = 37;

	public static int frameX = 977;
	public static int frameY = 750;

	public Hoved(BufferedImage image) {
		Hoved.image = image;
	}

	public static void main(String[] args) throws IOException {
		drawThePlan();

		JFrame f = new JFrame(r.getTitle());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(contentPane);
		f.setResizable(false);
		f.setSize(frameX, frameY + 30);
		f.setLocation(200, 200);
		f.setVisible(true);

		// System.out.println(r.getTable());

		sql = new Mysql();

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, this);
	}

	public static void drawThePlan() {
		try {
			image = ImageIO.read(url.getUkeplan(STUDENT_ID, UKE, frameX, 468));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new Hoved(image);
		contentPane.setOpaque(true);

	}
}