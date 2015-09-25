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

(defn compress-old [input]
  (if (or (nil? input)
          (<= (count input) 2))
    input
    (let [compressed (compress-string-2 input)]
      (if (>= (count compressed) (count input))
        input
        (apply str compressed)))))

(ffirst )

(defn- compress-string-2 [current
                          currentCount
                          in
                          out]
  (cond
    ; If the input is empty, just add the current tracker and count to the output and return it
    (empty? in)
    (into out [current currentCount])
    ; If the input is the same as the tracker, increment the counter and continue
    (= current (first in))
    (recur current (inc currentCount) (rest in) out)
    ; If the input is different from the tracker, add the current values to the output
    ; and reset the tracker and count
    (not= current (first in))
    (recur (first in) 1 (rest in) (into out [current currentCount]))))

(defn compress [input]
  (if (or (nil? input)
          (<= (count input) 2))
    ; Check to see if the input is worth compressing
    input
    (let [compressed (compress-string-2 (first input) 0 (seq input) [])
          ; Check to see if the output was an improvement
          use-compressed? (>= (count compressed) (count input))]
      (if use-compressed?
        input
        (apply str compressed)))))

(compress "aabbbcc")
(compress "abc")
(compress "aaa")
(compress "aaabbbccc")
(compress "aaaabababacc")
(compress "aaaabababaccccccccccccc")
(compress "aaaabababacccccccccccccd")
