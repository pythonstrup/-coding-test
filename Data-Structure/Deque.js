class Deque {
  constructor() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  empty() {
    if (!this.count) return 1;
    else return 0;
  }

  push_front(element) {
    if (this.head === null) {
      this.head = element;
      this.tail = element;
    } else {
      let curr = this.head;
      element.next = curr;
      curr.prev = element;
      this.head = element;
    }
    this.count++;
  }

  push_back(element) {
    if (this.tail === null) {
      this.head = element;
      this.tail = element;
    } else {
      this.tail.next = element;
      element.prev = this.tail;
      this.tail = element;
    }
    this.count++;
  }

  pop_front() {
    if (!this.empty()) {
      let temp = this.head;
      temp.next.prev = null;
      this.head = temp.next;
      temp = null;
      this.count--;
    }
  }

  pop_back() {
    if (!this.empty()) {
      let temp = this.tail;
      temp.prev.next = null;
      this.tail = temp.prev;
      temp = null;
      this.count--;
    }
  }

  print() {
    let curr = this.head;
    while (curr) {
      console.log(curr.value);
      curr = curr.next;
    }
  }

  front() {
    return this.head.value;
  }

  back() {
    return this.tail.value;
  }

  length() {
    return this.count;
  }
}
