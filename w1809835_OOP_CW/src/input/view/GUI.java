package input.view;

import driver.Formula1Driver;
import input.GUIInputHandler;
import manager.ChampionshipManager;
import manager.Formula1ChampionshipManager;
import race.Race;
import input.InputHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GUI
{
    public String driverDt;
    public static final String[] columns = {"Driver name", "Team", "Points", "First ", "Seconds", "Thirds"};

    private GUIInputHandler guiInputHandler;
    private InputHandler inputHandler;

    //create java swing Buttons , frames , panels

    private JFrame frame;
    private JPanel actionPanel;
    private JPanel statPanel;
    private JPanel racePanel;
    private JPanel randRacePanel;
    private JPanel driverDetailsPanel;
    private JPanel raceNewPanel;
    private JTabbedPane tabbedPane;
    private JTable statTable;
    private JButton sortByPoints;
    private JButton sortByFirstPositions;
    private JButton refresh;
    private JButton addRandRace;
    private JTextField nameField;
    private JTextField teamField;
    private JTextField locationFiled;
    private JButton addPlayer;
    private JButton addRace;
    private JButton addDriverDetailsButton;
    private JTextField driverName;
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dateField;
    private JTextField firstPlaceField;
    private JTextField secondPlaceField;
    private JTextField thirdPlaceFiled;
    private JTextField driverDetailsField;
    private ImageIcon formulaImage;
    private JLabel displayField;
    private JLabel backgroundImage;
    private JTextArea randRaceArea;

    private Formula1ChampionshipManager manager;
    private ChampionshipManager championshipManage;
    //private Race Race;
    private List<Race> race = new ArrayList<>();

    public GUI( ChampionshipManager championshipManager )
    {
        this.guiInputHandler = new GUIInputHandler( this, championshipManager );
        this.championshipManage = championshipManager;
        this.initView();

    }
    public GUI (Formula1ChampionshipManager manager){
        this.manager=manager;
    }

    private void initView(){

        //Frame data

        this.frame = new JFrame();
        //frame.setBackground(new Color(0,0,0,0));
        this.frame.setTitle( ">>> Formula One Championship <<<" );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setSize( 500, 600 );
        this.frame.setLocationRelativeTo( null );
        this.frame.setResizable( true );
        formulaImage = new ImageIcon("Image.jpeg");
        displayField = new JLabel(formulaImage);
        this.frame.add(displayField);

        //Colors import
        Color color1 = new Color(255,0,0);
        Color color2 =new Color(211,100,40);
        Color color = new Color(0,153,153);
        Color color3 = new Color(0,153,76);
        Color color4 = new Color(0,0,0);

        //Tabbed scroll panel details

        this.tabbedPane = new JTabbedPane();
        this.tabbedPane.setBounds( 20, 20, 460, 360 );
        this.frame.add( tabbedPane );

        this.actionPanel = new JPanel();
        actionPanel.setLayout( new GridLayout(4, 2) );
        this.tabbedPane.add( "Action", actionPanel );
        this.tabbedPane.setForeground(color1);


        this.statPanel = new JPanel();
        this.tabbedPane.add( "Drivers", statPanel );

        this.driverDetailsPanel = new JPanel();
        this.driverDetailsPanel.setLayout(new GridLayout(5, 2));
        this.tabbedPane.add("Driver Details", driverDetailsPanel);

        this.randRacePanel = new JPanel();
        this.randRacePanel.setLayout(new GridLayout(2,1));
        this.tabbedPane.add("Random Race" ,randRacePanel);


        this.racePanel = new JPanel();
        racePanel.setLayout(new GridLayout(4,1));
        this.tabbedPane.add( "Races", racePanel );

        // arrange state table details

        DefaultTableModel tableModel = new DefaultTableModel(1, GUI.columns.length);
        tableModel.setColumnIdentifiers( GUI.columns );
        this.statTable = new JTable(tableModel);
        this.statTable.setBounds( 40, 40, 400, 100 );
        JScrollPane jScrollPane = new JScrollPane(statTable);
        jScrollPane.setBounds( 40, 40, 400, 100 );
        this.statPanel.add( jScrollPane );

        this.sortByPoints = new JButton("Sort by Points");
        this.sortByPoints.addActionListener( e -> this.refreshTable() );
        this.statPanel.add( sortByPoints );

        this.sortByFirstPositions = new JButton("Sort by First Position");
        this.sortByFirstPositions.addActionListener( e -> this.sortedPoints() );
        this.statPanel.add( sortByFirstPositions );

        this.refresh = new JButton("Refresh");
        this.refresh.addActionListener( e -> this.sortedPoints() );
        this.statPanel.add( refresh );
        this.statPanel.setBackground(color4);


        // arrange action tab details
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds( 60, 60, 100, 20 );
        this.actionPanel.add( nameLabel );
        this.actionPanel.setBackground(color);

        this.nameField = new JTextField();
        this.nameField.setBounds( 130, 60, 200, 30 );
        this.actionPanel.add( nameField );

        // arrange action tab
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds( 60, 60, 100, 20 );
        this.actionPanel.add( locationLabel );

        this.locationFiled = new JTextField();
        this.locationFiled.setBounds( 130, 60, 200, 30 );
        this.actionPanel.add( locationFiled );

        // arrange action tab
        JLabel teamLabel = new JLabel("Team");
        teamLabel.setBounds( 60, 60, 100, 20 );
        this.actionPanel.add( teamLabel );

        this.teamField = new JTextField();
        this.teamField.setBounds( 130, 60, 200, 30 );
        this.actionPanel.add( teamField );

        this.addPlayer = new JButton("Add Player");
        this.addPlayer.addActionListener( e -> addPlayerToSeason() );
        this.actionPanel.add( addPlayer );
        this.addPlayer.setForeground(color1);

        //random race tab

        JTextArea areaRace =new JTextArea();
        this.addRandRace = new JButton("Add Random Race");
        this.addRandRace.setBounds(100,95,35,30);
        this.randRacePanel.add(areaRace);
        areaRace.setText(this.guiInputHandler.getRandRace());
        areaRace.contains(60,60);
        areaRace.setEditable(false);

        this.addRandRace.addActionListener( e -> this.randomRace() );
        this.randRacePanel.add( addRandRace );
        this.randRacePanel.setBackground(color1);
        areaRace.setBackground(color);

        //driver details tab

        JLabel driverDetailsName = new JLabel("Driver Name");
        driverDetailsName.setBounds( 60, 60, 100, 20 );
        this.driverDetailsPanel.add( driverDetailsName );
        this.driverDetailsPanel.setBackground(color);

        this.driverDetailsField = new JTextField();
        this.driverDetailsField.setBounds( 130, 60, 200, 30 );
        this.driverDetailsPanel.add( driverDetailsField );

        this.addDriverDetailsButton = new JButton("Add Driver");
        this.addDriverDetailsButton.setBounds(100,95,35,30);
        this.addDriverDetailsButton.addActionListener( e -> this.driverDetail());
        this.driverDetailsPanel.add( addDriverDetailsButton );

        JTextArea driverDetails =new JTextArea();
        this.driverDetailsPanel.add(driverDetails);
        driverDetails.setText(this.driverDetail());
        driverDetails.contains(60,60);
        driverDetails.setVisible(true);
        driverDetails.setEditable(false);

        this.driverDetailsPanel.setBackground(color);
        driverDetails.setBackground(color);

        this.frame.setVisible( true );//frame visibility

        //Race tab

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds( 60, 60, 200, 50 );
        this.racePanel.add( yearLabel );

        this.yearField = new JTextField();
        this.yearField.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( yearField );

        JLabel firstLabel = new JLabel("First place");
        firstLabel.setBounds( 60, 60, 200, 50 );
        this.racePanel.add( firstLabel );

        this.firstPlaceField = new JTextField();
        this.firstPlaceField.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( firstPlaceField );


        JLabel monthLabel = new JLabel("Month");
        monthLabel.setBounds( 60, 60, 100, 50 );
        this.racePanel.add( monthLabel );

        this.monthField = new JTextField();
        this.monthField.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( monthField );

        JLabel secondLabel = new JLabel("Second place");
        secondLabel.setBounds( 60, 60, 200, 50 );
        this.racePanel.add( secondLabel );

        this.secondPlaceField = new JTextField();
        this.secondPlaceField.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( secondPlaceField );

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds( 60, 60, 100, 50 );
        this.racePanel.add( dateLabel );

        this.dateField = new JTextField();
        this.dateField.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( dateField );


        JLabel thirdLabel = new JLabel("Third place");
        thirdLabel.setBounds( 60, 60, 200, 50 );
        this.racePanel.add( thirdLabel );


        this.thirdPlaceFiled = new JTextField();
        this.thirdPlaceFiled.setBounds( 130, 70, 100, 50 );
        this.racePanel.add( thirdPlaceFiled );


        this.addRace = new JButton("Add a new Race");
        this.addRace.setBounds(60,60,100,100);
        this.addRace.addActionListener( e -> addRace() );
        this.racePanel.add( addRace );
        this.addRace.setForeground(color2);
        this.yearField.setForeground(color2);
        this.monthField.setForeground(color2);
        this.dateField.setForeground(color2);

        JLabel driverNameLabel = new JLabel(" Enter Driver Name");
        driverNameLabel.setBounds( 60, 60, 100, 20 );
        this.racePanel.add( driverNameLabel );

        this.driverName = new JTextField();
        this.driverName.setBounds( 130, 60, 100, 30 );
        this.racePanel.add( driverName );
        this.racePanel.setBackground(color);

        this.frame.setVisible( true );//frame visibility

        ActHandle actHandle = new ActHandle();//handler object call
        addDriverDetailsButton.addActionListener(actHandle);
        addRandRace.addActionListener(actHandle);
    }

    private void initTable(){
        this.statTable = new JTable( this.guiInputHandler.getTableData(), GUI.columns);
    } //initiate table

    public void addPlayerToSeason(){ //add player
        String name = this.nameField.getText();
        String location = this.locationFiled.getText();
        String team = this.teamField.getText();

        this.championshipManage.createNewDriver( name, location, team );//add details into methods

        this.nameField.setText( "" );
        this.locationFiled.setText( "" );
        this.teamField.setText( "" );

    }
    public void addRace(){ // add new race

        String year = this.yearField.getText();
        String month = this.monthField.getText();
        String date = this.dateField.getText();

        try {
            String driverName = this.driverName.getText();
            this.championshipManage.displayDriverStatics(driverName);
            this.championshipManage.addRace((Race) race);
        }catch (ClassCastException e){
            System.out.println(" Race Adding Unsuccessful " + e);
        }

        this.yearField.setText( "     " );
        this.monthField.setText( "     " );
        this.dateField.setText( "     " );

        this.driverName.setText("");
    };

    public void refreshTable(){//refresh table
        DefaultTableModel dm = (DefaultTableModel) this.statTable.getModel();
        dm.getDataVector().removeAllElements();

        String[][] data =  this.guiInputHandler.getTableData();
        for(String[] d : data)
        {
            dm.addRow( d );
        }

        dm.fireTableDataChanged();
        System.out.println("Table refresh");
    }
    public void sortedPoints(){//table sort
        DefaultTableModel table = (DefaultTableModel) this.statTable.getModel();
        table.getDataVector().removeAllElements();
        String[][] sort =  this.guiInputHandler.getSortedTable();
        for(String[] point : sort)
        {
            table.addRow( point );
        }

        table.fireTableDataChanged();


    }

    public void randomRace(){
        this.guiInputHandler.getRandRace();
    }//random race method

    public String driverDetail (){ //Driver details method
        this.driverDt = this.driverDetailsField.getText();
        this.guiInputHandler.getDriverDetails(this.driverDt);

        return this.guiInputHandler.getDriverDetails(driverDt);
    }
    public void drivePrint(){
        this.driverDetail();
    }

    public class ActHandle implements ActionListener {//Button action
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addDriverDetailsButton) {
                try{
                    JOptionPane.showMessageDialog(null," Success ");
                }catch (NullPointerException ee){
                    JOptionPane.showMessageDialog(null,"Please Enter Name First");
                    System.out.println(ee +" NULL ");
                }

            }else if (e.getSource() == addRandRace){
                randomRace();
            }
        }
    }


}
