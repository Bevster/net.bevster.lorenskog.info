package net.bevster.lorenskog.info.read;

import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Reading {

	public static final String DOKUMENT_ADRESSE = "http://www.novasoftware.se/webviewer/(S(becpxq45fwkhwjqzjhnlwj55))/design1.aspx?schoolid=72150&code=546774&type=3&id=691";

	public static final String TABELL_LAERER_ADRESSE = "http://www.novasoftware.se/webviewer/(S(becpxq45fwkhwjqzjhnlwj55))/design1.aspx?schoolid=72150&code=546774&type=3&id=691";
	public static final String TABELL_ELEV_ADRESSE = "http://www.novasoftware.se/webviewer/(S(becpxq45fwkhwjqzjhnlwj55))/design1.aspx?schoolid=72150&code=546774&type=3&id=691";

	Document doc;

	// Abekatt
	public Reading() {
		// TODO Auto-generated constructor stub

		try {
			doc = Jsoup.connect(DOKUMENT_ADRESSE).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTitle() {

		if (doc.title() != null) {
			return doc.title();
		} else {
			return "RESERVE";
		}

	}

	public String getTable() {

		Document elev_doc = null;

		try {
			elev_doc = Jsoup.connect(TABELL_ELEV_ADRESSE).data("id", "hidden").userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Rompepung");
		}

		Elements es = elev_doc.select("iframe");

		String[] iframesrc;
		int iframeCount = es.size();
		iframesrc = new String[iframeCount];
		// extract iFrame sources:
		int i = 0;
		for (Element e : es) {
			iframesrc[i] = e.getElementsByTag("iframe").attr("src");
			i++;
		}

		// get iFrame content
		Document[] iframeDoc;
		iframeDoc = new Document[iframeCount];
		int j = 0;
		for (String s : iframesrc) {
			try {
				iframeDoc[j] = Jsoup.connect("www.novasoftware.se\\" + iframesrc[j]).get();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // pay attention that the correct url is built at this point!!!
			j++;
		}

		return iframeDoc.toString(); // ite.next().text();
	}
}
