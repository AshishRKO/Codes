/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.List;

/**
 * @author Ashish Barthwal
 * @version $Id: TrieInsert.java, v 0.1 2018-12-24 4:11 PM Ashish Barthwal $$
 */
public class TrieInsert {

    private static TrieNode root;
    public TrieInsert() {
        root = new TrieNode();
    }

    private class TrieNode
    {
        HashMap<Character, TrieNode> children;

        List<String> list;

        //O(N) N - length of string
        // only 10 elements are there

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }

    }


    public boolean search(String word)
    {
        TrieNode current = root;

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);

            TrieNode nextNode = current.children.get(ch);

            if(nextNode == null)
            {
                return false;
            }
            current = nextNode;

        }

        return current.isEndOfWord;
    }

    public void insert(String word)
    {
        TrieNode current = root;

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);

            TrieNode nextNode = current.children.get(ch);

            if(nextNode == null)
            {
                nextNode = new TrieNode();
                current.children.put(ch,nextNode);
            }
            current = nextNode;
        }

        current.isEndOfWord = true;
    }


     void display(TrieNode root, char str[], int level)
    {
        // If node is leaf node, it indiicates end
        // of string, so a null charcter is added
        // and string is displayed
        if (root.isEndOfWord)
        {
            //str[level] = '\0';
            System.out.println(str);
            //cout << str << endl;
        }

        int i;
        for (i = 0; i < 26; i++)
        {
            // if NON NULL child is found
            // add parent key to str and
            // call the display function recursively
            // for child node
            char ch = (char)(i+65);
            if (root.children.get(ch) != null)
            {
                str[level] = (char)(i + 'A');
                display(root.children.get(ch), str, level + 1);
            }
        }
    }


    public static void main(String[] args) {

        TrieInsert trieInsert = new TrieInsert();

        trieInsert.insert("mobile");
        trieInsert.insert("mob1");
        trieInsert.insert("mo2");
        trieInsert.insert("pen");
        trieInsert.insert("paper");


        char str[] = new char[7];
        trieInsert.display(root, str, 0);

        System.out.println(trieInsert.search("m"));
    }
}