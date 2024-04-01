package application;

import java.util.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import framework.File;
import framework.Folder;
import framework.FolderItem;

public class FileSystem {

	//创建哈希表
	public static Map<Integer, FolderItem> hashMap = new HashMap<>();
	
	/**
	 * The main function try to use <code>File<code>, <code>Folder<code> 
	 * and <code>FolderItem<code> and comparing with using class java.io.File
	 * 
	 */
	public static void main(String[] args) {
		// 获取当前用户路径并打印  
		String path = System.getProperty("user.dir");
		
		/** Get specified path and printout it */
        //		String path = "D:\\testFileSystem";
		// 分割路径字符串，获取最后的文件夹名
		System.out.println("Current Path:" + path);

		/** Get the folder name */
		//StringTokenizer 是 Java 中的一个类，它用于将字符串分解为标记
		StringTokenizer tokenizer = new StringTokenizer(path, "\\");//使用 \ 作为分隔符来分解 path 字符串
		String folderName = tokenizer.nextToken();
		FolderItem item = new FolderItem(folderName);
		int hashCode = item.hashCode();
		System.out.println("HashCode of item: " + hashCode);
		for (; tokenizer.hasMoreTokens();) {
			folderName = tokenizer.nextToken();
			item = new FolderItem(folderName);
			hashCode = item.hashCode();
			System.out.println("HashCode of item: " + hashCode);
			
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
			// 使用java.io.File递归打印当前文件夹下的所有文件项  
			System.out.println(folderName);
			printFolderItems(file, "--");
			// 分隔线，便于观察两种打印方式的差异  
			System.out.println("====Up:java.io.File========Down:filesystem===========");

			/**
			 * Recursive construct <code>folder<code> include all folder items
			 * by using <code>File<code>, <code>Folder<code>, <code>FolderItem<code>
			 * and java.io.File
			 * 
			 */
			// 使用自定义框架递归构建包含所有文件项的Folder对象   
			Folder folder = new Folder(folderName);
			// 创建哈希表
			//Map<Integer, FolderItem> hashMap = new HashMap<>();

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
			        // 将哈希码与文件对象的映射关系放入哈希表中
			        hashMap.put(f.hashCode(), folderItem);
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
			 // 使用自定义框架递归打印当前文件夹下的所有文件项  
			System.out.println(folderName);
			printFolderItems(folder, "--");
			System.out.println("Total size of all files:" + totalSize + "bytes");
			
	        // 提示用户输入哈希码
	        @SuppressWarnings("resource")
	       
			Scanner scanner = new Scanner(System.in);
	        while (toChar(scanner) != 'q')
	        {
	        	System.out.print("请输入哈希码以显示对应的文件：");
		        hashCode = scanner.nextInt();
		        // 根据哈希码查找文件对象并输出
		        FolderItem file2 = hashMap.get(hashCode);
		        if (file2 != null) {
		            System.out.println("找到哈希码对应的文件：" + file2.getName());
		        } else {
		            System.out.println("未找到对应的文件，请输入有效的哈希码。");
		        }
	        }
		}
	}
	
	private static char toChar(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
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
			// 如果i是文件，则创建一个File类型的folderItem  
			if (i.isFile()) {
				folderItem = new File(i.getName(), "  ", (int) i.length());
				// 将folderItem添加到folder中  
				folder.addFolderItem(folderItem);

				//将哈希值添加到哈希表中
				hashMap.put(i.hashCode(), folderItem);
			}
			// 如果i是目录，则创建一个Folder类型的folderItem  
			if (i.isDirectory()) { 
				folderItem = new Folder(i.getName());
				// 将folderItem添加到folder中 
				folder.addFolderItem(folderItem);
				// 递归调用constructFolderItems方法处理子目录
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
	 * 使用java.io.File递归打印指定文件夹下的所有文件项
	 */
	public static void printFolderItems(java.io.File f, String indent) {
		for (java.io.File i : f.listFiles()) {
			// 打印文件或文件夹的名称  
			System.out.println(indent + i.getName());
		
			if (i.isDirectory()) {
				// 如果i是目录，则递归打印子目录 
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
			// 打印文件或文件夹的名称 
			System.out.println(indent + item.getName());
			int hashCode = item.hashCode();
			//打印该项目的哈希值
			System.out.println("HashCode of " +  item.getName()+": " + hashCode);
		
			//检查对象 item 是否是 Folder 类或其子类的实例 
			// 如果item是Folder类型的实例，则递归打印子目录  
			if (item instanceof Folder)
				{
				String indentTemp = indent + "--";
				printFolderItems((Folder) item, indentTemp);
				hashCode = item.hashCode();
				System.out.println("HashCode of " +  item.getName()+": " + hashCode);
			}
		}
	}

}
