package ultimate;

import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class   Panel_Class2 extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GregorianCalendar cal = new GregorianCalendar();
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int month = cal.get(Calendar.MONTH)+1;
	int year = cal.get(Calendar.YEAR);
	int weekday = cal.get(Calendar.DAY_OF_WEEK);
	
	//prayer time dhaka
	int dfth,dath,djth,dmth,dith;
	int dftm,datm,djtm,dmtm,ditm;
	//prayer time khulna
		int kfth,kath,kjth,kmth,kith;
		int kftm,katm,kjtm,kmtm,kitm;
		//prayer time sylhet
		int sfth,sath,sjth,smth,sith;
		int sftm,satm,sjtm,smtm,sitm;
		//prayer time raj
		int rfth,rath,rjth,rmth,rith;
		int rftm,ratm,rjtm,rmtm,ritm;
		//prayer time chittagong
		int cfth,cath,cjth,cmth,cith;
		int cftm,catm,cjtm,cmtm,citm;
	
	int c,h,m;
	double in;
	
	JButton b = new JButton("ok");
	JLabel pray = new JLabel("Bangladesh Prayer Time");
	JLabel sdate = new JLabel("Date:"+day+"/"+month+"/"+year+"");
	
	JLabel dhaka = new JLabel("DHAKA");
	JLabel khulna = new JLabel("KHULNA");
	JLabel sylhet = new JLabel("SYLHET");
	JLabel raj = new JLabel("RAJSHAHI");
	JLabel chitta = new JLabel("CHITTA GONG");
	
	JLabel fajr = new JLabel("Fajr");
	JLabel dhuhr = new JLabel("Dhuhr");
	JLabel asr = new JLabel("Asr");
	JLabel maghrib = new JLabel("Maghrib");
	JLabel ishaa = new JLabel("Ishaa");
	
	JLabel d_ampm = new JLabel("am     "+"      pm     "+"     pm     "+"      pm     "+"     pm     ");
	JLabel k_ampm = new JLabel("am     "+"      pm     "+"     pm     "+"      pm     "+"     pm     ");
	JLabel s_ampm = new JLabel("am     "+"      pm     "+"     pm     "+"      pm     "+"     pm     ");
	JLabel r_ampm = new JLabel("am     "+"      pm     "+"     pm     "+"      pm     "+"     pm     ");
	JLabel c_ampm = new JLabel("am     "+"      pm     "+"     pm     "+"      pm     "+"     pm     ");
	
	Font pt = new Font("Algerian",Font.ITALIC,15);
	Font dis = new Font("Serif",Font.BOLD,20);
	Font tf = new Font("Serif",Font.BOLD,20);
	Font ampm = new Font("Algerian",Font.PLAIN,20);
	//dhaka prayer time
	JLabel dt = new JLabel();
	JLabel kt = new JLabel();
	JLabel st = new JLabel();
	JLabel rt = new JLabel();
	JLabel ct = new JLabel();
	
	
	
	private Scanner input;
	Panel_Class2()
	{
		add(d_ampm);
		add(k_ampm);
		add(s_ampm);
		add(r_ampm);
		add(c_ampm);
		
		add(dt);
		add(kt);
		add(st);
		add(rt);
		add(ct);
		add(sdate);
        add(pray);
        add(dhaka);
        add(khulna);
        add(sylhet);
        add(raj);
        add(chitta);
        
        add(fajr);
        add(dhuhr);
        add(asr);
        add(maghrib);
        add(ishaa);
        open_file();
        settimefajr();
        settimedhuhr();
        settimeasr();
        settimemaghrib();
        settimeishaa();
        setTime();
       // add(b);
        d_ampm.setFont(ampm);
       k_ampm.setFont(ampm);
        s_ampm.setFont(ampm);
        r_ampm.setFont(ampm);
        c_ampm.setFont(ampm);
        dt.setFont(tf);
        kt.setFont(tf);
        st.setFont(tf);
        rt.setFont(tf);
        ct.setFont(tf);
        pray.setFont(new Font("Cambria",Font.BOLD,20));
        sdate.setFont(new Font("Cambria",Font.BOLD,30));
        fajr.setFont(pt);
        dhuhr.setFont(pt);
        asr.setFont(pt);
        maghrib.setFont(pt);
        ishaa.setFont(pt);
        
        dhaka.setFont(dis);
        khulna.setFont(dis);
        sylhet.setFont(dis);
        raj.setFont(dis);
        chitta.setFont(new Font("Serif",Font.BOLD,18));
        
       
        
	}
	
	private void settimeishaa() {
		// 
		h = dith*60+ditm;    // setup fajr time
		m = h-1;
		kith = m/60;
		kitm = m%60;
		m = h-4;
		sith = m/60;
		sitm = m%60;
		m = h+8;
		rith = m/60;
		ritm = m%60;
		m = h-5;
		cith = m/60;
		citm = m%60;
		
	}

	private void settimemaghrib() {
		// 
		h = dmth*60+dmtm;    // setup fajr time
		m = h+0;
		kmth = m/60;
		kmtm = m%60;
		m = h-4;
		smth = m/60;
		smtm = m%60;
		m = h+8;
		rmth = m/60;
		rmtm = m%60;
		m = h-6;
		cmth = m/60;
		cmtm = m%60;
		
	}

	private void settimeasr() {
		// 
		h = dath*60+datm;    // setup fajr time
		m = h-2;
		kath = m/60;
		katm = m%60;
		m = h-4;
		sath = m/60;
		satm = m%60;
		m = h+8;
		rath = m/60;
		ratm = m%60;
		m = h-7;
		cath = m/60;
		catm = m%60;
		
	}

	private void settimedhuhr() {
		// 
		h = djth*60+djtm;    // setup fajr time
		m = h+1;
		kjth = m/60;
		kjtm = m%60;
		m = h-5;
		sjth = m/60;
		sjtm = m%60;
		m = h+8;
		rjth = m/60;
		rjtm = m%60;
		m = h-5;
		cjth = m/60;
		cjtm = m%60;
		
	}

	private void settimefajr() {
		// 
		h = dfth*60+dftm;    // setup fajr time
		m = h+3;
		kfth = m/60;
		kftm = m%60;
		m = h-7;
		sfth = m/60;
		sftm = m%60;
		m = h+7;
		rfth = m/60;
		rftm = m%60;
		m = h-3;
		cfth = m/60;
		cftm = m%60;
		
	}

	private void setTime() {
		// 
		dt.setText(""+dfth+":"+dftm+"       "+djth+":"+djtm+"       "+dath+":"+datm+"         "+dmth+":"+dmtm+"          "+dith+":"+ditm);
		kt.setText(""+kfth+":"+kftm+"       "+kjth+":"+kjtm+"       "+kath+":"+katm+"         "+kmth+":"+kmtm+"          "+kith+":"+kitm);
		st.setText(""+sfth+":"+sftm+"       "+sjth+":"+sjtm+"       "+sath+":"+satm+"           "+smth+":"+smtm+"          "+sith+":"+sitm);
		rt.setText(""+rfth+":"+rftm+"       "+rjth+":"+rjtm+"       "+rath+":"+ratm+"         "+rmth+":"+rmtm+"          "+rith+":"+ritm);
		ct.setText(""+cfth+":"+cftm+"       "+cjth+":"+cjtm+"       "+cath+":"+catm+"           "+cmth+":"+cmtm+"          "+cith+":"+citm);
		
	}

	public void  open_file(){
		try
	{
		input = new Scanner(new File("Prayer/"+day+"."+month+".txt" ));
		while(input.hasNextLine())
		{
			c++;
			if(c==6){break;}
			in = input.nextDouble();
			h = (int) in;
			in = in-h;
			in = in*100;
			m = (int) in;
			if(c==1){
				dfth = h;
				dftm = m;
			}
			if(c==2){
				djth = h;
				djtm = m;
				}
			if(c==3){
				dath = h;
				datm = m;
				}
			if(c==4){
				dmth = h;
				dmtm = m;
				}
			if(c==5){
				dith = h;
				ditm = m;
				}	
		}
		
	}
		catch ( FileNotFoundException fileNotFoundException )
		 {
		 System.err.println("Error opening file.");
		 //System.exit( 1);
		} 
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.setLocation(70, 130);
		
		pray.setLocation(230, 100);
		//make box
		g.drawLine(70, 130, 600, 130);
		g.drawLine(70, 150, 600, 150);
		g.drawLine(70, 175, 600, 175);
		
		g.drawLine(70, 430, 600, 430);
		
		g.drawLine(70, 130, 70, 430);
		g.drawLine(600, 130, 600, 430);
		//divide box colomn
		g.drawLine(520, 150, 520, 430);
		g.drawLine(440, 150, 440, 430);
		g.drawLine(360, 150, 360, 430);
		g.drawLine(280, 150, 280, 430);
		g.drawLine(200, 150, 200, 430);
		//devide box row
		g.drawLine(70, 226, 600, 226);
		g.drawLine(70, 277, 600, 277);
		g.drawLine(70, 328, 600, 328);
		g.drawLine(70, 379, 600, 379);
		//set prayer time location
		fajr.setLocation(213, 153);
		dhuhr.setLocation(293, 153);
		asr.setLocation(373, 153);
		maghrib.setLocation(451, 153);
		ishaa.setLocation(533, 153);
		//set district loc
		dhaka.setLocation(100, 185);
		khulna.setLocation(97, 237);
		sylhet.setLocation(98, 288);
		raj.setLocation(80, 339);
		chitta.setLocation(72, 390);
		//set time in the box
		dt.setLocation(225, 176);
		kt.setLocation(225, 227);
		st.setLocation(225, 277);
		rt.setLocation(225, 328);
		ct.setLocation(225, 379);
		//ampm setup
		d_ampm.setLocation(225, 200);
		k_ampm.setLocation(225, 251);
		s_ampm.setLocation(225, 302);
		r_ampm.setLocation(225, 353);
		c_ampm.setLocation(225, 404);
		
		sdate.setLocation(230, 65);
		
		
		
	}
}
