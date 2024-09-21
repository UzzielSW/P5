import JEditorPane;
import JFrame;
import JScrollPane;
import ScrollPaneConstants;

public class ScratchPad {

	public static void main(String args[]) throws Exception {
		String html = "<html>" +
				"<head>" +
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>" + // this is the problem right
																																													// here
				"<title>Error 400 BAD_REQUEST</title>" +
				"</head>" +
				"<body>" +
				"<h2>HTTP ERROR: 400</h2><pre>BAD_REQUEST</pre>" +
				"<p>RequestURI=null</p>" +
				"<p><i><small><a href=\"http://jetty.mortbay.org\">Powered by jetty://</a></small></i></p>" +
				"</body>" +
				"</html>";
		JFrame f = new JFrame();
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.getDocument().putProperty("Ignore-Charset", "true"); // this line makes no difference either way
		editor.setContentType("text/html");
		editor.getDocument().putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		editor.setText(html);

		f.add(new JScrollPane(editor, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
		f.pack();
		f.setVisible(true);
	}

}
