package de.gebit.integrity.tests.fixtures.basic.beans;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class PrimitiveTypeTestBean {

	private int primitiveInt;

	private long primitiveLong;

	private short primitiveShort;

	private byte primitiveByte;

	private double primitiveDouble;

	private float primitiveFloat;

	private char primitiveChar;

	private boolean primitiveBoolean;

	public void alterABit() {
		primitiveInt++;
		primitiveLong++;
		primitiveShort++;
		primitiveByte++;
		primitiveDouble += 1;
		primitiveFloat += 1;
		primitiveChar++;
		primitiveBoolean = !primitiveBoolean;
	}

	public int getPrimitiveInt() {
		return primitiveInt;
	}

	public void setPrimitiveInt(int primitiveInt) {
		this.primitiveInt = primitiveInt;
	}

	public long getPrimitiveLong() {
		return primitiveLong;
	}

	public void setPrimitiveLong(long primitiveLong) {
		this.primitiveLong = primitiveLong;
	}

	public short getPrimitiveShort() {
		return primitiveShort;
	}

	public void setPrimitiveShort(short primitiveShort) {
		this.primitiveShort = primitiveShort;
	}

	public byte getPrimitiveByte() {
		return primitiveByte;
	}

	public void setPrimitiveByte(byte primitiveByte) {
		this.primitiveByte = primitiveByte;
	}

	public double getPrimitiveDouble() {
		return primitiveDouble;
	}

	public void setPrimitiveDouble(double primitiveDouble) {
		this.primitiveDouble = primitiveDouble;
	}

	public float getPrimitiveFloat() {
		return primitiveFloat;
	}

	public void setPrimitiveFloat(float primitiveFloat) {
		this.primitiveFloat = primitiveFloat;
	}

	public char getPrimitiveChar() {
		return primitiveChar;
	}

	public void setPrimitiveChar(char primitiveChar) {
		this.primitiveChar = primitiveChar;
	}

	public boolean isPrimitiveBoolean() {
		return primitiveBoolean;
	}

	public void setPrimitiveBoolean(boolean primitiveBoolean) {
		this.primitiveBoolean = primitiveBoolean;
	}

}