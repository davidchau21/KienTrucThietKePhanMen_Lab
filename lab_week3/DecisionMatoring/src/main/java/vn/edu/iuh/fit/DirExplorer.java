package vn.edu.iuh.fit;

import java.io.File;

public class DirExplorer {
	// interface for file handler
	public interface FileHandler {
		void handle(int level, String path, File file);
	}

	// interface for file filter
	public interface Filter {
		boolean interested(int level, String path, File file);
	}

	private FileHandler fileHandler;
	private Filter filter;

	public DirExplorer(Filter filter, FileHandler fileHandler) {
		this.filter = filter;
		this.fileHandler = fileHandler;
	}

	public void explore(File root) {
		explore(0, "", root);
	}

	private void explore(int level, String path, File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				explore(level + 1, path + "/" + child.getName(), child);
			}
		} else {
			if (filter.interested(level, path, file)) {
				fileHandler.handle(level, path, file);
			}
		}
	}

	/*
	 * public static void main(String[] args) { test_old_style(); }
	 */

	public static void main(String[] args) {
		File projectDir = new File("T:\\KTPM\\javaparser-master");
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			System.out.println(path);
		}).explore(projectDir);
	}

	static void test_old_style() {
		File projectDir = new File("T:\\KTPM\\javaparser-master");
		DirExplorer.Filter filter = new Filter() {
			@Override
			public boolean interested(int level, String path, File file) {
				return path.endsWith(".java");
			}
		};
		DirExplorer.FileHandler handler = new FileHandler() {
			@Override
			public void handle(int level, String path, File file) {
				System.out.println(path);
			}
		};
		DirExplorer di = new DirExplorer(filter, handler);
		di.explore(projectDir);
	}

}
