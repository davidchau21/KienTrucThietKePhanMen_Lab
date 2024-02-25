package vn.edu.iuh.fit.example;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;

import vn.edu.iuh.fit.DirExplorer;

public class CommonOperations {
	public static void listMethodCalls(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), // filter
				(level, path, file) -> {// handle
					System.out.println(path);
					System.out.println(Strings.repeat("=", path.length()));
					try {
						new VoidVisitorAdapter<Object>() {

							@Override
							public void visit(JavadocComment n, Object arg) {
								// TODO Auto-generated method stub
								super.visit(n, arg);
								checValidComment(n);
							}

							private void checValidComment(JavadocComment n) {
								if (!n.getContent().isEmpty() || n == null)
									System.out.println("[" + n.getBegin() + "\t****** not valid comment");
								else
									System.out.println("[" + n.getBegin() + n.getContent() + "]" + n.getEnd());

							}

							@Override
							public void visit(PackageDeclaration n, Object arg) {
								// TODO Auto-generated method stub
								super.visit(n, arg);
								System.out.println(n.getNameAsString());
							}

							@Override
							public void visit(FieldDeclaration n, Object arg) {
								// TODO Auto-generated method stub
								super.visit(n, arg);
								NodeList<VariableDeclarator> vars = n.getVariables();
								
								vars.forEach(f -> {
									char c = f.getNameAsString().charAt(0);
									if(!(c>='a' && c<='z'))
										System.out.println("t******Invalid field name: "+ f);
								});

							}

							@Override
							public void visit(MethodDeclaration n, Object arg) {
								// TODO Auto-generated method stub
								super.visit(n, arg);
								System.out.println(n.getNameAsString());
							}

							@Override
							public void visit(ClassOrInterfaceDeclaration n, Object arg) {
								// TODO Auto-generated method stub
								super.visit(n, arg);
								Optional<Comment> onCmt = n.getComment();
								if(onCmt.isEmpty()) 
									System.out.println("Class "+n.getNameAsString()+"has NO comment");
								else {
									Comment cmt = onCmt.get();
									String content = cmt.getContent();
									if(!content.contains("@Created-Date") || 
											!content.contains("Author"))
										System.out.println("Class "+n.getNameAsString()+"has comment "
												+"without Author and create-date");
								}
								
							}
							
							
							

							/*
							 * @Override public void visit(PackageDeclaration n, Object arg) {
							 * super.visit(n, arg); System.out.println(n.getNameAsString()); }
							 * 
							 * @Override public void visit(FieldDeclaration n, Object arg) { super.visit(n,
							 * arg); System.out.println(" [L " + n.getBegin() + "]" + n); }
							 * 
							 * @Override public void visit(MethodDeclaration n, Object arg) { super.visit(n,
							 * arg); System.out.println(" [L " + n.getBegin() + "]" +
							 * n.getDeclarationAsString()); }
							 */
						}.visit(StaticJavaParser.parse(file), null);
					} catch (Exception e) {
						new RuntimeException(e);
					}
				}).explore(projectDir);
	}

//	protected static void checValidComment(JavadocComment n) {
//		// TODO Auto-generated method stub
//		if(!n.getContent().isEmpty()||n == null)
//			System.out.println("["+n.getBegin()+"\t****** not valid comment");
//		else
//			System.out.println("["+n.getBegin()+n.getContent()+"]"+n.getEnd());
//		
//	}

	public static void main(String[] args) {
		File projectDir = new File("E:\\HKII_2023-2024\\Kien-Truc-Phan-Mem\\Lab");
		listMethodCalls(projectDir);
	}

}
