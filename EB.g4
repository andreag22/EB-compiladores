// EB.g4

grammar EB;

program: statement+;

statement: ifStatement | printStatement | assignStatement;

ifStatement: 'IF' expression 'THEN' statement+ 'END';

printStatement: 'PRINT' expression;

assignStatement: VARIABLE '=' expression;

expression: '(' operator expression+ ')' | NUMBER | VARIABLE;

operator: '+' | '-' | '*' | '/';

NUMBER: [0-9]+;
VARIABLE: [a-zA-Z]+;

WS: [ \t\r\n]+ -> skip;
