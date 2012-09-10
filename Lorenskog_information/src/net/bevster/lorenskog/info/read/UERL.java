package net.bevster.lorenskog.info.read;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class UERL {
	public UERL() {
		// TODO Auto-generated constructor stub

	}

	public URL getUkeplan(String ID, int week, int x, int y) {

		String adresse = "http://www.novasoftware.se/ImgGen/schedulegenerator.aspx?format=png&schoolid=72150/nb-no&type=3&id={" + ID + "}&period=&week=" + week + "&mode=3&printer=0&colors=32&head=0&clock=0&foot=0&day=0&width=" + x + "&height=" + y + "&maxwidth=" + x + "&maxheight=" + y;

		URL url = null;
		try {
			url = new URL(adresse);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				url = new URL("http://www.vg.no");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return url;

	}
}
