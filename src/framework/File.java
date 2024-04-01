package framework;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class Folder extends FolderItem {  
	private List<FolderItem> folderItems;
	private int totalSize;
  
	public Folder(String initialName) {  
		super(initialName, isFolder());  // 调用父类的构造方法，传入初始名称和是否是文件夹的标识（通过isFolder()方法获取）。  
		// 初始化folderItems列表，用于存储文件夹中的项目（FolderItem）。
		folderItems = new ArrayList<FolderItem>();
		totalSize = 0;
	}  
  
	public List<FolderItem> getFolderItems() {  
		return new ArrayList<>(folderItems); // 返回副本以避免外部修改  
	}  
  
	public void addFolderItem(FolderItem item) {  
		if (item != null) {  
			folderItems.add(item);
			totalSize += item.getSize();//更新文件总大小
		}  
	}  
  
	public boolean removeFolderItem(FolderItem item) {  
		if (item != null && folderItems.contains(item)) {
			totalSize -= item.getSize(); // 更新文件夹总大小
			return folderItems.remove(item);  
		}  
		return false;  
	}  
  
	public FolderItem getFolderItem(int index) {  
		if (index >= 0 && index < folderItems.size()) {  
			return folderItems.get(index);  
		}  
		return null; // 或者抛出异常  
	}  
  
	public int getNumberOfFolderItems() {  
		return folderItems.size();  
	}
	public int getTotalSize(){
	return totalSize;
        }
}
