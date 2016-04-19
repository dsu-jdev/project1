package day4;

import javax.swing.SwingWorker;

public class TaskGenerate {

	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		@Override
		protected Void doInBackground() throws Exception {
			RandomNumber.btnMultithread.setEnabled(false);
			RandomNumber.btnOneThread.setEnabled(false);
			RandomNumber.status.setText("Generating " + (RandomNumber.SIZE / 1000000) + " million integers...");
			for (int i = 0; i < 5; i++) {
				new GenerateRandomNumber(RandomNumber.FILE_NAME[i]);
			}
			return null;
		}
	
		@Override
		public void done() {
			RandomNumber.btnMultithread.setEnabled(true);
			RandomNumber.btnOneThread.setEnabled(true);
			RandomNumber.status.setText("Generated!");
			RandomNumber.isJoined = false;
		}
	};
	
	public TaskGenerate() {
		worker.execute();
	}
}
