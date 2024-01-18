import java.io.File;

public class Main {
    // ├ └ ─ │

    private static String homePath = "/home/sarper/Documents/Programming/Python/Pygame";

    
    private static String getLastDirectory(File[] paths) {
        String lastDirectory = "";
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].isDirectory()) {
                lastDirectory = paths[i].getAbsolutePath();
            }
        }

        return lastDirectory;
    }

    private static int getLength(String path) {
        return path.substring((int)homePath.length()).replace('\\', '/').split("/").length;
    }

    private static void listPaths(String pathname, String treeString, int minus, String replacement, String spaces) {
        File home = new File(pathname);
        File[] paths = home.listFiles();

        String lastDirectory = getLastDirectory(paths);
  
        for (int i = 0; i < paths.length; i++) {

            int length = getLength(paths[i].getAbsolutePath());
            spaces = paths[i].isDirectory() && spaces.length() == 7 ? spaces.substring(0,3)+'│'+spaces.substring(4) : spaces;

            StringBuilder string = new StringBuilder();
            string.append(new String(new char[length-minus]).replace("\0", replacement)); // spacing
            string.append(spaces);
            string.append((i == paths.length-1) ? "└" : "├"); // start
            string.append("──"); // tree


            System.out.println(string + paths[i].getName());
            
            // move next directory
            if (paths[i].isDirectory()) {
                if (lastDirectory == paths[i].getAbsolutePath()) {
                    listPaths(paths[i].toString(), treeString.toString() + "    ", 3, "   │", "       ");
                } else {
                    listPaths(paths[i].toString(), treeString.toString() + "    ", 2, "   │", "   ");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        listPaths(args[0], "", 2, "  │", "   ");
    }
}
