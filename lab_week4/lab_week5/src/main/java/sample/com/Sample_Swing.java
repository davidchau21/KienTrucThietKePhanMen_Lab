package sample.com;


import jdepend.swingui.JDepend;

public class Sample_Swing {
	public static void main(String[] args) throws Exception  {
		JDepend db = new JDepend();
		db.addDirectory("T:\\chiase\\Library-Assistant");
		db.analyze();
	}
}
