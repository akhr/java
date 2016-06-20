/**
MEAT -> TAME, MATE, TEAM

M --> starting with M 
    {E, A, T}
    --> M,E  --> M,A --> M,T
       {A,T}     {E,T}    {A,E}
       -->    --> M,A,T  -->
                   {E}
                   --> M,A,T,E
       
       M, A, T, E 
       ==========

T --> TAME      

M , E , A, T
---
{M E A T}
M {E A T} --> M E {A T}
                M E A {T}
                M E T {A}
              M A {E T}
              M T {A E}
              ---
       

1. Dictionary 
2. Rearrange letters
3. Inputs? Word and Dictionary
4. Output? [words]
**/


public interface Dictionary{
    public boolean addWord(String word);
    public boolean isWord(String word);
}

public class AnagramFinder{

    public List<String> findAnagram(String word, Dictionary dictionary){
        char[] chars = word.toCharArray();
        List<String> result = new ArrayList();
        for(int i=0; i<chars.length; i++){
            //collection of left out chars --> collection
            String[] res = findCombinations(chars[i], collection)
            for(int j=0; j<res.length; j++){
                if(Dictionary.isWord(res[j))
                    result.add(res[j]);          
            }
        }
    }
    
    private string[] findCombinations(char root, char[] charList){
        char[] newArr = 
        
    }
    
    private string[] findCombinations(char[] left, char[] right){
    
    }
    
    private char[] formWord(char[] list, char c){
        char[] newList = new char[list+1];
        return newList;
    }
}
