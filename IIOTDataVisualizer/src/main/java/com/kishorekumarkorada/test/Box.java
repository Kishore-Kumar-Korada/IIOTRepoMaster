package com.kishorekumarkorada.test;

public class Box {
	
	private int boxLength;
	private int boxWidth;
	
	public Box(int boxLength, int boxWidth) {
		this.boxLength = boxLength;
		this.boxWidth = boxWidth;
	}

	public int getBoxLength() {
		return boxLength;
	}

	public int getBoxWidth() {
		return boxWidth;
	}
	
	public double getDimension() {
		return 5*boxLength*boxWidth;
	}
	
	public boolean isEqual(Box box) {
		return this.equals(box);
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Box) {
			Box box = (Box) obj;
			if(this.boxLength == box.boxLength && this.boxWidth == box.boxWidth) {
				return true;
			}
		}
		return false;
	}
	
}
