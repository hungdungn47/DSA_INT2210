package Leetcode;

import java.util.*;

public class all_possible_recipes {
    class Solution {
        private Set<String> availableSupplies;
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            availableSupplies = new HashSet<String>(Arrays.stream(supplies).toList());
            List<String> res = new ArrayList<String>();
            for(String recipe: recipes) {
                if(isPossible(recipe, recipes, ingredients)) {
                    res.add(recipe);
                }
            }
            return res;
        }

        private boolean isPossible(String recipe, String[] recipes, List<List<String>> ingredients) {
            if(availableSupplies.contains(recipe)) {
                return true;
            }
            boolean res = true;
            int i = 0;
            while(!Objects.equals(recipes[i], recipe)) i++;
            List<String> neededIngredients = ingredients.get(i);
            System.out.println("needed ingredients for " + recipe + ": " + neededIngredients );
            for(String ingredient : neededIngredients) {
                if(!isPossible(ingredient, recipes, ingredients)) {
                    res = false;
                }
            }
            if(res) {
                availableSupplies.add(recipe);
                return true;
            }
            return false;
        }
    }
    public void main(String[] args) {
        Solution mySolution = new Solution();
        String[] recipes = {"ju","fzjnm","x","e","zpmcz","h","q"};

    }
}
