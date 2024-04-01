package framework;  
  
import java.util.Date;  
/**  
 * 文件夹或文件项的类。  
 * 用于表示文件系统中的文件夹或文件。  
 */    
public class FolderItem {  
    private static final String hashcode = null;//哈希值初始为null
	private String name;  
    protected static boolean isFolder;  
    private FolderItem parent; // 父文件夹  
    private long size; // 文件大小（如果是文件）  
    private Date creationTime; // 创建时间  
    private Date lastModifiedTime; // 最后修改时间  
    // 可以添加更多字段，如权限等  
  
    public FolderItem(String name, boolean b) {  
        this.name = name;  
        FolderItem.isFolder = b; // 正确的做法 
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
    //判断此FolderItem是否为文件夹
    public boolean isFolder() {  
        return isFolder;  
    }  
    //获取父文件夹
    public FolderItem getParent() {  
        return parent;  
    }  
    //设置父文件夹
    public void setParent(FolderItem parent) {  
        this.parent = parent;  
    }  
    // 获取文件大小
    public long getSize() {  
        return size;  
    }  
    //设置文件大小
    public void setSize(long size) {  
        this.size = size;  
    }  
    //获取创建时间
    public Date getCreationTime() {  
        return creationTime;  
    }  
    //设置创建时间
    public void setCreationTime(Date creationTime) {  
        this.creationTime = creationTime;  
    }  
    //获取最后修改时间
    public Date getLastModifiedTime() {  
        return lastModifiedTime;  
    }  
    //设置最后修改时间
    public void setLastModifiedTime(Date lastModifiedTime) {  
        this.lastModifiedTime = lastModifiedTime;  
    }  
  
    // 实现equals和hashCode方法  
    //equals方法用于比较两个FolderItem是否相等
    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;  
        FolderItem that = (FolderItem) o;  
        return name.equals(that.name);  
    }  
  
    @Override  
    //返回此FolderItem的哈希码
    public int hashCode() {  
    	final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = (int) (prime * result + size);
        return result; 
    }  
  
    @Override  
    //返回此FolderItem的字符串表示形式
    public String toString() {  
        return "FolderItem{" +  
                "name='" + name + '\'' +  
                ", isFolder=" + isFolder +  
                ", parent=" + (parent != null ? parent.getName() : "null") +  
                ", size=" + size +  
                ", creationTime=" + creationTime +  
                ", lastModifiedTime=" + lastModifiedTime + 
                ", hashcode=" + hashcode +
                '}';  
    }  
}
