(require '[clojure.string :as str])

(defn str->vec [digits]
    (str/split digits #"")
)

(defn pop-bigint [bigint]
    (if (= (count bigint) 0)
        []
        (pop bigint)
    )
)

(defn f [result carry bigint1 bigint2]
    (if (and (= carry 0) (or (= (count bigint1) 0) (= (count bigint2) 0)))
        (concat bigint1 bigint2 result)
        (do
            (def last-digit1 (or (peek bigint1) "0"))
            (def last-digit2 (or (peek bigint2) "0"))
            (def digit1 (Integer/parseInt last-digit1))
            (def digit2 (Integer/parseInt last-digit2))
            (def sum (+ carry digit1 digit2))
            (def mod10 (mod sum 10))
            (def div10 (int (/ sum 10)))
            (def newResult (into [mod10] result))
            (def newBigint1 (pop-bigint bigint1))
            (def newBigint2 (pop-bigint bigint2))
            (f newResult div10 newBigint1 newBigint2)
        )
    )
)

(defn bigint-add [bigint1 bigint2]
    (str/join #"" (f [] 0 (str->vec bigint1) (str->vec bigint2)))
)

(println (bigint-add "999999999999999999999" "1"))
