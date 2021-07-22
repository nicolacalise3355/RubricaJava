package it.rubrica.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.rubrica.java.business.RubricaBusiness;
import it.rubrica.java.model.Contatti;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Rubrica {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtTelefono;
	private JButton btnAnnulla;
	
	RubricaBusiness rb = new RubricaBusiness();
	private JTable tabellaResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rubrica window = new Rubrica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rubrica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 778, 478);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Inserisci Contatto", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(38, 44, 41, 20);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(113, 44, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(38, 78, 46, 14);
		panel.add(lblCognome);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(113, 75, 86, 20);
		panel.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(33, 114, 46, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(113, 111, 86, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = rb.insertContact(txtNome.getText(), txtCognome.getText(), txtTelefono.getText());
					System.out.println(res);
					//eventualmente lanciare un log in base al risultato
					if(true) {
						JOptionPane.showMessageDialog(null, "Richiesta ricevuta, result: " + res);
					}
					txtNome.setText("");
					txtCognome.setText("");
					txtTelefono.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAggiungi.setBounds(113, 168, 89, 23);
		panel.add(btnAggiungi);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(246, 168, 89, 23);
		panel.add(btnAnnulla);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ricerca Contatti", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 763, 439);
		panel_1.add(scrollPane);
		
		tabellaResult = new JTable();
		tabellaResult.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cognome", "Telefono"
			}
		));
		scrollPane.setViewportView(tabellaResult);
		
		DefaultTableModel dtm = (DefaultTableModel) tabellaResult.getModel(); 
		try {
			Contatti tmpContatti = rb.getContatti();
		    for(int i=0; i<tmpContatti.getContatti().size();i++) {
			    //System.out.print(tmpContatti.getContatti().get(i).getNome() + " - " + tmpContatti.getContatti().get(i).getCognome());
			    //System.out.printf("\n");
		    	Vector rowData = new Vector();
		    	rowData.add(tmpContatti.getContatti().get(i).getId());
		    	rowData.add(tmpContatti.getContatti().get(i).getNome());
		    	rowData.add(tmpContatti.getContatti().get(i).getCognome());
		    	rowData.add(tmpContatti.getContatti().get(i).getTelefono());
		    	dtm.addRow(rowData);
		    }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
