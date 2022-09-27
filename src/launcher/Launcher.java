package launcher;

import javax.swing.JFrame;

import entities.Student;
import gui.SimplePresentationScreen;


public class Launcher {

	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student alumno = new Student(117858, "Loos", "Rodrigo", "rodrigoloos@outlook.es", "https://github.com/Rodrigoloos97", "/images/yo-2.png");
            	JFrame gui= new SimplePresentationScreen(alumno);
            	
            	
            }
        });
    }
}