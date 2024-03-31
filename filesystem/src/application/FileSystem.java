package application;

import java.util.StringTokenizer;

import framework.File;
import framework.Folder;
import framework.FolderItem;

public class FileSystem {

	/**
	 * The main function try to use <code>File<code>, <code>Folder<code> 
	 * and <code>FolderItem<code> and comparing with using class java.io.File
	 * 
	 */
	public static void main(String[] args) {
		/** Get the current user path and printout it */
		String path = System.getProperty("user.dir");
		
		/** Get specified path and printout it */
//		String path = "D:\\testFileSystem";
		
		System.out.println("Current Path:" + path);

		/** Get the folder name */
		StringTokenizer tokenizer = new StringTokenizer(path, "\\");
		String folderName = tokenizer.nextToken();
		for (; tokenizer.hasMoreTokens();) {
			folderName = tokenizer.nextToken();
		}

		/** Get all file items <code>files<code> of the current user path */
		java.io.File file = new java.io.File(System.getProperty("user.dir"));
		
		/** Get all file items <code>files<code> of specified path */
//		java.io.File file = new java.io.File("D:\\testFileSystem");
		
		java.io.File[] files = file.listFiles();

		if (files != null) {
			//累加文件夹内所有文件的总大小
			int totalSize = 0;

			/**
			 * Recursive printout all folder items of the current folder by
			 * using java.io.File
			 * 
			 */
			System.out.println(folderName);
			printFolderItems(file, "--");

			System.out.println("====Up:java.io.File========Down:filesystem===========");

			/**
			 * Recursive construct <code>folder<code> include all folder items
			 * by using <code>File<code>, <code>Folder<code>, <code>FolderItem<code>
			 * and java.io.File
			 * 
			 */
			// 创建一个名为folderName的Folder对象 
			Folder folder = new Folder(folderName);
			// 遍历files数组或集合中的每一个文件对象  
			for (java.io.File f : files) {
				FolderItem folderItem;
				// 如果当前文件对象f是一个普通文件 
				if (f.isFile()) {
					// 创建一个File类型的folderItem，名称是文件的名称，扩展名是空格，大小是文件的长度  
				    folderItem = new File(f.getName(), "  ", (int) f.length());
				    // 将这个folderItem添加到folder中 
					folder.addFolderItem(folderItem);
					// 将文件的长度累加到totalSize变量中  
					totalSize += f.length();
				}
				// 如果当前文件对象f是一个目录
				if (f.isDirectory()) {
					// 创建一个名为f.getName()的Folder类型的folderItem 
					folderItem = new Folder(f.getName());
					// 将这个folderItem添加到folder中
					folder.addFolderItem(folderItem);
					// 递归调用constructFolderItems方法，传入当前目录f和作为参数传入的folderItem（强制转型为Folder类型）  
			        // 这样会进一步处理该目录下的所有子文件和子目录
					constructFolderItems(f, (Folder) folderItem);
				}
			}

			/**
			 * Recursive printout all folder items of the current folder by
			 * using <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
			 * 
			 */
			System.out.println(folder.getName());
			printFolderItems(folder, "--");
			System.out.println("Total size of all files:" + totalSize + "bytes");
		}
	}

	/**
	 * Recursive construct <code>folder<coder> object of one folder 
	 * by using <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
	 * and class java.io.File
	 * 
	 * @param f  a java.io.File's object
	 * @param folder  Folder
	 * 
	 */
	public static void constructFolderItems(java.io.File f, Folder folder) {
		java.io.File[] subFiles = f.listFiles();
		for (java.io.File i : subFiles) {
			FolderItem folderItem;
			if (i.isFile()) {
				folderItem = new File(i.getName(), "  ", (int) i.length());
				folder.addFolderItem(folderItem);
			}
			if (i.isDirectory()) {
				folderItem = new Folder(i.getName());
				folder.addFolderItem(folderItem);
				constructFolderItems(i, (Folder) folderItem);
			}
		}
	}

	/**
	 * Recursive printout all folder items under one folder
	 * only by using class java.io.File
	 * 
	 * @param f  a java.io.File's object
	 * @param indent  a String object for printing indentation
	 * 
	 */
	public static void printFolderItems(java.io.File f, String indent) {
		for (java.io.File i : f.listFiles()) {
			System.out.println(indent + i.getName());
			if (i.isDirectory()) {
				String indentTemp = indent + "--";
				printFolderItems(i, indentTemp);
			}
		}
	}

	/**
	 * Recursive printout all folder items under one folder by using
	 * <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
	 * 
	 * @param f  a Folder object
	 * @param indent  a String object for printing indentation
	 * 
	 */
	public static void printFolderItems(Folder f, String indent) {
		for (FolderItem item : f.getFolderItems()) {
			System.out.println(indent + item.getName());
			if (item instanceof Folder)//检查对象 item 是否是 Folder 类或其子类的实例 
				{
				String indentTemp = indent + "--";
				printFolderItems((Folder) item, indentTemp);
			}
		}
	}

}
