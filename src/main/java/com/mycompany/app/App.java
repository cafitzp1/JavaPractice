package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        String str = "We have a large inventory of things in our warehouse falling in "
                + "the title category:apparell and the slightly "
                + "more in demand category:makeup along with the category:furniture and _.";

        printCategories(str);
    }

    static private void printCategories(String str) {

        if (str.length() <= 0 || str.indexOf("category") == -1)
            return;

        String newStr = "";
        int startIndex = str.indexOf("category")+1,
            activeIndex = startIndex,
            endIndex = startIndex;
            
        startIndex += "category".length();

        while (str.charAt(activeIndex++) != ' ') {
            endIndex++;
            if(activeIndex == str.length()-1) return;
        }

        newStr = str.substring(startIndex, endIndex);
        System.out.println(newStr);

        printCategories(str.substring(endIndex, str.length() - 1));
    }
}
