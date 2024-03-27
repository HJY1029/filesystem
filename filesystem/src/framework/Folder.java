package framework;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class Folder extends FolderItem {  
	private List<FolderItem> folderItems;  
  
	public Folder(String initialName) {  
		super(initialName, isFolder());  
		folderItems = new ArrayList<FolderItem>();  
	}  
  
	public List<FolderItem> getFolderItems() {  
		return new ArrayList<>(folderItems); // 返回副本以避免外部修改  
	}  
  
	public void addFolderItem(FolderItem item) {  
		if (item != null) {  
			folderItems.add(item);  
		}  
	}  
  
	public boolean removeFolderItem(FolderItem item) {  
		if (item != null && folderItems.contains(item)) {  
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
}