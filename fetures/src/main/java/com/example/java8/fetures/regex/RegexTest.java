package com.example.java8.fetures.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTest {

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foo");

        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foofoo");
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }

        assertEquals(matches, 2);
    }

    @Test
    public void givenText_whenMatchesWithDotMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    @Test
    public void givenRepeatedText_whenMatchesOnceWithDotMetach_thenCorrect() {
        int matches= runTest("foo.", "foofoo");

        assertEquals(matches, 1);
    }

    // ***************************** OR Class
    @Test
    public void givenORSet_whenMatchesAny_thenCorrect() {
        int matches = runTest("[abc]", "b");

        assertEquals(matches, 1);
    }

    @Test
    public void givenORSet_whenMatchesAnyAndAll_thenCorrect() {
        int matches = runTest("[abc]", "cababc");

        assertEquals(matches, 6);
    }

    @Test
    public void givenORSet_whenMatchesAllCombinations_thenCorrect() {
        int matches = runTest("[bcr]at", "bat cat rat vat");

        assertEquals(matches, 3);
    }

    // ***************************** NOR  Class
    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() {
        int matches = runTest("[^abc]", "abccbabcag");

        assertTrue(matches > 0);
    }

    @Test
    public void givenNORSet_whenMatchesAllExceptElements_thenCorrect() {
        int matches = runTest("[^bcr]at", "sat mat eat bat");

        assertTrue(matches > 0);
    }

    // ***************************** Range  Class
    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
        int matches = runTest("[A-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    public void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
        int matches = runTest("[a-z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 26);
    }

    @Test
    public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() {
        int matches = runTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 28);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[1-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect2(){
        int matches = runTest("3[0-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 1);
    }

    // ***************************** UNION  Class
    @Test
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3[7-9]]", "1456789");

        assertEquals(matches, 4);
    }

    /*
     Intersection Class
    Similar to the union class, this class results from picking common elements between two or more sets.
     To apply intersection, we use the &&:
     */
    @Test
    public void givenTwoSets_whenMatchesIntersection_thenCorrect() {
        int matches = runTest("[1-6&&[3-9]]", "123456789");

        assertEquals(matches, 4);
    }

    // Subtraction Class. Here: entre 0 e 9 mas que nao seja 2 4 6 8
    @Test
    public void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect() {
        int matches = runTest("[0-9&&[^2468]]", "123456789");

        assertEquals(matches, 5);
    }

    //  ******************************* Predefined Character Classes
    //  Some of the above character classes can be expressed in shorter form,
    //  although this makes the code less intuitive.
    // As we'll see, most characters will start with a backslash, which has a special meaning in Java.
    // For these to be compiled by the Pattern class, the leading backslash must be escaped, i.e. \d becomes \\d.

    @Test
    public void givenDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    // Matching non-digits, equivalent to [^0-9]:
    @Test
    public void givenNonDigits_whenMatches_thenCorrect() {
        int matches = runTest("\\D", "a6c");

        assertEquals(matches, 2);
    }

    //Matching white space:
    @Test
    public void givenWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\s", "a c");

        assertEquals(matches, 1);
    }

   // Matching non-white space:
    @Test
    public void givenNonWhiteSpace_whenMatches_thenCorrect() {
        int matches = runTest("\\S", "a c");

        assertEquals(matches, 2);
    }

    //Matching a word character, equivalent to [a-zA-Z_0-9]:
    @Test
    public void givenWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\w", "hi!");

        assertEquals(matches, 2);
    }

    @Test
    public void givenNonWordCharacter_whenMatches_thenCorrect() {
        int matches = runTest("\\W", "hi!");

        assertEquals(matches, 1);
    }

    // Quantifiers
    // The Java regex API also allows us to use quantifiers.
    // These enable us to further tweak the match's behavior by specifying the number of occurrences to match against.

    //To match a text zero or one time, we use the ? quantifier:
    /*
    This example introduces the concept of zero-length matches.
    It so happens that if a quantifier's threshold for matching is zero, it always matches everything in the text,
    including an empty String at the end of every input. This means that even if the input is empty, it'll return one zero-length match.
    This explains why we get three matches in the above example, despite having a String of length two.
    The third match is zero-length empty String.
     */
    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("a?", "");

        assertEquals(matches, 1);
    }

    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect_() {
        int matches = runTest("a?", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void givenZeroOrManyQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a*", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void givenZeroOrManyQuantifier_whenMatches_thenCorrect2() {
        int matches = runTest("\\a{0,}", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect2() {
        int matches = runTest("\\a{0,1}", "hi");

        assertEquals(matches, 3);
    }

    // The quantifier with a difference is +, which has a matching threshold of one.
    @Test
    public void givenOneOrManyQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("\\a+", "hi");

        assertEquals(matches, 0);
    }


    @Test
    public void givenOneOrManyQuantifier_whenMatches_thenCorrect2() {
        int matches = runTest("\\a{1,}", "hi");

        assertEquals(matches, 0);
    }


    //  we can use the brace syntax to match a given text a number of times:
    @Test
    public void givenBraceQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("a{3}", "aaaaaa");

        assertEquals(matches, 2);
    }

    // we get two matches, since a match occurs only if a appears three times in a row. However, in the next test, we won't get a match because the text only appears two times in a row:
    @Test
    public void givenBraceQuantifier_whenFailsToMatch_thenCorrect() {
        int matches = runTest("a{3}", "aa");

        assertEquals(matches, 0);
    }

    //When we use a range in the brace, the match will be greedy, matching from the higher end of the range:
    @Test
    public void givenBraceQuantifierWithRange_whenMatches_thenCorrect() {
        int matches = runTest("a{2,3}", "aaaa");

        assertEquals(matches, 1);
    }

    //Here we specified at least two occurrences, but not exceeding three,
    // so we get a single match where the matcher sees a single aaa and a alone a, which can't be matched.
    //However, the API allows us to specify a lazy or reluctant approach such that the matcher can start from the lower end of the range,
    // matching two occurrences as aa and aa:
    @Test
    public void givenBraceQuantifierWithRange_whenMatchesLazily_thenCorrect() {
        int matches = runTest("a{2,3}?", "aaaa");

        assertEquals(matches, 2);
    }

    //Capturing Groups

    @Test
    public void givenCapturingGroup_whenMatches_thenCorrect() {
        int matches = runTest("(\\d\\d)", "12");

        assertEquals(matches, 1);
    }

    @Test
    public void givenCapturingGroup_whenMatches_thenCorrect2() {
        int matches = runTest("(\\d\\d)", "1212");

        assertEquals(matches, 2);
    }

    //We can have one match, but propagating the same regex match to span the entire length of the input using back referencing:
    @Test
    public void givenCapturingGroup_whenMatchesWithBackReference_thenCorrect() {
        int matches = runTest("(\\d\\d)\\1", "12121212");

        assertEquals(matches, 2);
    }

    //We can have one match, but propagating the same regex match to span the entire length of the input using back referencing:
    @Test
    public void givenCapturingGroup_whenMatchesWithBackReference_thenCorrect_() {
        int matches = runTest("(\\d\\d)\\1", "1212");

        assertEquals(matches, 1);
    }


    @Test
    public void givenCapturingGroup_whenMatchesWithBackReference_thenCorrect2() {
        int matches = runTest("(\\d\\d)\\1\\1\\1", "12121212");

        assertEquals(matches, 1);
    }

    // *********************************************************** Boundary Matchers
    /*
    The Java regex API also supports boundary matching.
    If we care about where exactly in the input text the match should occur, then this is what we're looking for.
     With the previous examples, all we cared about was whether or not a match was found.
     */

    @Test
    public void givenText_whenMatchesAtBeginning_thenCorrect() {
        int matches = runTest("^dog", "dogs are friendly");

        assertEquals(matches, 1);
    }

    @Test
    public void givenTextAndWrongInput_whenMatchFailsAtBeginning_thenCorrect() {
        int matches = runTest("^dog", "are dogs are friendly?");

        assertEquals(matches, 0);
    }

    @Test
    public void givenText_whenMatchesAtEnd_thenCorrect() {
        int matches = runTest("dog$", "Man's best friend is a dog");

        assertEquals(matches, 1);
    }

    @Test
    public void givenTextAndWrongInput_whenMatchFailsAtEnd_thenCorrect() {
        int matches = runTest("dog$", "is a dog man's best friend?");

        assertEquals(matches, 0);
    }

    //If we want a match only when the required text is found at a word boundary,
    // we use the \\b regex at the beginning and end of the regex:
    // here we have a space before and after dog
    /*
    The following three positions are qualified as word boundaries:
        1) Before the first character in a string if the first character is a word character.
        2) After the last character in a string if the last character is a word character.
        3) Between two characters in a string if one is a word character and the other is not.
     */
    // exs: space, virgula, ponto, exclamacao, interrogacao sao word boundary,
    @Test
    public void givenText_whenMatchesAtWordBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\b", "a dog is friendly");

        //assertTrue(matches > 0);
        assertEquals(matches, 1);
    }

    @Test
    public void givenText_whenMatchesAtWordBoundary_thenCorrect_() {
        int matches = runTest("\\bdog\\b", "a dog is friendly, and a cat,dog,bird are so");

        //assertTrue(matches > 0);
        assertEquals(matches, 2);
    }

    @Test
    public void givenText_whenMatchesAtWordBoundary_thenCorrect2() {
        int matches = runTest("\\bdog\\b", "dog is man's best friend");

        assertTrue(matches == 1);
    }

    // \\B no bound caractere
    @Test
    public void givenText_whenMatchesAtWordAndNonBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\B", "snoop dogg is a rapper");
        assertTrue(matches == 1);
    }

    // *************** RunTest function.. cherche pattern with matcher.find()
    private static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            System.out.println("match=" + matcher.start() + " " + matcher.end());
            matches++;
        }
        return matches;
    }

    private static int runTest(String regex, String text, int flags) {
        var pattern = Pattern.compile(regex, flags);
        var matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()){
            matches++;
        }
        return matches;
    }
}
