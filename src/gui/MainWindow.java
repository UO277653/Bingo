package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import logic.CustomerRecord;
import logic.GameSession;
import logic.Prize;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel pnStart;
	private JLabel lblTitle;
	private JPanel centerPanel;
	private JLabel lblNorthSpace;
	private JPanel gridPanel;
	private JPanel panelCode;
	private JTextField txtCode;
	private JButton btnPlay;
	private JLabel lblInfoMessage;
	private JPanel informationPanel;
	private JPanel mainPanel;
	private JPanel northLimiter;
	private JLabel lblNorthLimiter;
	private JPanel southLimiter;
	private JLabel lblSouthLimiter;
	private JPanel westLimiter;
	private JLabel lblLimiter;
	private JPanel eastLimiter;
	private JLabel lblEastLimiter;
	
	private GameSession game;
	
	private JPanel pnGame;
	private JPanel northInformation;
	private JLabel lblInformation1;
	private JLabel lblInformation2;
	private JLabel lblInformation3;
	private JPanel centerPanelGame;
	private JPanel drumPanel;
	private JPanel buttonsPanel;
	private JLabel lblSeparator;
	private JButton btnRoll;
	private JButton btnLine;
	private JButton btnBingo;
	private JLabel lblSeparator2;
	private JButton btnFinish;
	private JPanel cardPanel;
	private JPanel drumImage;
	private JPanel southItems;
	private JLabel lblDrumSeparator;
	private JTextField txtNumberDrawn;
	private JPanel pnRemainingDrawns;
	private JLabel lblRemainingDrawns;
	private JTextField txtRemainingDrawns;
	private JLabel lblEII;
	private JPanel pnNumberOfPrizes;
	private JLabel lblNumberOfPrizes;
	private JTextField txtNumberOfPrizes;
	private JPanel pnCardNumbers;
	private JButton btnNumber1;
	private JButton btnNumber2;
	private JButton btnNumber3;
	private JButton btnNumber4;
	private JButton btnNumber5;
	private JButton btnNumber6;
	private JButton btnNumber7;
	private JButton btnNumber8;
	private JButton btnNumber9;
	private JPanel southPanelGame;
	private JPanel panel;
	private JLabel lblSeparator3;
	private JButton btnExit;
	private JPanel panelHelp;
	private JButton btnAccount;
	private JButton btnHelp;
	
	private List<JButton> numbers;
	private MarkAction mkAction = new MarkAction();
	
	private JPanel pnPrizes;
	private JPanel upperPanel;
	private JLabel lblPrizes1;
	private JLabel lblPrizes2;
	private JPanel westSepPrizes;
	private JLabel lblWestSeparator;
	private JPanel southSepPrizes;
	private JLabel lblSouthSeparator;
	private JPanel eastSepPrizes;
	private JLabel lblEast;
	private JPanel pnCenter;
	private JButton btnRedeemPrizes;
	private JPanel pnPrizesObjects;
	
	private SelectPrizeAction spa = new SelectPrizeAction();
	
	private JPanel pnReg;
	private JPanel pnTitleReg;
	private JLabel lblReg1;
	private JLabel lblReg2;
	private JLabel lblReg3;
	private JPanel westSepReg;
	private JLabel lblWestSeparatorReg;
	private JPanel southSepReg;
	private JLabel lblSouthSeparatorReg;
	private JPanel eastSepReg;
	private JLabel lblEastSeparatorReg;
	private JPanel pnData;
	private JPanel pnUpperSeparator;
	private JPanel pnID;
	private JPanel pnPassport;
	private JPanel pnName;
	private JPanel pnSurname;
	private JPanel pnLowerSeparator;
	private JPanel pnProceed;
	private JLabel lblID;
	private JTextField txtID;
	private JLabel lblPassport;
	private JTextField txtPassport;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblSep;
	private JButton btnProceed;
	private JButton btnProceedNoReg;
	
	private CustomerRecord cR = new CustomerRecord();
	private JPanel pnAcc;
	private JPanel westSepAcc;
	private JLabel lblWestSeparatorReg_1;
	private JPanel southSepAcc;
	private JLabel lblSouthSeparatorReg_1;
	private JPanel eastSepAcc;
	private JLabel lblEastSeparatorReg_1;
	private JPanel pnAccData;
	private JPanel northSepAcc;
	private JLabel lblNorthLimiter_1;
	private JLabel lblAccTitle;
	private JPanel pnIDAcc;
	private JLabel lblIDAcc;
	private JTextField txtIDAcc;
	private JPanel pnNameAcc;
	private JPanel pnSurnameAcc;
	private JPanel pnBalanceAcc;
	private JPanel pnButtonsAcc;
	private JLabel lblNameAcc;
	private JTextField txtNameAcc;
	private JLabel lblSurnameAcc;
	private JTextField txtSurnAcc;
	private JLabel lblBalanceAcc;
	private JTextField txtBalanceAcc;
	private JButton btnConfirm;
	private JLabel lblImage;
	
	private ResourceBundle texts;
	private JButton btnEnglishLanguage;
	private JPanel pnLanguages;
	private JButton btnSpanishLanguage;
	private JLabel lblRemainingPrizes;
	private JLabel lblNumberOfRemainingPrizes;
	private JPanel pnRemaining;
	
	private ValidateFieldsListener vfl= new ValidateFieldsListener();
	private JPanel pnWildCard;
	private JLabel lblWildCard;
	private JTextField txtWildCard;

	/**
	 * Create the frame.
	 */
	public MainWindow(GameSession gameSession) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/iconobingo.png")));
		setBackground(Color.WHITE);
		setTitle("Bingo!");
		this.game = gameSession;
		
		this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnStart(), "pnStart");
		contentPane.add(getPnGame(), "pnGame");
		contentPane.add(getPanel_1_2(), "pnPrizes");
		contentPane.add(getPanel_1_5(), "pnRegister");
		contentPane.add(getPanel_1_14(), "pnAcc");
		
		numbers = new ArrayList<JButton>();
		
		loadHelp();
		localize(Locale.getDefault(Locale.Category.FORMAT));
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				associateImagesToPrizes();
			}
		});
	}
	
	private void loadHelp(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Help.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Help not found!");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"intro", hs);
		   hb.enableHelp(pnStart, "initial", hs);
		   hb.enableHelp(pnGame, "game", hs);
		   hb.enableHelp(pnPrizes, "prizes", hs);
		   hb.enableHelp(pnReg, "registration", hs);
		   hb.enableHelp(pnAcc, "account", hs);
		   hb.enableHelpOnButton(btnHelp, "game", hs);
	}
	
	private void localize(Locale localization) {
		
		this.texts = ResourceBundle.getBundle("rcs/messages",localization);
		
		// Intro screen
		this.setTitle(texts.getString("title"));
		lblTitle.setText(texts.getString("introTitle"));
		btnPlay.setText(texts.getString("introPlayButton"));
		lblInfoMessage.setText(texts.getString("introScreenMessage"));
		
		// Game screen
		lblInformation1.setText(texts.getString("gameScreenInfo1"));
		lblInformation2.setText(texts.getString("gameScreenInfo2"));
		lblInformation3.setText(texts.getString("gameScreenInfo3"));
		
		btnRoll.setText(texts.getString("btnRoll"));
		btnLine.setText(texts.getString("btnLine"));
		btnBingo.setText(texts.getString("btnBingo"));
		btnFinish.setText(texts.getString("btnFinish"));
		btnExit.setText(texts.getString("btnExit"));
		btnAccount.setText(texts.getString("btnAccount"));
		btnHelp.setText(texts.getString("btnHelp"));
		
		lblRemainingDrawns.setText(texts.getString("lblRemainingDrawns"));
		lblNumberOfPrizes.setText(texts.getString("lblNumberOfPrizes"));
		lblWildCard.setText(texts.getString("lblWildCard"));
		
		// Prizes screen
		lblPrizes1.setText(texts.getString("lblPrizes1"));
		lblPrizes2.setText(texts.getString("lblPrizes2"));
		lblRemainingPrizes.setText(texts.getString("lblPrizes3"));
		btnRedeemPrizes.setText(texts.getString("btnRedeemPrizes"));
		
		// Registration screen
		lblReg1.setText(texts.getString("lblReg1"));
		lblReg2.setText(texts.getString("lblReg2"));
		lblReg3.setText(texts.getString("lblReg3"));
		
		lblID.setText(texts.getString("lblID"));
		lblPassport.setText(texts.getString("lblPassport"));
		lblName.setText(texts.getString("lblName"));
		lblSurname.setText(texts.getString("lblSurname"));
		btnProceed.setText(texts.getString("btnProceed"));
		btnProceedNoReg.setText(texts.getString("btnProceedNoReg"));
		
		// Account screen
		lblAccTitle.setText(texts.getString("lblAccTitle"));
		lblIDAcc.setText(texts.getString("lblIDAcc"));
		lblNameAcc.setText(texts.getString("lblNameAcc"));
		lblSurnameAcc.setText(texts.getString("lblSurnameAcc"));
		lblBalanceAcc.setText(texts.getString("lblBalanceAcc"));
		btnConfirm.setText(texts.getString("btnConfirm"));
		
		
	}
	
	private JPanel getPnStart() {
		if (pnStart == null) {
			pnStart = new JPanel();
			pnStart.setBackground(Color.WHITE);
			pnStart.setLayout(new BorderLayout(0, 0));
			pnStart.add(getPanel_1(), BorderLayout.CENTER);
			pnStart.add(getNorthLimiter(), BorderLayout.NORTH);
			pnStart.add(getSouthLimiter(), BorderLayout.SOUTH);
			pnStart.add(getWestLimiter(), BorderLayout.WEST);
			pnStart.add(getEastLimiter(), BorderLayout.EAST);
		}
		return pnStart;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("BINGO!");
			lblTitle.setBackground(Color.WHITE);
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Arial", Font.PLAIN, 50));
			lblTitle.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		}
		return lblTitle;
	}
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setBackground(Color.WHITE);
			centerPanel.setLayout(new BorderLayout(0, 0));
			centerPanel.add(getLblNorthSpace(), BorderLayout.NORTH);
			centerPanel.add(getInformationPanel(), BorderLayout.CENTER);
			centerPanel.add(getPanel_1_18(), BorderLayout.SOUTH);
		}
		return centerPanel;
	}
	private JLabel getLblNorthSpace() {
		if (lblNorthSpace == null) {
			lblNorthSpace = new JLabel("Limiter");
			lblNorthSpace.setForeground(Color.WHITE);
			lblNorthSpace.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblNorthSpace;
	}
	private JPanel getGridPanel() {
		if (gridPanel == null) {
			gridPanel = new JPanel();
			gridPanel.setBackground(Color.WHITE);
			gridPanel.setLayout(new GridLayout(0, 1, 0, 0));
			gridPanel.add(getPanelCode());
			gridPanel.add(getLblInfoMessage());
		}
		return gridPanel;
	}
	private JPanel getPanelCode() {
		if (panelCode == null) {
			panelCode = new JPanel();
			panelCode.setBackground(Color.WHITE);
			panelCode.setLayout(new BoxLayout(panelCode, BoxLayout.X_AXIS));
			panelCode.add(getTxtCode());
			panelCode.add(getBtnPlay());
		}
		return panelCode;
	}
	private JTextField getTxtCode() {
		if (txtCode == null) {
			txtCode = new JTextField();
			txtCode.setToolTipText("Introduce the code");
			txtCode.setHorizontalAlignment(SwingConstants.CENTER);
			txtCode.setColumns(10);
		}
		return txtCode;
	}
	/**
	 * Functionality of the play button
	 * @return
	 */
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("Play");
			btnPlay.setToolTipText("Play the game");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(game.isTicketValid(getTxtCode().getText())) {
						prepareGame();
						showGamePanel();
						if(game.isTicketWildCard()) {
							txtWildCard.setText(1 + "");
						}
					} else {
						String msg = texts.getString("introScreenAlert1");
						msg += texts.getString("introScreenAlert2");
						msg += texts.getString("introScreenAlert3");
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
			});
			btnPlay.setFont(new Font("Arial", Font.PLAIN, 20));
			btnPlay.setBackground(Color.CYAN);
			getRootPane().setDefaultButton(btnPlay);
		}
		return btnPlay;
	}
	
	/**
	 * Changes to the panel from which the game is played
	 */
	protected void showGamePanel() {
		getRootPane().setDefaultButton(btnFinish);
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnGame");
		
	}
	
	private JLabel getLblInfoMessage() {
		if (lblInfoMessage == null) {
			lblInfoMessage = new JLabel("Make a purchase of 30\u20AC or more and use the ticket to play one game of Bingo!");
			lblInfoMessage.setBackground(Color.WHITE);
		}
		return lblInfoMessage;
	}
	private JPanel getInformationPanel() {
		if (informationPanel == null) {
			informationPanel = new JPanel();
			informationPanel.setBackground(Color.WHITE);
			informationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			informationPanel.add(getGridPanel());
		}
		return informationPanel;
	}
	private JPanel getPanel_1() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setBackground(Color.WHITE);
			mainPanel.setLayout(new BorderLayout(0, 0));
			mainPanel.add(getLblTitle(), BorderLayout.NORTH);
			mainPanel.add(getCenterPanel());
		}
		return mainPanel;
	}
	private JPanel getNorthLimiter() {
		if (northLimiter == null) {
			northLimiter = new JPanel();
			northLimiter.setBackground(Color.WHITE);
			northLimiter.add(getLblNorthLimiter());
		}
		return northLimiter;
	}
	private JLabel getLblNorthLimiter() {
		if (lblNorthLimiter == null) {
			lblNorthLimiter = new JLabel("Limiter");
			lblNorthLimiter.setForeground(Color.WHITE);
			lblNorthLimiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNorthLimiter.setBackground(Color.WHITE);
		}
		return lblNorthLimiter;
	}
	private JPanel getSouthLimiter() {
		if (southLimiter == null) {
			southLimiter = new JPanel();
			southLimiter.setPreferredSize(new Dimension(15, 15));
			southLimiter.setBackground(Color.WHITE);
			southLimiter.add(getLblSouthLimiter());
		}
		return southLimiter;
	}
	private JLabel getLblSouthLimiter() {
		if (lblSouthLimiter == null) {
			lblSouthLimiter = new JLabel("Limiter");
			lblSouthLimiter.setForeground(Color.WHITE);
			lblSouthLimiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSouthLimiter.setBackground(Color.WHITE);
		}
		return lblSouthLimiter;
	}
	private JPanel getWestLimiter() {
		if (westLimiter == null) {
			westLimiter = new JPanel();
			westLimiter.setPreferredSize(new Dimension(30, 10));
			westLimiter.setBackground(Color.WHITE);
			westLimiter.add(getLblLimiter());
		}
		return westLimiter;
	}
	private JLabel getLblLimiter() {
		if (lblLimiter == null) {
			lblLimiter = new JLabel("Limiter");
			lblLimiter.setForeground(Color.WHITE);
			lblLimiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblLimiter;
	}
	private JPanel getEastLimiter() {
		if (eastLimiter == null) {
			eastLimiter = new JPanel();
			eastLimiter.setPreferredSize(new Dimension(30, 10));
			eastLimiter.setBackground(Color.WHITE);
			eastLimiter.add(getLblEastLimiter());
		}
		return eastLimiter;
	}
	private JLabel getLblEastLimiter() {
		if (lblEastLimiter == null) {
			lblEastLimiter = new JLabel("Limiter");
			lblEastLimiter.setForeground(Color.WHITE);
			lblEastLimiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblEastLimiter;
	}
	
	// PNGAME
	
	private JPanel getPnGame() {
		if (pnGame == null) {
			pnGame = new JPanel();
			pnGame.setLayout(new BorderLayout(0, 0));
			pnGame.add(getNorthInformation(), BorderLayout.NORTH);
			pnGame.add(getCenterPanelGame(), BorderLayout.CENTER);
			pnGame.add(getSouthPanelGame(), BorderLayout.SOUTH);
		}
		return pnGame;
	}
	private JPanel getNorthInformation() {
		if (northInformation == null) {
			northInformation = new JPanel();
			northInformation.setBackground(Color.WHITE);
			northInformation.setLayout(new GridLayout(0, 1, 0, 0));
			northInformation.add(getLblInformation1());
			northInformation.add(getLblInformation2());
			northInformation.add(getLblInformation3());
		}
		return northInformation;
	}
	private JLabel getLblInformation1() {
		if (lblInformation1 == null) {
			lblInformation1 = new JLabel("Start the game by tapping the \"Roll\" button");
			lblInformation1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblInformation1;
	}
	private JLabel getLblInformation2() {
		if (lblInformation2 == null) {
			lblInformation2 = new JLabel("In case you don't have time you can tap the \"Exit\" button before rolling the first ball");
			lblInformation2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblInformation2;
	}
	private JLabel getLblInformation3() {
		if (lblInformation3 == null) {
			lblInformation3 = new JLabel("Good luck!");
			lblInformation3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblInformation3;
	}
	private JPanel getCenterPanelGame() {
		if (centerPanelGame == null) {
			centerPanelGame = new JPanel();
			centerPanelGame.setBackground(Color.WHITE);
			centerPanelGame.setLayout(new GridLayout(1, 0, 0, 0));
			centerPanelGame.add(getDrumPanel());
			centerPanelGame.add(getButtonsPanel());
			centerPanelGame.add(getCardPanel());
		}
		return centerPanelGame;
	}
	private JPanel getDrumPanel() {
		if (drumPanel == null) {
			drumPanel = new JPanel();
			drumPanel.setPreferredSize(new Dimension(20, 10));
			drumPanel.setOpaque(false);
			drumPanel.setBackground(Color.WHITE);
			drumPanel.setLayout(new BorderLayout(0, 0));
			drumPanel.add(getDrumImage(), BorderLayout.CENTER);
			drumPanel.add(getSouthItems(), BorderLayout.SOUTH);
		}
		return drumPanel;
	}
	private JPanel getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new JPanel();
			buttonsPanel.setBackground(Color.WHITE);
			buttonsPanel.setLayout(new GridLayout(6, 0, 0, 0));
			buttonsPanel.add(getLblSeparator());
			buttonsPanel.add(getBtnRoll());
			buttonsPanel.add(getBtnLine());
			buttonsPanel.add(getBtnBingo());
			buttonsPanel.add(getLblSeparator2());
			buttonsPanel.add(getBtnFinish());
		}
		return buttonsPanel;
	}
	private JLabel getLblSeparator() {
		if (lblSeparator == null) {
			lblSeparator = new JLabel("");
		}
		return lblSeparator;
	}
	private JButton getBtnRoll() {
		if (btnRoll == null) {
			btnRoll = new JButton("Roll");
			btnRoll.setMnemonic('R');
			btnRoll.setToolTipText("Roll a number");
			btnRoll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Checking if the user has lost a line or a bingo
					game.checkLinesCompleted();
					game.checkBingo();
					
					game.useTicket();
					
					// Updating the number of remaining drawns and draw a new number
					if(Integer.valueOf(txtRemainingDrawns.getText()) > 0) {
						txtNumberDrawn.setText(game.generateNumber() + "");
						txtRemainingDrawns.setText(Integer.valueOf(txtRemainingDrawns.getText()) - 1 + "");
					}
					
					// When no more rolls are left, disable the buttons
					if(Integer.valueOf(txtRemainingDrawns.getText()) == 0) {
						btnRoll.setEnabled(false);
					}
				}
			});
			btnRoll.setBackground(Color.YELLOW);
		}
		return btnRoll;
	}
	private JButton getBtnLine() {
		if (btnLine == null) {
			btnLine = new JButton("Line");
			btnLine.setMnemonic('L');
			btnLine.setToolTipText("Claim a line");
			btnLine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Checks if lines are completed in this roll, if so it claims them
					game.claimLines();
					
					// Updates the number of prizes won
					txtNumberOfPrizes.setText(game.getNumberOfPrizes() + "");
					
					// If 2 lines are won it is disabled, as it is the maximum
					if(game.getNumberOfPrizes() == GameSession.MAX_NUMBER_OF_LINES) { // magic number // Two lines have been obtained, the maximum
						btnLine.setEnabled(false);
					}
				}
			});
			btnLine.setBackground(Color.ORANGE);
		}
		return btnLine;
	}
	private JButton getBtnBingo() {
		if (btnBingo == null) {
			btnBingo = new JButton("Bingo!");
			btnBingo.setToolTipText("Claim a bingo");
			btnBingo.setMnemonic('B');
			btnBingo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Checks if there is a bingo on the board and
					// if so it disables the roll button and updates
					// the number and type of prizes
					game.claimLines();
					
					if(game.isBingo()) {
						getBtnRoll().setEnabled(false);
						txtNumberOfPrizes.setText(3 + "");
						
					}
					
				}
			});
			btnBingo.setBackground(Color.GREEN);
		}
		return btnBingo;
	}
	private JLabel getLblSeparator2() {
		if (lblSeparator2 == null) {
			lblSeparator2 = new JLabel("");
		}
		return lblSeparator2;
	}
	
	/**
	 * 
	 * @return
	 */
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.setToolTipText("Finish the game");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Check if the user has won any prize
					// If so, it shows the prize panel and
					// loads the prizes depending on wether 
					// it is a bingo or not
					if(game.getNumberOfPrizes() > 0) {
						if(game.isBingo()) {
							showPrizePanel();
							loadBingoPrizes();
						} else {
							showPrizePanel();
							loadLinePrizes();
						}
					} else {
						showIntroPanel();
					}
				}
			});
			btnFinish.setBackground(Color.CYAN);
		}
		return btnFinish;
	}
	
	protected void loadBingoPrizes() {
		int pos = 1;
		
		List<Prize> prizes = game.getBingoPrizes();
		
		pnPrizesObjects.removeAll();
		
		for(Prize p: prizes) {
			pnPrizesObjects.add(createCell(p.getImagePath(), p, pos));
		}
	}
	
	protected void loadLinePrizes() {
		int pos = 1;
		
		List<Prize> prizes = game.getLinePrizes();
		
		pnPrizesObjects.removeAll();
		
		for(Prize p: prizes) {
			pnPrizesObjects.add(createCell(p.getImagePath(), p, pos));
			pos++;
		}
	}
	
	private Component createCell(String imagePath, Prize p, int pos) {
		JButton button = new JButton("");
		button.setBackground(Color.white);
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		button.setToolTipText(p.getName());
		
		char posChar =(pos + "").charAt(0);
		
		button.setMnemonic(posChar);
		
		pnPrizesObjects.add(button);
		
		Image imgOriginal = new ImageIcon(getClass().getResource(imagePath)).getImage();
		Image imgScaled = imgOriginal.getScaledInstance(160, 160, Image.SCALE_FAST);
		ImageIcon icon = new ImageIcon(imgScaled);
		button.setIcon(icon);
		
		button.addActionListener(spa);
		return button;
	}
	
	private void adaptImage(JButton button, String imagePath) {
		Image imgOriginal = new ImageIcon(getClass().getResource(imagePath)).getImage();
		Image imgScaled = imgOriginal.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_FAST);
		ImageIcon icon = new ImageIcon(imgScaled);
		button.setIcon(icon);
	}
	
	private void associateImagesToPrizes() {
		for (int i = 0; i < pnPrizesObjects.getComponents().length; i++) {
			JButton boton = (JButton) (pnPrizesObjects.getComponents()[i]);
			if(game.isBingo()) {
				adaptImage(boton, game.getBingoPrizes().get(i).getImagePath());
			} else {
				adaptImage(boton, game.getLinePrizes().get(i).getImagePath());
			}
		}
		
		adaptBingo();
		
	}
	
	private void adaptBingo() {
		Image imgOriginal = new ImageIcon(getClass().getResource("/img/maquinabingo.jpg")).getImage();
		Image imgScaled = imgOriginal.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_FAST);
		ImageIcon icon = new ImageIcon(imgScaled);
		lblImage.setIcon(icon);
	}
	
	protected void showPrizePanel() {
		associateImagesToPrizes();
		lblNumberOfRemainingPrizes.setText(game.getNumberOfPrizes() + "");
		getRootPane().setDefaultButton(btnRedeemPrizes);
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnPrizes");
		
	}
	
	private JPanel getCardPanel() {
		if (cardPanel == null) {
			cardPanel = new JPanel();
			cardPanel.setPreferredSize(new Dimension(20, 10));
			cardPanel.setBackground(Color.WHITE);
			cardPanel.setLayout(new BorderLayout(0, 0));
			cardPanel.add(getLblEII(), BorderLayout.NORTH);
			cardPanel.add(getPnNumberOfPrizes(), BorderLayout.SOUTH);
			cardPanel.add(getPnCardNumbers(), BorderLayout.CENTER);
		}
		return cardPanel;
	}
	private JPanel getDrumImage() {
		if (drumImage == null) {
			drumImage = new JPanel();
			drumImage.setBackground(Color.WHITE);
			drumImage.setLayout(new GridLayout(0, 1, 0, 0));
			drumImage.add(getLblImage());
		}
		return drumImage;
	}
	private JPanel getSouthItems() {
		if (southItems == null) {
			southItems = new JPanel();
			southItems.setLayout(new GridLayout(1, 0, 0, 0));
			southItems.add(getLblDrumSeparator());
			southItems.add(getTxtNumberDrawn());
			southItems.add(getPnRemainingDrawns());
		}
		return southItems;
	}
	private JLabel getLblDrumSeparator() {
		if (lblDrumSeparator == null) {
			lblDrumSeparator = new JLabel("");
			lblDrumSeparator.setForeground(Color.GRAY);
			lblDrumSeparator.setFont(new Font("Tahoma", Font.PLAIN, 10));
		}
		return lblDrumSeparator;
	}
	private JTextField getTxtNumberDrawn() {
		if (txtNumberDrawn == null) {
			txtNumberDrawn = new JTextField();
			txtNumberDrawn.setHorizontalAlignment(SwingConstants.CENTER);
			txtNumberDrawn.setForeground(Color.BLACK);
			txtNumberDrawn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtNumberDrawn.setEditable(false);
			txtNumberDrawn.setColumns(10);
		}
		return txtNumberDrawn;
	}
	private JPanel getPnRemainingDrawns() {
		if (pnRemainingDrawns == null) {
			pnRemainingDrawns = new JPanel();
			pnRemainingDrawns.setLayout(new GridLayout(0, 1, 0, 0));
			pnRemainingDrawns.add(getLblRemainingDrawns());
			pnRemainingDrawns.add(getTxtRemainingDrawns());
		}
		return pnRemainingDrawns;
	}
	private JLabel getLblRemainingDrawns() {
		if (lblRemainingDrawns == null) {
			lblRemainingDrawns = new JLabel("Remaining drawns:");
		}
		return lblRemainingDrawns;
	}
	private JTextField getTxtRemainingDrawns() {
		if (txtRemainingDrawns == null) {
			txtRemainingDrawns = new JTextField();
			txtRemainingDrawns.setHorizontalAlignment(SwingConstants.CENTER);
			txtRemainingDrawns.setEditable(false);
			txtRemainingDrawns.setColumns(10);
		}
		return txtRemainingDrawns;
	}
	private JLabel getLblEII() {
		if (lblEII == null) {
			lblEII = new JLabel("E I I");
			lblEII.setHorizontalAlignment(SwingConstants.CENTER);
			lblEII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblEII;
	}
	private JPanel getPnNumberOfPrizes() {
		if (pnNumberOfPrizes == null) {
			pnNumberOfPrizes = new JPanel();
			pnNumberOfPrizes.setBackground(Color.WHITE);
			pnNumberOfPrizes.setLayout(new BoxLayout(pnNumberOfPrizes, BoxLayout.X_AXIS));
			pnNumberOfPrizes.add(getLblNumberOfPrizes());
			pnNumberOfPrizes.add(getTxtNumberOfPrizes());
			pnNumberOfPrizes.add(getPanel_1_20());
		}
		return pnNumberOfPrizes;
	}
	private JLabel getLblNumberOfPrizes() {
		if (lblNumberOfPrizes == null) {
			lblNumberOfPrizes = new JLabel("Number of prizes accumulated:");
		}
		return lblNumberOfPrizes;
	}
	private JTextField getTxtNumberOfPrizes() {
		if (txtNumberOfPrizes == null) {
			txtNumberOfPrizes = new JTextField();
			txtNumberOfPrizes.setText("0");
			txtNumberOfPrizes.setHorizontalAlignment(SwingConstants.CENTER);
			txtNumberOfPrizes.setEditable(false);
			txtNumberOfPrizes.setColumns(10);
		}
		return txtNumberOfPrizes;
	}
	private JPanel getPnCardNumbers() {
		if (pnCardNumbers == null) {
			pnCardNumbers = new JPanel();
			pnCardNumbers.setBackground(Color.WHITE);
			pnCardNumbers.setLayout(new GridLayout(3, 2, 0, 0));
			pnCardNumbers.add(getBtnNumber1());
			pnCardNumbers.add(getBtnNumber2());
			pnCardNumbers.add(getBtnNumber3());
			pnCardNumbers.add(getBtnNumber4());
			pnCardNumbers.add(getBtnNumber5());
			pnCardNumbers.add(getBtnNumber6());
			pnCardNumbers.add(getBtnNumber7());
			pnCardNumbers.add(getBtnNumber8());
			pnCardNumbers.add(getBtnNumber9());
		}
		return pnCardNumbers;
	}
	private JButton getBtnNumber1() {
		if (btnNumber1 == null) {
			btnNumber1 = new JButton("0");
			btnNumber1.setMnemonic('1');
			btnNumber1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber1.setBackground(Color.WHITE);
			btnNumber1.addActionListener(mkAction);
		}
		return btnNumber1;
	}
	private JButton getBtnNumber2() {
		if (btnNumber2 == null) {
			btnNumber2 = new JButton("0");
			btnNumber2.setMnemonic('2');
			btnNumber2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber2.setBackground(Color.WHITE);
			btnNumber2.addActionListener(mkAction);
		}
		return btnNumber2;
	}
	private JButton getBtnNumber3() {
		if (btnNumber3 == null) {
			btnNumber3 = new JButton("0");
			btnNumber3.setMnemonic('3');
			btnNumber3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber3.setBackground(Color.WHITE);
			btnNumber3.addActionListener(mkAction);
		}
		return btnNumber3;
	}
	private JButton getBtnNumber4() {
		if (btnNumber4 == null) {
			btnNumber4 = new JButton("0");
			btnNumber4.setMnemonic('4');
			btnNumber4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber4.setBackground(Color.WHITE);
			btnNumber4.addActionListener(mkAction);
		}
		return btnNumber4;
	}
	private JButton getBtnNumber5() {
		if (btnNumber5 == null) {
			btnNumber5 = new JButton("0");
			btnNumber5.setMnemonic('5');
			btnNumber5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber5.setBackground(Color.WHITE);
			btnNumber5.addActionListener(mkAction);
		}
		return btnNumber5;
	}
	private JButton getBtnNumber6() {
		if (btnNumber6 == null) {
			btnNumber6 = new JButton("0");
			btnNumber6.setMnemonic('6');
			btnNumber6.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber6.setBackground(Color.WHITE);
			btnNumber6.addActionListener(mkAction);
		}
		return btnNumber6;
	}
	private JButton getBtnNumber7() {
		if (btnNumber7 == null) {
			btnNumber7 = new JButton("0");
			btnNumber7.setMnemonic('7');
			btnNumber7.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber7.setBackground(Color.WHITE);
			btnNumber7.addActionListener(mkAction);
		}
		return btnNumber7;
	}
	private JButton getBtnNumber8() {
		if (btnNumber8 == null) {
			btnNumber8 = new JButton("0");
			btnNumber8.setMnemonic('8');
			btnNumber8.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber8.setBackground(Color.WHITE);
			btnNumber8.addActionListener(mkAction);
		}
		return btnNumber8;
	}
	private JButton getBtnNumber9() {
		if (btnNumber9 == null) {
			btnNumber9 = new JButton("0");
			btnNumber9.setMnemonic('9');
			btnNumber9.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			btnNumber9.setBackground(Color.WHITE);
			btnNumber9.addActionListener(mkAction);
		}
		return btnNumber9;
	}
	private JPanel getSouthPanelGame() {
		if (southPanelGame == null) {
			southPanelGame = new JPanel();
			southPanelGame.setLayout(new BoxLayout(southPanelGame, BoxLayout.X_AXIS));
			southPanelGame.add(getPanel());
		}
		return southPanelGame;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new GridLayout(0, 3, 0, 0));
			panel.add(getLblSeparator3());
			panel.add(getBtnExit());
			panel.add(getPanel_1_1());
		}
		return panel;
	}
	private JLabel getLblSeparator3() {
		if (lblSeparator3 == null) {
			lblSeparator3 = new JLabel("");
		}
		return lblSeparator3;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setMnemonic('E');
			btnExit.setToolTipText("Exit the game");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showIntroPanel();
				}
			});
			btnExit.setBackground(Color.RED);
		}
		return btnExit;
	}
	private JPanel getPanel_1_1() {
		if (panelHelp == null) {
			panelHelp = new JPanel();
			panelHelp.setBackground(Color.WHITE);
			panelHelp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelHelp.add(getBtnAccount());
			panelHelp.add(getBtnHelp());
		}
		return panelHelp;
	}
	private JButton getBtnAccount() {
		if (btnAccount == null) {
			btnAccount = new JButton("Account");
			btnAccount.setToolTipText("Enter your account");
			btnAccount.setMnemonic('A');
			btnAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = JOptionPane.showInputDialog(null, texts.getString("gameScreenAccountText"), 
			                texts.getString("gameScreenAccountTitle"), JOptionPane.INFORMATION_MESSAGE);
					if(cR.isIDCorrect(ID)) {
						showAccountPanel(ID);
					}
				}
			});
		}
		return btnAccount;
	}
	

	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("Help");
			btnHelp.setMnemonic('H');
			btnHelp.setToolTipText("Access the help");
			btnHelp.setHorizontalTextPosition(SwingConstants.CENTER);
			btnHelp.setAlignmentX(0.5f);
		}
		return btnHelp;
	}
	
private void prepareGame() {
		
		// Prepare card
		int[] cardNumbers = game.generateNumbers();
		JButton specialNumber;
		
		btnNumber1.setText(cardNumbers[0] + "");
		btnNumber2.setText(cardNumbers[1] + "");
		btnNumber3.setText(cardNumbers[2] + "");
		btnNumber4.setText(cardNumbers[3] + "");
		btnNumber5.setText(cardNumbers[4] + "");
		btnNumber6.setText(cardNumbers[5] + "");
		btnNumber7.setText(cardNumbers[6] + "");
		btnNumber8.setText(cardNumbers[7] + "");
		btnNumber9.setText(cardNumbers[8] + "");
		
		numbers.add(btnNumber1);
		numbers.add(btnNumber2);
		numbers.add(btnNumber3);
		numbers.add(btnNumber4);
		numbers.add(btnNumber5);
		numbers.add(btnNumber6);
		numbers.add(btnNumber7);
		numbers.add(btnNumber8);
		numbers.add(btnNumber9);
		
		
		// Prepare special number
		specialNumber = numbers.get(game.getSpecialNumber());
		game.saveSpecialNumber(specialNumber.getText());
		specialNumber.setText("\u2605 " + specialNumber.getText() + " \u2605");
		
		// Number of drawns
		txtRemainingDrawns.setText(game.getNumberOfDrawns());
		txtWildCard.setText("0");
	}

	class MarkAction implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button.getText().equals(txtNumberDrawn.getText())) {
				game.setMarked(numbers.indexOf(button));
				button.setEnabled(false);
			}
			
			if(txtNumberDrawn.getText().equals(game.getMagicNumberValue())) {
				game.setMarked(game.getMagicNumber());
				numbers.get(game.getMagicNumber()).setEnabled(false);
				game.setMagicNumberMarked(true);
			}
			
			if(!button.getText().equals(txtNumberDrawn.getText()) && Integer.valueOf(txtWildCard.getText()) > 0) {
				if(numbers.indexOf(button) == game.getMagicNumber()) {
					game.setMarked(game.getMagicNumber());
					numbers.get(game.getMagicNumber()).setEnabled(false);
					game.setMagicNumberMarked(true);
					game.addNumber(Integer.valueOf(game.getMagicNumberValue()));
					txtWildCard.setText("0"); // Wild card consumed
					txtRemainingDrawns.setText(Integer.valueOf(txtRemainingDrawns.getText()) - 1 + "");
					return;
				}
				game.setMarked(numbers.indexOf(button));
				button.setEnabled(false);
				game.addNumber(Integer.valueOf(button.getText()));
				txtRemainingDrawns.setText(Integer.valueOf(txtRemainingDrawns.getText()) - 1 + "");
				txtWildCard.setText("0"); // Wild card consumed
			}
		}
		
	}
	
	class SelectPrizeAction implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button.getBackground() == Color.GRAY) {
				button.setBackground(Color.WHITE);
				button.setBorder(null);
				lblNumberOfRemainingPrizes.setText(Integer.valueOf(lblNumberOfRemainingPrizes.getText()) + 1 + "");
				btnRedeemPrizes.setEnabled(false);
			} else{
				if(!lblNumberOfRemainingPrizes.getText().equals("0")) {
					button.setBackground(Color.GRAY);
					button.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
					lblNumberOfRemainingPrizes.setText(Integer.valueOf(lblNumberOfRemainingPrizes.getText()) - 1 + "");
					if(Integer.valueOf(lblNumberOfRemainingPrizes.getText()) == 0) {
						btnRedeemPrizes.setEnabled(true);
					}
				}
			}
		}
		
	}
	
	private JPanel getPanel_1_2() {
		if (pnPrizes == null) {
			pnPrizes = new JPanel();
			pnPrizes.setBackground(Color.WHITE);
			pnPrizes.setLayout(new BorderLayout(0, 0));
			pnPrizes.add(getUpperPanel(), BorderLayout.NORTH);
			pnPrizes.add(getPanel_1_3(), BorderLayout.WEST);
			pnPrizes.add(getPanel_1_4(), BorderLayout.SOUTH);
			pnPrizes.add(getEastSepPrizes(), BorderLayout.EAST);
			pnPrizes.add(getPnCenter(), BorderLayout.CENTER);
		}
		return pnPrizes;
	}
	private JPanel getUpperPanel() {
		if (upperPanel == null) {
			upperPanel = new JPanel();
			upperPanel.setBackground(Color.WHITE);
			upperPanel.setLayout(new GridLayout(0, 1, 0, 0));
			upperPanel.add(getLblPrizes1());
			upperPanel.add(getLblPrizes2());
			upperPanel.add(getPanel_1_19());
		}
		return upperPanel;
	}
	private JLabel getLblPrizes1() {
		if (lblPrizes1 == null) {
			lblPrizes1 = new JLabel("Prizes!");
			lblPrizes1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrizes1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblPrizes1;
	}
	private JLabel getLblPrizes2() {
		if (lblPrizes2 == null) {
			lblPrizes2 = new JLabel("Tap on a prize in order to select it, then tap on \"Redeem\" to obtain it");
			lblPrizes2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrizes2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblPrizes2;
	}
	private JPanel getPanel_1_3() {
		if (westSepPrizes == null) {
			westSepPrizes = new JPanel();
			westSepPrizes.setForeground(Color.WHITE);
			westSepPrizes.setBackground(Color.WHITE);
			westSepPrizes.add(getLblWestSeparator());
		}
		return westSepPrizes;
	}
	private JLabel getLblWestSeparator() {
		if (lblWestSeparator == null) {
			lblWestSeparator = new JLabel("Separator");
			lblWestSeparator.setForeground(Color.WHITE);
		}
		return lblWestSeparator;
	}
	private JPanel getPanel_1_4() {
		if (southSepPrizes == null) {
			southSepPrizes = new JPanel();
			southSepPrizes.setBackground(Color.WHITE);
			southSepPrizes.setForeground(Color.WHITE);
			southSepPrizes.add(getLblSouthSeparator());
		}
		return southSepPrizes;
	}
	private JLabel getLblSouthSeparator() {
		if (lblSouthSeparator == null) {
			lblSouthSeparator = new JLabel("Separator");
			lblSouthSeparator.setBackground(Color.WHITE);
			lblSouthSeparator.setForeground(Color.WHITE);
		}
		return lblSouthSeparator;
	}
	private JPanel getEastSepPrizes() {
		if (eastSepPrizes == null) {
			eastSepPrizes = new JPanel();
			eastSepPrizes.setForeground(Color.WHITE);
			eastSepPrizes.setBackground(Color.WHITE);
			eastSepPrizes.add(getLblEast());
		}
		return eastSepPrizes;
	}
	private JLabel getLblEast() {
		if (lblEast == null) {
			lblEast = new JLabel("Separator");
			lblEast.setForeground(Color.WHITE);
			lblEast.setBackground(Color.WHITE);
		}
		return lblEast;
	}
	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getBtnRedeemPrizes(), BorderLayout.SOUTH);
			pnCenter.add(getPnPrizesObjects(), BorderLayout.CENTER);
		}
		return pnCenter;
	}
	
	/**
	 * 
	 * @return
	 */
	private JButton getBtnRedeemPrizes() {
		if (btnRedeemPrizes == null) {
			btnRedeemPrizes = new JButton("Redeem");
			btnRedeemPrizes.setMnemonic('R');
			btnRedeemPrizes.setToolTipText("Redeem the prize");
			btnRedeemPrizes.setEnabled(false);
			btnRedeemPrizes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(game.isVoucherWon()) {
						showRegistrationPanel();
					} else {
						showIntroPanel();
					}
				}
			});
			btnRedeemPrizes.setBackground(Color.GREEN);
		}
		return btnRedeemPrizes;
	}
	
	protected void showRegistrationPanel() {
		getRootPane().setDefaultButton(btnProceed);
		btnProceedNoReg.grabFocus();
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnRegister");
	}
	
	private JPanel getPnPrizesObjects() {
		if (pnPrizesObjects == null) {
			pnPrizesObjects = new JPanel();
			pnPrizesObjects.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnPrizesObjects.setBackground(new Color(153, 255, 51));
			pnPrizesObjects.setLayout(new GridLayout(3, 0, 1, 1));
		}
		return pnPrizesObjects;
	}
	private JPanel getPanel_1_5() {
		if (pnReg == null) {
			pnReg = new JPanel();
			pnReg.setLayout(new BorderLayout(0, 0));
			pnReg.add(getPnTitleReg(), BorderLayout.NORTH);
			pnReg.add(getWestSepReg(), BorderLayout.WEST);
			pnReg.add(getSouthSepReg(), BorderLayout.SOUTH);
			pnReg.add(getEastSepReg(), BorderLayout.EAST);
			pnReg.add(getPanel_1_7(), BorderLayout.CENTER);
		}
		return pnReg;
	}
	private JPanel getPnTitleReg() {
		if (pnTitleReg == null) {
			pnTitleReg = new JPanel();
			pnTitleReg.setBackground(Color.WHITE);
			pnTitleReg.setLayout(new GridLayout(0, 1, 0, 0));
			pnTitleReg.add(getLblReg1());
			pnTitleReg.add(getLblReg2());
			pnTitleReg.add(getLblReg3());
		}
		return pnTitleReg;
	}
	private JLabel getLblReg1() {
		if (lblReg1 == null) {
			lblReg1 = new JLabel("Register");
			lblReg1.setHorizontalAlignment(SwingConstants.CENTER);
			lblReg1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblReg1;
	}
	private JLabel getLblReg2() {
		if (lblReg2 == null) {
			lblReg2 = new JLabel("You have won a voucher! In order to receive it you need to register");
			lblReg2.setHorizontalAlignment(SwingConstants.CENTER);
			lblReg2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblReg2;
	}
	private JLabel getLblReg3() {
		if (lblReg3 == null) {
			lblReg3 = new JLabel("In case you have already registered it is enough with writing the ID");
			lblReg3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblReg3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblReg3;
	}
	private JPanel getWestSepReg() {
		if (westSepReg == null) {
			westSepReg = new JPanel();
			westSepReg.setForeground(Color.WHITE);
			westSepReg.setBackground(Color.WHITE);
			westSepReg.add(getLblWestSeparatorReg());
		}
		return westSepReg;
	}
	private JLabel getLblWestSeparatorReg() {
		if (lblWestSeparatorReg == null) {
			lblWestSeparatorReg = new JLabel("Separator");
			lblWestSeparatorReg.setForeground(Color.WHITE);
		}
		return lblWestSeparatorReg;
	}
	private JPanel getSouthSepReg() {
		if (southSepReg == null) {
			southSepReg = new JPanel();
			southSepReg.setForeground(Color.WHITE);
			southSepReg.setBackground(Color.WHITE);
			southSepReg.add(getLblSouthSeparatorReg());
		}
		return southSepReg;
	}
	private JLabel getLblSouthSeparatorReg() {
		if (lblSouthSeparatorReg == null) {
			lblSouthSeparatorReg = new JLabel("Separator");
			lblSouthSeparatorReg.setForeground(Color.WHITE);
			lblSouthSeparatorReg.setBackground(Color.WHITE);
		}
		return lblSouthSeparatorReg;
	}
	private JPanel getEastSepReg() {
		if (eastSepReg == null) {
			eastSepReg = new JPanel();
			eastSepReg.setForeground(Color.WHITE);
			eastSepReg.setBackground(Color.WHITE);
			eastSepReg.add(getLblEastSeparatorReg());
		}
		return eastSepReg;
	}
	private JLabel getLblEastSeparatorReg() {
		if (lblEastSeparatorReg == null) {
			lblEastSeparatorReg = new JLabel("Separator");
			lblEastSeparatorReg.setForeground(Color.WHITE);
			lblEastSeparatorReg.setBackground(Color.WHITE);
		}
		return lblEastSeparatorReg;
	}
	private JPanel getPanel_1_7() {
		if (pnData == null) {
			pnData = new JPanel();
			pnData.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnData.setBackground(Color.LIGHT_GRAY);
			pnData.setLayout(new GridLayout(7, 0, 0, 0));
			pnData.add(getPanel_1_6());
			pnData.add(getPanel_1_8());
			pnData.add(getPanel_1_9());
			pnData.add(getPanel_1_10());
			pnData.add(getPanel_1_11());
			pnData.add(getPanel_1_12());
			pnData.add(getPanel_1_13());
		}
		return pnData;
	}
	private JPanel getPanel_1_6() {
		if (pnUpperSeparator == null) {
			pnUpperSeparator = new JPanel();
			pnUpperSeparator.setBackground(Color.LIGHT_GRAY);
		}
		return pnUpperSeparator;
	}
	private JPanel getPanel_1_8() {
		if (pnID == null) {
			pnID = new JPanel();
			pnID.setBackground(Color.LIGHT_GRAY);
			pnID.setLayout(new BoxLayout(pnID, BoxLayout.X_AXIS));
			pnID.add(getLblID());
			pnID.add(getTxtID());
		}
		return pnID;
	}
	private JPanel getPanel_1_9() {
		if (pnPassport == null) {
			pnPassport = new JPanel();
			pnPassport.setBackground(Color.LIGHT_GRAY);
			pnPassport.setLayout(new BoxLayout(pnPassport, BoxLayout.X_AXIS));
			pnPassport.add(getLblPassport());
			pnPassport.add(getTxtPassport());
		}
		return pnPassport;
	}
	private JPanel getPanel_1_10() {
		if (pnName == null) {
			pnName = new JPanel();
			pnName.setBackground(Color.LIGHT_GRAY);
			pnName.setLayout(new BoxLayout(pnName, BoxLayout.X_AXIS));
			pnName.add(getLblName());
			pnName.add(getTxtName());
		}
		return pnName;
	}
	private JPanel getPanel_1_11() {
		if (pnSurname == null) {
			pnSurname = new JPanel();
			pnSurname.setBackground(Color.LIGHT_GRAY);
			pnSurname.setLayout(new BoxLayout(pnSurname, BoxLayout.X_AXIS));
			pnSurname.add(getLblSurname());
			pnSurname.add(getTxtSurname());
		}
		return pnSurname;
	}
	private JPanel getPanel_1_12() {
		if (pnLowerSeparator == null) {
			pnLowerSeparator = new JPanel();
			pnLowerSeparator.setForeground(Color.LIGHT_GRAY);
			pnLowerSeparator.setBackground(Color.LIGHT_GRAY);
		}
		return pnLowerSeparator;
	}
	private JPanel getPanel_1_13() {
		if (pnProceed == null) {
			pnProceed = new JPanel();
			pnProceed.setLayout(new GridLayout(1, 0, 0, 0));
			pnProceed.add(getLblSep());
			pnProceed.add(getBtnProceed());
			pnProceed.add(getBtnProceedNoReg());
		}
		return pnProceed;
	}
	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("ID");
			lblID.setToolTipText("ID");
			lblID.setHorizontalAlignment(SwingConstants.CENTER);
			lblID.setPreferredSize(new Dimension(150, 13));
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblID;
	}
	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setPreferredSize(new Dimension(200, 30));
			txtID.setColumns(10);
			txtID.addKeyListener(vfl);
		}
		return txtID;
	}
	private JLabel getLblPassport() {
		if (lblPassport == null) {
			lblPassport = new JLabel("Passport");
			lblPassport.setToolTipText("Passport");
			lblPassport.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassport.setPreferredSize(new Dimension(150, 0));
			lblPassport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblPassport;
	}
	private JTextField getTxtPassport() {
		if (txtPassport == null) {
			txtPassport = new JTextField();
			txtPassport.setPreferredSize(new Dimension(600, 30));
			txtPassport.setColumns(10);
			txtPassport.addKeyListener(vfl);
		}
		return txtPassport;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setToolTipText("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setPreferredSize(new Dimension(150, 0));
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblName;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setPreferredSize(new Dimension(600, 30));
			txtName.setColumns(10);
			txtName.addKeyListener(vfl);
		}
		return txtName;
	}
	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Surname");
			lblSurname.setToolTipText("Surname");
			lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
			lblSurname.setPreferredSize(new Dimension(150, 0));
			lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblSurname;
	}
	private JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setPreferredSize(new Dimension(600, 30));
			txtSurname.setColumns(10);
			txtSurname.addKeyListener(vfl);
		}
		return txtSurname;
	}
	private JLabel getLblSep() {
		if (lblSep == null) {
			lblSep = new JLabel("");
			lblSep.setForeground(Color.LIGHT_GRAY);
			lblSep.setBackground(Color.LIGHT_GRAY);
		}
		return lblSep;
	}
	
	/**
	 * 
	 * @return
	 */
	private JButton getBtnProceed() {
		if (btnProceed == null) {
			btnProceed = new JButton("Proceed");
			btnProceed.setToolTipText("Proceed to the account page");
			btnProceed.setEnabled(false);
			btnProceed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = txtID.getText();
					String passport = txtPassport.getText();
					String name = txtName.getText();
					String surname = txtSurname.getText();
					
					if(passport.isEmpty()) {
						txtIDAcc.setText(ID);
					} else {
						txtIDAcc.setText(passport);
					}
					
					txtNameAcc.setText(name);
					txtSurnAcc.setText(surname);
					
					if(!ID.isEmpty() && passport.isEmpty() && !name.isEmpty() && !surname.isEmpty()) {
						// Standard case of registration
						cR.addNewCustomer(ID, name, surname);
						showAccountPanel();
					} else if(ID.isEmpty() && !passport.isEmpty() && !name.isEmpty() && !surname.isEmpty()) {
						// Registration using passport
						cR.addNewCustomer(passport, name, surname);
						showAccountPanel();
					} else if(!ID.isEmpty() && passport.isEmpty() && name.isEmpty() && surname.isEmpty() && cR.isIDCorrect(ID)) {
						// User was already registered
						cR.updateCustomerBalance(ID);
						txtBalanceAcc.setText(cR.getBalance(ID) + "");
						showAccountPanel(ID);
					} else if(ID.isEmpty() && !passport.isEmpty() && name.isEmpty() && surname.isEmpty() && cR.isIDCorrect(passport)) {
						// User was already registered with a passport
						cR.updateCustomerBalance(passport);
						txtBalanceAcc.setText(cR.getBalance(passport) + "");
						showAccountPanel(passport);
					}
				}
			});
			btnProceed.setBackground(Color.CYAN);
		}
		return btnProceed;
	}
	
	protected void showAccountPanel() {
		txtBalanceAcc.setText(cR.getBalance(txtIDAcc.getText()) + "");
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnAcc");
	}
	
	protected void showAccountPanel(String ID) {
		
		txtIDAcc.setText(ID);
		txtNameAcc.setText(cR.getNameFromID(ID));
		txtSurnAcc.setText(cR.getSurnameFromID(ID));
		txtBalanceAcc.setText(cR.getBalance(ID) + "");
		
		getRootPane().setDefaultButton(btnConfirm);
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnAcc");
	}
	
	private JButton getBtnProceedNoReg() {
		if (btnProceedNoReg == null) {
			btnProceedNoReg = new JButton("Proceed without registration (voucher is lost)");
			btnProceedNoReg.setToolTipText("Proceed without registrating");
			btnProceedNoReg.setMnemonic('C');
			btnProceedNoReg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showIntroPanel();
				}
			});
			btnProceedNoReg.setBackground(new Color(0, 255, 255));
		}
		return btnProceedNoReg;
	}
	private JPanel getPanel_1_14() {
		if (pnAcc == null) {
			pnAcc = new JPanel();
			pnAcc.setLayout(new BorderLayout(0, 0));
			pnAcc.add(getWestSepAcc(), BorderLayout.WEST);
			pnAcc.add(getSouthSepAcc(), BorderLayout.SOUTH);
			pnAcc.add(getEastSepAcc(), BorderLayout.EAST);
			pnAcc.add(getPanel_1_15(), BorderLayout.CENTER);
			pnAcc.add(getNorthSepAcc(), BorderLayout.NORTH);
		}
		return pnAcc;
	}
	private JPanel getWestSepAcc() {
		if (westSepAcc == null) {
			westSepAcc = new JPanel();
			westSepAcc.setForeground(Color.WHITE);
			westSepAcc.setBackground(Color.WHITE);
			westSepAcc.add(getLblWestSeparatorReg_1());
		}
		return westSepAcc;
	}
	private JLabel getLblWestSeparatorReg_1() {
		if (lblWestSeparatorReg_1 == null) {
			lblWestSeparatorReg_1 = new JLabel("Separator");
			lblWestSeparatorReg_1.setForeground(Color.WHITE);
		}
		return lblWestSeparatorReg_1;
	}
	private JPanel getSouthSepAcc() {
		if (southSepAcc == null) {
			southSepAcc = new JPanel();
			southSepAcc.setForeground(Color.WHITE);
			southSepAcc.setBackground(Color.WHITE);
			southSepAcc.add(getLblSouthSeparatorReg_1());
		}
		return southSepAcc;
	}
	private JLabel getLblSouthSeparatorReg_1() {
		if (lblSouthSeparatorReg_1 == null) {
			lblSouthSeparatorReg_1 = new JLabel("Separator");
			lblSouthSeparatorReg_1.setForeground(Color.WHITE);
			lblSouthSeparatorReg_1.setBackground(Color.WHITE);
		}
		return lblSouthSeparatorReg_1;
	}
	private JPanel getEastSepAcc() {
		if (eastSepAcc == null) {
			eastSepAcc = new JPanel();
			eastSepAcc.setForeground(Color.WHITE);
			eastSepAcc.setBackground(Color.WHITE);
			eastSepAcc.add(getLblEastSeparatorReg_1());
		}
		return eastSepAcc;
	}
	private JLabel getLblEastSeparatorReg_1() {
		if (lblEastSeparatorReg_1 == null) {
			lblEastSeparatorReg_1 = new JLabel("Separator");
			lblEastSeparatorReg_1.setForeground(Color.WHITE);
			lblEastSeparatorReg_1.setBackground(Color.WHITE);
		}
		return lblEastSeparatorReg_1;
	}
	private JPanel getPanel_1_15() {
		if (pnAccData == null) {
			pnAccData = new JPanel();
			pnAccData.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			pnAccData.setBackground(Color.LIGHT_GRAY);
			pnAccData.setLayout(new GridLayout(6, 0, 0, 0));
			pnAccData.add(getLblAccTitle());
			pnAccData.add(getPanel_1_16());
			pnAccData.add(getPanel_1_17());
			pnAccData.add(getPnSurnameAcc());
			pnAccData.add(getPnBalanceAcc());
			pnAccData.add(getPnButtonsAcc());
		}
		return pnAccData;
	}
	private JPanel getNorthSepAcc() {
		if (northSepAcc == null) {
			northSepAcc = new JPanel();
			northSepAcc.setBackground(Color.WHITE);
			northSepAcc.add(getLblNorthLimiter_1());
		}
		return northSepAcc;
	}
	private JLabel getLblNorthLimiter_1() {
		if (lblNorthLimiter_1 == null) {
			lblNorthLimiter_1 = new JLabel("Limiter");
			lblNorthLimiter_1.setForeground(Color.WHITE);
			lblNorthLimiter_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNorthLimiter_1.setBackground(Color.WHITE);
		}
		return lblNorthLimiter_1;
	}
	private JLabel getLblAccTitle() {
		if (lblAccTitle == null) {
			lblAccTitle = new JLabel("Bingo: Account Information");
			lblAccTitle.setBackground(Color.LIGHT_GRAY);
			lblAccTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblAccTitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAccTitle;
	}
	private JPanel getPanel_1_16() {
		if (pnIDAcc == null) {
			pnIDAcc = new JPanel();
			pnIDAcc.setBackground(Color.LIGHT_GRAY);
			pnIDAcc.setLayout(new BoxLayout(pnIDAcc, BoxLayout.X_AXIS));
			pnIDAcc.add(getLblIDAcc());
			pnIDAcc.add(getTxtIDAcc());
		}
		return pnIDAcc;
	}
	private JLabel getLblIDAcc() {
		if (lblIDAcc == null) {
			lblIDAcc = new JLabel("ID");
			lblIDAcc.setToolTipText("ID");
			lblIDAcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblIDAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblIDAcc.setPreferredSize(new Dimension(200, 13));
		}
		return lblIDAcc;
	}
	private JTextField getTxtIDAcc() {
		if (txtIDAcc == null) {
			txtIDAcc = new JTextField();
			txtIDAcc.setEditable(false);
			txtIDAcc.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtIDAcc.setColumns(10);
		}
		return txtIDAcc;
	}
	private JPanel getPanel_1_17() {
		if (pnNameAcc == null) {
			pnNameAcc = new JPanel();
			pnNameAcc.setBackground(Color.LIGHT_GRAY);
			pnNameAcc.setLayout(new BoxLayout(pnNameAcc, BoxLayout.X_AXIS));
			pnNameAcc.add(getLblNameAcc());
			pnNameAcc.add(getTxtNameAcc());
		}
		return pnNameAcc;
	}
	private JPanel getPnSurnameAcc() {
		if (pnSurnameAcc == null) {
			pnSurnameAcc = new JPanel();
			pnSurnameAcc.setBackground(Color.LIGHT_GRAY);
			pnSurnameAcc.setLayout(new BoxLayout(pnSurnameAcc, BoxLayout.X_AXIS));
			pnSurnameAcc.add(getLblSurnameAcc());
			pnSurnameAcc.add(getTxtSurnAcc());
		}
		return pnSurnameAcc;
	}
	private JPanel getPnBalanceAcc() {
		if (pnBalanceAcc == null) {
			pnBalanceAcc = new JPanel();
			pnBalanceAcc.setBackground(Color.LIGHT_GRAY);
			pnBalanceAcc.setLayout(new BoxLayout(pnBalanceAcc, BoxLayout.X_AXIS));
			pnBalanceAcc.add(getLblBalanceAcc());
			pnBalanceAcc.add(getTxtBalanceAcc());
		}
		return pnBalanceAcc;
	}
	private JPanel getPnButtonsAcc() {
		if (pnButtonsAcc == null) {
			pnButtonsAcc = new JPanel();
			pnButtonsAcc.setBackground(Color.LIGHT_GRAY);
			pnButtonsAcc.add(getBtnConfirm());
		}
		return pnButtonsAcc;
	}
	private JLabel getLblNameAcc() {
		if (lblNameAcc == null) {
			lblNameAcc = new JLabel("Name");
			lblNameAcc.setToolTipText("Name");
			lblNameAcc.setPreferredSize(new Dimension(200, 13));
			lblNameAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblNameAcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNameAcc;
	}
	private JTextField getTxtNameAcc() {
		if (txtNameAcc == null) {
			txtNameAcc = new JTextField();
			txtNameAcc.setEditable(false);
			txtNameAcc.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtNameAcc.setColumns(10);
		}
		return txtNameAcc;
	}
	private JLabel getLblSurnameAcc() {
		if (lblSurnameAcc == null) {
			lblSurnameAcc = new JLabel("Surname");
			lblSurnameAcc.setToolTipText("Surname");
			lblSurnameAcc.setPreferredSize(new Dimension(200, 13));
			lblSurnameAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblSurnameAcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblSurnameAcc;
	}
	private JTextField getTxtSurnAcc() {
		if (txtSurnAcc == null) {
			txtSurnAcc = new JTextField();
			txtSurnAcc.setEditable(false);
			txtSurnAcc.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtSurnAcc.setColumns(10);
		}
		return txtSurnAcc;
	}
	private JLabel getLblBalanceAcc() {
		if (lblBalanceAcc == null) {
			lblBalanceAcc = new JLabel("Balance");
			lblBalanceAcc.setToolTipText("Balance");
			lblBalanceAcc.setPreferredSize(new Dimension(200, 13));
			lblBalanceAcc.setHorizontalAlignment(SwingConstants.CENTER);
			lblBalanceAcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblBalanceAcc;
	}
	private JTextField getTxtBalanceAcc() {
		if (txtBalanceAcc == null) {
			txtBalanceAcc = new JTextField();
			txtBalanceAcc.setEditable(false);
			txtBalanceAcc.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtBalanceAcc.setColumns(10);
		}
		return txtBalanceAcc;
	}
	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("CONFIRM");
			btnConfirm.setToolTipText("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showIntroPanel();
				}
			});
		}
		return btnConfirm;
	}
	
	/**
	 * 
	 */
	protected void showIntroPanel() {
		((CardLayout)getContentPane().getLayout()).show(contentPane, "pnStart");
		getRootPane().setDefaultButton(btnPlay);
		initialize();
	}
	private void initialize() {

		// Intro screen and game screen
		game.initialize();
		
		txtCode.setText("");
		btnRoll.setEnabled(true);
		btnLine.setEnabled(true);
		game.setWildCard(false);
		
		for(JButton b: numbers) {
			b.setEnabled(true);
			b.setText("0");
		}
		
		txtNumberDrawn.setText("");
		txtNumberOfPrizes.setText("0");
		
		// Registration screen
		txtID.setText("");
		txtPassport.setText("");
		txtName.setText("");
		txtSurname.setText("");
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/maquinabingo.jpg")));
			lblImage.setBackground(Color.WHITE);
		}
		return lblImage;
	}
	private JButton getBtnEnglishLanguage() {
		if (btnEnglishLanguage == null) {
			btnEnglishLanguage = new JButton("en");
			btnEnglishLanguage.setMnemonic('e');
			btnEnglishLanguage.setToolTipText("Change to English language");
			btnEnglishLanguage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localize(new Locale("en"));
				}
			});
			btnEnglishLanguage.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEnglishLanguage.setBackground(Color.WHITE);
		}
		return btnEnglishLanguage;
	}
	private JPanel getPanel_1_18() {
		if (pnLanguages == null) {
			pnLanguages = new JPanel();
			pnLanguages.setBackground(Color.WHITE);
			pnLanguages.add(getBtnEnglishLanguage());
			pnLanguages.add(getBtnSpanishLanguage());
		}
		return pnLanguages;
	}
	private JButton getBtnSpanishLanguage() {
		if (btnSpanishLanguage == null) {
			btnSpanishLanguage = new JButton("es");
			btnSpanishLanguage.setToolTipText("Change to Spanish language");
			btnSpanishLanguage.setMnemonic('s');
			btnSpanishLanguage.setBackground(Color.WHITE);
			btnSpanishLanguage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localize(new Locale("es"));
				}
			});
			btnSpanishLanguage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btnSpanishLanguage;
	}
	private JLabel getLblRemainingPrizes() {
		if (lblRemainingPrizes == null) {
			lblRemainingPrizes = new JLabel("Remaining:");
			lblRemainingPrizes.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblRemainingPrizes;
	}
	private JLabel getLblNumberOfRemainingPrizes() {
		if (lblNumberOfRemainingPrizes == null) {
			lblNumberOfRemainingPrizes = new JLabel("0");
		}
		return lblNumberOfRemainingPrizes;
	}
	private JPanel getPanel_1_19() {
		if (pnRemaining == null) {
			pnRemaining = new JPanel();
			pnRemaining.setBackground(Color.WHITE);
			pnRemaining.add(getLblRemainingPrizes());
			pnRemaining.add(getLblNumberOfRemainingPrizes());
		}
		return pnRemaining;
	}
	
	class ValidateFieldsListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			String ID = txtID.getText();
			String passport = txtPassport.getText();
			String name = txtName.getText();
			String surname = txtSurname.getText();
			
			if(!ID.isEmpty() && passport.isEmpty() && !name.isEmpty() && !surname.isEmpty()) {
				btnProceed.setEnabled(true);
			} else if(ID.isEmpty() && !passport.isEmpty() && !name.isEmpty() && !surname.isEmpty()) {
				btnProceed.setEnabled(true);
			} else if(!ID.isEmpty() && passport.isEmpty() && name.isEmpty() && surname.isEmpty()) {
				btnProceed.setEnabled(true);
			} else if(ID.isEmpty() && !passport.isEmpty() && name.isEmpty() && surname.isEmpty()) {
				btnProceed.setEnabled(true);
			} else {
				btnProceed.setEnabled(false);
			}
		}
		
		
	}
	private JPanel getPanel_1_20() {
		if (pnWildCard == null) {
			pnWildCard = new JPanel();
			pnWildCard.setBackground(Color.WHITE);
			pnWildCard.setLayout(new BoxLayout(pnWildCard, BoxLayout.X_AXIS));
			pnWildCard.add(getLblWildCard());
			pnWildCard.add(getTxtWildCard());
		}
		return pnWildCard;
	}
	private JLabel getLblWildCard() {
		if (lblWildCard == null) {
			lblWildCard = new JLabel("Wild Card:");
		}
		return lblWildCard;
	}
	private JTextField getTxtWildCard() {
		if (txtWildCard == null) {
			txtWildCard = new JTextField();
			txtWildCard.setEditable(false);
			txtWildCard.setText("0");
			txtWildCard.setColumns(10);
		}
		return txtWildCard;
	}
}
