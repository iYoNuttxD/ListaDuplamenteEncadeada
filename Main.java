package Node;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // Criar uma nova lista duplamente ligada
        NodeL list = new NodeL();

        // Testar adição de elementos
        System.out.println("Adicionando elementos:");
        list.add(10); // Adiciona no topo
        list.add(20); // Adiciona no topo
        list.add(30); // Adiciona no topo
        list.add(0, 5); // Adiciona na base
        list.add(2, 15); // Adiciona no meio

        // Mostrar lista atual
        printList(list);

        // Testar recuperação de elementos
        System.out.println("Elemento na posição 0: " + list.get(0));
        System.out.println("Elemento na posição 2: " + list.get(2));
        System.out.println("Elemento na posição 4: " + list.get(4));

        // Testar atualização de elementos
        System.out.println("Atualizando elemento na posição 2 para 25.");
        list.set(2, 25);
        printList(list);

        // Testar remoção de elementos
        System.out.println("Removendo elemento na posição 0.");
        list.remove(0);
        printList(list);

        System.out.println("Removendo elemento na posição 2.");
        list.remove(2);
        printList(list);

        // Testar remoção de todos os elementos e limpar a lista
        System.out.println("Removendo elemento na posição 0.");
        list.remove(0);
        printList(list);

        System.out.println("Limpando a lista.");
        list.clear();
        printList(list);
    }

    private static void printList(NodeL list) {
        if (list.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            Node current = list.base;
            System.out.print("Lista: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
