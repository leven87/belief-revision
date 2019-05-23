grammar Grammar;

start : s+=sentence* EOF;

sentence : atomicSentence                        #Atomic
         | '(' sentence ')'                      #Parenthesis
         | '[' sentence ']'                      #Bracket
         | '¬' sentence                          #Not
         | s1=sentence '∧' s2=sentence           #And
         | s1=sentence '∨' s2=sentence           #Or
         | s1=sentence '⇒' s2=sentence           #Implies
         | s1=sentence '⇔' s2=sentence           #IfAndOnlyIf
         ;

atomicSentence : Predicate                       #Predicate
               | x=Variable                      #Terms
               ;

Quantifier : '∀' | '∃';
Variable : 'p' | 'q' | 'r' | 's';

Predicate : 'True' | 'False';

WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT    : '//' ~('\n')* -> skip;