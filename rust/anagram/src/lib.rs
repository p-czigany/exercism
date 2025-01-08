use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let not_similar = Box::new(NotEqualsIgnoreCase::not_equals_ignore_case);
    let anagrams = Box::new(Anagrams::is_anagram);

    possible_anagrams
        .iter()
        .filter(|&candidate| (not_similar)(word, candidate))
        .filter(|&candidate| (anagrams)(word, candidate))
        .cloned()
        .collect()
}

struct Anagrams;

impl Anagrams {
    fn is_anagram(s1: &str, s2: &str) -> bool {
        if s1.len() != s2.len() {
            return false;
        }
        let mut chars1: Vec<char> = s1.to_lowercase().chars().collect();
        let mut chars2: Vec<char> = s2.to_lowercase().chars().collect();
        chars1.sort_unstable();
        chars2.sort_unstable();
        chars1 == chars2
    }
}

struct NotEqualsIgnoreCase;

impl NotEqualsIgnoreCase {
    fn not_equals_ignore_case(s1: &str, s2: &str) -> bool {
        !s1.to_lowercase().eq(&s2.to_lowercase())
    }
}
