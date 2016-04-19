package day4;

import javax.swing.SwingWorker;

public class TaskOneThread {

	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		@Override
		protected Void doInBackground() throws Exception {
			RandomNumber.btnOneThread.setEnabled(false);
			new OneThread();
			return null;
		}
	
		@Override
		public void done() {
			RandomNumber.btnOneThread.setEnabled(true);
			RandomNumber.status.setText("Done!");
			RandomNumber.isJoined = true;
		}
	};
	
	public TaskOneThread() {
		worker.execute();
	}
}
