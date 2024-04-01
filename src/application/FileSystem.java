package application;  
  
import java.util.StringTokenizer;  
  
import framework.File;   
import framework.Folder; 
import framework.FolderItem; 
  
public class FileSystem {  
  
    public static void main(String[] args) {  
        // 获取当前用户路径并打印  
        String path = System.getProperty("user.dir");  
        System.out.println("当前路径:" + path);  
  
        // 分割路径字符串，获取最后的文件夹名  
        StringTokenizer tokenizer = new StringTokenizer(path, "\\");  
        String folderName = tokenizer.nextToken();  
        for (; tokenizer.hasMoreTokens();) {  
            folderName = tokenizer.nextToken();  
        }  
  
        // 使用java.io.File获取当前用户路径下的所有文件项  
        java.io.File file = new java.io.File(System.getProperty("user.dir"));  
        java.io.File[] files = file.listFiles();  
  
        if (files != null) {  
            // 累加文件夹内所有文件的总大小  
            int totalSize = 0;  
  
            // 使用java.io.File递归打印当前文件夹下的所有文件项  
            System.out.println(folderName);  
            printFolderItems(file, "--");  
  
            // 分隔线，便于观察两种打印方式的差异  
            System.out.println("====使用java.io.File打印====使用自定义框架打印===");  
  
            // 使用自定义框架递归构建包含所有文件项的Folder对象  
            Folder folder = new Folder(folderName);  
            for (java.io.File f : files) {  
                FolderItem folderItem;  
                // 如果当前文件对象是一个普通文件  
                if (f.isFile()) {  
                    // 创建一个File类型的folderItem，名称是文件的名称，扩展名是空格，大小是文件的长度  
                    folderItem = new File(f.getName(), "  ", (int) f.length());  
                    // 将这个folderItem添加到folder中  
                    folder.addFolderItem(folderItem);  
                    // 将文件的长度累加到totalSize变量中  
                    totalSize += f.length();  
                }  
                // 如果当前文件对象是一个目录  
                if (f.isDirectory()) {  
                    // 创建一个名为f.getName()的Folder类型的folderItem  
                    folderItem = new Folder(f.getName());  
                    // 将这个folderItem添加到folder中  
                    folder.addFolderItem(folderItem);  
                    // 递归调用constructFolderItems方法，传入当前目录f和作为参数传入的folderItem（强制转型为Folder类型）  
                    constructFolderItems(f, (Folder) folderItem);  
                }  
            }  
  
            // 使用自定义框架递归打印当前文件夹下的所有文件项  
            System.out.println(folder.getName());  
            printFolderItems(folder, "--");  
            System.out.println("所有文件的总大小:" + totalSize + "字节");  
        }  
    }  
  
    /**  
     * 使用自定义框架递归构建指定文件夹的Folder对象  
     *   
     * @param f      一个java.io.File对象  
     * @param folder 一个Folder对象  
     */  
    public static void constructFolderItems(java.io.File f, Folder folder) {  
        java.io.File[] subFiles = f.listFiles();  
        for (java.io.File i : subFiles) {  
            FolderItem folderItem;  
            if (i.isFile()) {  
                // 如果i是文件，则创建一个File类型的folderItem  
                folderItem = new File(i.getName(), "  ", (int) i.length());  
                // 将folderItem添加到folder中  
                folder.addFolderItem(folderItem);  
            }  
            if (i.isDirectory()) {  
                // 如果i是目录，则创建一个Folder类型的folderItem  
                folderItem = new Folder(i.getName());  
                // 将folderItem添加到folder中  
                folder.addFolderItem(folderItem);  
                // 递归调用constructFolderItems方法处理子目录  
                constructFolderItems(i, (Folder) folderItem);  
            }  
        }  
    }  
  
    /**  
     * 使用java.io.File递归打印指定文件夹下的所有文件项  
     *   
     * @param f       一个java.io.File对象  
     * @param indent  用于打印缩进的字符串  
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
     * 使用自定义框架递归打印指定文件夹下的所有文件项  
     *   
     * @param f       一个Folder对象  
     * @param indent  用于打印缩进的字符串  
     */  
    public static void printFolderItems(Folder f, String indent) {  
        for (FolderItem item : f.getFolderItems()) {  
            // 打印文件或文件夹的名称  
            System.out.println(indent + item.getName());  
            // 如果item是Folder类型的实例，则递归打印子目录  
            if (item instanceof Folder) {  
                String indentTemp = indent + "--";  
                printFolderItems((Folder) item, indentTemp);  
            }  
        }  
    }  
}
