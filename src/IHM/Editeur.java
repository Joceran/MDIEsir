package IHM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Editeur extends JFrame implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private IHM ihm;
	private JTextArea tA;
	private JButton b_cut, b_copy, b_paste,b_undo, b_redo;//, b_enregistrer, b_stop, b_play;
	
	public Editeur(IHM ihm){
		super("Editeur");
		
		this.ihm = ihm;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tA = new JTextArea();
		
		tA.setTransferHandler(null);
		tA.setEditable(false);
		tA.getCaret().setVisible(true);
		tA.getCaret().setSelectionVisible(true);
		tA.setLineWrap(true);
	    tA.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Typed : "+e.getExtendedKeyCode());
				if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE){
					ihm.getDelete();
				}
				else if(isPrintable(e.getExtendedKeyCode())){
					ihm.setTexteAInserer(String.valueOf(e.getKeyChar()));
					ihm.getInserer();

				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
	    });
	    tA.addMouseListener(this);
		/*tA.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				System.out.println("Cursor Position (update) : "+tA.getSelectionStart());
				System.out.println("Dot : "+e.getDot());
				System.out.println("Mark :"+e.getMark());
				ihm.getDeplacerCurseur();
			}
		});*/
	    
		Container c = getContentPane();
		c.setLayout( new BorderLayout() );
		c.add(BorderLayout.CENTER, tA);

		Panel p_button = new Panel();
		p_button.setLayout(new GridLayout(1,5));
		b_cut = new JButton("Couper");
		b_cut.addActionListener(this);
		
		
		b_copy = new JButton("Copier");
		b_copy.addActionListener(this);
		
		b_paste = new JButton("Coller");
		b_paste.addActionListener(this);
		
		//Version 2
		b_undo = new JButton("Undo");
		b_undo.addActionListener(this);
		
		b_redo = new JButton("Redo");
		b_redo.addActionListener(this);
		
		p_button.add(b_cut);
		p_button.add(b_copy);
		p_button.add(b_paste);
		p_button.add(b_undo);
		p_button.add(b_redo);
		
		c.add(BorderLayout.NORTH,p_button);
		
		//Version 3
		/*Panel p_recorder = new Panel();
		p_recorder.setLayout(new GridLayout(1,3));
		b_enregistrer = new JButton("Enregistrer");
		b_enregistrer.addActionListener(this);
		
		
		b_stop = new JButton("Arrêter l'enregistrement");
		b_stop.addActionListener(this);
		
		b_play = new JButton("Jouer la macro");
		b_play.addActionListener(this);
		
		p_recorder.add(b_enregistrer);
		p_recorder.add(b_stop);
		p_recorder.add(b_play);
		
		c.add(BorderLayout.SOUTH,p_recorder);*/
		
		setSize(600, 500);
		setLocation(200, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if (source == tA) {
			
		}
		else if (source == b_cut){
			this.ihm.getCouper();
		} 
		else if (source == b_copy){
			this.ihm.getCopier();
		}
		else if (source == b_paste){
			this.ihm.getColler();
		}
		else if (source == b_undo){
			this.ihm.getUndo();
		}
		else if (source == b_redo){
			this.ihm.getRedo();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		/*if (source == tA) {
			this.ihm.setDebut(tA.getSelectionStart());
			this.ihm.setFin(tA.getSelectionEnd());
			this.ihm.getSelectionner();
		}*/
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	public JTextArea gettA() {
		return tA;
	}
	
	private boolean isPrintable(int key){
		return ((key > 40) && (key < 112)) || (key == 32);
	}
}
