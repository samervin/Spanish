package conjugation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

//given a word, type its conjugations in a variety of tenses.
//currently includes all illogical conjugations for llover
//currently leaves estar out of the commands

public class Conjugation extends JFrame{

	private static final long serialVersionUID = 1L;

	static ArrayList<String> arr = new ArrayList<String>();

	static JButton enter;
	public static JTextArea output;
	public static JTextField input;
	static JFrame frame;
	static JPanel panel;

	static int numberOfInputs = 6;
	static int numberOfChapters = 11;
	static int correct;
	static int total;
	static int word;
	static int state = 0; //0 = getting information, 1 = entering info, 2 = end program
	static String pool = "any";
	static Random rand = new Random();

	public static void createFrame() {
		frame = new JFrame("SPAN101/102 Conjugation");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(true);
		ButtonListener butt = new ButtonListener();
		output = new JTextArea(25, 60);
		output.setWrapStyleWord(true);
		output.setEditable(false);
		JScrollPane scroller = new JScrollPane(output);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		input = new JTextField(50);
		enter = new JButton("Enter");
		enter.setActionCommand("Enter");
		enter.addActionListener(butt);
		//enter.setEnabled(false);
		input.setActionCommand("Enter");
		input.addActionListener(butt);
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroller);
		inputpanel.add(input);
		inputpanel.add(enter);
		panel.add(inputpanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		//center of screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		input.requestFocus();
	}

	public static void askQuestion() {
		word = rand.nextInt(arr.size());
		String wordline = arr.get(word);
		String infinitive = wordline.substring(0, wordline.indexOf(' '));

		output.append("Type all conjugations of the verb " + infinitive + ":\n");
		input.setText("");
	}

	public static void loadWordsFromFile() {
		arr.clear();
		Scanner in;
		File pathToData = new File("data");
		File[] filenames = pathToData.listFiles();
		
		try {
			if(pool.equals("any")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(!f.getName().contains("formal")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("pres")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("present")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("pret")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("preterite")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("imp")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("imperfect")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("formal")) {
				numberOfInputs = 3;
				for(File f : filenames) {
					if(f.getName().contains("_formal")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("informal")) {
				numberOfInputs = 2;
				for(File f : filenames) {
					if(f.getName().contains("informal")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("any-i")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("irregular")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("pres-i")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("irregular") && f.getName().contains("present")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("pret-i")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("irregular") && f.getName().contains("preterite")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.equals("imp-i")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					if(f.getName().contains("irregular") && f.getName().contains("imperfect")) {
						in = new Scanner(f);
						while(in.hasNext()) arr.add(in.nextLine());
					}
				}
			} else if(pool.contains("any")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(!f.getName().contains("formal") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			} else if(pool.contains("pres")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(f.getName().contains("present") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			} else if(pool.contains("pret")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(f.getName().contains("preterite") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			} else if(pool.contains("imp")) {
				numberOfInputs = 6;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(f.getName().contains("imperfect") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			} else if(pool.contains("formal") && !pool.contains("informal")) {
				numberOfInputs = 3;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(f.getName().contains("_formal") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			} else if(pool.contains("informal")) {
				numberOfInputs = 2;
				for(File f : filenames) {
					for(int i = 1; i <= numberOfChapters; i++) {
						if(f.getName().contains("informal") && f.getName().contains(""+i) && pool.contains(""+i)) {
							in = new Scanner(f);
							while(in.hasNext()) arr.add(in.nextLine());
						}
					}
				}
			}
		}
		catch(Exception e) {
			output.append("Error reading files. Try restarting.\n");
		}
	}

	public static class ButtonListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			if(!input.getText().trim().equals("")) {
				//String cmd = e.getActionCommand();
				String[] ans = input.getText().toLowerCase().split(" ");
				if(ans.length == 1 && ans[0].equals("quit")) {
					//perform quitting
					int percent = (int) ((double) correct / (double) total * 100);
					output.append("\n\nYour final score is "+correct+"/"+total+", which is about "+percent+" percent!\n");
					output.append("You may close the program at any time, or type \"reset\" to start again.\n");
					state = 2;
					input.setText("");

				} else if(ans.length == 1 && ans[0].equals("help")) {
					output.append("\n\nFor each verb that appears, type, in order, the six present tense conjugations.\n");
					output.append("Please go in yo-tu-el-nosotros-vosotros-ellos order, and separate all words with spaces.\n");
					output.append("Do not type nonstandard letters, type an apostrophe ' after the appropriate letter\n\t(for example, vosotros ayuda'is or yo ensen'o).\n");
					input.setText("");

				} else if(ans.length == 1 && ans[0].equals("reset")) {
					output.setText("");
					input.setText("");
					correct = 0;
					total = 0;
					state = 0;
					appendWords();

				} else if(ans.length == 1 && ans[0].equals("words")) {
					appendWords();
					state = 0;
					input.setText("");
				}


				else if(state == 0 && ans.length == 1) {
					pool = ans[0];
					loadWordsFromFile();
					if(arr.size() > 0) {
						input.setText("");
						state = 1;
						askQuestion();
					} else {
						output.append("You didn't input a valid set of words! Try again!\n");
						input.setText("");
					}	
				}
				else if(state == 1 && ans.length != numberOfInputs) {
					//there was a problem!
					output.append(">>> Your reply was not valid. Try again.\n");

				} else if(state == 1){
					//process input
					total += numberOfInputs;
					Scanner line = new Scanner(arr.get(word));
					line.next();
					for(int j = 0; j < numberOfInputs; j++) {
						if(ans[j].equals(line.next()))
							correct++;
					}
					line.close();
					output.append("You answered:\t");
					for(int j = 0; j < numberOfInputs; j++) {
						output.append(ans[j] + " "); 
					} output.append("\n");
					String conjugations = arr.get(word).substring(arr.get(word).indexOf(' ') + 1);
					output.append("Actual answer:\t" + conjugations + "\n\n");
					askQuestion();
					output.setCaretPosition(output.getDocument().getLength());
				}


				else {
					output.append("You've encountered an error. Try whatever you were doing again, typing \"reset\", or restarting the program.\n");
					input.setText("");
				}
				//output.append(input.getText() + "\n");
			}


			input.requestFocus();
		}
	}
	
	public static void appendWords() {
		output.append("Which words would you like to study?\n");
		output.append("Type \"any\" for all possible words, \"pres\" for all present-tense words,\n");
		output.append("\t\"pret\" for all preterite-tense words, \"imp\" for all imperfect words,\n");
		output.append("\t\"any-i\" for all irregular words, \"pres-i\" for all present-tense irregulars,\n");
		output.append("\t\"pret-i\" for all preterite irregulars, \"imp-i\" for all imperfect irregulars,\n");
		output.append("\t\"any-#\" for any words from # chapters, \"pres-#\" for present-tense words from # chapters,\n");
		output.append("\t\"pret-#\" for preterite words from # chapters, or \"imp-#\" for imperfect words from # chapters,\n");
		output.append("\t(where # can be any string of numbers like 1 or 245 or 96)\n");
		output.append("\tYou can also type \"formal\" (or \"formal-#\") or \"informal\" (or \"informal-#\")\n");
		output.append("\tto study formal and informal commands, as learned in class.\n");
	}

	public static void main(String[] args) {

		String s = System.getProperty("user.dir");

		createFrame();
		output.append("Current working directory: " + s + "\n");
		output.append("Spanish 101/102 Conjugation practice program, version 11\n");
		output.append("\tChapters 1-11, present/preterite/imperfect/command tenses)\n");
		output.append("Type \"help\" for assistance or type \"quit\" to see your final score.\n\n");
		state = 0;

		appendWords();
	}
}