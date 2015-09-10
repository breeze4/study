(ns problems.misc.fizzbuzz)

(defn fizzbuzz [n]
  (cond (= 0 (mod n 15)) (prn "fizzbuzz")
        (= 0 (mod n 3)) (prn "fizz")
        (= 0 (mod n 5)) (prn "buzz")))

(map fizzbuzz (range 1 101))