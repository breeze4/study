(ns ch1-arrays-and-strings.ch1-5)

; fairly direct translation of Java algorithm
; not very pleasant to look at and it seems messy
(defn- compress-string [input]
  (let [output (loop [current (first input)
                      currentCount 0
                      in (seq input)
                      out []]
                 ;(prn current currentCount in out)
                 (cond (and (= current (first in))          ; same as the pointer and not the last element
                            (not= 1 (count in)))
                       (recur current (inc currentCount) (next in) out) ; just increment count and move on
                       (and (= current (first in))          ; same as pointer and the last element
                            (= 1 (count in)))
                       (into out [current (inc currentCount)])

                       (and (not= current (first in))       ; different from pointer and not the last element
                            (not= 1 (count in)))
                       (recur (first in) 1 (rest in) (into out [current currentCount]))
                       (and (not= current (first in))       ; different from pointer and the last element
                            (= 1 (count in)))
                       (into out [current currentCount (first in) 1])
                       ))]
    (if (>= (count output) (count input))
      input
      (apply str output))))

(defn compress [input]
  (if (or (nil? input)
          (<= (count input) 2))
    input
    (compress-string input)))

(compress "aabbbcc")
(compress "abc")
(compress "aaa")
(compress "aaabbbccc")
(compress "aaaabababacc")
(compress "aaaabababaccccccccccccc")
(compress "aaaabababacccccccccccccd")
