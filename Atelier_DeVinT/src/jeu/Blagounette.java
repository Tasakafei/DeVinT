package jeu;
import javax.swing.*;
import javax.swing.border.LineBorder;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Blagounette extends GestionSon implements ActionListener{
	private JButton blagounette;
	public Blagounette(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	@Override
	/*public  void changeColor() {
    	// on récupère les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
	}*/
	
	public void keyPressed(KeyEvent e) {
    	// appel à la méthode mère qui gère les évènements ESC, F1, F3, F4
    	super.keyPressed(e);
    	// cas particulier pour ce jeu : la touche F5
    	if (e.getKeyCode()==KeyEvent.VK_F5){
    	   	voix.playText("Vous venez d'appuyer sur EFFE 5");
    	   	
    	}
    	if (e.getKeyCode()==KeyEvent.VK_F4){
    		voix.playText("Vous venez d'appuyer sur EFFE 4");
    		changeSize();
    	}
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		voix.stop();
		Object source = ae.getSource();
		if (source.equals(blagounette)) {
    		String text = "Si la question est longue et que son contenu est variable";
    		text += "par exemple si on lit la question dans un fichier texte";
    		text += "il faut lire directement le texte avec playText";
    		// texte long, interruptible car un seul paramètre
    		voix.playWav("../ressources/sons/lala.wav");
    	}
		
	}

	@Override
	protected void init() {
		setLayout(new BorderLayout());
		Preferences pref = Preferences.getData();
		Color foregroundColor = pref.getCurrentForegroundColor();
		Color backgroundColor = pref.getCurrentBackgroundColor();
		// bouton pour poser une question
    	blagounette = new JButton();
    	blagounette.setText("Lancement de la blagounette");
    	// c'est l'objet Jeu lui-même qui réagit au clic souris
    	blagounette.addActionListener(this);
    	// on met le bouton à droite
     	this.add(blagounette,BorderLayout.CENTER);
     	
	}

	@Override
	protected String wavAide() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void changeSize() {
		Font f = Preferences.getData().getCurrentFont();
		lb1.setFont(f);	
	}*/

	@Override
	protected String wavAccueil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String wavRegleJeu() {
		// TODO Auto-generated method stub
		return null;
	}

}
