package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2606 {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int numberOfPairs = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[computers + 1];
        for (int i = 1; i <= computers; i++) {
            nodes[i] = new Node(i);
        }

        int temp = 0;
        while(temp < numberOfPairs) {
            String[] tokens = br.readLine().split(" ");
            int index = Integer.parseInt(tokens[0]);
            int computer = Integer.parseInt(tokens[1]);

            nodes[index].add(computer);
            //TODO 아래 한줄이 핵심이었다. '양방향'!!!!
            nodes[computer].add(index);
            temp++;
        }

        bfs(nodes, nodes[1]);
        System.out.println(count - 1);
    }

    private static void bfs(Node[] nodes, Node node) {
        if(node.visit) {
            return;
        }
        node.visit = true;
        count++;

        for (Integer integer : node.connected) {
            bfs(nodes, nodes[integer]);
        }
    }

    private static class Node {
        private int index;
        private Set<Integer> connected = new HashSet<>();
        boolean visit = false;

        Node(int index) {
            this.index = index;
        }

        private void add(int computer) {
            connected.add(computer);
        }
    }

}
