package eg.edu.guc.yugioh.gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelTest extends JLabel implements MouseListener {
	static ImageIcon BigShieldGardna = new ImageIcon(("Big Shield Gardna.jpg"));

	JLabelTest(){
		super(BigShieldGardna);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		  Component c = e.getComponent();
		    System.out.println("entered");
		   // Boolean constraint = layout.getConstraints(c);

		  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
		 //       layout.addLayoutComponent(c, OverlapLayout.POP_UP);
		  //  else
		    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

		    c.getParent().invalidate();
		    c.getParent().validate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		  Component c = e.getComponent();
		    c.getParent().invalidate();
		    c.getParent().validate();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		  Component c = e.getComponent();
		    System.out.println("entered");
		   // Boolean constraint = layout.getConstraints(c);

		  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
		 //       layout.addLayoutComponent(c, OverlapLayout.POP_UP);
		  //  else
		    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

		    c.getParent().invalidate();
		    c.getParent().validate();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		  Component c = e.getComponent();
		    System.out.println("entered");
		   // Boolean constraint = layout.getConstraints(c);

		  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
		 //       layout.addLayoutComponent(c, OverlapLayout.POP_UP);
		  //  else
		    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

		    c.getParent().invalidate();
		    c.getParent().validate();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		  Component c = e.getComponent();
		   // System.out.println("entered");
		   // Boolean constraint = layout.getConstraints(c);

		  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
		 //       layout.addLayoutComponent(c, OverlapLayout.POP_UP);
		  //  else
		    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

		    c.getParent().invalidate();
		    c.getParent().validate();
	}

}
