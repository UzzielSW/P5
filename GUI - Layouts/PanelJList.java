import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelJList extends JFrame implements ActionListener {

	public static void main(String[] args) {
		PanelJList f = new PanelJList("Panel: JList");
		f.setVisible(true);
	}

	private JButton next, prev, first;
	private JList<String> list;

	public PanelJList(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("Has una eleccion"));
		this.add(northPanel, BorderLayout.NORTH);

		list = new JList<>();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 1; i <= 10; i++) {
			listModel.addElement("elemento" + i);
		}

		list.setModel(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		list.setAutoscrolls(true);
		this.add(scrollPane, BorderLayout.CENTER);

		next = new JButton("Next >>");
		next.setMnemonic('n');
		prev = new JButton("<< Previous");
		prev.setMnemonic('p');
		first = new JButton("First");
		first.setMnemonic('f');

		JPanel southPanel = new JPanel();
		southPanel.add(prev);
		southPanel.add(first);
		southPanel.add(next);

		this.add(southPanel, BorderLayout.SOUTH);

		next.addActionListener(this);
		first.addActionListener(this);
		prev.addActionListener(this);

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int pos = list.getSelectedIndex();
		if (e.getSource() == prev){
			if (pos > 0) list.setSelectedIndex(pos - 1);
		} else if (e.getSource() == next) {
			if (pos < 10) list.setSelectedIndex(pos + 1);
		} else
			list.setSelectedIndex(0);

		// actualizar la vista del scroll al elemento selecionado
		pos = list.getSelectedIndex();
		list.ensureIndexIsVisible(pos);
	}
}
