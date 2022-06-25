package view;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Features;
import model.ImageProcessingModel;

/**
 * Represents a GUI based view, implemented using JSwing, for the Image Processor.
 */
public class GUIViewImpl extends JFrame implements GUIView {

  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;

  //Recent
  private int displayedImageWidths = 600;
  private int displayedImageHeights = 500;
  private ActionListener listener;
  String[] images = {"", ""};
  private JButton fileOpenButton;
  JLabel selectedImageLabel;


  /**
   * This view class opens the main window, that has different elements illustrated in it. The
   * action listeners are located in the constructor.
   *
   * @param model is the ImageProcessingModel which contains and operates on all the Images in
   *              the Program.
   */
  public GUIViewImpl(ImageProcessingModel model) {
    super();
    setTitle("Image Processor");
    setSize(displayedImageWidths * 2 + 100, displayedImageHeights + 300);

    JPanel mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    //show an image with a scrollbar
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    //imagePanel.setBorder(BorderFactory.createTitledBorder("Selected Image: "));
    imagePanel.setLayout(new GridLayout(1, 0, 10, 10));
    //imagePanel.setMaximumSize(null);
    mainPanel.add(imagePanel);


    String[] images = {"Jellyfish.jpg"};
    //JLabel[] imageLabel = new JLabel[images.length];
    JScrollPane[] imageScrollPane = new JScrollPane[2];

    //SELECTED IMAGE Panel
    JPanel selectedImagePanel = new JPanel();
    selectedImagePanel.setBorder(BorderFactory.createTitledBorder("Selected Image: "));
    //SelectedImagePanel.setLayout(new GridLayout(2, 1, 10, 10));
    selectedImageLabel = new JLabel();
    imageScrollPane[0] = new JScrollPane(selectedImageLabel);
    selectedImageLabel.setIcon(new ImageIcon(images[0]));
    imageScrollPane[0].setPreferredSize(new Dimension(this.displayedImageWidths,
            this.displayedImageHeights));
    //SelectedImagePanel.add(new JLabel("This is a test"));
    selectedImagePanel.add(imageScrollPane[0]);
    imagePanel.add(selectedImagePanel);

    //Histogram
    JPanel alteredImagePanel = new JPanel();
    alteredImagePanel.setBorder(BorderFactory.createTitledBorder("Histogram of Selected Image: "));
    JLabel alteredImageLabel = new JLabel();
    imageScrollPane[1] = new JScrollPane(alteredImageLabel);
    alteredImageLabel.setIcon(new ImageIcon("images[1]"));
    imageScrollPane[1].setPreferredSize(new Dimension(displayedImageWidths,
            displayedImageHeights));
    alteredImagePanel.add(imageScrollPane[1]);
    imagePanel.add(alteredImagePanel);

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
    fileOpenButton = new JButton("Load an Image File");
    fileOpenButton.setActionCommand("Open file");
    fileOpenButton.addActionListener(listener);
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
    fileSaveButton.addActionListener(listener);
    filesavePanel.add(fileSaveButton);
    fileSaveDisplay = new JLabel("File path will appear here");
    filesavePanel.add(fileSaveDisplay);

    //Available Image Mutations
    String[] componentToGreyscaleMutations
            = {"Red-To-Greyscale", "Green-To-Greyscale",
               "Blue-To-Greyscale", "Value-To-Greyscale", "Luma-To-Greyscale",
               "Intensity-To-Greyscale"};
    String[] otherMutations = {"Blur", "Sharpen", "Greyscale", "Sepia", "Horizontal-Flip",
                               "Vertical-Flip"};
    String[] allMutations
            = {"Red-To-Greyscale", "Green-To-Greyscale", "Blue-To-Greyscale",
               "Value-To-Greyscale", "Luma-To-Greyscale", "Intensity-To-Greyscale", "Blur",
               "Sharpen", "Greyscale", "Sepia", "Horizontal-Flip", "Vertical-Flip"};

    //combo box
    JPanel comboboxPanel = new JPanel();
    comboboxPanel.setBorder(BorderFactory.createTitledBorder("Available Image Mutations"));
    comboboxPanel.setLayout(new BoxLayout(comboboxPanel, BoxLayout.PAGE_AXIS));
    dialogBoxesPanel.add(comboboxPanel);
    JComboBox<String> combobox = new JComboBox<String>();
    //the event listener when an option is selected
    combobox.setActionCommand("Mutation options");
    combobox.addActionListener(listener);
    for (int i = 0; i < allMutations.length; i++) {
      combobox.addItem(allMutations[i]);
    }
    comboboxPanel.add(combobox);
    JButton applyMutationButton = new JButton("Apply Mutation To Selected Image!");
    applyMutationButton.setActionCommand("Apply Mutation");
    applyMutationButton.addActionListener(listener);
    comboboxPanel.add(applyMutationButton);


    //Run a Script Text File
    JPanel runScriptFilePanel = new JPanel();
    runScriptFilePanel.setLayout(new FlowLayout());
    JButton runScriptFileButton = new JButton("Run a Script Text File (.txt)");
    runScriptFileButton.setActionCommand("Run file");
    runScriptFileButton.addActionListener(listener);
    runScriptFilePanel.add(runScriptFileButton);
    JLabel runScriptFileDisplay = new JLabel("File path will appear here");
    runScriptFilePanel.add(runScriptFileDisplay);
    dialogBoxesPanel.add(runScriptFilePanel);
  }

  @Override
  public void setListener(ActionListener listener) {
    this.listener = listener;
  }

  @Override
  public void setFileOpenDisplay(String filepath) {
    this.fileOpenDisplay.setText(filepath);
  }

  @Override
  public void setFileSaveDisplay(String filepath) {
    this.fileSaveDisplay.setText(filepath);
  }

  @Override
  public void acceptFeatures(Features features) {
    fileOpenButton.addActionListener(actionEvent -> features.doLoadImage());
  }

  @Override
  public String getFilePath(boolean isLoad) {
    String filepath = null;
    final JFileChooser fchooser = new JFileChooser(".");
    if (isLoad) {
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
              "JPG, JPEG, PNG, & PPM Images", "jpg", "jpeg", "png", "ppm");
      fchooser.setFileFilter(filter);
      int retvalue = fchooser.showOpenDialog((JFrame) this);

      if (retvalue == JFileChooser.APPROVE_OPTION) {
        File f = fchooser.getSelectedFile();
        filepath = f.getName();
        //this.model.addImage(userGivenName, new ImageImpl(this.loadImage(filepath)));
        this.setFileOpenDisplay(filepath);
      }
      return filepath;
    } else {
      int retvalue = fchooser.showSaveDialog((JFrame) this);
      if (retvalue == JFileChooser.APPROVE_OPTION) {
        File f = fchooser.getSelectedFile();
        filepath = f.getName();
        this.setFileSaveDisplay(filepath);
      }
      return null;
    }
  }

  @Override
  public String getUserGivenName() {
    return "defaultUserGivenName";
  }

  @Override
  public void displayImage(String userGivenName) {
    this.images[0] = userGivenName;
  }

  @Override
  public String getOriginalName() {
    return null;
  }

  @Override
  public String getAlteredName() {
    return null;
  }

  @Override
  public void setSelectedImage(String imageFilePath) {
    this.selectedImageLabel.setIcon(new ImageIcon(imageFilePath));
  }

  @Override
  public void renderMessage(String message) {
    //render the message
  }

  @Override
  public void renderApplication() {
    this.setDefaultLookAndFeelDecorated(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    try {
      // Set cross-platform Java L&F (also called "Metal")
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

      //UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());

      //   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      //    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
      //    {
      //       if ("Nimbus".equals(info.getName())) {
      //          UIManager.setLookAndFeel(info.getClassName());
      //         break;
      //    }
      // }
    } catch (UnsupportedLookAndFeelException e) {
      // handle exception
    } catch (ClassNotFoundException e) {
      // handle exception
    } catch (InstantiationException e) {
      // handle exception
    } catch (IllegalAccessException e) {
      // handle exception
    } catch (Exception e) {
      // handle exception
    }
  }

  /*
  @Override
  public void actionPerformed(ActionEvent userAction) {
    switch (userAction.getActionCommand()) {
      case "Mutation options":
        if (userAction.getSource() instanceof JComboBox) {
          JComboBox<String> box = (JComboBox<String>) userAction.getSource();
          this.mutationToPerform = ((String) box.getSelectedItem());
        }
        break;
      case "Apply Mutation":
        if (commandMap.containsKey(mutationToPerform)) {
          StringReader guiInput = new StringReader(userGivenName + " " + userGivenName + "2");
          Scanner sc = new Scanner(guiInput);
          try {
            this.commandMap.get(mutationToPerform).apply(this.model, this.guiView, this, sc);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        break;
      case "Open file": {
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, JPEG, PNG, & PPM Images", "jpg", "jpeg", "png", "ppm");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog((JFrame) this.guiView);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          filepath = f.getName();
          this.model.addImage(userGivenName, new ImageImpl(this.loadImage(filepath)));
          this.guiView.setFileOpenDisplay(filepath);
        }
      }
      break;
      case "Save file": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog((JFrame) this.guiView);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          filepath = f.getName();
          this.saveImage(filepath, this.model.getImage(filepath.split(".")[0]));
          this.guiView.setFileSaveDisplay(filepath);
        }
      }
      break;
    }
  } */
}
