import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Horror implements ActionListener {
	JTextArea area;
	String year, m, loc, ch, ant, per, ev, weap, e, set;
	//adj[(int) (Math.random() * adj.length)]
	String[] adj = {" awful ", " ancient ", " terrific ", " old ", " abandoned ", " obscure ", " dark ", " gloomy ", " fearful ", " abandoned ", " evil ", " silent ", " mad ", " black ", 
	" filthy ", " rotten ", " shocking ", " dreadful "};
	
	String[] mood = {"bored", "happy", "curious", "upset", "excited"};
	String[] locations = {"medieval castle", "manor house", "forest", "graveyard", "abandoned hospital", "night school"};
	String[] characters = {"brother and sister", "group of teens", "YOU", "blind girl", "young painter"};
	String[] antags = {"psychic child", "mad scientist", "ghost", "evil twins", "reaper", "black market slaver"};
	String[] periods = {"when there's a new moon", "one year ago", "in a cold rainy afternoon", "in year ", "just before the millennium"};
	String[] events = {"attacked", "made some traps for the protagonist(s)", "used some unknown black magic (no one knows exactly) ", "used some sleeping gas against the protagonist(s)"};
	String[] weapons = {"knife", "extremely sharpened blade", "claw", "iron hook", "silver revolver", "acid", "medical kit", "chainsaw", "flamethrower"};
	String[] end = {"good", "bad", "not clear"};
	String[] setting = {"city", "town", "village"};
		
	Horror() {
		JFrame jfrm = new JFrame("Horror Story Generator (by Alex Rock-n-Roller)");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 600);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("Generate");
		btn.addActionListener(this);
		btn.setPreferredSize(new Dimension(120,50));
		area = new JTextArea("Press the button to generate a story.");
		area.setPreferredSize(new Dimension(600,500));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		jfrm.add(area);
		jfrm.add(btn);
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String beg = ""; 
		String middle = "";
		String ending = "";
		
		year = Integer.toString(((int) (Math.random() * 99)) + 1900);
		m = mood[(int) (Math.random() * mood.length)];
		loc = locations[(int) (Math.random() * locations.length)];
		ch = characters[(int) (Math.random() * characters.length)];
		ant = antags[(int) (Math.random() * antags.length)];
		per = periods[(int) (Math.random() * periods.length)];
		if (per.equals(periods[3])) per += year;
		ev = events[(int) (Math.random() * events.length)];
		weap = weapons[(int) (Math.random() * weapons.length)];
		e = end[(int) (Math.random() * end.length)];
		set = setting[(int) (Math.random() * setting.length)];
		
		beg = "     It happened " + per + ". The story took place when a/an " + ch + " was/were so " + m + ", that finally decided to take a look at a/an " + adj[(int) (Math.random() * adj.length)] + adj[(int) (Math.random() * adj.length)] + loc + " which was" +
		" located not far away from the " + adj[(int) (Math.random() * adj.length)] + set + ".\n";
		
		middle = "     The place was quiet and suspiciously silent. The " + ch + " 'd better known... The " + loc + " became a lair for a/an " + adj[(int) (Math.random() * adj.length)] + ant
		+ ", who punished and killed the victims with a/an " + weap + ". The " + ant + " " + ev + " all of a sudden. The " + ch + " had not so many chances left.\n";
		
		ending = "     The end of the story is still " + e + ". The " + adj[(int) (Math.random() * adj.length)] + ant;
		if (e == "bad") ending += " just slaughtered the " + ch + " and it's still unknown... How do you think, who am I, if I'm telling all these facts????";
		else if (e == "good") ending += " just did that in order to make the " + ch + " scared enough and tell this story to the locals. The " + ch + " , injured and frightened, left alive...";
		else ending += " is/are gone. But no one has seen the " + ch + " ever since. And the locals still tell the horrible things. The government doesn't believe... or doesn't want to believe.";
		
		area.setText(beg);
		area.setText(area.getText() + middle);
		area.setText(area.getText() + ending);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Horror();
			}
		});
	}
}