import java.awt.*;
import java.awt.event.*;

public class Rotations extends Frame implements ActionListener,MouseListener {

 // Initialize coordinates of the rectangle
 int[] x = {500,700,700,500};
 int[] y = {300,300,200,200};
 static final int windowWidth = 800;
 static final int windowHeight = 800;
 public static void main(String[] args) {
 // Set Frame s ize to 800x800
 // Set background color
 // Set visibility
	 Rotations f = new Rotations();
	 f.setTitle("Transformations");
	 f.setSize(windowWidth, windowHeight);        
	 f.setVisible(true);
	 

 }
 public Rotations() {
 // Set title
 // Create menu
 // Add WindowListener to exit the program when window is closed
 // Set layout
 // Add control panel
 // Add buttons
	 MenuBar menu_bar = new MenuBar();             // Creating Menu Bar
		Menu def = new Menu("File");
		def.add(new MenuItem("Set Default"));
		def.addActionListener(this);
		menu_bar.add(def);
		setMenuBar(menu_bar);
		
		
		 Panel panel=new Panel();  						// creating panel
	     panel.setBounds(0,40,windowWidth,40); 
	     
	     
	     	Button button_lbc = new Button();
			button_lbc.setLabel("Left Bottom - Clockwise");        // Set up Left Bottom - Clockwise button
			button_lbc.addActionListener(this);
			
			Button button_oc = new Button();
			button_oc.addActionListener(this);			// Set up Origin - Clockwise button
			button_oc.setLabel("Origin - Clockwise");
			
			
			Button button_occ = new Button();
			button_occ.addActionListener(this);			//  Set up Origin - C.Clockwise button
			button_occ.setLabel("Origin - C.Clockwise");
			
			
			panel.add(button_lbc);
			panel.add(button_oc);						//add the buttons to panel we create
			panel.add(button_occ);

			panel.setBackground(Color.black); 
			add(panel);
			setLayout(null);								// setting background colors
			addWindowListener(new MyFinishWindow());
			addMouseListener(this);
			setBackground(Color.getHSBColor(0.4f, 0.3f, 0.9f));
 }
 
 public class MyFinishWindow extends WindowAdapter
	{
		     public void windowClosing(WindowEvent e)
		     {
		       System.exit(0);
		     }
	}
 // Draw 2 lines and paint 1 filled rectangle
 public void paint(Graphics g) {
	 Graphics2D g2d = (Graphics2D) g;
	 
	 g2d.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight()); // Drawing Vertical line
	 g2d.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2); // Drawing Horizontal Line
	 g2d.fillPolygon(x,y,4);
	 


 }

 // Action listener
 public void actionPerformed(ActionEvent evt) {
	 
	 String str = evt.getActionCommand();
	 if(str.equals("Left Bottom - Clockwise")) {
		
		 x[0] = 500;
		 y[0] = 500;
		 
		 x[1] = 600;									// rotating values in only set default mode
		 y[1] = 500;
		 
		 x[2] = 600;
		 y[2] = 300;
		 
		 x[3] = 500;
		 y[3] = 300;
		 
		 
		 repaint();
	

						
	 }
	 
	 else if(str.equals("Origin - Clockwise")) {
		 int distance[] = new int[x.length];		
		 for(int i =0; i<x.length;i++) {
			 distance[i] = getHeight() - y[i];       // distance every y value according to height (800x800)
			
		 }
		 for(int i = 0;i<x.length;i++) {
			 y[i] = x[i];						// assign it to every distance y value to x 
			 x[i] = distance[i];
		 }
		
		 

			repaint();
	
	 } 
	 else if(str.equals("Origin - C.Clockwise")) {
		 int distance[] = new int[y.length];
		 for(int i =0; i<y.length;i++) {		// distance every x value according to height (800x800) 
			 distance[i] = getHeight() - x[i];
			
		 }
		 for(int i = 0;i<y.length;i++) {		// assign it to every distance x value to y 
			 x[i] = y[i];
			 y[i] = distance[i];
		 }
		 
		 
		 
		 repaint();
			
	
	 }
	 else if(str.equals("Set Default")) {
		 x[0] = 500;
		 x[1] = 700;		// x default values 
		 x[2] = 700;
		 x[3] =	500;
		 
		 y[0] = 300;
		 y[1] = 300;		// y default values
		 y[2] = 200;
		 y[3] = 200;
		
		 repaint();
	 }
	 

 }
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
	}
} 
