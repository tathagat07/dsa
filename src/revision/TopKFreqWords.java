package revision;

import java.util.*;

public class TopKFreqWords {

    public List<String> topKFrequentWord(String[] words, int k){

        Map<String, Integer> freq = new HashMap<>();

        for(String word : words){
            freq.put(word, freq.getOrDefault(word,0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) -> {
                    if(freq.get(a).equals(freq.get(b))){
                        return b.compareTo(a);
                    }
                    return freq.get(a) - freq.get(b);
                }
        );

        for(String word : freq.keySet()){
            pq.offer(word);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"ONE", "TWO","ONE","ONE", "TWO","ONE","three" };
        TopKFreqWords topKFreqWords = new TopKFreqWords();

        System.out.println(topKFreqWords.topKFrequentWord(words,2));
    }
}
