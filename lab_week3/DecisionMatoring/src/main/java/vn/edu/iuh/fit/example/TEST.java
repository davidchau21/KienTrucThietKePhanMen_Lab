package vn.edu.iuh.fit.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

public class TEST {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("T:\\test_www\\DecisionMatoring\\src\\main\\java\\vn\\edu\\iuh\\fit\\DirExplorer.java");

//		JavaParser parser = new JavaParser();
//		ParseResult<CompilationUnit> cu = parser.parse(file);

		CompilationUnit cu = StaticJavaParser.parse(file);
		List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
		for (MethodDeclaration m : methods) {
			System.out.println(m);
		}

		/*
		 * void eplore(File root) { if(root.exists()) {
		 * 
		 * } }
		 */
	}

}
