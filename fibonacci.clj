(defn fib [n]
  (loop [left n prev2 0 prev 1 current 1]
    (if (= left 0)
      0
      (if (<= left 2)
        current
        (recur (dec left) prev current (+ prev current))
      )
    )
  )
)

(assert (= (fib 0) 0))
(assert (= (fib 1) 1))
(assert (= (fib 2) 1))
(assert (= (fib 3) 2))
(assert (= (fib 4) 3))
(assert (= (fib 5) 5))
(assert (= (fib 6) 8))
(assert (= (fib 7) 13))
(assert (= (fib 8) 21))
(assert (= (fib 9) 34))
(assert (= (fib 10) 55))
