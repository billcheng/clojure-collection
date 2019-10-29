(require '[clojure.string :as str])

(defn str->vec [word]
    (str/split word #"")
)

(defn anagram [word1 word2]
    (def vec1 (sort (str->vec word1)))
    (def vec2 (sort (str->vec word2)))
    (= vec1 vec2)
)

(assert (anagram "race" "care") "race vs care")
(assert (anagram "care" "acre") "care vs acre")
(assert (not(anagram "super" "uber")) "super vs uber")
(assert (anagram "super" "purse") "super vs purse")
(println "All good")
