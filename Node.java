package Node;

public class Node {
    Node previous; // Referência para o nó anterior
    int data;      // Dado armazenado no nó
    Node next;     // Referência para o próximo nó

    public Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

}

class NodeL {
    Node base;  // Referência para o primeiro nó
    Node top;   // Referência para o último nó
    int size;   // Tamanho da lista

    public NodeL() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            //Primeira inserção
            base = node;
            top = node;
        } else {
            //Inserção no topo
            Node currentTop = top;
            currentTop.next = node;
            node.previous = currentTop;
            top = node;
        }
        size += 1;
    }

    public void add(int pos, int data) throws IllegalAccessException {
        if (pos < 0 || pos > size) {
            throw new IllegalAccessException("Posição Inválida");
        }
        Node node = new Node(data);
        if (pos == 0) {
            if (isEmpty()) {
                //Primeira inserção
                base = node;
                top = node;
            } else {
                //Inserção na base
                Node currentBase = base;
                currentBase.previous = node;
                node.next = currentBase;
                base = node;
            }
        } else if (pos == size) {
            //Inserção no topo
            Node currentTop = top;
            currentTop.next = node;
            node.previous = currentTop;
            top = node;
        } else {
            //Inserção no meio
            Node Current = getNode(pos);
            Node previousCurrent = Current.previous;
            node.previous = previousCurrent;
            node.next = Current;

            if (previousCurrent != null) {
                previousCurrent.next = node;
            }
            Current.previous = node;
        }
        size += 1;
    }

    public int remove(int pos) throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Nó vazio");
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalAccessException("Posição inválida.");
        }
        Node currentRemove = getNode(pos);
        if (currentRemove == base && currentRemove == top) {
            //Remoção de nó único
            top = null;
            base = null;
        } else if (currentRemove == base) {
            //Remoção da base
            Node nextCurrentRemove = currentRemove.next;
            nextCurrentRemove.previous = null;
            base = nextCurrentRemove;
        } else if (currentRemove == top) {
            //Remoção do topo
            Node previousCurrentRemove = currentRemove.previous;
            previousCurrentRemove.next = null;
            top = previousCurrentRemove;
        } else {
            //Remoção do meio
            Node nextCurrentRemove = currentRemove.next;
            Node previousCurrentRemove = currentRemove.previous;
            if (nextCurrentRemove != null) {
                nextCurrentRemove.previous = previousCurrentRemove;
            }
            if (previousCurrentRemove != null) {
                previousCurrentRemove.next = nextCurrentRemove;
            }
        }
        return remove(currentRemove);
    }

    private int remove(Node node) {
        node.next = null;
        node.previous = null;
        size -= 1;
        return node.data;
    }

    public void set(int pos, int value) throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Nó vazio");
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalAccessException("Posição inválida.");
        }
        Node current = getNode(pos);
        current.data = value;
    }

    public Node getNode(int pos) throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Nó vazio");
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalAccessException("Posição Inválida");
        }
        Node current;
        if (pos < (size / 2)) {
            current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = top;
            for (int i = size - 1; i > pos; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public int get(int pos) throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Nó vazio");
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalAccessException("Posição Inválida");
        }
        Node current;
        if (pos < (size / 2)) {
            current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = top;
            for (int i = size - 1; i > pos; i--) {
                current = current.previous;
            }
        }
        return current.data;
    }

    public void clear() {
        base = null;
        top = null;
        size = 0;
    }

}