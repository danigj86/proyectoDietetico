package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class BotonMenu extends JButton {
	public BotonMenu(String txt) {
		super(txt);
		this.setFont(new Font("MV Boli", Font.PLAIN, 16));
		this.setForeground(new Color(255, 255, 255));
		this.setBorder(new LineBorder(new Color(0, 100, 0)));
		this.setBackground(new Color(0, 0, 200));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(0, 0, 250));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(0, 0, 200));
			}
		}
        );
	}

}
