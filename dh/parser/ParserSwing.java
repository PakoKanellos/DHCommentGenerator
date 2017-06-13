package dh.parser;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

import dh.parser.commenti.CommentoMinimale;

public class ParserSwing {

	
private static void createAndShowGUI(){

    JFrame frame = new JFrame("DHParser 1.0");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setSize(800, 600);
    
    JPanel pannelloPrincipale;

    JTabbedPane tabbed;

    JPanel pannelloPrincipaleMassivo;
    JPanel pannelloPrincipaleSingolo;
    JPanel pannelloPrincipaleAbout;
    
    ButtonGroup btnGroup;
    btnGroup = new ButtonGroup();
    
    //PANNELLI      
    pannelloPrincipale = new JPanel();
    BorderLayout layoutPannello = new BorderLayout();
    pannelloPrincipale.setLayout( layoutPannello );
    
    pannelloPrincipaleMassivo = new JPanel();
    GridBagLayout layoutPannelloMassivo = new GridBagLayout();
    GridBagConstraints constraintPannelloMassivo = new GridBagConstraints();
    pannelloPrincipaleMassivo.setLayout( layoutPannelloMassivo );
    
    pannelloPrincipaleSingolo = new JPanel();
    GridBagLayout layoutPannelloSingolo = new GridBagLayout();
    GridBagConstraints constraintPannelloSingolo = new GridBagConstraints();
    pannelloPrincipaleSingolo.setLayout( layoutPannelloSingolo );
    
    pannelloPrincipaleAbout = new JPanel();
    GridBagLayout layoutPannelloAbout = new GridBagLayout();
    GridBagConstraints constraintPannelloAbout = new GridBagConstraints();
    pannelloPrincipaleAbout.setLayout( layoutPannelloAbout );
    
    //TAB
    tabbed = new JTabbedPane( );
    tabbed.addTab("Massive",pannelloPrincipaleMassivo);
    pannelloPrincipale.add( tabbed );
    
    tabbed.addTab("Single",pannelloPrincipaleSingolo);
    pannelloPrincipale.add( tabbed );
    
    tabbed.addTab("About",pannelloPrincipaleAbout);
    pannelloPrincipale.add( tabbed );

    getMassivo(pannelloPrincipaleMassivo, btnGroup, layoutPannelloMassivo,
			constraintPannelloMassivo);

    getSingolo(pannelloPrincipaleSingolo, btnGroup, layoutPannelloSingolo,
			constraintPannelloSingolo);
 
    

    
    
    
    
    
    
    
    
    
    
    
	//Display the window.
   frame.getContentPane().add(pannelloPrincipale);

     
    //Display the window.
    frame.pack();
   frame.setVisible(true);

}


private static void getMassivo(JPanel pannelloPrincipaleMassivo,
		ButtonGroup btnGroup, GridBagLayout layoutPannelloMassivo,
		GridBagConstraints constraintPannelloMassivo) {
	JLabel lbLabel34;
	final JTextField directory,modsDirectory;
	JLabel lbLabel17;
	final JTextArea taArea0;
	JRadioButton minimalBtn;
	JRadioButton mediumBtn;
	JRadioButton maximumBtn;
	JLabel livello;
    taArea0 = new JTextArea(50,100);
    
	//PANNELLO MASSIVO
    lbLabel34 = new JLabel( "Dir :"  );
    constraintPannelloMassivo.gridx = 0;
    constraintPannelloMassivo.gridy = 0;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloMassivo.insets = new Insets( 5,5,0,0 );
    layoutPannelloMassivo.setConstraints( lbLabel34, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( lbLabel34 );

    directory = new JTextField( );
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 0;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloMassivo.insets = new Insets( 5,0,0,5 );
    layoutPannelloMassivo.setConstraints( directory, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( directory );
    
    lbLabel34 = new JLabel( "Mods Dir :"  );
    constraintPannelloMassivo.gridx = 0;
    constraintPannelloMassivo.gridy = 5;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloMassivo.insets = new Insets( 5,5,0,0 );
    layoutPannelloMassivo.setConstraints( lbLabel34, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( lbLabel34 );
    
    modsDirectory = new JTextField( );
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 5;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloMassivo.insets = new Insets( 5,0,0,5 );
    layoutPannelloMassivo.setConstraints( modsDirectory, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( modsDirectory );

    livello = new JLabel( "Level of comments"  );
    constraintPannelloMassivo.gridx = 0;
    constraintPannelloMassivo.gridy = 7;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    layoutPannelloMassivo.setConstraints( livello, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( livello );
    
    minimalBtn = new JRadioButton( "Minimal"  );
    minimalBtn.setSelected( true );
    btnGroup.add( minimalBtn );
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 7;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    layoutPannelloMassivo.setConstraints( minimalBtn, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( minimalBtn );
    
    mediumBtn = new JRadioButton( "Medium"  );
    mediumBtn.setSelected( true );
    btnGroup.add( mediumBtn );
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 8;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    layoutPannelloMassivo.setConstraints( mediumBtn, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( mediumBtn );
    
    maximumBtn = new JRadioButton( "Maximum"  );
    maximumBtn.setSelected( true );
    btnGroup.add( maximumBtn );
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 9;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    layoutPannelloMassivo.setConstraints( maximumBtn, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( maximumBtn );
    
    JButton ok = new JButton();

    ok.setLabel("Generate");
    ok.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ae){
	    	Parser parser = new Parser();
	    	String commento = parser.massiveSwing(directory.getText(), modsDirectory.getText(), new CommentoMinimale());
        	taArea0.setEditable(false);
        	taArea0.setAutoscrolls(true);
        	taArea0.setSize(800, 10000);

	    	taArea0.append("**************************************** " + "\n");
	    	taArea0.append("Event comments generator " + "\n");
	    	taArea0.append("Made by Pako " + "\n");
	    	taArea0.append("Version 1.0 beta" + "\n");
	    	taArea0.append("**************************************** " + "\n");
	    	taArea0.append("");
	    	taArea0.append(commento);
	    	taArea0.append("\n");
	    	
        } 
     });
    constraintPannelloMassivo.gridx = 1;
    constraintPannelloMassivo.gridy = 11;
    constraintPannelloMassivo.gridwidth = 1;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    layoutPannelloMassivo.setConstraints( ok, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( ok );

    lbLabel17 = new JLabel( "Comments :"  );
    constraintPannelloMassivo.gridx = 0;
    constraintPannelloMassivo.gridy = 15;
    constraintPannelloMassivo.gridwidth = 2;
    constraintPannelloMassivo.gridheight = 1;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 0;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    constraintPannelloMassivo.insets = new Insets( 0,5,0,0 );
    layoutPannelloMassivo.setConstraints( lbLabel17, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( lbLabel17 );

    taArea0.setSize(1000, 1000);
    taArea0.setEditable(false);
    constraintPannelloMassivo.gridx = 0;
    constraintPannelloMassivo.gridy = 20;
    constraintPannelloMassivo.gridwidth = 2;
    constraintPannelloMassivo.gridheight = 100;
    constraintPannelloMassivo.fill = GridBagConstraints.BOTH;
    constraintPannelloMassivo.weightx = 1;
    constraintPannelloMassivo.weighty = 1;
    constraintPannelloMassivo.anchor = GridBagConstraints.NORTH;
    constraintPannelloMassivo.insets = new Insets( 0,5,5,5 );
    layoutPannelloMassivo.setConstraints( taArea0, constraintPannelloMassivo );
    pannelloPrincipaleMassivo.add( taArea0 );
}

private static void getSingolo(JPanel pannelloPrincipaleSingolo,
		ButtonGroup btnGroup, GridBagLayout layoutPannelloSingolo,
		GridBagConstraints constraintPannelloSingolo) {
	JLabel lbLabel34;
	JTextField tfText9;
	JLabel lbLabel17;
	JTextArea taArea0;
	JRadioButton minimalBtn;
	JRadioButton mediumBtn;
	JRadioButton maximumBtn;
	JLabel livello;
	
	//PANNELLO MASSIVO
    lbLabel34 = new JLabel( "Dir :"  );
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 0;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,5,0,0 );
    layoutPannelloSingolo.setConstraints( lbLabel34, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( lbLabel34 );

    tfText9 = new JTextField( );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 0;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,0,0,5 );
    layoutPannelloSingolo.setConstraints( tfText9, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( tfText9 );
    
    lbLabel34 = new JLabel( "File name :"  );
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 1;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,5,0,0 );
    layoutPannelloSingolo.setConstraints( lbLabel34, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( lbLabel34 );

    tfText9 = new JTextField( );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 1;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,0,0,5 );
    layoutPannelloSingolo.setConstraints( tfText9, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( tfText9 );
    
    lbLabel34 = new JLabel( "Mods Dir :"  );
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 5;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,5,0,0 );
    layoutPannelloSingolo.setConstraints( lbLabel34, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( lbLabel34 );
    
    tfText9 = new JTextField( );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 5;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTHWEST;
    constraintPannelloSingolo.insets = new Insets( 5,0,0,5 );
    layoutPannelloSingolo.setConstraints( tfText9, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( tfText9 );

    livello = new JLabel( "Level of comments"  );
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 7;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    layoutPannelloSingolo.setConstraints( livello, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( livello );
    
    minimalBtn = new JRadioButton( "Minimal"  );
    minimalBtn.setSelected( true );
    btnGroup.add( minimalBtn );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 7;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    layoutPannelloSingolo.setConstraints( minimalBtn, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( minimalBtn );
    
    mediumBtn = new JRadioButton( "Medium"  );
    mediumBtn.setSelected( true );
    btnGroup.add( mediumBtn );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 8;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    layoutPannelloSingolo.setConstraints( mediumBtn, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( mediumBtn );
    
    maximumBtn = new JRadioButton( "Maximum"  );
    maximumBtn.setSelected( true );
    btnGroup.add( maximumBtn );
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 9;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    layoutPannelloSingolo.setConstraints( maximumBtn, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( maximumBtn );
    
    JButton ok = new JButton();
    ok.setLabel("Generate");
    constraintPannelloSingolo.gridx = 1;
    constraintPannelloSingolo.gridy = 11;
    constraintPannelloSingolo.gridwidth = 1;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    layoutPannelloSingolo.setConstraints( ok, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( ok );

    lbLabel17 = new JLabel( "Comments :"  );
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 15;
    constraintPannelloSingolo.gridwidth = 2;
    constraintPannelloSingolo.gridheight = 1;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 0;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    constraintPannelloSingolo.insets = new Insets( 0,5,0,0 );
    layoutPannelloSingolo.setConstraints( lbLabel17, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( lbLabel17 );

    taArea0 = new JTextArea(50,100);
    taArea0.setSize(1000, 1000);
    constraintPannelloSingolo.gridx = 0;
    constraintPannelloSingolo.gridy = 20;
    constraintPannelloSingolo.gridwidth = 2;
    constraintPannelloSingolo.gridheight = 100;
    constraintPannelloSingolo.fill = GridBagConstraints.BOTH;
    constraintPannelloSingolo.weightx = 1;
    constraintPannelloSingolo.weighty = 1;
    constraintPannelloSingolo.anchor = GridBagConstraints.NORTH;
    constraintPannelloSingolo.insets = new Insets( 0,5,5,5 );
    layoutPannelloSingolo.setConstraints( taArea0, constraintPannelloSingolo );
    pannelloPrincipaleSingolo.add( taArea0 );
}
public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });


}
}
