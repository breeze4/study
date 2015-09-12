(ns ch1-arrays-and-strings.ch1-4)

(def encoded-space '(\0 \2 \%))

(defn encoder [coll char]
  (let [encoded (if (Character/isWhitespace char)
                  encoded-space
                  (list char))]
    (apply conj coll encoded)))

(defn encode-spaces [input]
  (reduce encoder () (reverse input)))

(encode-spaces "a b c")
(encode-spaces "a b c ")
(encode-spaces " ")
(encode-spaces "  ")
