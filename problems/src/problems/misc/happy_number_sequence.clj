(ns problems.misc.happy-number-sequence)

;happy number sequence
;take squares of each digit in a number and sum them up, if the sequence of this goes to 1, it is a happy number
;ex: 31 -> 3 ^ 2 + 1 ^ 2 = 9 + 1 = 10 -> 1 ^ 2 + 0 ^ 2 = 1 happy number

(defn sqr [n]
  (* n n))

(defn digitize [n]
  (map #(Character/digit % 10)
       (str n)))

(defn sqr-all [n]
  (map sqr
       (digitize n)))

(defn next-happy-num [n]
  (reduce + (sqr-all n)))

(defn is-happy? [num]
  (let [seen (atom #{})]
    (loop
      [nextnum (next-happy-num num)]
      (if (= nextnum 1)
        (prn "happy number found")
        (if (contains? @seen nextnum)
          (prn "loop found")
          (do
            (swap! seen conj nextnum)
            (recur (next-happy-num nextnum))))))))

(defn is-happy?-2 [num]
  (let [seen (atom #{})]
    (loop
      [nextnum (next-happy-num num)]
      (cond (= nextnum 1) (prn "happy number found")
            (contains? @seen nextnum) (prn "loop found")
            :else (do
                    (swap! seen conj nextnum)
                    (recur (next-happy-num nextnum)))))))

;;