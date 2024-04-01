package framework;    
  
import java.util.Date;    
  
/**  
 * 文件夹或文件项的类。  
 * 用于表示文件系统中的文件夹或文件。  
 */  
public class FolderItem {    
      
    private String name;    
      
    /**  
     * 表示此FolderItem是否为文件夹的静态变量。  
     */  
    protected static boolean isFolder;    
      
    /**  
     * 父文件夹。  
     * 如果是根文件夹，则此值为null。  
     */  
    private FolderItem parent;   
      
    /**  
     * 文件大小（如果是文件）。  
     * 如果是文件夹，此值可能不相关或未定义。  
     */  
    private long size;   
      
    /**  
     * 创建时间。  
     * 当文件夹或文件被创建时的时间。  
     */  
    private Date creationTime;   
      
    /**  
     * 最后修改时间。  
     * 当文件夹或文件最后被修改时的时间。  
     */  
    private Date lastModifiedTime;   
      
    // 可以添加更多字段，如权限等    
    
    /**  
     * 构造一个FolderItem实例。  
     *  
     * @param name 名称  
     * @param b 是否为文件夹  
     */  
    public FolderItem(String name, boolean b) {    
        this.name = name;    
        FolderItem.isFolder = b; 
        this.isFolder = b; // 正确的做法  
        this.creationTime = new Date(); // 默认为当前时间    
        this.lastModifiedTime = new Date(); // 默认为当前时间    
    }    
    
    // 可以添加其他构造器    
    
    /**  
     * 构造一个非文件夹的FolderItem实例。  
     *  
     * @param initialName 初始名称  
     */  
    public FolderItem(String initialName) {  
        this(initialName, false); // 调用上面的构造器，并默认此实例为非文件夹  
    }  
  
    /**  
     * 获取文件夹或文件的名字。  
     *  
     * @return 名称  
     */  
    public String getName() {    
        return name;    
    }    
    
    /**  
     * 设置文件夹或文件的名字。  
     *  
     * @param newName 新的名称  
     */  
    public void setName(String newName) {    
        this.name = newName;    
    }    
    
    /**  
     * 判断此FolderItem是否为文件夹。  
     *  
     * @return 如果为文件夹则返回true，否则返回false  
     */  
    public boolean isFolder() {    
        return isFolder;    
    }    
    
    /**  
     * 获取父文件夹。  
     *  
     * @return 父文件夹，如果没有父文件夹则返回null  
     */  
    public FolderItem getParent() {    
        return parent;    
    }    
    
    /**  
     * 设置父文件夹。  
     *  
     * @param parent 父文件夹  
     */  
    public void setParent(FolderItem parent) {    
        this.parent = parent;    
    }    
    
    /**  
     * 获取文件大小（如果是文件）。  
     *  
     * @return 文件大小  
     */  
    public long getSize() {    
        return size;    
    }    
    
    /**  
     * 设置文件大小（如果是文件）。  
     *  
     * @param size 文件大小  
     */  
    public void setSize(long size) {    
        this.size = size;    
    }    
    
    /**  
     * 获取创建时间。  
     *  
     * @return 创建时间  
     */  
    public Date getCreationTime() {    
        return creationTime;    
    }    
    
    /**  
     * 设置创建时间。  
     *  
     * @param creationTime 创建时间  
     */  
    public void setCreationTime(Date creationTime) {    
        this.creationTime = creationTime;    
    }    
    
    /**  
     * 获取最后修改时间。  
     *  
     * @return 最后修改时间  
     */  
    public Date getLastModifiedTime() {    
        return lastModifiedTime;    
    }    
    
    /**  
     * 设置最后修改时间。  
     *  
     * @param lastModifiedTime 最后修改时间  
     */  
    public void setLastModifiedTime(Date lastModifiedTime) {    
        this.lastModifiedTime = lastModifiedTime;    
    }    
    
    // 实现equals和hashCode方法    
      
    /**  
     * 重写equals方法，用于比较两个FolderItem是否相等。  
     *  
     * @param o 要比较的对象  
     * @return 如果相等则返回true，否则返回false  
     */  
    @Override    
    public boolean equals(Object o) {    
        if (this == o) return true;    
        if (o == null || getClass() != o.getClass()) return false;    
        FolderItem that = (FolderItem) o;    
        return name.equals(that.name);    
    }    
    
    /**  
     * 重写hashCode方法，返回此FolderItem的哈希码。  
     *  
     * @return 哈希码  
     */  
    @Override    
    public int hashCode() {    
        return name.hashCode();    
    }    
    
    /**  
     * 重写toString方法，返回此FolderItem的字符串表示形式。  
     *  
     * @return 字符串表示形式  
     */  
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
