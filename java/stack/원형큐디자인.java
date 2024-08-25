package no;

public class 원형큐디자인 {

  private final int[] values;
  private int len;
  private int front;
  private int rear;

  public 원형큐디자인(int size) {
    this.values = new int[size];
    this.len = 0;
    front = 0;
    rear = -1;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    rear = (rear+1) % values.length;
    values[rear] = value;
    len++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    front = (front + 1) % values.length;
    len--;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return values[front];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return values[rear];
  }

  public boolean isEmpty() {
    return len == 0;
  }

  public boolean isFull() {
    return len == values.length;
  }
}
