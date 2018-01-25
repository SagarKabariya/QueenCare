package Settings;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Layout {

	int width;
	int height;
	
	public Layout() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
	}
		public double getwidth()
		{
			return width;
		}
		public double getheight()
		{
			return height;
		}
		public double getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}
}
