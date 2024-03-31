package framework;  
  
public class File extends FolderItem {  
    private String extension;  
    private final long size;  
  
    public File(String initialName, String initialExtension, long initialSize) {  
        super(initialName, false); // 假设File类代表文件，不是文件夹  
        if (initialExtension == null || initialExtension.isEmpty()) {  
            throw new IllegalArgumentException("Extension cannot be null or empty.");  
        }  
        if (initialSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");  
        }  
        this.extension = initialExtension;  
        this.size = initialSize;  
    }
    public File(String name, boolean indent, int size) {
    super(name, indent);
	this.extension = "";
    this.size = size;
    }

  
    public String getExtension() {  
        return extension;  
    }  
  
    public long getSize() {  
        return size;  
    }  
    public void setExtension(String newExtension) {
		extension = newExtension;
	}
    public boolean isFolder() {  
        return false; // 明确返回false，表示这是一个文件而不是文件夹  
    }  
  
    @Override  
    public String toString() {  
        return "File{" +  
                "name='" + getName() + '\'' +  
                ", extension='" + extension + '\'' +  
                ", size=" + size +  
                '}';  
    }  
}
