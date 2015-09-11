(ns problems.cracking.ch1-arrays-and-strings.ch1-1)

; wow this one really sucks
(defn has-all-unique [str]
  (if (nil? str)
    nil
    (loop
      [set #{}
       nums (into () (.toCharArray str))]
      (let [num (first nums)]
        (if (nil? num)
          true
          (if (contains? set num)
            false
            (recur (conj set num) (rest nums))))))))

(has-all-unique "abcde")
(has-all-unique "abccde")
(has-all-unique nil)
(has-all-unique "")
(has-all-unique "a")

(defn add-or-false-atom [num set]
  (if (contains? @set num)
    false
    (swap! set conj num)))

(defn unique?-atom [num set]
  (if (nil? num)
    true
    (add-or-false-atom num set)))

; This one isn't much better.
; Switched to seq from toCharArray, it's null safe.
; Used an atom to hold onto the not-unique flag.
; It doesn't get away from all the nested ifs from above,
; but this doesn't just accidentally end by returning true.

; It works, but it doesn't feel idiomatic to hold onto the state this way.
; I think I should be able to pass along the characters in the sequence
; the set of seen chars and whether the whole thing has already been found
; to not be unique.
(defn has-all-unique-alt [str]
  (let [set (atom #{})
        not-unique (atom true)]
    (do
      (doseq [num (seq str)]
        (if-not (unique?-atom num set)
          (swap! not-unique (fn [n] false))))
      (if (true? @not-unique)
        true
        false))))

; So far, this is the clearest and I think the most idiomatic thus far.
; I would like to get rid of the atom entirely.
(defn has-all-unique-alt-2 [str]
  (let [chars (seq str)
        seen (atom #{})]
    (loop [num (first chars)
           chs chars]
      (cond (nil? num) true
            (unique?-atom num seen) (recur (second chs) (rest chs))
            :else false))))


; Best so far! Peel things apart.
(defn unique? [char seen]
  (if (contains? seen char)
    false
    (conj seen num)))

; This is cool, it recurs on the function itself!
(defn all-unique? [current chars seen]
  (let [unique (unique? current seen)]
    (cond (nil? current) true
          (false? unique) false
          unique (recur (second chars) (rest chars) unique))))

(defn has-all-unique-alt-3 [str]
  (let [chars (seq str)
        current (first chars)
        seen '()]
    (all-unique? current chars seen)))


(has-all-unique-alt-2 "abcde")
(has-all-unique-alt-2 "abccddddeeeeee")
(has-all-unique-alt-2 nil)
(has-all-unique-alt-2 "")
(has-all-unique-alt-2 "a")

;;