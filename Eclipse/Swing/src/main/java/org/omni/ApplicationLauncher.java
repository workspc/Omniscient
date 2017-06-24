package org.omni;

import static javax.swing.SwingUtilities.invokeLater;
import static org.omni.Property.prop;

public class ApplicationLauncher {

	private final Application application;

	private ApplicationLauncher(Application application) {
		this.application = application;
	}

	private void launch() {
		invokeLater(new Runnable() {
			public void run() {
				application.execute();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<Application> loadedApplication = (Class<Application>) Class
				.forName(prop.getString(prop.getString("application.run") + ".class"));
		Application application = loadedApplication.newInstance();
		ApplicationLauncher launcher = new ApplicationLauncher(application);
		launcher.launch();
	}
}