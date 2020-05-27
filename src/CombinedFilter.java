import java.awt.image.BufferedImage;

public class CombinedFilter {
	public static BufferedImage OpeningProcess(BufferedImage img, int r, int l) {
		BufferedImage img2 = MinimumFilter.MinimumProcess(img, r, l);
		BufferedImage result = MaximumFilter.MaximumProcess(img2, r, l);
		return result;
	}
	
	public static BufferedImage ClosingProcess(BufferedImage img, int r, int l) {
		BufferedImage img2 = MaximumFilter.MaximumProcess(img, r, l);
		BufferedImage result = MinimumFilter.MinimumProcess(img2, r, l);
		return result;
	}
}
