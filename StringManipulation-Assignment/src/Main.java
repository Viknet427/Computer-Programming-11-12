public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s) {

        int answer = 0;

        char[] vowel = "aeiouAEIOU".toCharArray();
        char[] string = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            for (char aVowel : vowel) {

                if (string[i] == aVowel) {

                    answer++;

                }

            }

        }

        return answer;

    }
    //Code you problem number two here
    static int problemTwo(String s) {

        int answer = 0;
        char[] problem = s.toCharArray();

        for (int i = 0; i < s.length()-2; i++) {

            if (problem[i] == 'b' && problem[i+1] == 'o' && problem[i+2] == 'b') {

                answer++;

            }

        }

        return answer;

    }
    //Code your solution to problem number 3 here
    static String problemThree(String s) {

        char[] sChars = s.toCharArray();

        StringBuilder answer = new StringBuilder();
        String save = "";

        for (int i = 0; i < sChars.length; i++) {

            //Progress check
            int check = answer.length();

            //Appends a letter if the current collected letters length is 0
            if (answer.length() == 0) {

                answer.append(sChars[i]);

            }

            //Checks if previous letter has a value lower than current letter
            else if (sChars[i-1] <= sChars[i]) {

                answer.append(sChars[i]);

            }

            //Saves the current letters collected if current letters are greater than the saved letters
            if (answer.length() > save.length()) {

                save = answer.toString();

            }

            //Deletes everything and goes back one letter if nothing happens
            else if (check >= answer.length()) {

                answer.delete(0,answer.length());
                i--;

            }

        }

        if (save.length() >= answer.length()) {

            return save;

        }

        else {

            return answer.toString();

        }

    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s = "ztapvefsnx";
        System.out.println(problemThree(s));
    }
}
