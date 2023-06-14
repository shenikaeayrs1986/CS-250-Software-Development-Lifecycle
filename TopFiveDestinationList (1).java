import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.peer.TextAreaPeer;

import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
                
 
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        addDestinationNameAndPicture("1. Laos (Laos is the only landlocked country in Southeast Asia and has become a popular tourist destination. It offers captivating landscapes, and a vibrant culture and is easily accessible, making it a hidden treasure for visitors.)", new ImageIcon(getClass().getResource("/resources/Laos.jpg")));
        addDestinationNameAndPicture("2. China (China is the leading tourist destination in the world. China provides something to every traveler from China's distinguished history, archaic architectonics, and contemporary cuisine.)", new ImageIcon(getClass().getResource("/resources/China.jpg")));
        addDestinationNameAndPicture("3. Japan (Japan is a truly captivating destination that offers a unique experience to visitors. From the stunning cherry blossom trees to the serene tea ceremonies and the overall Omotenshi ambiance, there's plenty to explore and enjoy in Japan.)", new ImageIcon(getClass().getResource("/resources/Japan.jpg")));
        addDestinationNameAndPicture("4. Korea (Korea is a fascinating travel destination that offers a perfect blend of adventure and relaxation. Korea has something for everyone with its crystal clear waters at Haeundae Beach, the renowned Busan International Film Festival, and a history of over 5000 years.)", new ImageIcon(getClass().getResource("/resources/Korea.jpg")));
        addDestinationNameAndPicture("5. Philippines (Explore the hidden gem of Southeast Asia, the Philippines. With more than 7,000 islands, a variety of year-round festivals, and historical heritage sites such as the Rice Terraces of the Cordilleras, you are in for an unforgettable experience.)", new ImageIcon(getClass().getResource("/resources/Philippines.jpg")));
        
  
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);
        
        // *** additional customizations** Added Color Scheme customization
        list.setBackground(Color.YELLOW);
        list.setSelectionBackground(Color.green);
        list.setCellRenderer(renderer);

        // *** additional customizations** Added nameLabel
        JLabel nameLabel = new JLabel ("Developer: Shenika Eayrs");
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}