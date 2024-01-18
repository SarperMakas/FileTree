import java.io.File;

public class Main {
    // ├ └ ─ │

    private static String homePath = "/home/sarper/Documents/Programming/Python/Pygame";

    private static void listPaths(String pathname, String treeString) {
        File home = new File(pathname);
        File[] paths = home.listFiles();
  
        for (int i = 0; i < paths.length; i++) {

            int length = paths[i].getAbsolutePath().substring((int)homePath.length()).replace('\\', '/').split("/").length;

            StringBuilder string = new StringBuilder();
            string.append(new String(new char[length-2]).replace("\0", "   │")); // spacing
            string.append("   ");
            string.append((i ==paths.length-1) ? "└" : "├"); // start
            string.append("──"); // tree


            System.out.println(string + paths[i].getName());
            
            // move next directory
            if (paths[i].isDirectory()) {
                listPaths(paths[i].toString(), treeString.toString() + "    ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        listPaths(homePath, "");
    }
}
