package day4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RandomNumber extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomNumber frame = new RandomNumber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RandomNumber() {
		setTitle("Random Number");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelButton = new JPanel();

		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TaskGenerate();
			}
		});

		btnMultithread = new JButton("Run Multithread");
		btnMultithread.setEnabled(false);
		btnMultithread.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TaskMultithread();
			}
		});

		btnOneThread = new JButton("Run One Thread");
		btnOneThread.setEnabled(false);
		btnOneThread.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TaskOneThread();
			}
		});

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GroupLayout gl_panelButton = new GroupLayout(panelButton);
		gl_panelButton.setHorizontalGroup(
				gl_panelButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton.createSequentialGroup()
						.addComponent(btnMultithread, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnGenerate, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
				.addGroup(gl_panelButton.createSequentialGroup()
						.addComponent(btnOneThread, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
				);
		gl_panelButton.setVerticalGroup(
				gl_panelButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton.createSequentialGroup()
						.addGroup(gl_panelButton.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMultithread, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnGenerate, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelButton.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOneThread, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
				);
		panelButton.setLayout(gl_panelButton);

		JPanel panel0 = new JPanel();
		panel0.setBorder(new TitledBorder(null, "Multithread", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel00 = new JPanel();

		JPanel panel000 = new JPanel();

		JLabel lblThread0 = new JLabel("Thread 1");

		JLabel lblThread1 = new JLabel("Thread 2");

		JLabel lblThread2 = new JLabel("Thread 3");

		JLabel lblThread3 = new JLabel("Thread 4");

		JLabel lblThread4 = new JLabel("Thread 5");
		GroupLayout gl_panel000 = new GroupLayout(panel000);
		gl_panel000.setHorizontalGroup(
			gl_panel000.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel000.createSequentialGroup()
					.addGroup(gl_panel000.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblThread0, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThread1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThread2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThread3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThread4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(0))
		);
		gl_panel000.setVerticalGroup(
			gl_panel000.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel000.createSequentialGroup()
					.addComponent(lblThread0, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThread1, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThread2, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThread3, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThread4, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addGap(0))
		);
		panel000.setLayout(gl_panel000);

		JPanel panel001 = new JPanel();

		progressBar0 = new JProgressBar();

		progressBar1 = new JProgressBar();

		progressBar2 = new JProgressBar();

		progressBar3 = new JProgressBar();

		progressBar4 = new JProgressBar();
		GroupLayout gl_panel001 = new GroupLayout(panel001);
		gl_panel001.setHorizontalGroup(
			gl_panel001.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar0, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addComponent(progressBar1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addComponent(progressBar2, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addComponent(progressBar3, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addComponent(progressBar4, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
		);
		gl_panel001.setVerticalGroup(
			gl_panel001.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel001.createSequentialGroup()
					.addComponent(progressBar0, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar1, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar2, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar3, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel001.setLayout(gl_panel001);
		GroupLayout gl_panel00 = new GroupLayout(panel00);
		gl_panel00.setHorizontalGroup(
			gl_panel00.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel00.createSequentialGroup().
					addContainerGap()
					.addComponent(panel000, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel001, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel00.setVerticalGroup(
			gl_panel00.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel00.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel00.createParallelGroup(Alignment.LEADING)
						.addComponent(panel000, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addComponent(panel001, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel00.setLayout(gl_panel00);

		JScrollPane scrollPane0 = new JScrollPane();

		multithreadResult = new JTextArea();
		multithreadResult.setWrapStyleWord(true);
		multithreadResult.setLineWrap(true);
		multithreadResult.setEditable(false);
		multithreadResult.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane0.setViewportView(multithreadResult);

		JLabel lblResult0 = new JLabel("Result");
		scrollPane0.setColumnHeaderView(lblResult0);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "One Thread", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel10 = new JPanel();

		JLabel lblProgress = new JLabel("Progress");

		progressBar = new JProgressBar();

		progressBar.setStringPainted(true);

		GroupLayout gl_panel10 = new GroupLayout(panel10);
		gl_panel10.setHorizontalGroup(
			gl_panel10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel10.createSequentialGroup().addContainerGap()
					.addComponent(lblProgress, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel10.setVerticalGroup(
			gl_panel10.createParallelGroup(Alignment.LEADING).
				addGroup(Alignment.TRAILING,gl_panel10.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel10.createParallelGroup(Alignment.TRAILING)
						.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(lblProgress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel10.setLayout(gl_panel10);

		JScrollPane scrollPane1 = new JScrollPane();

		oneThreadResult = new JTextArea();
		oneThreadResult.setWrapStyleWord(true);
		oneThreadResult.setLineWrap(true);
		oneThreadResult.setEditable(false);
		oneThreadResult.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane1.setViewportView(oneThreadResult);

		JLabel lblResult1 = new JLabel("Result");
		scrollPane1.setColumnHeaderView(lblResult1);

		status = new JLabel("Ready");
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel10, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addGap(4))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(panel10, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(4))
		);
		panel1.setLayout(gl_panel1);
		GroupLayout gl_panel0 = new GroupLayout(panel0);
		gl_panel0.setHorizontalGroup(
			gl_panel0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel0.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel0.createParallelGroup(Alignment.LEADING)
						.addComponent(panel00, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(scrollPane0, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addGap(4))
		);
		gl_panel0.setVerticalGroup(
			gl_panel0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel0.createSequentialGroup()
					.addComponent(panel00, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane0, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(4))
		);
		panel0.setLayout(gl_panel0);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel0, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
								.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(status, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel0, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(status, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public static final int SIZE = 10000000; // 10 million
	public static final String[] FILE_NAME = {
			"random-0.txt",
			"random-1.txt",
			"random-2.txt",
			"random-3.txt",
			"random-4.txt"
	};
	static boolean isJoined = false;
	
	static JButton btnGenerate;
	static JButton btnMultithread;
	static JButton btnOneThread;
	static JButton btnExit;

	static JProgressBar progressBar0;
	static JProgressBar progressBar1;
	static JProgressBar progressBar2;
	static JProgressBar progressBar3;
	static JProgressBar progressBar4;
	static JTextArea multithreadResult;

	static JProgressBar progressBar;
	static JTextArea oneThreadResult;

	static JLabel status;
}
