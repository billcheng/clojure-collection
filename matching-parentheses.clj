(defn isEmpty? [parentheses]
    (= (count parentheses) 0)
)

(defn isOpenParen? [chr]
    (= chr \()
)

(defn balance
    ([parentheses] (balance parentheses []))
    ([parentheses stack]
        (if (isEmpty? parentheses)
            (true? (isEmpty? stack))
            (do
                (def current (first parentheses))
                (def restOfThem (next parentheses))
                (if (isOpenParen? current)
                    (balance restOfThem (conj stack current))
                    (if (isOpenParen? (peek stack))
                        (balance restOfThem (pop stack))
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