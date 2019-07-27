package programmers.lv2;

import org.junit.Test;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String skill_tree : skill_trees) {
            String target = skill_tree;

            for (String letter : target.split("")) {
                if(!skill.contains(letter)) {
                    target = target.replaceAll(letter, "");
                }
            }

            if (target.equals(skill.substring(0, target.length()))) {
                count++;
            }
        }

        return count;
    }

    public int 참고풀이_정규표현식(String skill, String[] skill_trees) {
        int count = 0;

        for (String skill_tree : skill_trees) {
            String target = skill_tree;
            target = target.replaceAll("[^" + skill + "]", "");

            if (target.equals(skill.substring(0, target.length()))) {
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(참고풀이_정규표현식(skill, skill_trees));
    }

}
