package ultimate;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Panel_Class extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static double up;
	public static double lo;
	public static double cal0;
	public static double cal1;
	public static double lon=90;
	public static double lat = 23;
	public static int cal = 81;
	public int c=0, d, ca;
	public double gmt=0;
	public static final int WIDTH = 125; 
	public static final int HEIGHT = 125;
	public String[] country = {
			"Select Country",
			"Afganistan","Algeria","Antarctica","Argentina","Australia",
			"Bahrain","Bangladesh","Barbados","Belgium","Belarus","Bhutan","Brazil","Burma",
			"Canada","China","Colombia","Cyprus","Cameroon","Cambodia","Cayman Islands","Chad","Congo","Costa Rica",
			"Denmark","Dominican","Djibouti",
			"Egypt","Ethiopia","Ecuador","Eritrea","Estonia",
			"Fiji","France","Finland","French Polynesia",
			"Germany","Ghana","Greece","Greenland","Gabon","Gambia","Georgia","Guyana",
			"Haiti","Hong Kong"
	};
	private ImageIcon imageIcon = new ImageIcon("Icon/asman.jpg");//obj of imageicon background
	private Image image = imageIcon.getImage();//getting background image
	public Icon ic = new ImageIcon("Icon/makka.png");//obj of makka image
	//public Icon ex = new ImageIcon("Icon/exit.png");//obj of exit image

	
    
    JLabel east = new JLabel("East");
    JLabel west = new JLabel("West");
    JLabel south = new JLabel("South");
    JLabel north = new JLabel("North");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox combo = new JComboBox(country);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox<String> combo1 = new JComboBox();
    JLabel loca = new JLabel("SET  LOCATION");
    JLabel countri = new JLabel(ic); //add makka image
    JLabel citi = new JLabel("City");
    JLabel angl = new JLabel("Angle With Respect To North");
    static JLabel angle = new JLabel("AntiClockWise angle = 81 degree");
    public static JButton update = new JButton("UPDATE");
    public JButton exit = new JButton("Exit");
    JButton prayer = new JButton("Namaz Time");
 
    Panel_Class()
    {
    	add(prayer);
    	add(angle);
    	add(angl);
    	add(east);
    	add(west);
    	add(south);
    	add(north);
    	add(combo);
    	add(loca);
    	add(countri);
    	add(combo1);
    	add(update);
    	add(exit);
  	
    	
    	prayer.addActionListener(p);
    	update.setBounds(2, 2, 2, 2);
    	combo.setBorder(new TitledBorder(
    			new EtchedBorder(),
    			"COUNTRY"));
    	combo1.setBackground(Color.WHITE);
    	combo1.setBorder(new TitledBorder(
    			new EtchedBorder(),
		"CITY"));
    	combo1.addItem("Select  City");
    	countri.setBorder(new TitledBorder(
    			new EtchedBorder(),
		"COUNTRY PICTURE"));
    	
    	west.setForeground(Color.RED);
    	east.setForeground(Color.red);
    	south.setForeground(Color.red);
    	north.setForeground(Color.red);
    	west.setFont(new Font("Cambria",Font.BOLD,30));
		east.setFont(new Font("Cambria",Font.BOLD,30));
		south.setFont(new Font("Cambria",Font.BOLD,30));
		north.setFont(new Font("Cambria",Font.BOLD,30));
		loca.setFont(new Font("Serif",Font.BOLD + Font.ITALIC,35));
		loca.setForeground(Color.WHITE);
		countri.setFont(new Font("Arial",Font.ITALIC,20));
		angle.setFont(new Font("Arial",Font.PLAIN,25));
		angl.setFont(new Font("Arial",Font.ITALIC,30));
		citi.setFont(new Font("Calibri",Font.ITALIC,30));
		combo.setFont(new Font("Cambria",Font.PLAIN,20));
		combo1.setFont(new Font("Cambria",Font.PLAIN,20));
		combo1.setMaximumRowCount(6);
		combo.setMaximumRowCount(18);
		
	    class MenuItemListener_exit implements ActionListener
		{

			public void actionPerformed(final ActionEvent arg0) {
				// 
				System.exit(0);
			}
			
		}
		final ActionListener ex = new MenuItemListener_exit();
		exit.addActionListener(ex);
		exit.setEnabled(true);
		
		
		class MenuItemListener_update implements ActionListener
		{

			public void actionPerformed(final ActionEvent arg0) {
				// 
				calculation();
				angleupdate();
				repaint();
				
				
			}
			
		}
		final ActionListener upd = new MenuItemListener_update();
		update.addActionListener(upd);
		
   combo.addItemListener(new ItemListener() //////country select listener
		{
	    	 public void itemStateChanged(ItemEvent e )
	    	 {
	    		  combo1.removeAllItems();
	    		  combo1.addItem("Select  City");
	    	      get_city_in_combo1(combo.getSelectedIndex());
	    	      
	    	     }
	    }); 
   
    
    }
    
   
    class ppanel implements ActionListener         //salat time panel
	{

		public void actionPerformed(ActionEvent arg0) {
			
			JFrame pc = new JFrame("<< Salat Time >>");
			pc.setSize(700, 500);
			pc.setLocationRelativeTo(null);
			pc.setVisible(true);
			pc.setResizable(false);
			Panel_Class2 np = new Panel_Class2();
			pc.add(np);
		}
		
	}
    ActionListener p = new ppanel();
        public void get_city_in_combo1(int i) {
		// 
        	d=i;//saved country index
    	
		if(c==0)
		{
			select_city();c++;
			combo1.addItemListener(new ItemListener() 
			{
		    	 public void itemStateChanged(ItemEvent e )
		    	 {
		    		 set_lat_and_lon_overal(combo1.getSelectedIndex());
		    		 calculation();	
		    		
		    		 
		    	 }
			}
		);
			
	}		
		
   }	
	

	    public void select_city() {        ////  
	// 
	    	
    	
	    	if( d==1 )//Afghanistan
	    	{
	    		combo1.addItem("Ghazni");
				combo1.addItem("Herat");
				combo1.addItem("Kabol");
				combo1.addItem("Kandahar");
	    	}
	    	if( d==2 )//Algeria
	    	{
	    		combo1.addItem("Alger");
				combo1.addItem("Annaba");
				combo1.addItem("Batna");
				combo1.addItem("Jijel");
				combo1.addItem("Medea");
				combo1.addItem("Saida");
	    	}
	    	if( d==3 )//Antarctica
	    	{
	    		combo1.addItem("Casey");
				combo1.addItem("Dumount");
				combo1.addItem("Mawson");
				combo1.addItem("Palmer");
	    	}
	    	if( d==4 )//Argentina
	    	{
	    		combo1.addItem("Cordoba");
				combo1.addItem("La Plata");
				combo1.addItem("Mendoza");
				combo1.addItem("Tukuman");
	    	}
	    	if( d==5 )//Australia
	    	{
	    		combo1.addItem("Quenland");
				combo1.addItem("Victoria");
				combo1.addItem("Tasmania");
				combo1.addItem("Melbourne");
	    	}
	    	if( d==6 )//Bahrain
	    	{
	    		combo1.addItem("Bahrain");
				
	    	}
	    	if( d==7 )//BD
	    	{
	    		combo1.addItem("Barisal");
				combo1.addItem("Chittagong");
				combo1.addItem("Dhaka");
				combo1.addItem("Khulna");
				combo1.addItem("Rajshahi");
				combo1.addItem("Sylhet");
	    	}
	    	if(d==8)//Barbados
	    	{
	    		combo1.addItem("Bridgetown");
			
	    	}
	    	if( d==9 )//Belgium
	    	{
	    		combo1.addItem(" Brussels");
			
	    	}
	    	//paste below
	    	if( d==10 )//Belarus
	    	{
	    		combo1.addItem("Minsk");
	    	}
	    	if(d==11)
	    	{
	    		combo1.addItem("Thimphu");
	    	}
	    	if( d==12 )//Brazil
	    	{
	    		combo1.addItem("Brasilia");
	    	}
	    	if( d==13 )//Burma
	    	{
	    		combo1.addItem("Mandalay");
	    	}
	    	if( d== 14)//canada
	    	{
	    		combo1.addItem("Ottawa");
	    	}
	    	if( d==15 )//Chaina
	    	{
	    		combo1.addItem("Bortala");
	    	}
	    	if( d==16 )//Colombia
	    	{
	    		combo1.addItem("Bogota");
	    	}
	    	if( d==17 )//
	    	{
	    		combo1.addItem("Nicosia");
	    	}
	    
	    	
	    	if( d==18 )//cameroon
	    	{
	    		combo1.addItem("Yaounde");
	    	}
	    	if( d==19 )//
	    	{
	    		combo1.addItem("Batdam Bang");
	    	}
	    	if( d==20 )//
	    	{
	    		combo1.addItem("George town");
	    	}
	    	if( d== 21)//
	    	{
	    		combo1.addItem("Ndjamena");
	    	}
	    	if( d==22 )//
	    	{
	    		combo1.addItem("Brazzaville");
	    	}
	    	if( d==23 )//
	    	{
	    		combo1.addItem("San Jose");
	    	}
	    	if( d==24 )//
	    	{
	    		combo1.addItem("Copenhagen");
	    		
	    	}
	    	if( d==25 )//
	    	{
	    		combo1.addItem("Roseau");
	    	}
	    	if( d==26 )//
	    	{
	    		combo1.addItem("Djibouti");
	    	}
	    	if( d==27 )//
	    	{
	    		combo1.addItem("Cairo");
	    	}
	    	if( d==28 )//
	    	{
	    		combo1.addItem("Addis Ababa");
	    	}
	    	if( d== 29)//
	    	{
	    		combo1.addItem("Quito");
	    	}
	    	if( d==30 )//
	    	{
	    		combo1.addItem("Asmara");
	    	}
	    	if( d==31 )//
	    	{
	    		combo1.addItem("Tallinn");
	    	}
	    	if( d==32 )//
	    	{
	    		combo1.addItem("Suba");
	    	}
	    	if( d==33 )//
	    	{
	    		combo1.addItem("Paris");
	    	}
	    	if( d== 34)//
	    	{
	    		combo1.addItem("Helsinki");
	    	}
	    	if( d==35 )//
	    	{
	    		combo1.addItem("Papeete");
	    	}
	    	if( d==36 )//
	    	{
	    		combo1.addItem("Berlin");
	    	}
	    	if( d== 37)//
	    	{
	    		combo1.addItem("Accra");
	    	}
	    	if( d== 38)//
	    	{
	    		combo1.addItem("Athens");
	    	}
	    	if( d==39 )//
	    	{
	    		combo1.addItem("Nuuk");
	    	}
	    	if( d==40 )//
	    	{
	    		combo1.addItem("Librebille");
	    	}
	    	if( d== 41)//
	    	{
	    		combo1.addItem("Banjul");
	    	}
	    	if( d==42 )//
	    	{
	    		combo1.addItem("Tbilisi");
	    	}
	    	if( d==43 )//
	    	{
	    		combo1.addItem("Georgetown");
	    	}
	    	if( d==44 )//
	    	{
	    		combo1.addItem("Port Au Prince");
	    	}
	    	if( d==45 )//
	    	{
	    		combo1.addItem("Hong kong");
	    	}
	    	
	    		
				
	    	}
	
  
	    private void set_lat_and_lon_overal(int a) {    //// 
			// 
	    	//paste below
	    	if(d==45)
	    	{
	    		if( a==1 ){lat=22.24 ;lon=114.15 ;}
	    			
	    	}
	    	if(d==44)
	    	{
	    		if( a==1 ){lat=19.75 ;lon=-72.19 ;}
	    			
	    	}
	    	if(d==43)
	    	{
	    		if( a==1 ){lat=6.81 ;lon=-58.15 ;}
	    			
	    	}
	    	if(d==42)
	    	{
	    		if( a==1 ){lat=41.66 ;lon= 44.74;}
	    			
	    	}
	    	if(d==41)
	    	{
	    		if( a==1 ){lat=13.46 ;lon=-16.56 ;}
	    			
	    	}
	    	if(d==40)
	    	{
	    		if( a==1 ){lat=-1.67 ;lon=9.44 ;}
	    			
	    	}
	    	if(d==39)
	    	{
	    		if( a==1 ){lat=59.78 ;lon=-43.90 ;}
	    			
	    	}
	    	if(d==38)
	    	{
	    		if( a==1 ){lat=37.99 ;lon= 23.74;}
	    			
	    	}
	    	if(d==37)
	    	{
	    		if( a==1 ){lat=5.55 ;lon=-.207 ;}
	    			
	    	}
	    	if(d==36)
	    	{
	    		if( a==1 ){lat=51.72 ;lon=13 ;}
	    			
	    	}
	    	if(d==35)
	    	{
	    		if( a==1 ){lat=-17.52 ;lon=-149.55 ;}
	    			
	    	}
	    	if(d==34)
	    	{
	    		if( a==1 ){lat=60.26 ;lon=24.67 ;}
	    			
	    	}
	    	if(d==33)
	    	{
	    		if( a==1 ){lat=48.83 ;lon=2.28 ;}
	    			
	    	}
	    	if(d==32)
	    	{
	    		if( a==1 ){lat=-18.12 ;lon=178.42 ;}
	    			
	    	}
	    	if(d==31)
	    	{
	    		if( a==1 ){lat=59.445500 ;lon=24.739700 ;}
	    			
	    	}
	    	if(d==30)
	    	{
	    		if( a==1 ){lat=15.343000 ;lon=38.943000 ;}
	    			
	    	}
	    	if(d==29)
	    	{
	    		if( a==1 ){lat=-1.24 ;lon=-78.60;}
	    			
	    	}
	    	if(d==28)
	    	{
	    		if( a==1 ){lat=9.04 ;lon=38.70 ;}
	    			
	    	}
	    	
	    	if(d==27)
	    	{
	    		if( a==1 ){lat=30.99 ;lon=31.008 ;}
	    			
	    	}
	    	if(d==26)
	    	{
	    		if( a==1 ){lat=11.60 ;lon= 43.15;}
	    			
	    	}
	    	if(d==25)
	    	{
	    		if( a==1 ){lat=15.54 ;lon=-61.28 ;}
	    			
	    	}
	    	if(d==24)
	    	{
	    		if( a==1 ){lat=55.04 ;lon=9.44 ;}
	    			
	    	}
	    	if(d==23)
	    	{
	    		if( a==1 ){lat=9.87 ;lon= -83.90;}
	    			
	    	}
	    	if(d==22)
	    	{
	    		if( a==1 ){lat=-4.24 ;lon=15.26 ;}
	    			
	    	}
	    	if(d==21)
	    	{
	    		if( a==1 ){lat= 13.85;lon=20.85 ;}
	    			
	    	}
	    	if(d==20)
	    	{
	    		if( a==1 ){lat=19.31 ;lon= -81.37;}
	    			
	    	}	    	
	    	if(d==19)
	    	{
	    		if( a==1 ){lat=11 ;lon= 104;}
	    			
	    	}
	    	if( d== 18)//cameroon
	    	{
	    		if( a==1 ){lat =3 ;lon =11;}
			
	    	}
	    	
	    	if(d==17)
	    	{
	    		if( a==1 ){lat=35.13 ;lon=33.96 ;}
	    			
	    	}
	    	if(d==16)
	    	{
	    		if( a==1 ){lat=11.009 ;lon=-74.79 ;}
	    			
	    	}
	    	
	    	if(d==15)
	    	{
	    		if( a==1 ){lat=44.17 ;lon= 82.28;}
	    			
	    	}
	    	if(d==14){
	    		if( a==1 ){lat= 45.65;lon=-75.23655 ;}
	    			
	    	}
	    	if( d== 13)//
	    	{
	    		if( a==1 ){lon =98.6 ;lat =14.1 ;}
			
	    	}
	    	
	    	if( d== 12)//
	    	{
	    		if( a==1 ){lon =-42.47 ;lat =-3.43 ;}
			
	    	}
	    	if( d== 11)//
	    	{
	    		if( a==1 ){lon =89 ;lat =27 ;}
			
	    	}
	    	if( d== 10)//Belarus
	    	{
	    		if( a==1 ){lon =27 ;lat =53 ;}
			
	    	}
	    	
	    	if( d==9 )//Belgium
	    	{
	    		if( a==1 ){lon = 4;lat = 50;}
			
	    	}
	    	if(d==8)//Barbados
	    	{
	    		if( a==1 ){lon = -59;lat = 13;}
		
	    	}
	    	if( d==7 )//BD
	    	{
	    		if(a==1){lon = 90.3765;lat = 22.71;}
				if(a==2){lon = 91.8132;lat = 22.3735;}
				if(a==3){lon = 90.51;lat =24.01 ;}
				if(a==4){lon = 90.2274;lat = 22.594;}
				if(a==5){lon = 88.6114;lat = 24.378;}
				if(a==6){lon = 91.7782;lat = 24.9282;}
	    	}
	    	if( d==6 )//Bahrain
	    	{
	    		if(a==1){lon = 50;lat = 26;}
					
	    	}
	    	if( d==5 )//Australia
	    	{
	    		if(a==1){lon = 147.34;lat = -26.77;}
				if(a==2){lon = 145.05;lat = -37.8;}
				if(a==3){lon = 145.9;lat = -41.05;}
				if(a==4){lon = 144.9;lat = -37.8;}
	    	}
	    	if( d==4 )//Argentina
	    	{
	    		if(a==1){lon = -64.66;lat = -31.577;}
				if(a==2){lon = -65.9;lat = -32.022;}
				if(a==3){lon = -68.8;lat = -32.88;}
				if(a==4){lon = -65.2;lat = -26.8;}	
	    	}
	    	if( d==3 )//Antarctica
	    	{
	    		if(a==1){lon = 110.31;lat = -66.160;}
				if(a==2){lon = 140.11;lat = -66.4;}
				if(a==3){lon = 62.54;lat = -67.34;}
				if(a==4){lon = -64.588;lat = -64.46;}
	    	}
	    	if( d==2 )//Algeria
	    	{
	    		if(a==1){lon = 3.16;lat = 36.26;}
				if(a==2){lon = 6.1695;lat = 35.55 ;}
				if(a==3){lon = 7.444;lat = 36.47;}
				if(a==4){lon = 5.777;lat = 36.81;}
				if(a==5){lon = 2.76;lat = 36.274;}
				if(a==6){lon = -1.0718;lat = 35.44;}
	    	}
	    	if( d==1)//Afghanistan
	    	{
	    		if(a==1){lon = 68.4061;lat = 33.57;}
				if(a==2){lon = 62.2110;lat =34.3554 ;}
				if(a==3){lon = 69.194;lat = 34.5274;}
				if(a==4){lon = 65.716;lat = 31.6185;}
	    	}
	    	if(d!=0)
	    	{
		    	angleupdate();	   
	    	}
		}

		private void angleupdate() {


		    	if(cal>=0){
		    		   if(lat>30)
		  	    		 {
		  	    			 cal=cal+180;
		  	    		 }
		    		angle.setText("AntiClockWise angle = "+cal+" degree");
    		    //countri.setIcon(iccc);
    		   }
    		   if(cal<0){
    			   if(lat>30&&lon>0)
  	    		 {
  	    			 cal=cal-180;
  	    		 }
	    		 
	    		 angle.setText("Clockwise Angle = "+-cal+" degree"); 
    		   }
    		   
    		   
    		   
			
		}

		public void  calculation() {
			// 
			{
 				up = Math.sin(Math.PI/180*(lon-39.8230));
 				lo = Math.cos(Math.PI/180*lat)*Math.tan(Math.PI/180*21.42330)-Math.sin(Math.PI/180*lat)* Math.cos(Math.PI/180*(lon-39.8230));
 				cal0 = up/lo;
 				cal1=Math.atan(cal0);
 				cal1 = cal1*180/Math.PI;
 				cal = (int) cal1;
 				
 				angleupdate();
 				repaint();
	              c = 0;
 			  }
                          
		}
		public static void manual() {
			// 
			String la = JOptionPane.showInputDialog("Enter Latitude(-90 to +90)");
			String lo = JOptionPane.showInputDialog("Enter Longtitude(-180 to +180)");
			if(la!=null&&lo!=null){
			lat = Double.parseDouble(la);
			lon = Double.parseDouble(lo);
			
			
			}
			else
			{
				angle.setText("You Input Nothing");
			}
			
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image,0,0, getWidth(), getHeight(), this);//background image paint
			loca.setLocation(100, 15);                    //set location
			combo.setLocation(25, 75);          //country combo box
			combo1.setLocation(270,75);    //city combo box
			update.setLocation(25, 155);  //update button
			update.setSize(385, 35);
			angl.setLocation(25,200);        //angle with respect to north
			angl.setForeground(Color.white);
			angle.setLocation(25,250);
			angle.setForeground(Color.white);
			countri.setLocation(710,15);   //country wise picture
			countri.setSize(270, 200);
			exit.setLocation(890,610);  //exit button
			exit.setToolTipText("Get Aborted");
			exit.setSize(90, 40);
			//citi.setLocation(630, 45);
			//direction setup
			west.setLocation(460, 257);
			east.setLocation(460, 610);
			south.setLocation(260, 429);
			north.setLocation(665, 431);
			//direction line setup
			g.setColor(Color.MAGENTA);
			g.drawLine(500,283,500,630);
			g.setColor(Color.magenta);
			g.drawLine(333, 450, 670, 450);
			
			//navigator
			//g.setColor(Color.black);
			//g.fillOval(350, 300,320 , 320);
			g.setColor(Color.white);   //outer circle
			g.fillArc(350, 300,300 , 300, 0, 360);
			g.setColor(Color.LIGHT_GRAY);   //inner circle
			g.fillOval(360, 300+10,280 , 280);
			g.setColor(Color.blue);
			g.fillArc(350, 300,300 , 300, cal-1, 03);  //navigator
			//
			prayer.setLocation(710, 230);
			prayer.setSize(270, 40);
			
		}
		
	}