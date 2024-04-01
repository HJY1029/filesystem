package framework;    
  
import java.util.ArrayList;  
import java.util.List;  
  
public class Folder extends FolderItem {  
  
    /**  
     * 存储文件夹内的所有项目（FolderItem）的列表。  
     */  
    private List<FolderItem> folderItems;  
  
    /**  
     * 存储文件夹内所有项目的总大小（单位视项目类型而定）。  
     */  
    private int totalSize;  
  
    public Folder(String initialName) {  
        super(initialName);  // 调用父类的构造方法，传入初始名称，并设置isFolder()为true，表示这是一个文件夹。  
        // 初始化folderItems列表，用于存储文件夹中的项目（FolderItem）。  
        folderItems = new ArrayList<FolderItem>();  
        totalSize = 0;  
    }  
  
    /**  
     * 获取文件夹内的项目列表的副本。  
     * 返回副本以避免外部直接修改folderItems列表。  
     *  
     * @return 文件夹内的项目列表的副本。  
     */  
    public List<FolderItem> getFolderItems() {  
        return new ArrayList<>(folderItems);  
    }  
  
    /**  
     * 向文件夹中添加一个项目。  
     *  
     * @param item 要添加的项目（FolderItem）。  
     */  
    public void addFolderItem(FolderItem item) {  
        if (item != null) {  
            folderItems.add(item);  
            totalSize += item.getSize(); // 更新文件夹内的项目总大小  
        }  
    }  
  
    /**  
     * 从文件夹中移除一个项目。  
     *  
     * @param item 要移除的项目（FolderItem）。  
     * @return 如果成功移除，则返回true；否则返回false。  
     */  
    public boolean removeFolderItem(FolderItem item) {  
        if (item != null && folderItems.contains(item)) {  
            totalSize -= item.getSize(); // 更新文件夹内的项目总大小  
            return folderItems.remove(item);  
        }  
        return false;  
    }  
  
    /**  
     * 根据索引获取文件夹内的项目。  
     *  
     * @param index 项目的索引。  
     * @return 索引对应的项目（FolderItem），如果索引无效则返回null。  
     */  
    public FolderItem getFolderItem(int index) {  
        if (index >= 0 && index < folderItems.size()) {  
            return folderItems.get(index);  
        }  
        return null; // 或者可以抛出异常  
    }  
  
    /**  
     * 获取文件夹内的项目数量。  
     *  
     * @return 文件夹内的项目数量。  
     */  
    public int getNumberOfFolderItems() {  
        return folderItems.size();  
    }  
  
    /**  
     * 获取文件夹内的项目总大小。  
     *  
     * @return 文件夹内的项目总大小。  
     */  
    public int getTotalSize() {  
        return totalSize;  
    }  
}
