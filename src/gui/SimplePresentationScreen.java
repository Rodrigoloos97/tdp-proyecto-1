package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textLU;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textGit;
	private ImageIcon imgIcono,imgPerfil;
	private JLabel lblFecha;
	
	
	
	public SimplePresentationScreen(Student studentData) {
		setVisible(true);
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setVisible(true);
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		
		
		
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 201);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		
		//Get the screen size  
				Toolkit toolkit = Toolkit.getDefaultToolkit();  
				Dimension screenSize = toolkit.getScreenSize();
				//Calculate the frame location  
				int x = (screenSize.width - contentPane.getWidth()) / 2;  
				int y = (screenSize.height - contentPane.getHeight()) / 2;  
				  
				//Set the new frame location  
				contentPane.setLocation(x, y);  
		
		
		
		textLU = new JTextField();
		textLU.setEditable(false);
		textLU.setBounds(124, 11, 291, 20);
		tabInformation.add(textLU);
		textLU.setColumns(10);
		textLU.setText(""+ studentData.getId());
		
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(32, 14, 46, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(32, 39, 46, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 64, 46, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(32, 89, 46, 14);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setBounds(32, 114, 63, 14);
		tabInformation.add(lblGithubUrl);
		
		textApellido = new JTextField();
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setBounds(124, 36, 291, 20);
		tabInformation.add(textApellido);
		textApellido.setText(studentData.getLastName());
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(124, 61, 291, 20);
		tabInformation.add(textNombre);
		textNombre.setText(studentData.getFirstName());
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(124, 86, 291, 20);
		tabInformation.add(textEmail);
		textEmail.setText(studentData.getMail());
		
		textGit = new JTextField();
		textGit.setEditable(false);
		textGit.setColumns(10);
		textGit.setBounds(124, 111, 291, 20);
		tabInformation.add(textGit);
		textGit.setText(studentData.getGithubURL());
		
		
		imgIcono= new ImageIcon(".\\images\\tdp.png");
		imgPerfil= new ImageIcon(studentData.getPathPhoto());
		this.setIconImage(imgIcono.getImage());
		
		
		Calendar cal= new GregorianCalendar();
		int day, month, year, sec, min, hour;
		day=cal.get(Calendar.DAY_OF_MONTH);
		month=cal.get(Calendar.MONTH); //la variable month muestra los valores de los meses del 0 al 11
		year=cal.get(Calendar.YEAR);
		sec=cal.get(Calendar.SECOND);
		min=cal.get(Calendar.MINUTE);
		hour=cal.get(Calendar.HOUR_OF_DAY);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(32, 148, 383, 14);
		lblFecha.setText("Generado el: "+day+"/"+(month+1)+"/"+year+" a las: "+hour+":"+min+":"+sec );
		tabInformation.add(lblFecha);
		contentPane.add(tabbedPane);
		
		JLabel lblImagePerfil = new JLabel("");
		lblImagePerfil.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImagePerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagePerfil.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblImagePerfil.setSize(new Dimension(400, 400));
		lblImagePerfil.setBounds(445, 35, 144, 165);
		lblImagePerfil.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		//lblImagePerfil.setIcon(new ImageIcon(studentData.getPathPhoto()));
		//studentData.getPathPhoto()
		contentPane.add(lblImagePerfil);
	}
}