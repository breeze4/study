(ns ch1-arrays-and-strings.ch1-2)

; Reverse a string
; Just apply the str function to each of the seqs of chars resulting from reverse
(apply str (reverse "abc"))
(apply str (reverse nil))
(apply str (reverse "a"))

; What it boils down to:
(apply str (reduce conj () "abc"))
; Because seqs add to the front, iterating over the word and putting each element as
; the head of the return seq will reverse the word.
; (apply str (reduce conj [] "abc")) => "abc"
; Vectors add at the tail, so it just copies exactly

; Reduce is interesting here. It's