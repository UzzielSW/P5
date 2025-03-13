package guiprogramming;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Random; 
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class PhotoOp {
  private JFrame window;
  private JPanel topPanel, groupPanel;
  private PhotoOpDrawingPanel drawingPanel;
  private JPanel titlePanel;
  private JLabel titleLabel;
  private JFormattedTextField scaleField;
  private JCheckBox shearBox1;
  private JCheckBox shearBox2;
  private JFileChooser chooser;

	
  public PhotoOp() { 
    // create the window
    window = new JFrame();

    // create the panels		
    createPanels();

    // panel to hold photo's title
    titlePanel = createTitlePanel();

    // create a label
   titleLabel = new JLabel("squirrelMonkey.jpg");
 
    titlePanel.add(titleLabel);

    // create rotate panel
    groupPanel.add(createRotatePanel());

    // create scale panel
    groupPanel.add(createScalePanel());

    // create shear panel
    groupPanel.add(createShearPanel());

    // create menu bar
    window.setJMenuBar(createMenuBar());

    // set topPanel as the content pane of this window
    window.setContentPane(topPanel);

    // when window is closed, terminate the program as well		
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
    // set window size
   window.setSize(600, 600);	
     // window.pack();

    // set window title	
    window.setTitle("Photo Op");	
window.setLocationRelativeTo(null);
    // make window visible
    window.setVisible(true);	

  }

  public void createPanels() {
    topPanel = new JPanel(new BorderLayout());
    drawingPanel = new PhotoOpDrawingPanel();
    groupPanel = new JPanel();

    // add drawingPanel to topPanel
    topPanel.add(drawingPanel, BorderLayout.CENTER);
    topPanel.add(groupPanel, BorderLayout.EAST);

    groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
    groupPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    groupPanel.setBackground(Color.lightGray);
    topPanel.setBackground(Color.lightGray);
  }

  public JPanel createTitlePanel() {
    JPanel titlePanel = new JPanel();
    topPanel.add(titlePanel, BorderLayout.NORTH);
    titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    titlePanel.setBackground(Color.lightGray);
    return titlePanel;
  }

  public JPanel createRotatePanel() {
    JPanel rotatePanel = new JPanel();
	
    // create two buttons to rotate image
    JButton rotateButton1 = new JButton(new ImageIcon("image/leftButton.jpg"));
    JButton rotateButton2 = new JButton(new ImageIcon("image/rightButton.jpg"));
    rotatePanel.add(rotateButton1);
    rotatePanel.add(rotateButton2);
		
    rotateButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // rotate image to the left by 45 degrees
        drawingPanel.rotateImage(-Math.PI/4);
      }
    });

    rotateButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // rotate image to the right by 45 degrees
        drawingPanel.rotateImage(Math.PI/4);
      }
    });
    rotateButton1.setToolTipText("Rotate left by 45 degrees");
    rotateButton2.setToolTipText("Rotate right by 45 degrees");
    rotatePanel.setMaximumSize(new Dimension(200, 60));
    rotatePanel.setBackground(Color.lightGray);
    return rotatePanel;
  }

  public JPanel createScalePanel() {
    JPanel scalePanel = new JPanel();
    JLabel scaleLabel = new JLabel("Scale:");

    // create a formatted text field called scaleField
    scaleField = new JFormattedTextField(new Float(100));
   scaleField.setColumns(3);
    JLabel percentLabel = new JLabel("%");
    scalePanel.add(scaleLabel);
    scalePanel.add(scaleField);
    scalePanel.add(percentLabel);

    // actionListener for scaleField
    scaleField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // scale the image by the value in scaleField
        float scale = (Float) scaleField.getValue()/100.0f;
        drawingPanel.scaleImage(scale);
      }
    });
    scalePanel.setMaximumSize(new Dimension(200, 40));
    scalePanel.setBackground(Color.lightGray);
    return scalePanel;
  }

  public JPanel createShearPanel() {
    JPanel shearPanel = new JPanel();
    shearPanel.setLayout(new BoxLayout(shearPanel, BoxLayout.Y_AXIS));

    // create two panels for holding each check box.
    JPanel shearPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
    JPanel shearPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
    shearPanel.add(shearPanel1);
    shearPanel.add(shearPanel2);
    JLabel shearLabel = new JLabel("Shear:");

    // create check box for horizontal shear
    shearBox1 = new JCheckBox("Horizontal");
    shearPanel1.add(shearLabel);
    shearPanel1.add(shearBox1);

    // create check box for vertical shear
    shearBox2 = new JCheckBox("Vertical");
    shearPanel2.add(Box.createHorizontalStrut(37));
    shearPanel2.add(shearBox2);		

    // add event handlers to the check boxes
    shearBox1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        shearAction();
      }
    });
    shearBox2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        shearAction();
      }
    });
		
    shearPanel.setBackground(Color.lightGray);
    shearBox1.setBackground(Color.lightGray);
    shearBox2.setBackground(Color.lightGray);
    shearPanel1.setBackground(Color.lightGray);
    shearPanel.setBackground(Color.lightGray);
    shearPanel2.setBackground(Color.lightGray);
    shearPanel.setMaximumSize(new Dimension(200, 60));
    return shearPanel;
}

  public void shearAction() {
    Random r = new Random();
    int value = r.nextInt(100);

    // shears the image by a random value
    if(shearBox1.isSelected() && shearBox2.isSelected()) 
      drawingPanel.shearImage(value/100.0f, value/100.0f);
    else if(shearBox1.isSelected()) 
      drawingPanel.shearImage(value/100.0f, 0);
    else if(shearBox2.isSelected())
      drawingPanel.shearImage(0, value/100.0f);
    else 
      drawingPanel.shearImage(0, 0);	 
  }

  public JMenuBar createMenuBar() {
    // create a menuBar
    JMenuBar menuBar = new JMenuBar();

    // add a menu called File to menuBar
    JMenu menu = new JMenu("File");
    menuBar.add(menu);
		
    // add a menu item called Open to File
    JMenuItem menuItem = new JMenuItem("Open Image");
    menu.add(menuItem);

    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        selectFile();
      }
    });
	
    menuBar.setBackground(Color.lightGray);
    return menuBar;
  }

  public void selectFile() {
    chooser = new JFileChooser();

    // This file filter allows the user to select JPEG files only
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG files", "JPG", "JPEG");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(window);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      //open a dialog box to select files 
      File file = chooser.getSelectedFile();
      System.out.println(file.getPath());

      //load the image from the file and put it in drawing panel
      Image image =  new javax.swing.ImageIcon(file.getPath()).getImage();	
      drawingPanel.loadImage(image);

      // update the title of the image
      titleLabel.setText(file.getName());
      titlePanel.repaint();
    }	
}	


  public static void main(String[] args) {
    new PhotoOp();
  }
}

