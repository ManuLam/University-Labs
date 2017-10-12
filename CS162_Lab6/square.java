public class square {
public int length;

    public square() {
    	length = 1;
    }

    public square(int L) {
    	length = L;
    }

    public int getLength() {
    	return length;
	}

	public void setLength(int y) {
		length = y;
	}

	public int getArea() {
		return length*length;
	}

	public String toString() {
		return Integer.toString(length);
		
	}

}