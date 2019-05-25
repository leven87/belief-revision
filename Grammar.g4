grammar Grammar;

start : s+=sentence* EOF;

sentence : atomicSentence                        # Atomic
         | PARENTHESIS sentence PARENTHESIS      # Parenthesis
         | BRACKET sentence BRACKET              # Bracket
         | NOT sentence                          # Not
         | s1=sentence AND s2=sentence           # And
         | s1=sentence OR s2=sentence            # Or
         | s1=sentence IMPLIES s2=sentence       # Implies
         | s1=sentence BICONDITION s2=sentence   # IfAndOnlyIf
         ;

atomicSentence : PREDICATE                       # Predicate
               | x=VARIABLE                      # Terms
               ;

QUANTIFIER  : '∀' | '∃';
VARIABLE    : 'p' | 'q' | 'r' | 's';

NOT         : '¬' | '!';
AND         : '∧' | '&';
OR          : '∨' | '|';
IMPLIES     : '⇒' | '>';
BICONDITION : '⇔' | '<>';

PARENTHESIS : '(' | ')';
BRACKET     : '[' | ']';

PREDICATE   : 'True' | 'False';

WHITESPACE  : [ \n\t\r]+ -> skip;
COMMENT     : '//' ~('\n')* -> skip;