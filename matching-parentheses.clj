(defn isOpenParen? [chr]
    (= chr \()
)

(defn balance [input]
  (loop [parentheses input stack []]
    (if (empty? parentheses)
        (true? (empty? stack))
        (do
            (def current (first parentheses))
            (def restOfThem (next parentheses))
            (if (isOpenParen? current)
                (recur restOfThem (conj stack current))
                (if (isOpenParen? (peek stack))
                    (recur restOfThem (pop stack))
                    false
                )
            )
        )
    )
  )
)

(assert (balance "(())") "(())")
(assert (balance "()") "()")
(assert (balance "()()") "()()")
(assert (not (balance "()(")) "()(")
(assert (not (balance "())")) "())")
(assert (not (balance ")(")) ")(")
