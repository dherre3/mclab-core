grammar t031emptyAlt;
options {
  language = Python;
}

r
    : NAME 
        ( {self.cond}?=> WS+ NAME
        | 
        )
        EOF
    ;

NAME: ('a'..'z') ('a'..'z' | '0'..'9')+;
NUMBER: ('0'..'9')+;
WS: ' '+;
