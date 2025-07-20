package com.francesco.mastermind;

public abstract class Sequence {

    public void checkIndex(int length, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
