(ns ch1-arrays-and-strings.ch1-3
  (:import (java.util Arrays)))

; Finding out if the second string is a permutation of the first

; Short and sweet
(defn is-permutation? [orig perm]
  (if (or (nil? orig) (nil? perm)
          (not (= (count orig) (count perm))))
    false
    (let [origCh (sort orig)
          permCh (sort perm)]
      (= origCh permCh))))

(is-permutation? "abc" "cba")
(is-permutation? "abc" "cbaa")
(is-permutation? "abc" "ccba")
(is-permutation? "abcc" "ccba")


;;