package firstproj;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

  public static void main(String[] args) {
    new Fenetre();
  }

  private Panneau pan = new Panneau();
  private JButton bouton1 = new JButton("On");
  private JButton bouton2 = new JButton("Off");
  private SndMQTTcmd raspfja1 = new SndMQTTcmd();



  public Fenetre() {
    this.setTitle("Commande lumières");
    this.setSize(300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(pan);
    this.setVisible(true);
  //Ajout du bouton à notre content pane
    pan.add(bouton1);
    
    //Définition de l'action du bouton
    bouton1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
    	  System.out.println("tu as tapé sur On") ;
    	  raspfja1.go("R1ON");
    	  pan.setBackground(Color.green);
    	  pan.repaint();
      }
    });
    pan.add(bouton2);
    bouton2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
      	  System.out.println("tu as tapé sur Off") ;
      	raspfja1.go("R1OFF");
  	  pan.setBackground(Color.red);
  	  pan.repaint();
        }
      });
    this.setContentPane(pan);
    this.setVisible(true);

  }
}
  