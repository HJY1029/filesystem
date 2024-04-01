package framework;  
  
import java.util.Date;  
  
public class FolderItem {  
    private String name;  
    protected static boolean isFolder;  
    private FolderItem parent; // 父文件夹  
    private long size; // 文件大小（如果是文件）  
    private Date creationTime; // 创建时间  
    private Date lastModifiedTime; // 最后修改时间  
    // 可以添加更多字段，如权限等  
  
    public FolderItem(String name, boolean b) {  
        this.name = name;  
        FolderItem.isFolder = b;  
        this.creationTime = new Date(); // 默认为当前时间  
        this.lastModifiedTime = new Date(); // 默认为当前时间  
    }  
  
    // 可以添加其他构造器  
  
    public FolderItem(String initialName) {
    	this.name = initialName;  
        FolderItem.isFolder = false; // 假设这个构造器是用于非文件夹的项  
        this.creationTime = new Date(); // 默认为当前时间  
        this.lastModifiedTime = new Date(); // 默认为当前时间  
	}

	public String getName() {  
        return name;  
    }  
  
    public void setName(String newName) {  
        this.name = newName;  
    }  
  
    public boolean isFolder() {  
        return isFolder;  
    }  
  
    public FolderItem getParent() {  
        return parent;  
    }  
  
    public void setParent(FolderItem parent) {  
        this.parent = parent;  
    }  
  
    public long getSize() {  
        return size;  
    }  
  
    public void setSize(long size) {  
        this.size = size;  
    }  
  
    public Date getCreationTime() {  
        return creationTime;  
    }  
  
    public void setCreationTime(Date creationTime) {  
        this.creationTime = creationTime;  
    }  
  
    public Date getLastModifiedTime() {  
        return lastModifiedTime;  
    }  
  
    public void setLastModifiedTime(Date lastModifiedTime) {  
        this.lastModifiedTime = lastModifiedTime;  
    }  
  
    // 实现equals和hashCode方法  
    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;  
        FolderItem that = (FolderItem) o;  
        return name.equals(that.name);  
    }  
  
    @Override  
    public int hashCode() {  
        return name.hashCode();  
    }  
  
    @Override  
    public String toString() {  
        return "FolderItem{" +  
                "name='" + name + '\'' +  
                ", isFolder=" + isFolder +  
                ", parent=" + (parent != null ? parent.getName() : "null") +  
                ", size=" + size +  
                ", creationTime=" + creationTime +  
                ", lastModifiedTime=" + lastModifiedTime +  
                '}';  
    }  
}
