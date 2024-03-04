package sample.com;

import java.io.PrintWriter;

import jdepend.xmlui.JDepend;

public class Sample_XML {
	public static void main(String[] args) throws Exception {
		JDepend db = new JDepend(new PrintWriter("reports/report.xml"));
		db.addDirectory("T:\\chiase\\Library-Assistant");
		db.analyze();
		System.out.println("DONE");

	}
}
