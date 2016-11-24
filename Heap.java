package dijkstra;

import java.util.ArrayList;

public class Heap {
	ArrayList<Node> heap = null;

	public Heap() {
		heap = new ArrayList<Node>();
	}

	public int Parent(int i) {
		return (i - 1) / 2;
	}

	public int LeftChild(int i) {
		int left = 2 * i + 1; // �迭�� 0���� �����ϹǷ�
		return left; // ���� �ڽ� index�� 2 * i + 1
	}

	public int RightChild(int i) {
		int right = 2 * i + 2; // �迭�� 0���� �����ϹǷ�
		return right; // 2 * i + 2 �� ��ȯ
	}

	public Node min() { // �ּ� ������ �ּ� �׸��� �׻� �Ѹ��� �����Ƿ�
		return heap.get(0);
	}

	public void swap(int a, int b) {
		Node temp = heap.get(a); // a index ����
		heap.set(a, heap.get(b)); // b index ��� swap
		heap.set(b, temp);
	}

	public void Min_Heapify(int i) { // �� ����
		int l = LeftChild(i); // �ش� ���� �ڽ� index
		int r = RightChild(i); // ������ �ڽ� index
		int smallest = i; // ���� ū��
		if (l < heap.size() && heap.get(l).getDist() < heap.get(i).getDist()) {
			smallest = l; // �켱������ ������ ������
		} else {
			smallest = i; // �θ� ������
		}
		if (r < heap.size()
				&& heap.get(r).getDist() < heap.get(smallest).getDist()) {
			smallest = r; // �켱������ �������� ������
		}
		if (smallest != i) { // ���� ���� �Ͱ� index�� ���� ������ swap
			swap(i, smallest);
			Min_Heapify(smallest); // ������
		}
	}

	public void set_priority(int i, int priority) {
		Node tmp = heap.get(i);		// �ʱ� ��� �� �����´�.
		tmp.setDist(priority);			// �켱���� ���� �ٲ��ش�.
		heap.set(i, tmp);			// ����� �켱 �������� ���� ��� ����
	}

	public Node extract_min() { // ���� �տ� �ִ� ���� ���� ���� ���̹Ƿ�
		Node tmp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1)); // ���� ���� �ִ� ���� ������ �Ű��ְ�
		heap.remove(heap.size() - 1); // ���� ����
		Min_Heapify(0);
		return tmp;
	}

	public void insert(Node input) {
		heap.add(input); // ���� �߰��� ���� heap�� �߰� �����ش�.
		Build_Min_Heap(); // min heap �ٽ� ������ش�.
	}

	public void Build_Min_Heap() {
		for (int i = heap.size() / 2; i >= 0; i--) { // ��ü �������� ���� ��, ������ ����� �θ�
														// ������
			Min_Heapify(i); // Min Heap ������ min heap check
		}
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}

	public int size() {
		return heap.size();
	}

	public Node get(int i) {
		return heap.get(i);
	}
}