import javax.swing.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Component extends JPanel implements TreeSelectionListener {

    private JEditorPane htmlPane;
    private JTree JT;
    public static Node Tonmai;

    //Optionally play with line styles.  Possible values are
    //"Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";

    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

    public Component() {
        super(new GridLayout(1, 0));

        //Create the nodes.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(Homework1.tree);

        createNodes(top, Homework1.tree);

        //Create a tree that allows one selection at a time.
        JT = new JTree(top);
        JT.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        JT.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style =" + lineStyle);
            JT.putClientProperty("JTree.lineStyle", lineStyle);
        }
        ImageIcon NodeIcon =  new ImageIcon(Component.class.getResource("middle.gif"));
        //ImageIcon leafIcon = createImageIcon("middle.gif");

       /* if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setClosedIcon(leafIcon);
            renderer.setOpenIcon(leafIcon);
            JT.setCellRenderer(renderer);
        }*/

        //Create the scroll pane and add the tree to it.
        JScrollPane treeView = new JScrollPane(JT);

        //Create the HTML viewing pane.
        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);

        JScrollPane htmlView = new JScrollPane(htmlPane);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(htmlView);

        Dimension minimumSize = new Dimension(100, 50);
        htmlView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100);
        splitPane.setPreferredSize(new Dimension(500, 300));

        //Add the split pane to this panel.
        add(splitPane);
    }

    private class BookInfo {
        public String bookname;
        public URL bookU;
    }

    protected static ImageIcon createImageIcon(String book, String Wicon) {
        java.net.URL ImU = Homework1.class.getResource(Wicon);

        if (ImU != null) {
            return new ImageIcon(ImU);
        } else {
            System.err.println("Couldn't find file : " + Wicon);
            return null;
        }
    }


    public void createNodes(DefaultMutableTreeNode top, Node n) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);
    }

    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }
        //Create and set up the window.
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Component());
    }

    public static boolean Baimai = false;

    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                JT.getLastSelectedPathComponent();

        if (node == null) return;

        Object NodeInfo = node.getUserObject();

    }

    private void createNodes(DefaultMutableTreeNode top, Homework1.tree n) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);
    }
}