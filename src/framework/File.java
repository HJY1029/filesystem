package framework;    
  
// 定义一个File类，继承自FolderItem类
public class File extends FolderItem {    
    private String extension;    
    // 文件的大小，由于文件大小在创建后不会改变
    private final long size;    
  
    // 构造方法，用于创建一个新的文件对象  
    // 参数initialName表示文件的初始名称  
    // 参数initialExtension表示文件的初始扩展名  
    // 参数initialSize表示文件的初始大小  
    public File(String initialName, String initialExtension, long initialSize) {    
        // 调用父类FolderItem的构造方法，设置文件名称，并设置isFolder为false，表示这是一个文件  
        super(initialName, false);   
        // 校验扩展名，如果为空或null则抛出异常  
        if (initialExtension == null || initialExtension.isEmpty()) {    
            throw new IllegalArgumentException("Extension cannot be null or empty.");    
        }    
        // 校验文件大小，如果小于0则抛出异常  
        if (initialSize < 0) {  
            throw new IllegalArgumentException("Size cannot be negative.");    
        }    
        // 初始化扩展名  
        this.extension = initialExtension;    
        // 初始化文件大小  
        this.size = initialSize;    
    }  
  
    // 另一个构造方法，用于创建一个新的文件对象  
    // 参数name表示文件的名称  
    // 参数indent通常用于格式化输出时的缩进，但在这个方法中并未使用  
    // 参数size表示文件的大小  
    public File(String name, boolean indent, int size) {  
        // 调用父类FolderItem的构造方法，设置文件名称和isFolder值  
        super(name, indent);  
        // 扩展名被初始化为空字符串  
        this.extension = "";  
        // 初始化文件大小  
        this.size = size;  
    }  
  
    // 获取文件的扩展名  
    public String getExtension() {    
        return extension;    
    }    
  
    // 获取文件的大小  
    public long getSize() {    
        return size;    
    }    
  
    // 设置文件的扩展名  
    public void setExtension(String newExtension) {  
        extension = newExtension;  
    }  
  
    // 判断当前对象是否是一个文件夹  
    // 由于这是一个文件对象，所以直接返回false  
    public boolean isFolder() {    
        return false; // 明确返回false，表示这是一个文件而不是文件夹    
    }    
  
    // 重写toString方法，返回文件的字符串表示  
    @Override    
    public String toString() {    
        return "File{" +    
                "name='" + getName() + '\'' +  // 获取并拼接文件名称  
                ", extension='" + extension + '\'' +  // 获取并拼接文件扩展名  
                ", size=" + size +  // 获取并拼接文件大小  
                '}';    
    }    
}
