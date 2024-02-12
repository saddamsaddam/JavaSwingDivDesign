import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Design extends JFrame {

    public Design() {
        setTitle("Vertical Panes Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int gapSize = 50; // Adjust the gap size as needed

        JPanel boxLayoutPanel = new JPanel();
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.X_AXIS));
        boxLayoutPanel.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));

        for (int i = 0; i < 15; i++) {
            JPanel pane = new JPanel();
            pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

            for (int j = 0; j < 15; j++) {
                JPanel paneleft = new JPanel();
                paneleft.setLayout(new BoxLayout(paneleft, BoxLayout.X_AXIS));

                JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Set layout manager to FlowLayout with left alignment
               
                JLabel a1 = new JLabel();
                panel1.add(a1);
                panel1.setPreferredSize(new Dimension(150, panel1.getPreferredSize().height)); // Set width for panel1

                JPanel panel2 = new JPanel();
                JLabel a2 = new JLabel();
                a2.setHorizontalAlignment(SwingConstants.CENTER); // Center-align horizontally
                a2.setVerticalAlignment(SwingConstants.CENTER); // Center-align vertically
                panel2.add(a2);
                panel2.setPreferredSize(new Dimension(60, panel2.getPreferredSize().height)); // Set width for panel2
                JPanel mid=new JPanel();
                mid.setPreferredSize(new Dimension(10, panel2.getPreferredSize().height)); // Set width for panel2
                paneleft.add(panel1);
                paneleft.add(mid);
                paneleft.add(panel2);
                if(j==0)
                {
                	 a1.setText("Product Name");
               	   a2.setText("Quantity");
                	panel1.setBackground(Color.pink);

                    panel2.setBackground(Color.pink);
                    panel1.setForeground(Color.WHITE);
                    panel2.setForeground(Color.WHITE);
                    panel1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    panel2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    a1.setForeground(Color.WHITE);
                    a2.setForeground(Color.WHITE);
                }
                else if(i<3)// under 30 will red nvn
                {
                	panel1.setBackground(Color.red);
                    panel2.setBackground(Color.red);
                    panel1.setForeground(Color.WHITE);
                    panel2.setForeground(Color.WHITE);
                    panel1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    panel2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    a1.setForeground(Color.WHITE);
                    a2.setForeground(Color.WHITE);
                    
                    a1.setText("XYZ");
                	   a2.setText("0");
                }
                else
                {
                	panel1.setBackground(Color.WHITE);
                    panel2.setBackground(Color.WHITE);
                 // Create a LineBorder with a specified color (e.g., black) and thickness (e.g., 1)
                    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                    panel1.setBorder(border);
                   
                    panel2.setBorder(border);
                    
                    a1.setText("XYZ");
                	   a2.setText("0");
                }
                
                pane.add(paneleft);

                // Add a fixed-size gap between vertical panes
                if (j < 14) {
                    pane.add(Box.createRigidArea(new Dimension(0, 10)));
                }
            }

            boxLayoutPanel.add(pane);

            // Add a fixed-size gap between vertical panes
            if (i < 14) { // change will list nvn
                boxLayoutPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            }
        }

        JScrollPane scrollPane = new JScrollPane(boxLayoutPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Design frame = new Design();
            frame.setVisible(true);
        });
    }
}
