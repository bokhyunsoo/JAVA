package ch18;

public class Missile {
	private int mx;
	private int my;

	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}

	@Override
	public String toString() {
		return "Missile [mx=" + mx + ", my=" + my + "]";
	}

}
