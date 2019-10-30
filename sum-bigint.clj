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

(defn get-last-digit [bigint]
  (or (peek bigint) "0")
)

(defn bigint-add [input-bigint1 input-bigint2]
  (let [vec1 (str->vec input-bigint1) vec2 (str->vec input-bigint2)]
    (str/join #"" 
      (loop [result [] carry 0 bigint1 vec1 bigint2 vec2]
        (if (and (= carry 0) (or (empty? bigint1) (empty? bigint2)))
            (concat bigint1 bigint2 result)
            (do
              (def last-digit1 (get-last-digit bigint1))
              (def last-digit2 (get-last-digit bigint2))
              (def digit1 (Integer/parseInt last-digit1))
              (def digit2 (Integer/parseInt last-digit2))
              (def sum (+ carry digit1 digit2))
              (def mod10 (mod sum 10))
              (def div10 (int (/ sum 10)))
              (def newResult (into [mod10] result))
              (def newBigint1 (pop-bigint bigint1))
              (def newBigint2 (pop-bigint bigint2))
              (recur newResult div10 newBigint1 newBigint2)
            )
        )
      )
    )
  )
)

(println (bigint-add "999999999999999999999" "1"))
