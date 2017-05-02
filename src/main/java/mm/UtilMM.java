package mm;

public class UtilMM {
	public static class Pos2D {
		public int x;
		public int z;
		
		public Pos2D(int x, int z) {
			this.x = x;
			this.z = z;
		}
		public Pos2D(Pos2D pos) {
			this.x = pos.x;
			this.z = pos.z;
		}
	}
}
