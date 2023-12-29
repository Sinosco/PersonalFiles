public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /*
     * isWord is currently useless as I am not using this data structure to fix words
     * but rather focusing on prefixes and the beginning of words.
     */
    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;         

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c-'A';
            if(current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }
            else
                current = current.children[index];
        }
        current.isWord=true;
    }

    // Code taken from geekforgeeks but edited.
    public boolean search(String word){
        int index;
        TrieNode current = root;
      
        for(int level=0; level<word.length(); level++)
        {
            index = word.charAt(level) - 'A';
      
            if (current.children[index] == null)
                return false;
      
            current = current.children[index];
        }
        return (current.isWord || true); //just so vsc stops yelling at me about not using isWord
    }

}
