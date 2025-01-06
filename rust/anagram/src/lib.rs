use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let mut result = HashSet::new();
    let mut sorted_word: Vec<char> = word
        .to_lowercase()
        .chars()
        .collect::<Vec<_>>()
        .into_iter()
        .collect();
    sorted_word.sort();

    for possible_anagram in possible_anagrams {
        if word.len() == possible_anagram.len() {
            let mut sorted_candidate: Vec<char> = possible_anagram
                .to_lowercase()
                .chars()
                .collect::<Vec<_>>()
                .into_iter()
                .collect();
            sorted_candidate.sort();
            if !case_insensitive_equal(word, possible_anagram) && sorted_word == sorted_candidate {
                result.insert(possible_anagram.clone());
            }
        }
    }

    result
}

fn case_insensitive_equal(word1: &str, word2: &str) -> bool {
    word1.to_lowercase() == word2.to_lowercase()
}
