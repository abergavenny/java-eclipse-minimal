package abergavenny.minimal.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String ID = "abergavenny.minimal.ui.messages";

	public static String hello;

	static {
		NLS.initializeMessages(ID, Messages.class);
	}

	private Messages() {
	}
}
