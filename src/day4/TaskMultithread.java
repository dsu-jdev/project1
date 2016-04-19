package day4;

import javax.swing.SwingWorker;

public class TaskMultithread {

	long time;
	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		@Override
		protected Void doInBackground() throws Exception {
			RandomNumber.btnMultithread.setEnabled(false);
			RandomNumber.status.setText("Initializing...");
			long start = System.currentTimeMillis();
			new Master();
			long end = System.currentTimeMillis();
			time = end - start;
			return null;
		}
	
		@Override
		public void done() {
			RandomNumber.btnMultithread.setEnabled(true);
			RandomNumber.status.setText("Done!");
			RandomNumber.multithreadResult.append("Total time: " + time);
		}
	};
	public TaskMultithread() {
		worker.execute();
	}
	
	
}
