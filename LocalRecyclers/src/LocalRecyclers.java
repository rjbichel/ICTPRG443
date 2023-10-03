//Importing components necessary for application
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
//@author Reece Bichel

public class LocalRecyclers extends Frame implements WindowListener
{
    //declares variables for buttons, labels and text fields
    Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast, btnSortBusnName, btnBinarySearchBusnName, btnFilterBy;
    TextField txtBusnName, txtAddress, txtPhone, txtFind, txtWebSite, txtRecyclesType, txtFilterBy;
    Label lblBusName, lblFind, lblAddress, lblPhone, lblWebSite, lblRecyclesType, lblRecyclersList, lblRecyclersTitle;
    TextArea txaRecyclersList;

    //the entry point for the program
    public static void main(String[] args)
    {
        Frame myFrame = new LocalRecyclers();
        myFrame.setSize(700,550);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    public LocalRecyclers()
    {
        //indicates title of screen located in top left hand corner
        setTitle("Local Recyclers");

        //sets colour of background in window
        //setBackground(Color.yellow);

        //sets the layout manager of different screen components
        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);

        //calls the method that initialises the items presented to the screen
        LocateRecyclersLabels(myLayout);
        LocateRecyclersTextFields(myLayout);
        LocateRecyclersButtons(myLayout);

        //adds WindowListener to the UI
        this.addWindowListener(this);

    }

    //Locates the labels for the screen
    public void LocateRecyclersLabels(SpringLayout myLabelLayout)
    {
        //Label size variables that can be changed if dimensions of the screen need to be adjusted
        int labelWidth = 120;
        int labelHeight = 25;

        //sets label location variables to be adjusted if changes need to be made later
        int labelTitleXPosition = 30;
        int labelTitleYPosition = 25;

        int labelXPosition = 30;
        int labelYPosition = 75;

        int labelRecyclersListXPosition = 30;
        int labelRecyclersListYPosition = 310;

        //Chooses font, colour, size of letters and label background
        Font labelTitleFont = new Font("Arial", Font.BOLD, 25);
        Color labelTitleColor = new Color(0, 0,255);

        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColorBackground = new Color(43, 101, 236);
        Color labelColorForeground = new Color(255,255,255);
        //Font labelFindBusnName = new Font("Arial", Font.PLAIN, 12);

        //The title screen label
        lblRecyclersTitle = new Label("Local Recycler Contacts");
        //Sets colour of the label's font
        lblRecyclersTitle.setForeground(labelTitleColor);
        //Sets font type and font size of label
        lblRecyclersTitle.setFont(labelTitleFont);
        //Adds label to frame
        add(lblRecyclersTitle);
        //Sets the location of the label
        myLabelLayout.putConstraint(SpringLayout.WEST, lblRecyclersTitle, labelTitleXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblRecyclersTitle, labelTitleYPosition, SpringLayout.NORTH, this);

        //Activates new label
        lblBusName = new Label("Business Name: ");
        //Sets background colour of label
        lblBusName.setBackground(labelColorBackground);
        lblBusName.setForeground(labelColorForeground);
        lblBusName.setFont(labelFont);
        //sets size of label to make all labels aligned
        lblBusName.setPreferredSize(new Dimension(labelWidth, labelHeight));
        add(lblBusName);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblBusName, labelXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblBusName, labelYPosition, SpringLayout.NORTH, this);

        lblAddress = new Label("Address: ");
        lblAddress.setBackground(labelColorBackground);
        lblAddress.setForeground(labelColorForeground);
        lblAddress.setFont(labelFont);
        lblAddress.setPreferredSize(new Dimension(labelWidth, labelHeight));
        add(lblAddress);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblAddress, labelXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblAddress, labelYPosition+35, SpringLayout.NORTH, this);

        lblPhone = new Label("Phone: ");
        lblPhone.setBackground(labelColorBackground);
        lblPhone.setForeground(labelColorForeground);
        lblPhone.setFont(labelFont);
        lblPhone.setPreferredSize(new Dimension(labelWidth, labelHeight));
        add(lblPhone);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblPhone, labelXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblPhone, labelYPosition+70, SpringLayout.NORTH, this);

        lblWebSite = new Label("Web Site: ");
        lblWebSite.setBackground(labelColorBackground);
        lblWebSite.setForeground(labelColorForeground);
        lblWebSite.setFont(labelFont);
        lblWebSite.setPreferredSize(new Dimension(labelWidth, labelHeight));
        add(lblWebSite);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblWebSite, labelXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblWebSite, labelYPosition+105, SpringLayout.NORTH, this);

        lblRecyclesType = new Label("Recycles: ");
        lblRecyclesType.setBackground(labelColorBackground);
        lblRecyclesType.setForeground(labelColorForeground);
        lblRecyclesType.setFont(labelFont);
        lblRecyclesType.setPreferredSize(new Dimension(labelWidth, labelHeight));
        add(lblRecyclesType);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblRecyclesType, labelXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblRecyclesType, labelYPosition+140, SpringLayout.NORTH, this);

        lblFind = new Label("Find: ");
        lblFind.setBackground(labelColorBackground);
        lblFind.setForeground(labelColorForeground);
        lblFind.setFont(labelFont);
        add(lblFind);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblFind, 480, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblFind, 45, SpringLayout.NORTH, this);

        lblRecyclersList = new Label("Recyclers List: ");
        lblRecyclersList.setBackground(labelColorBackground);
        lblRecyclersList.setForeground(labelColorForeground);
        lblRecyclersList.setFont(labelFont);
        lblRecyclersList.setPreferredSize(new Dimension(643, labelHeight));
        add(lblRecyclersList);
        myLabelLayout.putConstraint(SpringLayout.WEST, lblRecyclersList, labelRecyclersListXPosition, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, lblRecyclersList, labelRecyclersListYPosition, SpringLayout.NORTH, this);

    }

    //Locates the text fields for the screen
    public void LocateRecyclersTextFields(SpringLayout myTextLayout)
    {
        //Text size variables that can be changed if dimensions of the screen need to be adjusted
        int textWidth = 300;
        int textHeight = 25;

        //sets text location variables to be adjusted if changes need to be made later
        int textXPosition = 153;
        int textYPosition = 75;

        //Chooses font and font size for user entered data
        Font textFont = new Font("Arial", Font.PLAIN, 14);
        //Font textFindBusnName = new Font("Arial", Font.PLAIN, 12);


        //initialises text field
        txtBusnName = new TextField();
        //sets dimensions of text field
        txtBusnName.setPreferredSize(new Dimension(textWidth, textHeight));
        //chooses font and font size for entered information
        txtBusnName.setFont(textFont);
        //adds the text box to the frame
        add(txtBusnName);
        //locates text box onto frame
        myTextLayout.putConstraint(SpringLayout.WEST, txtBusnName, textXPosition, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtBusnName, textYPosition, SpringLayout.NORTH, this);

        txtAddress = new TextField();
        txtAddress.setPreferredSize(new Dimension(textWidth, textHeight));
        txtAddress.setFont(textFont);
        add(txtAddress);
        myTextLayout.putConstraint(SpringLayout.WEST, txtAddress, textXPosition, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtAddress, textYPosition+35, SpringLayout.NORTH, this);

        txtPhone = new TextField();
        txtPhone.setPreferredSize(new Dimension(textWidth, textHeight));
        txtPhone.setFont(textFont);
        add(txtPhone);
        myTextLayout.putConstraint(SpringLayout.WEST, txtPhone, textXPosition, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtPhone, textYPosition+70, SpringLayout.NORTH, this);

        txtWebSite = new TextField();
        txtWebSite.setPreferredSize(new Dimension(textWidth, textHeight));
        txtWebSite.setFont(textFont);
        add(txtWebSite);
        myTextLayout.putConstraint(SpringLayout.WEST, txtWebSite, textXPosition, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtWebSite, textYPosition+105, SpringLayout.NORTH, this);

        txtRecyclesType = new TextField();
        txtRecyclesType.setPreferredSize(new Dimension(textWidth, textHeight+25));
        txtRecyclesType.setFont(textFont);
        add(txtRecyclesType);
        myTextLayout.putConstraint(SpringLayout.WEST, txtRecyclesType, textXPosition, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtRecyclesType, textYPosition+140, SpringLayout.NORTH, this);

        txtFind = new TextField("by Busn Name");
        txtFind.setFont(textFont);
        add(txtFind);
        myTextLayout.putConstraint(SpringLayout.WEST, txtFind, 531, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtFind, 45, SpringLayout.NORTH, this);

        txtFilterBy = new TextField("Recycle Product", 12);
        txtFilterBy.setFont(textFont);
        txtFilterBy.setPreferredSize (new Dimension((textWidth), textHeight));
        add(txtFilterBy);
        myTextLayout.putConstraint(SpringLayout.WEST, txtFilterBy, 529, SpringLayout.WEST, this);
        myTextLayout.putConstraint(SpringLayout.NORTH, txtFilterBy, 280, SpringLayout.NORTH, this);
    }

    //Locates the buttons for the screen
    public void LocateRecyclersButtons(SpringLayout myButtonLayout)
    {
        //Button Dimension
        int buttonWidth = 194;
        int buttonHeight = 25;

        int buttonSmallWidth = 35;
        int buttonSmallHeight = 25;

        //Sets location of buttons
        int buttonFindXLocation = 480;
        int buttonFindYLocation = 70;

        int buttonExitXLocation = 480;
        int buttonExitYLocation = 240;

        int buttonColumnXLocation = 480;
        int buttonColumnYLocation = 110;

        int buttonRowXLocation = 30;
        int buttonRowYLocation = 280;

        int buttonSmallXLocation = 480;
        int buttonSmallYLocation = 200;

        //initialises button field
        btnFind = new Button("Find");
        //sets dimensions of button field
        btnFind.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        //Adds button to frame
        add(btnFind);
        //Locates button on screen
        myButtonLayout.putConstraint(SpringLayout.WEST, btnFind, buttonFindXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnFind, buttonFindYLocation, SpringLayout.NORTH, this);

        btnNew = new Button("New");
        btnNew.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        add(btnNew);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnNew, buttonColumnXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnNew, buttonColumnYLocation, SpringLayout.NORTH, this);

        btnSave = new Button("Save");
        btnSave.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        add(btnSave);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnSave, buttonColumnXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnSave, buttonColumnYLocation+27, SpringLayout.NORTH, this);

        btnDel = new Button("Delete");
        btnDel.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
        add(btnDel);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnDel, buttonColumnXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnDel, buttonColumnYLocation+54, SpringLayout.NORTH, this);

        btnFirst = new Button("|<");
        btnFirst.setPreferredSize(new Dimension(buttonSmallWidth,buttonSmallHeight));
        add(btnFirst);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnFirst, buttonSmallXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnFirst, buttonSmallYLocation, SpringLayout.NORTH, this);

        btnPrev = new Button("<");
        btnPrev.setPreferredSize(new Dimension(buttonSmallWidth,buttonSmallHeight));
        add(btnPrev);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnPrev, buttonSmallXLocation+52, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnPrev, buttonSmallYLocation, SpringLayout.NORTH, this);

        btnNext = new Button(">");
        btnNext.setPreferredSize(new Dimension(buttonSmallWidth,buttonSmallHeight));
        add(btnNext);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnNext, buttonSmallXLocation+104, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnNext, buttonSmallYLocation, SpringLayout.NORTH, this);

        btnLast = new Button(">|");
        btnLast.setPreferredSize(new Dimension(buttonSmallWidth,buttonSmallHeight));
        add(btnLast);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnLast, buttonSmallXLocation+156, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnLast, buttonSmallYLocation, SpringLayout.NORTH, this);

        btnExit = new Button("Exit");
        btnExit.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(btnExit);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnExit, buttonExitXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnExit, buttonExitYLocation, SpringLayout.NORTH, this);

        btnSortBusnName = new Button("Sort by Business Name");
        btnSortBusnName.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(btnSortBusnName);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnSortBusnName, buttonRowXLocation, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnSortBusnName, buttonRowYLocation, SpringLayout.NORTH, this);

        btnBinarySearchBusnName = new Button("Binary Search by Business Name");
        btnBinarySearchBusnName.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        add(btnBinarySearchBusnName);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnBinarySearchBusnName, buttonRowXLocation+200, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnBinarySearchBusnName, buttonRowYLocation, SpringLayout.NORTH, this);

        btnFilterBy = new Button("Filter By: ");
        btnFilterBy.setPreferredSize(new Dimension(buttonWidth-100, buttonHeight));
        add(btnFilterBy);
        myButtonLayout.putConstraint(SpringLayout.WEST, btnFilterBy, buttonRowXLocation+400, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, btnFilterBy, buttonRowYLocation, SpringLayout.NORTH, this);

    }

    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }

    public void windowIconified(WindowEvent we)
    {
    }

    public void windowOpened(WindowEvent we)
    {
    }

    public void windowClosed(WindowEvent we)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowActivated(WindowEvent we)
    {
    }

    public void windowDeactivated(WindowEvent we)
    {
    }
}
