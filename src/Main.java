import java.io.File;

public class Main {
    // ├ └ ─ │
    private static void listPaths(String pathname, String treeString) {
        File home = new File(pathname);
        File[] paths = home.listFiles();
  
        for (int i = 0; i < paths.length; i++) {
            
            System.out.println(treeString + paths[i].getName());
            if (paths[i].isDirectory()) {
                listPaths(paths[i].toString(), treeString.toString() + "    ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        listPaths("/home/sarper/Documents/Programming/Python", "");
    }
}
