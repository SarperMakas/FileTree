import java.io.File;

public class Main {
    // ├ └ ─ │
    private static void listPaths(String pathname, String treeString) {
        File home = new File(pathname);
        File[] paths = home.listFiles();
  
        for (int i = 0; i < paths.length; i++) {
            String spacing = new String(new char[treeString.length()]).replace('\0', ' ');

            String start = (i ==paths.length-1) ? "└" : "├";

            System.out.println(spacing + start + "──" + paths[i].getName());
            if (paths[i].isDirectory()) {
                listPaths(paths[i].toString(), treeString.toString() + "    ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        listPaths("/home/sarper/Documents/Programming/Python/Pygame", "");
    }
}
