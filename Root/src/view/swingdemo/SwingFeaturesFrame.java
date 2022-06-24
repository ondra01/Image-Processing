package view.swingdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ImageController;
import model.ImageProcessingModel;

/**
 * This class opens the main window, that has different elements illustrated in
 * it. It also doubles up as all the listeners for simplicity. Such a design is
 * not recommended in general.
 */

public class SwingFeaturesFrame extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
  private JPasswordField pfield;
  private JButton pButton;
  private JLabel pDisplay;
  private JPanel mainPanel;
  private JScrollPane mainScrollPane;

  private JLabel checkboxDisplay;
  private JLabel radioDisplay;
  private JLabel comboboxDisplay;
  private JLabel colorChooserDisplay;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;
  private JLabel inputDisplay;
  private JLabel optionDisplay;

  private JList<String> listOfStrings;
  private JList<Integer> listOfIntegers;

  //Recent
  private int DisplayedImageWidths = 600;
  private int DisplayedImageHeights = 500;
  private final JLabel runScriptFileDisplay;

  private ImageProcessingModel model;
  private ImageController controller;

  public SwingFeaturesFrame() {
    super();
    this.model = model;
    this.controller = controller;
    setTitle("Image Processor");
    setSize(DisplayedImageWidths * 2 + 100, DisplayedImageHeights + 300);

    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    //show an image with a scrollbar
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    //imagePanel.setBorder(BorderFactory.createTitledBorder("Selected Image: "));
    imagePanel.setLayout(new GridLayout(1, 0, 10, 10));
    //imagePanel.setMaximumSize(null);
    mainPanel.add(imagePanel);


    String[] images = {"Jellyfish.jpg", "Koala.jpg"};
    //String[] images = {"", ""};
    //JLabel[] imageLabel = new JLabel[images.length];
    JScrollPane[] imageScrollPane = new JScrollPane[images.length];

    //SELECTED IMAGE Panel
    JPanel SelectedImagePanel = new JPanel();
    SelectedImagePanel.setBorder(BorderFactory.createTitledBorder("Selected Image: "));
    //SelectedImagePanel.setLayout(new GridLayout(2, 1, 10, 10));
    JLabel SelectedImageLabel = new JLabel();
    imageScrollPane[0] = new JScrollPane(SelectedImageLabel);
    SelectedImageLabel.setIcon(new ImageIcon(images[0]));
    imageScrollPane[0].setPreferredSize(new Dimension(this.DisplayedImageWidths,
            this.DisplayedImageHeights));
    //SelectedImagePanel.add(new JLabel("This is a test"));
    SelectedImagePanel.add(imageScrollPane[0]);
    imagePanel.add(SelectedImagePanel);

    //ALTERED IMAGE
    JPanel AlteredImagePanel = new JPanel();
    AlteredImagePanel.setBorder(BorderFactory.createTitledBorder("Altered Image: "));
    JLabel AlteredImageLabel = new JLabel();
    imageScrollPane[1] = new JScrollPane(AlteredImageLabel);
    AlteredImageLabel.setIcon(new ImageIcon(images[1]));
    imageScrollPane[1].setPreferredSize(new Dimension(DisplayedImageWidths,
            DisplayedImageHeights));
    AlteredImagePanel.add(imageScrollPane[1]);
    imagePanel.add(AlteredImagePanel);

    //dialog boxes
    JPanel dialogBoxesPanel = new JPanel();
    //dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("User Input"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(dialogBoxesPanel);

    JPanel loadAndSavePanel = new JPanel();
    dialogBoxesPanel.add(loadAndSavePanel);

    //file open
    JPanel fileopenPanel = new JPanel();
    fileopenPanel.setLayout(new FlowLayout());
    JButton fileOpenButton = new JButton("Load an Image File");
    fileOpenButton.setActionCommand("Open file");
    fileOpenButton.addActionListener(this);
    fileopenPanel.add(fileOpenButton);
    fileOpenDisplay = new JLabel("File path will appear here");
    fileopenPanel.add(fileOpenDisplay);
    loadAndSavePanel.add(fileopenPanel);
    //dialogBoxesPanel.add(fileopenPanel);

    //file save
    JPanel filesavePanel = new JPanel();
    filesavePanel.setLayout(new FlowLayout());
    loadAndSavePanel.add(filesavePanel);
    //dialogBoxesPanel.add(filesavePanel);
    JButton fileSaveButton = new JButton("Save an Image File");
    fileSaveButton.setActionCommand("Save file");
    fileSaveButton.addActionListener(this);
    filesavePanel.add(fileSaveButton);
    fileSaveDisplay = new JLabel("File path will appear here");
    filesavePanel.add(fileSaveDisplay);

    //Available Image Mutations
    String[] componentToGreyscaleMutations = {"Red-To-Greyscale", "Green-To-Greyscale",
            "Blue-To-Greyscale", "Value-To-Greyscale", "Luma-To-Greyscale",
            "Intensity-To-Greyscale"};
    String[] otherMutations = {"Blur", "Sharpen", "Greyscale", "Sepia", "Horizontal-Flip",
            "Vertical-Flip"};
    String[] allMutations = {"Red-To-Greyscale", "Green-To-Greyscale", "Blue-To-Greyscale",
            "Value-To-Greyscale", "Luma-To-Greyscale", "Intensity-To-Greyscale", "Blur", "Sharpen",
            "Greyscale", "Sepia", "Horizontal-Flip", "Vertical-Flip"};

    //combo box
    JPanel comboboxPanel = new JPanel();
    comboboxPanel.setBorder(BorderFactory.createTitledBorder("Available Image Mutations"));
    comboboxPanel.setLayout(new BoxLayout(comboboxPanel, BoxLayout.PAGE_AXIS));
    dialogBoxesPanel.add(comboboxPanel);
    JComboBox<String> combobox = new JComboBox<String>();
    //the event listener when an option is selected
    combobox.setActionCommand("Mutation options");
    combobox.addActionListener(this);
    for (int i = 0; i < allMutations.length; i++) {
      combobox.addItem(allMutations[i]);
    }
    comboboxPanel.add(combobox);
    JButton applyMutationButton = new JButton("Apply Mutation To Selected Image!");
    applyMutationButton.setActionCommand("Apply Mutation");
    applyMutationButton.addActionListener(this);
    comboboxPanel.add(applyMutationButton);



    //Run a Script Text File
    JPanel runScriptFilePanel = new JPanel();
    runScriptFilePanel.setLayout(new FlowLayout());
    JButton runScriptFileButton = new JButton("Run a Script Text File (.txt)");
    runScriptFileButton.setActionCommand("Run file");
    runScriptFileButton.addActionListener(this);
    runScriptFilePanel.add(runScriptFileButton);
    runScriptFileDisplay = new JLabel("File path will appear here");
    runScriptFilePanel.add(runScriptFileDisplay);
    dialogBoxesPanel.add(runScriptFilePanel);
  }


  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    switch (arg0.getActionCommand()) {
      case "Size options":
        if (arg0.getSource() instanceof JComboBox) {
          JComboBox<String> box = (JComboBox<String>) arg0.getSource();
          //comboboxDisplay.setText("You selected: " + (String) box.getSelectedItem());


        }
        break;
      case "Open file": {
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, JPEG, PNG, & PPM Images", "jpg", "jpeg", "png", "ppm");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog(SwingFeaturesFrame.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          String filepath = f.getName();
          this.model.addImage();
          fileOpenDisplay.setText(filepath);
        }
      }
      break;
      case "Save file": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog(SwingFeaturesFrame.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          fileSaveDisplay.setText(f.getAbsolutePath());
        }
      }
      break;
      case "Message":
        JOptionPane.showMessageDialog(SwingFeaturesFrame.this, "This is a demo message", "Message", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(SwingFeaturesFrame.this, "You are about to be deleted.", "Last Chance", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(SwingFeaturesFrame.this, "You have been deleted.", "Too late", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(SwingFeaturesFrame.this, "Please start again.", "What to do next", JOptionPane.INFORMATION_MESSAGE);
        break;
      case "Input":
        inputDisplay.setText(JOptionPane.showInputDialog("Please enter your username"));
        break;
      case "Option": {
        String[] options = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "seis", "siete", "ocho", "nueve", "dies"};
        int retvalue = JOptionPane.showOptionDialog(SwingFeaturesFrame.this, "Please choose number", "Options", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[4]);
        optionDisplay.setText(options[retvalue]);
      }
      break;
    }
  }

  @Override
  public void itemStateChanged(ItemEvent arg0) {
    // TODO Auto-generated method stub
    String who = ((JCheckBox) arg0.getItemSelectable()).getActionCommand();

    switch (who) {
      case "CB1":
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
          checkboxDisplay.setText("Check box 1 was selected");
        } else {
          checkboxDisplay.setText("Check box 1 was deselected");
        }
        break;
      case "CB2":
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
          checkboxDisplay.setText("Check box 2 was selected");
        } else {
          checkboxDisplay.setText("Check box 2 was deselected");
        }
        break;
      case "CB3":
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
          checkboxDisplay.setText("Check box 3 was selected");
        } else {
          checkboxDisplay.setText("Check box 3 was deselected");
        }
        break;
      case "CB4":
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
          checkboxDisplay.setText("Check box 4 was selected");
        } else {
          checkboxDisplay.setText("Check box 4 was deselected");
        }
        break;

      case "CB5":
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
          checkboxDisplay.setText("Check box 5 was selected");
        } else {
          checkboxDisplay.setText("Check box 5 was deselected");
        }
        break;

    }
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    // We don't know which list called this callback, because we're using it
    // for two lists.  In practice, you should use separate listeners
    JOptionPane.showMessageDialog(SwingFeaturesFrame.this,
            "The source object is " + e.getSource(), "Source", JOptionPane.PLAIN_MESSAGE);
    // Regardless, the event information tells us which index was selected
    JOptionPane.showMessageDialog(SwingFeaturesFrame.this,
            "The changing index is " + e.getFirstIndex(), "Index", JOptionPane.PLAIN_MESSAGE);
    // This gets us the string value that's currently selected
    JOptionPane.showMessageDialog(SwingFeaturesFrame.this,
            "The current string item is " + this.listOfStrings.getSelectedValue(), "Selected string", JOptionPane.PLAIN_MESSAGE);
    // This gets us the integer value that's currently selected
    JOptionPane.showMessageDialog(SwingFeaturesFrame.this,
            "The current number item is " + this.listOfIntegers.getSelectedValue(), "Selected integer", JOptionPane.PLAIN_MESSAGE);
  }
}
